package com.zenith.cache.data.chunk;

import com.github.steveice10.mc.protocol.codec.MinecraftCodecHelper;
import com.github.steveice10.mc.protocol.data.game.chunk.ChunkSection;
import com.github.steveice10.mc.protocol.data.game.level.LightUpdateData;
import com.github.steveice10.mc.protocol.data.game.level.block.BlockEntityInfo;
import com.github.steveice10.opennbt.mini.MNBT;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Chunk {
    final int x;
    final int z;
    final ChunkSection[] sections;
    final int sectionsCount;
    final List<BlockEntityInfo> blockEntities;
    LightUpdateData lightUpdateData;
    MNBT heightMaps;

    public byte[] serialize(MinecraftCodecHelper codec) {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < sections.length; i++) {
            codec.writeChunkSection(buf, sections[i]);
        }
        return buf.array();
    }
}
