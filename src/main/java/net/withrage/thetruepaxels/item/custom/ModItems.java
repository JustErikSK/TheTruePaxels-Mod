package net.withrage.thetruepaxels.item.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;

public class ModItems {
    public static final Item WOODEN_PAXEL = registerItem("wooden_paxel", /*new Item(ModToolMaterial.WOOD, 1, -2.8F, new Item.Settings().maxCount(1).maxDamage(69)))*/ new Item(new FabricItemSettings()));
    public static final Item STONE_PAXEL = registerItem("stone_paxel", new Item(new FabricItemSettings()));
    public static final Item GOLDEN_PAXEL = registerItem("golden_paxel", new Item(new FabricItemSettings()));
    public static final Item IRON_PAXEL = registerItem("iron_paxel", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_PAXEL = registerItem("diamond_paxel", new Item(new FabricItemSettings()));
    public static final Item NETHERITE_PAXEL = registerItem("netherite_paxel", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TheTruePaxels.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheTruePaxels.LOGGER.info("Registering Mod Items for " + TheTruePaxels.MOD_ID);
    }
}
