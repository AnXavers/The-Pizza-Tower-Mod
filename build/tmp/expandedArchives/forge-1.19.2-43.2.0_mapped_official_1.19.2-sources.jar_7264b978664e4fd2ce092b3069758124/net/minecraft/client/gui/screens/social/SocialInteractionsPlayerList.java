package net.minecraft.client.gui.screens.social;

import com.google.common.base.Strings;
import com.google.common.base.Suppliers;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SocialInteractionsPlayerList extends ContainerObjectSelectionList<PlayerEntry> {
   private final SocialInteractionsScreen socialInteractionsScreen;
   private final List<PlayerEntry> players = Lists.newArrayList();
   @Nullable
   private String filter;

   public SocialInteractionsPlayerList(SocialInteractionsScreen p_100697_, Minecraft p_100698_, int p_100699_, int p_100700_, int p_100701_, int p_100702_, int p_100703_) {
      super(p_100698_, p_100699_, p_100700_, p_100701_, p_100702_, p_100703_);
      this.socialInteractionsScreen = p_100697_;
      this.setRenderBackground(false);
      this.setRenderTopAndBottom(false);
   }

   public void render(PoseStack p_100705_, int p_100706_, int p_100707_, float p_100708_) {
      double d0 = this.minecraft.getWindow().getGuiScale();
      RenderSystem.enableScissor((int)((double)this.getRowLeft() * d0), (int)((double)(this.height - this.y1) * d0), (int)((double)(this.getScrollbarPosition() + 6) * d0), (int)((double)(this.height - (this.height - this.y1) - this.y0 - 4) * d0));
      super.render(p_100705_, p_100706_, p_100707_, p_100708_);
      RenderSystem.disableScissor();
   }

   public void updatePlayerList(Collection<UUID> p_240798_, double p_240792_, boolean p_240829_) {
      Map<UUID, PlayerEntry> map = new HashMap<>();
      this.addOnlinePlayers(p_240798_, map);
      this.updatePlayersFromChatLog(map, p_240829_);
      this.updateFiltersAndScroll(map.values(), p_240792_);
   }

   private void addOnlinePlayers(Collection<UUID> p_240813_, Map<UUID, PlayerEntry> p_240796_) {
      ClientPacketListener clientpacketlistener = this.minecraft.player.connection;

      for(UUID uuid : p_240813_) {
         PlayerInfo playerinfo = clientpacketlistener.getPlayerInfo(uuid);
         if (playerinfo != null) {
            UUID uuid1 = playerinfo.getProfile().getId();
            boolean flag = playerinfo.getProfilePublicKey() != null;
            p_240796_.put(uuid1, new PlayerEntry(this.minecraft, this.socialInteractionsScreen, uuid1, playerinfo.getProfile().getName(), playerinfo::getSkinLocation, flag));
         }
      }

   }

   private void updatePlayersFromChatLog(Map<UUID, PlayerEntry> p_240780_, boolean p_240827_) {
      Collection<GameProfile> collection = this.minecraft.getReportingContext().chatLog().selectAllDescending().reportableGameProfiles();
      Iterator iterator = collection.iterator();

      while(true) {
         PlayerEntry playerentry;
         do {
            if (!iterator.hasNext()) {
               return;
            }

            GameProfile gameprofile = (GameProfile)iterator.next();
            if (p_240827_) {
               playerentry = p_240780_.computeIfAbsent(gameprofile.getId(), (p_243147_) -> {
                  PlayerEntry playerentry1 = new PlayerEntry(this.minecraft, this.socialInteractionsScreen, gameprofile.getId(), gameprofile.getName(), Suppliers.memoize(() -> {
                     return this.minecraft.getSkinManager().getInsecureSkinLocation(gameprofile);
                  }), true);
                  playerentry1.setRemoved(true);
                  return playerentry1;
               });
               break;
            }

            playerentry = p_240780_.get(gameprofile.getId());
         } while(playerentry == null);

         playerentry.setHasRecentMessages(true);
      }
   }

   private void sortPlayerEntries() {
      this.players.sort(Comparator.<PlayerEntry, Integer>comparing((p_240744_) -> {
         if (p_240744_.getPlayerId().equals(this.minecraft.getUser().getProfileId())) {
            return 0;
         } else if (p_240744_.getPlayerId().version() == 2) {
            return 3;
         } else {
            return p_240744_.hasRecentMessages() ? 1 : 2;
         }
      }).thenComparing((p_240745_) -> {
         if (!p_240745_.getPlayerName().isBlank()) {
            int i = p_240745_.getPlayerName().codePointAt(0);
            if (i == 95 || i >= 97 && i <= 122 || i >= 65 && i <= 90 || i >= 48 && i <= 57) {
               return 0;
            }
         }

         return 1;
      }).thenComparing(PlayerEntry::getPlayerName, String::compareToIgnoreCase));
   }

   private void updateFiltersAndScroll(Collection<PlayerEntry> p_240809_, double p_240830_) {
      this.players.clear();
      this.players.addAll(p_240809_);
      this.sortPlayerEntries();
      this.updateFilteredPlayers();
      this.replaceEntries(this.players);
      this.setScrollAmount(p_240830_);
   }

   private void updateFilteredPlayers() {
      if (this.filter != null) {
         this.players.removeIf((p_100710_) -> {
            return !p_100710_.getPlayerName().toLowerCase(Locale.ROOT).contains(this.filter);
         });
         this.replaceEntries(this.players);
      }

   }

   public void setFilter(String p_100718_) {
      this.filter = p_100718_;
   }

   public boolean isEmpty() {
      return this.players.isEmpty();
   }

   public void addPlayer(PlayerInfo p_100715_, SocialInteractionsScreen.Page p_100716_) {
      UUID uuid = p_100715_.getProfile().getId();

      for(PlayerEntry playerentry : this.players) {
         if (playerentry.getPlayerId().equals(uuid)) {
            playerentry.setRemoved(false);
            return;
         }
      }

      if ((p_100716_ == SocialInteractionsScreen.Page.ALL || this.minecraft.getPlayerSocialManager().shouldHideMessageFrom(uuid)) && (Strings.isNullOrEmpty(this.filter) || p_100715_.getProfile().getName().toLowerCase(Locale.ROOT).contains(this.filter))) {
         boolean flag = p_100715_.getProfilePublicKey() != null;
         PlayerEntry playerentry1 = new PlayerEntry(this.minecraft, this.socialInteractionsScreen, p_100715_.getProfile().getId(), p_100715_.getProfile().getName(), p_100715_::getSkinLocation, flag);
         this.addEntry(playerentry1);
         this.players.add(playerentry1);
      }

   }

   public void removePlayer(UUID p_100723_) {
      for(PlayerEntry playerentry : this.players) {
         if (playerentry.getPlayerId().equals(p_100723_)) {
            playerentry.setRemoved(true);
            return;
         }
      }

   }
}