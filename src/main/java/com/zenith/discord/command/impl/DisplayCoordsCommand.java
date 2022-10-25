package com.zenith.discord.command.impl;

import com.mojang.brigadier.CommandDispatcher;
import com.zenith.discord.command.Command;
import com.zenith.discord.command.CommandContext;
import com.zenith.discord.command.CommandUsage;
import discord4j.rest.util.Color;

import static com.zenith.util.Constants.CONFIG;
import static java.util.Arrays.asList;

public class DisplayCoordsCommand extends Command {
    @Override
    public CommandUsage commandUsage() {
        return CommandUsage.args(
                "displayCoords",
                "Sets whether proxy status commands should display coordinates. Only usable by account owner(s).",
                asList("on/off")
        );
    }

    @Override
    public void register(CommandDispatcher<CommandContext> dispatcher) {
        dispatcher.register(
                command("displayCoords").requires(this::validateAccountOwner)
                        .then(literal("on").executes(c -> {
                            CONFIG.discord.reportCoords = true;
                            c.getSource().getEmbedBuilder()
                                    .title("Coordinates On!")
                                    .color(Color.CYAN);
                        }))
                        .then(literal("off").executes(c -> {
                            CONFIG.discord.reportCoords = false;
                            c.getSource().getEmbedBuilder()
                                    .title("Coordinates Off!")
                                    .color(Color.CYAN);
                        }))
        );
    }
}
