package com.zenith.discord.command.brigadier.impl;

import com.mojang.brigadier.CommandDispatcher;
import com.zenith.discord.command.brigadier.BrigadierCommand;
import com.zenith.discord.command.brigadier.CommandContext;
import com.zenith.discord.command.brigadier.CommandUsage;
import discord4j.rest.util.Color;

import static com.zenith.util.Constants.CONFIG;
import static java.util.Arrays.asList;

public class ChatRelayBrigadierCommand extends BrigadierCommand {
    @Override
    public CommandUsage commandUsage() {
        return CommandUsage.of(
                "chatRelay",
                "Configures the ChatRelay feature",
                asList("on/off", "connectionMessages on/off", "whisperMentions on/off",
                        "nameMentions on/off", "mentionsWhileConnected on/off")
        );
    }

    @Override
    public void register(CommandDispatcher<CommandContext> dispatcher) {
        dispatcher.register(
                command("chatRelay")
                        .then(literal("on").executes(c -> {
                            CONFIG.discord.chatRelay.enable = true;
                            c.getSource().getEmbedBuilder()
                                    .title("Chat Relay On!")
                                    .color(Color.CYAN);
                        }))
                        .then(literal("off").executes(c -> {
                            CONFIG.discord.chatRelay.enable = false;
                            c.getSource().getEmbedBuilder()
                                    .title("Chat Relay Off!")
                                    .color(Color.CYAN);
                        }))
                        .then(literal("connectionMessages")
                                .then(literal("on").executes(c -> {
                                    CONFIG.discord.chatRelay.connectionMessages = true;
                                    c.getSource().getEmbedBuilder()
                                            .title("Connection Messages Relay On!")
                                            .color(Color.CYAN);
                                }))
                                .then(literal("off").executes(c -> {
                                    CONFIG.discord.chatRelay.connectionMessages = false;
                                    c.getSource().getEmbedBuilder()
                                            .title("Connection Messages Relay Off!")
                                            .color(Color.CYAN);
                                })))
                        .then(literal("whisperMentions")
                                .then(literal("on").executes(c -> {
                                    CONFIG.discord.chatRelay.mentionRoleOnWhisper = true;
                                    c.getSource().getEmbedBuilder()
                                            .title("Whisper Mentions Relay On!")
                                            .color(Color.CYAN);
                                }))
                                .then(literal("off").executes(c -> {
                                    CONFIG.discord.chatRelay.mentionRoleOnWhisper = false;
                                    c.getSource().getEmbedBuilder()
                                            .title("Whisper Mentions Relay Off!")
                                            .color(Color.CYAN);
                                })))
                        .then(literal("nameMentions")
                                .then(literal("on").executes(c -> {
                                    CONFIG.discord.chatRelay.mentionRoleOnNameMention = true;
                                    c.getSource().getEmbedBuilder()
                                            .title("Name Mentions Relay On!")
                                            .color(Color.CYAN);
                                }))
                                .then(literal("off").executes(c -> {
                                    CONFIG.discord.chatRelay.mentionRoleOnNameMention = false;
                                    c.getSource().getEmbedBuilder()
                                            .title("Name Mentions Relay Off!")
                                            .color(Color.CYAN);
                                })))
                        .then(literal("mentionsWhileConnected")
                                .then(literal("on").executes(c -> {
                                    CONFIG.discord.chatRelay.mentionWhileConnected = true;
                                    c.getSource().getEmbedBuilder()
                                            .title("Mentions While Connected On!")
                                            .color(Color.CYAN);
                                }))
                                .then(literal("off").executes(c -> {
                                    CONFIG.discord.chatRelay.mentionWhileConnected = false;
                                    c.getSource().getEmbedBuilder()
                                            .title("Mentions While Connected Off!")
                                            .color(Color.CYAN);
                                })))
        );
    }
}
