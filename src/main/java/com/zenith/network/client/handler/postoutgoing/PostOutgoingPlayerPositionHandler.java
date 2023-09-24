package com.zenith.network.client.handler.postoutgoing;

import com.github.steveice10.mc.protocol.packet.ingame.serverbound.player.ServerboundMovePlayerPosPacket;
import com.zenith.feature.spectator.SpectatorUtils;
import com.zenith.network.client.ClientSession;
import com.zenith.network.registry.PostOutgoingHandler;

import static com.zenith.Shared.CACHE;

public class PostOutgoingPlayerPositionHandler implements PostOutgoingHandler<ServerboundMovePlayerPosPacket, ClientSession> {

    @Override
    public void accept(ServerboundMovePlayerPosPacket packet, ClientSession session) {
        CACHE.getPlayerCache()
                .setX(packet.getX())
                .setY(packet.getY())
                .setZ(packet.getZ());
        SpectatorUtils.syncPlayerPositionWithSpectators();
//        CLIENT_LOG.info("Client set player position: {}, {}, {}", packet.getX(), packet.getY(), packet.getZ());
    }
}
