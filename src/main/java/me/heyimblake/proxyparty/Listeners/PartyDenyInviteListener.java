package me.heyimblake.proxyparty.listeners;

import me.heyimblake.proxyparty.events.PartyDenyInviteEvent;
import me.heyimblake.proxyparty.partyutils.Party;
import me.heyimblake.proxyparty.utils.ActionLogEntry;
import me.heyimblake.proxyparty.utils.Constants;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by heyimblake on 11/3/2016.
 *
 * @author heyimblake
 *         https://heyimblake.me
 */
public class PartyDenyInviteListener implements Listener {
    @EventHandler
    public void onPartyDenyInvite(PartyDenyInviteEvent event) {
        Party party = event.getParty();
        ProxiedPlayer denier = event.getDenier();
        TextComponent msg = new TextComponent("Player " + denier.getName() + " has denied your party invitation.");
        msg.setColor(ChatColor.AQUA);
        party.getLeader().sendMessage(Constants.TAG, msg);
        new ActionLogEntry("deny", denier.getUniqueId(), new String[]{party.getLeader().getName()}).log();
    }
}
