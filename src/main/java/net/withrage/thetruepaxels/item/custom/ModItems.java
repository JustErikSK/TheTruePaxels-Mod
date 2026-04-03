package net.withrage.thetruepaxels.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

import java.util.List;

import static net.withrage.thetruepaxels.TheTruePaxels.MOD_ID;

public class ModItems {
    public static final Item WOODEN_PAXEL = registerPaxel("wooden_paxel",  ModToolMaterial.WOOD, 1, -2.8f, TheTruePaxelsConfig.woodenDurability, false);
    public static final Item STONE_PAXEL = registerPaxel("stone_paxel",  ModToolMaterial.STONE, 1, -2.8f, TheTruePaxelsConfig.stoneDurability, false);
    public static final Item COPPER_PAXEL = registerPaxel("copper_paxel", ModToolMaterial.COPPER, 1, -2.7f, TheTruePaxelsConfig.copperDurability, false);
    public static final Item GOLDEN_PAXEL = registerPaxel("golden_paxel", ModToolMaterial.GOLD, 1, -2.8f, TheTruePaxelsConfig.goldenDurability, false);
    public static final Item IRON_PAXEL = registerPaxel("iron_paxel",   ModToolMaterial.IRON, 1, -2.7f, TheTruePaxelsConfig.ironDurability, false);
    public static final Item DIAMOND_PAXEL = registerPaxel("diamond_paxel",ModToolMaterial.DIAMOND, 1, -2.7f, TheTruePaxelsConfig.diamondDurability, false);
    public static final Item NETHERITE_PAXEL =registerPaxel("netherite_paxel",ModToolMaterial.NETHERITE, 1, -2.7f, TheTruePaxelsConfig.netheriteDurability, true);

    public static final Item COPPER_PICKAXE = register("copper_pickaxe", new PickaxeItem(ModToolMaterial.COPPER, new Item.Settings()));
    public static final Item COPPER_SHOVEL = register("copper_shovel", new ShovelItem(ModToolMaterial.COPPER, new Item.Settings()));
    public static final Item COPPER_AXE = register("copper_axe", new AxeItem(ModToolMaterial.COPPER, new Item.Settings()));

    private static Item registerPaxel(String name,
                                      ToolMaterial material,
                                      int attackDamage,
                                      float attackSpeed,
                                      int durability,
                                      boolean fireproof) {

        Item.Settings settings = new Item.Settings()
                .maxCount(1)
                .maxDamage(durability)
                .attributeModifiers(MiningToolItem.createAttributeModifiers(material, attackDamage, attackSpeed))
                .component(
                        DataComponentTypes.TOOL,
                        new ToolComponent(
                                List.of(
                                        ToolComponent.Rule.of(BlockTags.PICKAXE_MINEABLE, material.getMiningSpeedMultiplier()),
                                        ToolComponent.Rule.of(BlockTags.AXE_MINEABLE, material.getMiningSpeedMultiplier()),
                                        ToolComponent.Rule.of(BlockTags.SHOVEL_MINEABLE, material.getMiningSpeedMultiplier()),
                                        ToolComponent.Rule.of(BlockTags.HOE_MINEABLE, material.getMiningSpeedMultiplier())
                                ),
                                1.0F,
                                1
                        )
                );

        if (fireproof) settings.fireproof();

        return Registry.register(
                Registries.ITEM,
                Identifier.of(MOD_ID, name),
                new PaxelItem(material, attackDamage, attackSpeed, durability, settings)
        );
    }

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheTruePaxels.MOD_ID, id), item);
    }

    public static void registerModItems() {
        TheTruePaxels.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
