package net.withrage.thetruepaxels.item.custom;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;

import static net.withrage.thetruepaxels.TheTruePaxels.MOD_ID;

public class ModItems {
    public static final Item WOODEN_PAXEL  = registerPaxel("wooden_paxel",  ModToolMaterial.WOOD, 1, -2.8f, false);
    public static final Item STONE_PAXEL  = registerPaxel("stone_paxel",  ModToolMaterial.STONE, 1, -2.8f, false);
    public static final Item COPPER_PAXEL = registerPaxel("copper_paxel", ModToolMaterial.COPPER, 1, -2.7f, false);
    public static final Item GOLDEN_PAXEL = registerPaxel("golden_paxel", ModToolMaterial.GOLD, 1, -2.8f, false);
    public static final Item IRON_PAXEL   = registerPaxel("iron_paxel",   ModToolMaterial.IRON, 1, -2.7f, false);
    public static final Item DIAMOND_PAXEL= registerPaxel("diamond_paxel",ModToolMaterial.DIAMOND, 1, -2.7f, false);
    public static final Item NETHERITE_PAXEL= registerPaxel("netherite_paxel",ModToolMaterial.NETHERITE, 1, -2.7f, true);

    public static final Item COPPER_PICKAXE = register("copper_pickaxe", settings -> new PickaxeItem(ModToolMaterial.COPPER, 1.0f, -2.8f, settings));
    public static final Item COPPER_SHOVEL = register("copper_shovel", settings -> new ShovelItem(ModToolMaterial.COPPER, 1.5f, -3.0f, settings));
    public static final Item COPPER_AXE = register("copper_axe", settings -> new AxeItem(ModToolMaterial.COPPER, 6.0f, -3.1f, settings));

    private static Item registerPaxel(String name,
                                          ToolMaterial material,
                                          int attackDamage,
                                          float attackSpeed,
                                          boolean fireproof) {

        Identifier id = Identifier.of(TheTruePaxels.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(Registries.ITEM.getKey(), id);

        Item.Settings settings = new Item.Settings()
                .registryKey(key)
                .maxCount(1);

        if (fireproof) settings.fireproof();

        Item hammer = new PaxelItem(material, attackDamage, attackSpeed, settings);

        return Registry.register(Registries.ITEM, id, hammer);
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
