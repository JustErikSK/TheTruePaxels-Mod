package net.withrage.thetruepaxels.item.custom;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
    public static final TagKey<Item> WOODEN_TOOL_MATERIALS =
            TagKey.of(RegistryKeys.ITEM, Identifier.of("thetruepaxels", "wooden_tool_materials"));
    public static final TagKey<Item> STONE_TOOL_MATERIALS =
            TagKey.of(RegistryKeys.ITEM, Identifier.of("thetruepaxels", "stone_tool_materials"));
    public static final TagKey<Item> GOLDEN_TOOL_MATERIALS =
            TagKey.of(RegistryKeys.ITEM, Identifier.of("thetruepaxels", "golden_tool_materials"));
    public static final TagKey<Item> IRON_TOOL_MATERIALS =
            TagKey.of(RegistryKeys.ITEM, Identifier.of("thetruepaxels", "iron_tool_materials"));
    public static final TagKey<Item> DIAMOND_TOOL_MATERIALS =
            TagKey.of(RegistryKeys.ITEM, Identifier.of("thetruepaxels", "diamond_tool_materials"));
    public static final TagKey<Item> NETHERITE_TOOL_MATERIALS =
            TagKey.of(RegistryKeys.ITEM, Identifier.of("thetruepaxels", "netherite_tool_materials"));
    private ModItemTags() {}
}
