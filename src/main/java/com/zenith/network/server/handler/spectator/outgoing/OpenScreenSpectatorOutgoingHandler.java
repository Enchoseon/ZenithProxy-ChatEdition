package com.zenith.network.server.handler.spectator.outgoing;

import com.github.steveice10.mc.protocol.packet.ingame.clientbound.inventory.ClientboundOpenScreenPacket;
import com.zenith.network.registry.OutgoingHandler;
import com.zenith.network.server.ServerConnection;

public class OpenScreenSpectatorOutgoingHandler implements OutgoingHandler<ClientboundOpenScreenPacket, ServerConnection> {
    @Override
    public ClientboundOpenScreenPacket apply(ClientboundOpenScreenPacket packet, ServerConnection session) {
        return null;
    }
}
