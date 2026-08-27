package net.withrage.thetruepaxels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

public class ModToolMaterial {
    public static final ToolMaterial WOOD = new ToolMaterial() {
        @Override public int getDurability() { return TheTruePaxelsConfig.woodenDurability; }
        @Override public float getMiningSpeedMultiplier() { return 2.0F; }
        @Override public float getAttackDamage() { return 1.0F; }
        @Override public int getEnchantability() { return 8; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.fromTag(ItemTags.PLANKS); }
        @Override public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_WOODEN_TOOL; }
    };

    public static final ToolMaterial STONE = new ToolMaterial() {
        @Override public int getDurability() { return TheTruePaxelsConfig.stoneDurability; }
        @Override public float getMiningSpeedMultiplier() { return 4.0F; }
        @Override public float getAttackDamage() { return 1.0F; }
        @Override public int getEnchantability() { return 9; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS); }
        @Override public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_STONE_TOOL; }
    };

    public static final ToolMaterial COPPER = new ToolMaterial() {
        @Override public int getDurability() { return TheTruePaxelsConfig.copperDurability; }
        @Override public float getMiningSpeedMultiplier() { return 5.0F; }
        @Override public float getAttackDamage() { return 1.0F; }
        @Override public int getEnchantability() { return 10; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.COPPER_INGOT); }
        @Override public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_IRON_TOOL; }
    };

    public static final ToolMaterial GOLD = new ToolMaterial() {
        @Override public int getDurability() { return TheTruePaxelsConfig.goldenDurability; }
        @Override public float getMiningSpeedMultiplier() { return 12.0F; }
        @Override public float getAttackDamage() { return 1.0F; }
        @Override public int getEnchantability() { return 11; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.GOLD_INGOT); }
        @Override public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_GOLD_TOOL; }
    };

    public static final ToolMaterial IRON = new ToolMaterial() {
        @Override public int getDurability() { return TheTruePaxelsConfig.ironDurability; }
        @Override public float getMiningSpeedMultiplier() { return 6.0F; }
        @Override public float getAttackDamage() { return 2.0F; }
        @Override public int getEnchantability() { return 12; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.IRON_INGOT); }
        @Override public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_IRON_TOOL; }
    };

    public static final ToolMaterial DIAMOND = new ToolMaterial() {
        @Override public int getDurability() { return TheTruePaxelsConfig.diamondDurability; }
        @Override public float getMiningSpeedMultiplier() { return 8.0F; }
        @Override public float getAttackDamage() { return 3.0F; }
        @Override public int getEnchantability() { return 16; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.DIAMOND); }
        @Override public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_DIAMOND_TOOL; }
    };

    public static final ToolMaterial NETHERITE = new ToolMaterial() {
        @Override public int getDurability() { return TheTruePaxelsConfig.netheriteDurability; }
        @Override public float getMiningSpeedMultiplier() { return 9.0F; }
        @Override public float getAttackDamage() { return 4.0F; }
        @Override public int getEnchantability() { return 16; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(Items.NETHERITE_INGOT); }
        @Override public TagKey<Block> getInverseTag() { return BlockTags.INCORRECT_FOR_NETHERITE_TOOL; }
    };
}
