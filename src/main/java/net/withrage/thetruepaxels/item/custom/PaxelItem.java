package net.withrage.thetruepaxels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class PaxelItem extends MiningToolItem {
    public static final TagKey<Block> PAXEL_MINEABLE = TagKey.of(
            RegistryKeys.BLOCK,
            new Identifier("thetruepaxels", "paxel_mining")
    );

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (world.isClient()) return;

        int max = stack.getMaxDamage();
        if (max <= 0) return;

        int dmg = stack.getDamage();

        if (dmg < 0) {
            stack.setDamage(0);
            return;
        }
        if (dmg >= max) {
            stack.setDamage(max - 1);
        }
    }

    public PaxelItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(
                attackDamage,
                attackSpeed,
                material,
                PAXEL_MINEABLE,
                settings
        );
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isIn(BlockTags.PICKAXE_MINEABLE)
                || state.isIn(BlockTags.AXE_MINEABLE)
                || state.isIn(BlockTags.SHOVEL_MINEABLE)
                || super.isSuitableFor(state);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isIn(BlockTags.PICKAXE_MINEABLE)
                || state.isIn(BlockTags.AXE_MINEABLE)
                || state.isIn(BlockTags.SHOVEL_MINEABLE)) {
            return this.getMaterial().getMiningSpeedMultiplier();
        }
        return super.getMiningSpeedMultiplier(stack, state);
    }
}
