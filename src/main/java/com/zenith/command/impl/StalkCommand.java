package com.zenith.command.impl;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.zenith.command.Command;
import com.zenith.command.CommandUsage;
import com.zenith.command.brigadier.CommandCategory;
import com.zenith.command.brigadier.CommandContext;
import com.zenith.discord.Embed;

import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static com.zenith.Shared.CONFIG;
import static com.zenith.Shared.PLAYER_LISTS;
import static com.zenith.command.brigadier.ToggleArgumentType.getToggle;
import static com.zenith.command.brigadier.ToggleArgumentType.toggle;
import static com.zenith.command.util.CommandOutputHelper.playerListToString;
import static com.zenith.discord.DiscordBot.escape;
import static java.util.Arrays.asList;

public class StalkCommand extends Command {
    @Override
    public CommandUsage commandUsage() {
        return CommandUsage.args(
            "stalk",
            CommandCategory.MODULE,
            "Configures the stalk module which sends discord mentions when a player connects",
            asList("on/off", "list", "add/del <player>")
        );
    }

    @Override
    public LiteralArgumentBuilder<CommandContext> register() {
        return command("stalk")
            .then(argument("toggle", toggle()).executes(c -> {
                CONFIG.client.extra.stalk.enabled = getToggle(c, "toggle");
                c.getSource().getEmbed()
                    .title("Stalk " + toggleStrCaps(CONFIG.client.extra.stalk.enabled));
                return 1;
            }))
            .then(literal("list").executes(c -> {
                c.getSource().getEmbed()
                    .title("Stalk List");
            }))
            .then(literal("add").then(argument("player", string()).executes(c -> {
                final String player = StringArgumentType.getString(c, "player");
                PLAYER_LISTS.getStalkList().add(player).ifPresentOrElse(e ->
                    c.getSource().getEmbed()
                            .title("Added player: " + escape(e.getUsername()) + " To Stalk List"),
                        () -> c.getSource().getEmbed()
                            .title("Failed to add player: " + escape(player) + " to stalk list. Unable to lookup profile."));
                return 1;
            })))
            .then(literal("del").then(argument("player", string()).executes(c -> {
                final String player = StringArgumentType.getString(c, "player");
                PLAYER_LISTS.getStalkList().remove(player);
                c.getSource().getEmbed()
                    .title("Removed player: " + escape(player) + " From Stalk List");
                return 1;
            })));
    }

    @Override
    public void postPopulate(final Embed builder) {
        builder
            .addField("Stalk", toggleStr(CONFIG.client.extra.stalk.enabled), false)
            .description("**Stalk List**\n" + playerListToString(PLAYER_LISTS.getStalkList()))
            .primaryColor();
    }
}
