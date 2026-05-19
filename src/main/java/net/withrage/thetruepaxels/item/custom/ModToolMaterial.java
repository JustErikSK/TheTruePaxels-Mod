package net.withrage.thetruepaxels.item.custom;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

public class ModToolMaterial {

    public static final Tier WOOD = new Tier() {
        @Override public int getUses() { return TheTruePaxelsConfig.woodenDurability; }
        @Override public float getSpeed() { return 6.0F; }
        @Override public float getAttackDamageBonus() { return 1.0F; }
        @Override public int getLevel() { return 0; }
        @Override public int getEnchantmentValue() { return 8; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(ItemTags.PLANKS); }
    };

    public static final Tier STONE = new Tier() {
        @Override public int getUses() { return TheTruePaxelsConfig.stoneDurability; }
        @Override public float getSpeed() { return 6.0F; }
        @Override public float getAttackDamageBonus() { return 1.0F; }
        @Override public int getLevel() { return 1; }
        @Override public int getEnchantmentValue() { return 9; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(ItemTags.STONE_TOOL_MATERIALS); }
    };

    public static final Tier COPPER = new Tier() {
        @Override public int getUses() { return TheTruePaxelsConfig.copperDurability; }
        @Override public float getSpeed() { return 6.0F; }
        @Override public float getAttackDamageBonus() { return 1.0F; }
        @Override public int getLevel() { return 2; }
        @Override public int getEnchantmentValue() { return 10; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(Items.COPPER_INGOT); }
    };

    public static final Tier GOLD = new Tier() {
        @Override public int getUses() { return TheTruePaxelsConfig.goldenDurability; }
        @Override public float getSpeed() { return 6.0F; }
        @Override public float getAttackDamageBonus() { return 1.0F; }
        @Override public int getLevel() { return 0; }
        @Override public int getEnchantmentValue() { return 11; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(Items.GOLD_INGOT); }
    };

    public static final Tier IRON = new Tier() {
        @Override public int getUses() { return TheTruePaxelsConfig.ironDurability; }
        @Override public float getSpeed() { return 6.0F; }
        @Override public float getAttackDamageBonus() { return 2.0F; }
        @Override public int getLevel() { return 2; }
        @Override public int getEnchantmentValue() { return 12; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(Items.IRON_INGOT); }
    };

    public static final Tier DIAMOND = new Tier() {
        @Override public int getUses() { return TheTruePaxelsConfig.diamondDurability; }
        @Override public float getSpeed() { return 7.0F; }
        @Override public float getAttackDamageBonus() { return 3.0F; }
        @Override public int getLevel() { return 3; }
        @Override public int getEnchantmentValue() { return 16; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(Items.DIAMOND); }
    };

    public static final Tier NETHERITE = new Tier() {
        @Override public int getUses() { return TheTruePaxelsConfig.netheriteDurability; }
        @Override public float getSpeed() { return 8.0F; }
        @Override public float getAttackDamageBonus() { return 4.0F; }
        @Override public int getLevel() { return 4; }
        @Override public int getEnchantmentValue() { return 16; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.of(Items.NETHERITE_INGOT); }
    };
}