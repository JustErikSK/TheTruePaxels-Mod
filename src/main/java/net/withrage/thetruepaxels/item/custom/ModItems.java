package net.withrage.thetruepaxels.item.custom;

import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

import java.util.List;

import static net.withrage.thetruepaxels.TheTruePaxels.MOD_ID;

public class ModItems {
    public static final Item WOODEN_PAXEL  = registerPaxel("wooden_paxel",  ModToolMaterial.WOOD, 1, -2.8f, TheTruePaxelsConfig.woodenDurability, false);
    public static final Item STONE_PAXEL  = registerPaxel("stone_paxel",  ModToolMaterial.STONE, 1, -2.8f, TheTruePaxelsConfig.stoneDurability,false);
    public static final Item GOLDEN_PAXEL = registerPaxel("golden_paxel", ModToolMaterial.GOLD, 1, -2.8f, TheTruePaxelsConfig.goldenDurability,false);
    public static final Item IRON_PAXEL   = registerPaxel("iron_paxel",   ModToolMaterial.IRON, 1, -2.7f, TheTruePaxelsConfig.ironDurability,false);
    public static final Item DIAMOND_PAXEL= registerPaxel("diamond_paxel",ModToolMaterial.DIAMOND, 1, -2.7f, TheTruePaxelsConfig.diamondDurability,false);
    public static final Item NETHERITE_PAXEL= registerPaxel("netherite_paxel",ModToolMaterial.NETHERITE, 1, -2.7f, TheTruePaxelsConfig.netheriteDurability,true);

    private static Item registerPaxel(String name,
                                      ToolMaterial material,
                                      int attackDamage,
                                      float attackSpeed,
                                      int durability,
                                      boolean fireproof) {

        Identifier id = Identifier.of(TheTruePaxels.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);

        int enchantability = switch (name) {
            case "wooden_paxel"    -> 15;
            case "stone_paxel"     -> 5;
            case "golden_paxel"    -> 22;
            case "iron_paxel"      -> 14;
            case "diamond_paxel"   -> 11;
            case "netherite_paxel" -> 16;
            default -> 10;
        };

        Item.Settings settings = new Item.Settings()
                .registryKey(key)
                .maxCount(1)
                .maxDamage(durability)
                .enchantable(enchantability)
                .repairable(material.repairItems());

        if (fireproof) settings.fireproof();

        RegistryEntryLookup<Block> blockLookup = Registries.createEntryLookup(Registries.BLOCK);

        settings.component(
                DataComponentTypes.TOOL,
                new ToolComponent(
                        List.of(
                                ToolComponent.Rule.ofNeverDropping(blockLookup.getOrThrow(material.incorrectBlocksForDrops())),

                                ToolComponent.Rule.ofAlwaysDropping(blockLookup.getOrThrow(net.minecraft.registry.tag.BlockTags.PICKAXE_MINEABLE), material.speed()),
                                ToolComponent.Rule.ofAlwaysDropping(blockLookup.getOrThrow(net.minecraft.registry.tag.BlockTags.AXE_MINEABLE), material.speed()),
                                ToolComponent.Rule.ofAlwaysDropping(blockLookup.getOrThrow(net.minecraft.registry.tag.BlockTags.SHOVEL_MINEABLE), material.speed()),
                                ToolComponent.Rule.ofAlwaysDropping(blockLookup.getOrThrow(net.minecraft.registry.tag.BlockTags.HOE_MINEABLE), material.speed())
                        ),
                        1.0F,
                        1,
                        true
                )
        );
        Item paxel = new PaxelItem(settings);
        return Registry.register(Registries.ITEM, key, paxel);
    }

    public static void registerModItems() {
        TheTruePaxels.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
