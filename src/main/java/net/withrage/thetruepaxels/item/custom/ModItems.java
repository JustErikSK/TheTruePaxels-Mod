package net.withrage.thetruepaxels.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

import static net.withrage.thetruepaxels.TheTruePaxels.MOD_ID;

public class ModItems {
    public static final Item WOODEN_PAXEL = registerPaxel("wooden_paxel", ToolMaterials.WOOD, 3, -2.8f, TheTruePaxelsConfig.woodenDurability, false);
    public static final Item STONE_PAXEL  = registerPaxel("stone_paxel",  ToolMaterials.STONE, 4, -2.8f, TheTruePaxelsConfig.stoneDurability, false);
    public static final Item GOLDEN_PAXEL = registerPaxel("golden_paxel", ToolMaterials.GOLD, 3, -2.8f, TheTruePaxelsConfig.goldenDurability, false);
    public static final Item IRON_PAXEL   = registerPaxel("iron_paxel",   ToolMaterials.IRON, 4, -2.7f, TheTruePaxelsConfig.ironDurability, false);
    public static final Item DIAMOND_PAXEL= registerPaxel("diamond_paxel",ToolMaterials.DIAMOND, 5, -2.7f, TheTruePaxelsConfig.diamondDurability, false);
    public static final Item NETHERITE_PAXEL=registerPaxel("netherite_paxel",ToolMaterials.NETHERITE, 6, -2.7f, TheTruePaxelsConfig.netheriteDurability, true);

    private static Item registerPaxel(String name, ToolMaterial material, int attackDamage, float attackSpeed, int durability, boolean fireproof) {
        Item.Settings settings = new Item.Settings()
                .maxCount(1)
                .maxDamage(Math.max(1, durability));

        if (fireproof) settings.fireproof();

        return Registry.register(Registries.ITEM,
                new Identifier(MOD_ID, name),
                new PaxelItem(material, attackDamage, attackSpeed, settings));
    }

    public static void registerModItems() {
        TheTruePaxels.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
