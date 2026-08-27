package net.withrage.thetruepaxels.item.custom;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

public class ModToolMaterial {
    public static final ToolMaterial WOOD =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_WOODEN_TOOL,
                    TheTruePaxelsConfig.woodenDurability,
                    2.0f,
                    0.0f,
                    15,
                    ModItemTags.WOODEN_TOOL_MATERIALS
            );

    public static final ToolMaterial STONE =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_STONE_TOOL,
                    TheTruePaxelsConfig.stoneDurability,
                    4.0f,
                    1.0f,
                    5,
                    ModItemTags.STONE_TOOL_MATERIALS
            );

    public static final ToolMaterial COPPER =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_GOLD_TOOL,
                    TheTruePaxelsConfig.stoneDurability,
                    5.0f,
                    1.0f,
                    10,
                    ModItemTags.COPPER_TOOL_MATERIALS
            );

    public static final ToolMaterial GOLD =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_GOLD_TOOL,
                    TheTruePaxelsConfig.goldenDurability,
                    12.0f,
                    0.0f,
                    22,
                    ModItemTags.GOLDEN_TOOL_MATERIALS
            );

    public static final ToolMaterial IRON =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_IRON_TOOL,
                    TheTruePaxelsConfig.ironDurability,
                    6.0f,
                    2.0f,
                    14,
                    ModItemTags.IRON_TOOL_MATERIALS
            );

    public static final ToolMaterial DIAMOND =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
                    TheTruePaxelsConfig.diamondDurability,
                    8.0f,
                    3.0f,
                    18,
                    ModItemTags.DIAMOND_TOOL_MATERIALS
            );

    public static final ToolMaterial NETHERITE =
            new ToolMaterial(
                    BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
                    TheTruePaxelsConfig.netheriteDurability,
                    9.0f,
                    4.0f,
                    16,
                    ModItemTags.NETHERITE_TOOL_MATERIALS
            );
}
