package net.withrage.thetruepaxels.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

public class PaxelItem extends Item {

    private final ToolMaterial material;

    public PaxelItem(ToolMaterial material,
                     int attackDamage,
                     float attackSpeed,
                     int durability,
                     Item.Properties properties) {
        super(
                properties
                        .durability(durability)
                        .attributes(ItemAttributeModifiers.builder()
                                .add(
                                        Attributes.ATTACK_DAMAGE,
                                        new AttributeModifier(
                                                BASE_ATTACK_DAMAGE_ID,
                                                attackDamage,
                                                AttributeModifier.Operation.ADD_VALUE
                                        ),
                                        EquipmentSlotGroup.MAINHAND
                                )
                                .add(
                                        Attributes.ATTACK_SPEED,
                                        new AttributeModifier(
                                                BASE_ATTACK_SPEED_ID,
                                                attackSpeed,
                                                AttributeModifier.Operation.ADD_VALUE
                                        ),
                                        EquipmentSlotGroup.MAINHAND
                                )
                                .build()
                        )
                        .tool(
                                material,
                                ModBlockTags.PAXEL_MINEABLE,
                                material.speed(),
                                1,
                                1.0F
                        )
        );

        this.material = material;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        super.inventoryTick(stack, level, entity, slot);
        if (level.isClientSide()) return;
        int dmg = stack.getDamageValue();
        if (dmg < 0) {
            stack.setDamageValue(0);
        }
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return isPaxelMineable(state)
                ? material.speed()
                : super.getDestroySpeed(stack, state);
    }

    private static boolean isPaxelMineable(BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE)
                || state.is(BlockTags.MINEABLE_WITH_AXE)
                || state.is(BlockTags.MINEABLE_WITH_SHOVEL)
                || state.is(BlockTags.MINEABLE_WITH_HOE);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack paxelStack = context.getItemInHand();

        boolean sneaking = player != null && player.isShiftKeyDown();

        if (sneaking && TheTruePaxelsConfig.farmlandMaking) {
            InteractionResult hoeResult = tryDelegateUseOnBlock(context, Items.DIAMOND_HOE);

            if (hoeResult.consumesAction()) {
                damagePaxelIfServer(context, player, paxelStack);
                return hoeResult;
            }
        }

        if (!sneaking) {
            if (TheTruePaxelsConfig.woodStripping) {
                InteractionResult axeResult = tryDelegateUseOnBlock(context, Items.DIAMOND_AXE);

                if (axeResult.consumesAction()) {
                    context.getLevel().playSound(
                            player,
                            context.getClickedPos(),
                            SoundEvents.AXE_STRIP,
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                    );

                    damagePaxelIfServer(context, player, paxelStack);
                    return axeResult;
                }
            }

            if (TheTruePaxelsConfig.pathMaking) {
                InteractionResult shovelResult = tryDelegateUseOnBlock(context, Items.DIAMOND_SHOVEL);

                if (shovelResult.consumesAction()) {
                    damagePaxelIfServer(context, player, paxelStack);
                    return shovelResult;
                }
            }
        }

        return super.useOn(context);
    }

    private static InteractionResult tryDelegateUseOnBlock(UseOnContext context, Item delegateItem) {
        ItemStack fakeTool = new ItemStack(delegateItem);

        BlockHitResult hitResult = new BlockHitResult(
                context.getClickLocation(),
                context.getClickedFace(),
                context.getClickedPos(),
                false
        );

        UseOnContext fakeContext = new UseOnContext(
                context.getLevel(),
                context.getPlayer(),
                context.getHand(),
                fakeTool,
                hitResult
        );

        return fakeTool.useOn(fakeContext);
    }

    private static void damagePaxelIfServer(UseOnContext context, Player player, ItemStack paxelStack) {
        if (player == null) return;
        if (context.getLevel().isClientSide()) return;

        EquipmentSlot slot = context.getHand() == InteractionHand.MAIN_HAND
                ? EquipmentSlot.MAINHAND
                : EquipmentSlot.OFFHAND;

        paxelStack.hurtAndBreak(1, player, slot);
    }
}