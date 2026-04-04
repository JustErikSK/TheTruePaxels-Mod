package net.withrage.thetruepaxels.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

public class PaxelItem extends Item {
    public static final TagKey<Block> PAXEL_MINEABLE = TagKey.create(
            Registries.BLOCK,
            Identifier.fromNamespaceAndPath("thetruepaxels", "paxel_mineable")
    );

    public PaxelItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        super.inventoryTick(stack, level, entity, slot);
        if (level.isClientSide()) return;
        if (!(entity instanceof Player)) return;
        int max = stack.getMaxDamage();
        if (max <= 0) return;
        int dmg = stack.getDamageValue();
        if (dmg < 0) {stack.setDamageValue(0);return;}
        if (dmg >= max) {stack.setDamageValue(max - 1);}
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack paxelStack = context.getItemInHand();
        boolean sneaking = player != null && player.isShiftKeyDown();
        if (sneaking) {
            if (TheTruePaxelsConfig.farmlandMaking) {
                InteractionResult hoeResult = tryDelegateUseOnBlock(context, Items.DIAMOND_HOE);
                if (hoeResult.consumesAction()) {
                    damagePaxelIfServer(context, player, paxelStack);
                    return hoeResult;
                }
            }
        }
        if (!sneaking) {
            if (TheTruePaxelsConfig.woodStripping) {
                InteractionResult axeResult = tryDelegateUseOnBlock(context, Items.DIAMOND_AXE);
                if (TheTruePaxelsConfig.woodStripping && axeResult.consumesAction()) {
                    damagePaxelIfServer(context, player, paxelStack);
                    return axeResult;
                }
            }
            if (TheTruePaxelsConfig.pathMaking) {
                InteractionResult shovelResult = tryDelegateUseOnBlock(context, Items.DIAMOND_SHOVEL);
                if (TheTruePaxelsConfig.pathMaking && shovelResult.consumesAction()) {
                    damagePaxelIfServer(context, player, paxelStack);
                    return shovelResult;
                }
            }
        }
        return super.useOn(context);
    }

    private static InteractionResult tryDelegateUseOnBlock(UseOnContext context, Item delegateItem) {
        ItemStack fakeTool = new ItemStack(delegateItem);
        return fakeTool.useOn(context);
    }

    private static void damagePaxelIfServer(UseOnContext context, Player player, ItemStack paxelStack) {
        if (player == null) return;
        if (context.getLevel().isClientSide()) return;
        EquipmentSlot slot = (context.getHand() == InteractionHand.MAIN_HAND)
                ? EquipmentSlot.MAINHAND
                : EquipmentSlot.OFFHAND;
        paxelStack.hurtAndBreak(1, player, slot);
    }
}
