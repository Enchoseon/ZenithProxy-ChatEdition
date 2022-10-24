package com.zenith.discord.command.brigadier.impl;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.zenith.discord.command.brigadier.BrigadierCommand;
import com.zenith.discord.command.brigadier.CommandContext;
import com.zenith.discord.command.brigadier.CommandUsage;
import discord4j.rest.util.Color;

import static com.mojang.brigadier.arguments.StringArgumentType.string;
import static com.zenith.discord.DiscordBot.escape;
import static com.zenith.util.Constants.CONFIG;
import static java.util.Arrays.asList;

public class VisualRangeBrigadierCommand extends BrigadierCommand {
    @Override
    public CommandUsage commandUsage() {
        return CommandUsage.of(
                "visualRange",
                "Configure the VisualRange notification feature",
                asList("on/off", "mention on/off", "friend add/del <player>", "friend list", "friend clear")
        );
    }

    @Override
    public void register(CommandDispatcher<CommandContext> dispatcher) {
        dispatcher.register(
                command("visualRange")
                        .then(literal("on").executes(c -> {
                            CONFIG.client.extra.visualRangeAlert = true;
                            c.getSource().getEmbedBuilder()
                                    .title("VisualRange On!")
                                    .color(Color.CYAN);
                        }))
                        .then(literal("off").executes(c -> {
                            CONFIG.client.extra.visualRangeAlert = false;
                            c.getSource().getEmbedBuilder()
                                    .title("VisualRange Off!")
                                    .color(Color.CYAN);
                        }))
                        .then(literal("mention")
                                .then(literal("on").executes(c -> {
                                    CONFIG.client.extra.visualRangeAlertMention = true;
                                    c.getSource().getEmbedBuilder()
                                            .title("VisualRange Mentions On!")
                                            .addField("Friend List", friendListString(), false)
                                            .color(Color.CYAN);
                                }))
                                .then(literal("off").executes(c -> {
                                    CONFIG.client.extra.visualRangeAlertMention = false;
                                    c.getSource().getEmbedBuilder()
                                            .title("VisualRange Mentions Off!")
                                            .color(Color.CYAN);
                                })))
                        .then(literal("friend")
                                .then(literal("add").then(argument("player", string()).executes(c -> {
                                    final String player = StringArgumentType.getString(c, "player");
                                    if (!CONFIG.client.extra.friendList.contains(player)) {
                                        CONFIG.client.extra.friendList.add(player);
                                    }
                                    c.getSource().getEmbedBuilder()
                                            .title("Friend added")
                                            .addField("Friend List", friendListString(), false)
                                            .color(Color.CYAN);
                                    return 1;
                                })))
                                .then(literal("del").then(argument("player", string()).executes(c -> {
                                    final String player = StringArgumentType.getString(c, "player");
                                    CONFIG.client.extra.friendList.removeIf(friend -> friend.equalsIgnoreCase(player));
                                    c.getSource().getEmbedBuilder()
                                            .title("Friend deleted")
                                            .addField("Friend List", friendListString(), false)
                                            .color(Color.CYAN);
                                    return 1;
                                })))
                                .then(literal("list").executes(c -> {
                                    c.getSource().getEmbedBuilder()
                                            .title("Friend list")
                                            .addField("Friend List", friendListString(), false)
                                            .color(Color.CYAN);
                                }))
                                .then(literal("clear").executes(c -> {
                                    CONFIG.client.extra.friendList.clear();
                                    c.getSource().getEmbedBuilder()
                                            .title("Friend list cleared!")
                                            .color(Color.CYAN);
                                })))
        );
    }

    private String friendListString() {
        return escape((CONFIG.client.extra.friendList.size() > 0 ? String.join(", ", CONFIG.client.extra.friendList) : "Friend List is empty"));
    }
}
