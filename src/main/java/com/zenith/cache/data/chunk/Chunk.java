package com.zenith.cache.data.chunk;

import com.github.steveice10.mc.protocol.codec.MinecraftCodecHelper;
import com.github.steveice10.mc.protocol.data.game.chunk.ChunkSection;
import com.github.steveice10.mc.protocol.data.game.level.LightUpdateData;
import com.github.steveice10.mc.protocol.data.game.level.block.BlockEntityInfo;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Chunk {
    final int x;
    final int z;
    final ChunkSection[] sections;
    final int sectionsCount;
    final List<BlockEntityInfo> blockEntities;
    LightUpdateData lightUpdateData;

    public byte[] serialize(MinecraftCodecHelper codec) {
        ByteBuf buf = Unpooled.buffer();
        for (ChunkSection section : sections) {
            codec.writeChunkSection(buf, section);
        }
        return buf.array();
    }
}