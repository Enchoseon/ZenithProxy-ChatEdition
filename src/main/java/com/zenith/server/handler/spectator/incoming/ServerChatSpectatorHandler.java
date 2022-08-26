package com.zenith.server.handler.spectator.incoming;

import com.github.steveice10.mc.protocol.packet.ingame.client.ClientChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerChatPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityDestroyPacket;
import com.zenith.server.ServerConnection;
import com.zenith.util.handler.HandlerRegistry;
import com.zenith.util.spectator.SpectatorEntityRegistry;

public class ServerChatSpectatorHandler implements HandlerRegistry.IncomingHandler<ClientChatPacket, ServerConnection> {

    @Override
    public boolean apply(ClientChatPacket packet, ServerConnection session) {
        if (packet.getMessage().startsWith("!m")) {
            session.getProxy().getClient().send(new ClientChatPacket(packet.getMessage().substring(2).trim()));
        } else if (packet.getMessage().startsWith("!e")) {
            String entityId = packet.getMessage().substring(2).trim();
            boolean spectatorEntitySet = session.setSpectatorEntity(entityId);
            if (spectatorEntitySet) {
                // respawn entity on all connections
                session.getProxy().getServerConnections().forEach(connection -> {
                    if (connection.equals(session)) {
                        session.send(new ServerEntityDestroyPacket(session.getSpectatorSelfEntityId()));
                        session.send(session.getSelfSpawnPacket());
                    } else {
                        connection.send(new ServerEntityDestroyPacket(session.getSpectatorEntityId()));
                        connection.send(session.getSpawnPacket());
                    }
                });
                session.send(new ServerChatPacket("§9Updated entity to: " + entityId + "§r", true));
            } else {
                session.send(new ServerChatPacket("§cNo entity found with id: " + entityId + "§r", true));
                session.send(new ServerChatPacket("§cValid id's: " + String.join(", ", SpectatorEntityRegistry.getEntityIdentifiers()) + "§r", true));
            }
        } else {
            session.getProxy().getServerConnections().forEach(connection -> {
                connection.send(new ServerChatPacket("§c" + session.getProfileCache().getProfile().getName() + " > " + packet.getMessage() + "§r", true));
            });
        }
        return false;
    }

    @Override
    public Class<ClientChatPacket> getPacketClass() {
        return ClientChatPacket.class;
    }
}