package net.withrage.thetruepaxels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

public class PaxelItem extends Item {
    public static final TagKey<Block> PAXEL_MINEABLE = TagKey.of(
            RegistryKeys.BLOCK,
            Identifier.of("thetruepaxels", "paxel_mineable")
    );

    public PaxelItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, EquipmentSlot slot) {
        super.inventoryTick(stack, world, entity, slot);
        if (world.isClient()) return;
        if (!(entity instanceof PlayerEntity)) return;
        int max = stack.getMaxDamage();
        if (max <= 0) return;
        int dmg = stack.getDamage();
        if (dmg < 0) {stack.setDamage(0);return;}
        if (dmg >= max) {stack.setDamage(max - 1);}
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        ItemStack paxelStack = context.getStack();
        boolean sneaking = player != null && player.isSneaking();
        if (sneaking) {
            if (TheTruePaxelsConfig.farmlandMaking) {
                ActionResult hoeResult = tryDelegateUseOnBlock(context, Items.DIAMOND_HOE);
                if (hoeResult.isAccepted()) {
                    damagePaxelIfServer(context, player, paxelStack);
                    return hoeResult;
                }
            }
        }
        if (!sneaking) {
            if (TheTruePaxelsConfig.woodStripping) {
                ActionResult axeResult = tryDelegateUseOnBlock(context, Items.DIAMOND_AXE);
                if (TheTruePaxelsConfig.woodStripping && axeResult.isAccepted()) {
                    damagePaxelIfServer(context, player, paxelStack);
                    return axeResult;
                }
            }
            if (TheTruePaxelsConfig.pathMaking) {
                ActionResult shovelResult = tryDelegateUseOnBlock(context, Items.DIAMOND_SHOVEL);
                if (TheTruePaxelsConfig.pathMaking && shovelResult.isAccepted()) {
                    damagePaxelIfServer(context, player, paxelStack);
                    return shovelResult;
                }
            }
        }
        return super.useOnBlock(context);
    }

    private static ActionResult tryDelegateUseOnBlock(ItemUsageContext context, Item delegateItem) {
        ItemStack fakeTool = new ItemStack(delegateItem);
        return fakeTool.useOnBlock(context);
    }

    private static void damagePaxelIfServer(ItemUsageContext context, PlayerEntity player, ItemStack paxelStack) {
        if (player == null) return;
        if (context.getWorld().isClient()) return;
        EquipmentSlot slot = (context.getHand() == Hand.MAIN_HAND)
                ? EquipmentSlot.MAINHAND
                : EquipmentSlot.OFFHAND;
        paxelStack.damage(1, player, slot);
    }
}
