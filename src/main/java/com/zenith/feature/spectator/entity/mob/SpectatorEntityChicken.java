package com.zenith.feature.spectator.entity.mob;

import com.zenith.cache.data.PlayerCache;
import org.geysermc.mcprotocollib.auth.GameProfile;
import org.geysermc.mcprotocollib.network.packet.Packet;
import org.geysermc.mcprotocollib.protocol.data.game.entity.metadata.EntityMetadata;
import org.geysermc.mcprotocollib.protocol.data.game.entity.type.EntityType;
import org.geysermc.mcprotocollib.protocol.data.game.level.sound.BuiltinSound;

import java.util.ArrayList;
import java.util.Optional;

public class SpectatorEntityChicken extends SpectatorMob {
    @Override
    public ArrayList<EntityMetadata<?, ?>> getBaseEntityMetadata(final GameProfile spectatorProfile, final int spectatorEntityId) {
        return noMetadataList();
    }

    @Override
    EntityType getType() {
        return EntityType.CHICKEN;
    }

    @Override
    public double getEyeHeight() {
        return 0.644;
    }

    @Override
    public double getHeight() {
        return 0.7;
    }

    @Override
    public double getWidth() {
        return 0.4;
    }

    @Override
    public Optional<Packet> getSoundPacket(final PlayerCache playerCache) {
        return Optional.of(buildSoundPacket(playerCache, BuiltinSound.ENTITY_CHICKEN_EGG, BuiltinSound.ENTITY_CHICKEN_AMBIENT));
    }
}
