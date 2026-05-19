package net.withrage.thetruepaxels.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> WOODEN_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("thetruepaxels", "wooden_tool_materials"));
    public static final TagKey<Item> STONE_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("thetruepaxels", "stone_tool_materials"));
    public static final TagKey<Item> COPPER_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("thetruepaxels", "copper_tool_materials"));
    public static final TagKey<Item> GOLDEN_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("thetruepaxels", "golden_tool_materials"));
    public static final TagKey<Item> IRON_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("thetruepaxels", "iron_tool_materials"));
    public static final TagKey<Item> DIAMOND_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("thetruepaxels", "diamond_tool_materials"));
    public static final TagKey<Item> NETHERITE_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("thetruepaxels", "netherite_tool_materials"));
    private ModItemTags() {}
}
