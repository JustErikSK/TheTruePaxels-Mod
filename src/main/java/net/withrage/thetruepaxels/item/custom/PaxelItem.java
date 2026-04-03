package net.withrage.thetruepaxels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

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
        if (dmg < 0) {stack.setDamage(0);return;}
        if (dmg >= max) {stack.setDamage(max - 1);}
    }

    public PaxelItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(
                material,
                ModBlockTags.PAXEL_MINEABLE,
                settings.attributeModifiers(
                        MiningToolItem.createAttributeModifiers(material, attackDamage, attackSpeed)
                )
        );
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
