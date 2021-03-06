package me.heyimblake.proxyparty.listeners;

import me.heyimblake.proxyparty.events.PartyCreateEvent;
import me.heyimblake.proxyparty.utils.ActionLogEntry;
import me.heyimblake.proxyparty.utils.Constants;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by heyimblake on 10/23/2016.
 *
 * @author heyimblake
 *         https://heyimblake.me
 */
public class PartyCreateListener implements Listener {
    @EventHandler
    public void onPartyCreate(PartyCreateEvent event) {
        ProxiedPlayer player = event.getCreator();
        TextComponent msg = new TextComponent("You just created a party!");
        msg.setColor(ChatColor.YELLOW);
        player.sendMessage(Constants.TAG, msg);
        new ActionLogEntry("create", player.getUniqueId()).log();
    }
}
