package me.heyimblake.proxyparty.commands.subcommands;

import me.heyimblake.proxyparty.commands.AnnotatedPartySubCommand;
import me.heyimblake.proxyparty.commands.PartySubCommandExecutor;
import me.heyimblake.proxyparty.commands.PartySubCommandHandler;
import me.heyimblake.proxyparty.partyutils.Party;
import me.heyimblake.proxyparty.partyutils.PartyManager;
import me.heyimblake.proxyparty.utils.Constants;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * Created by heyimblake on 10/21/2016.
 *
 * @author heyimblake
 *         https://heyimblake.me
 */
@PartySubCommandExecutor(subCommand = "invited",
        syntax = "/party invited",
        description = "Shows a list of players invited to your party.",
        requiresArgumentCompletion = false,
        leaderExclusive = false,
        mustBeInParty = true)
public class InvitedSubCommand extends AnnotatedPartySubCommand {

    public InvitedSubCommand(PartySubCommandHandler handler) {
        super(handler);
    }

    @Override
    public void runProxiedPlayer() {
        ProxiedPlayer player = ((ProxiedPlayer) getHandler().getCommandSender());
        Party party = PartyManager.getInstance().getPartyOf(player);
        String names = "";
        for (ProxiedPlayer invited : party.getInvited())
            names += names + invited.getName() + ", ";
        TextComponent msg = new TextComponent("These players have invitations to your party:");
        msg.setColor(ChatColor.AQUA);
        TextComponent retractMSG = new TextComponent("Use /party retract <Player> to retract an invite from a player.");
        retractMSG.setColor(ChatColor.DARK_AQUA);
        retractMSG.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/party retract "));
        retractMSG.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[]{new TextComponent(ChatColor.GRAY + "Click to prepare command.")}));
        player.sendMessage(Constants.TAG, msg);
        player.sendMessage(Constants.TAG, new TextComponent(names));
        player.sendMessage(Constants.TAG, retractMSG);
    }

    @Override
    public void runConsole() {

    }
}
