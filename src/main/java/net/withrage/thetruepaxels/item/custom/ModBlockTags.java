package net.withrage.thetruepaxels.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.withrage.thetruepaxels.TheTruePaxels;

public class ModBlockTags {

    public static final TagKey<Block> PAXEL_MINEABLE =
            TagKey.create(
                    Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(TheTruePaxels.MOD_ID, "paxel_mineable")
            );
}