package net.withrage.thetruepaxels.item.custom;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;

public class ModToolMaterial {
    public static final ToolMaterial WOOD = ToolMaterials.WOOD;
    public static final ToolMaterial STONE = ToolMaterials.STONE;
    public static final ToolMaterial GOLD = ToolMaterials.GOLD;
    public static final ToolMaterial IRON = ToolMaterials.IRON;
    public static final ToolMaterial DIAMOND = ToolMaterials.DIAMOND;
    public static final ToolMaterial NETHERITE = ToolMaterials.NETHERITE;

    public static final ToolMaterial COPPER = new ToolMaterial() {
        @Override
        public int getDurability() {
            return 262;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 5.0F;
        }

        @Override
        public float getAttackDamage() {
            return 2.0F;
        }

        @Override
        public int getMiningLevel() {
            return 2;
        }

        @Override
        public int getEnchantability() {
            return 12;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.COPPER_INGOT);
        }
    };
}
