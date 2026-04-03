package net.withrage.thetruepaxels.item.custom;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

import static net.withrage.thetruepaxels.TheTruePaxels.MOD_ID;

public class ModItems {
    public static final Item WOODEN_PAXEL  = registerPaxel("wooden_paxel",  ModToolMaterial.WOOD, 1, -2.8f, TheTruePaxelsConfig.woodenDurability, false);
    public static final Item STONE_PAXEL  = registerPaxel("stone_paxel",  ModToolMaterial.STONE, 1, -2.8f, TheTruePaxelsConfig.stoneDurability,false);
    public static final Item COPPER_PAXEL = registerPaxel("copper_paxel", ModToolMaterial.COPPER, 1, -2.7f, TheTruePaxelsConfig.copperDurability,false);
    public static final Item GOLDEN_PAXEL = registerPaxel("golden_paxel", ModToolMaterial.GOLD, 1, -2.8f, TheTruePaxelsConfig.goldenDurability,false);
    public static final Item IRON_PAXEL   = registerPaxel("iron_paxel",   ModToolMaterial.IRON, 1, -2.7f, TheTruePaxelsConfig.ironDurability,false);
    public static final Item DIAMOND_PAXEL= registerPaxel("diamond_paxel",ModToolMaterial.DIAMOND, 1, -2.7f, TheTruePaxelsConfig.diamondDurability,false);
    public static final Item NETHERITE_PAXEL= registerPaxel("netherite_paxel",ModToolMaterial.NETHERITE, 1, -2.7f, TheTruePaxelsConfig.netheriteDurability,true);

    public static final Item COPPER_PICKAXE = register("copper_pickaxe", settings -> new Item(settings.pickaxe(ModToolMaterial.COPPER, 1.0f, -2.8f)));
    public static final Item COPPER_SHOVEL = register("copper_shovel", settings -> new ShovelItem(ModToolMaterial.COPPER, 1.5f, -3.0f, settings));
    public static final Item COPPER_AXE = register("copper_axe", settings -> new AxeItem(ModToolMaterial.COPPER, 6.0f, -3.1f, settings));

    private static Item registerPaxel(String name,
                                      ToolMaterial material,
                                      float attackDamage,
                                      float attackSpeed,
                                      int durability,
                                      boolean fireproof) {

        Identifier id = Identifier.of(TheTruePaxels.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);

        int enchantability = switch (name) {
            case "wooden_paxel"    -> 15;
            case "stone_paxel"     -> 5;
            case "copper_paxel"    -> 12;
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
                .repairable(material.repairItems())
                .tool(material, PaxelItem.PAXEL_MINEABLE, attackDamage, attackSpeed, 0.0f);

        if (fireproof) {
            settings.fireproof();
        }

        Item paxel = new PaxelItem(settings);
        return Registry.register(Registries.ITEM, key, paxel);
    }

    private static Item register(String name, java.util.function.Function<Item.Settings, Item> factory) {
        Identifier id = Identifier.of(TheTruePaxels.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);
        Item.Settings settings = new Item.Settings().registryKey(key);
        return Registry.register(Registries.ITEM, key, factory.apply(settings));
    }

    public static void registerModItems() {
        TheTruePaxels.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
