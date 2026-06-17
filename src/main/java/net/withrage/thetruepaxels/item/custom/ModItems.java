package net.withrage.thetruepaxels.item.custom;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.withrage.thetruepaxels.TheTruePaxels;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

public class ModItems {
    public static final Item WOODEN_PAXEL = registerPaxel("wooden_paxel", ModToolMaterial.WOOD, 1.0F, -2.8F, TheTruePaxelsConfig.woodenDurability, false);
    public static final Item STONE_PAXEL = registerPaxel("stone_paxel", ModToolMaterial.STONE, 1.0F, -2.8F, TheTruePaxelsConfig.stoneDurability, false);
    public static final Item COPPER_PAXEL = registerPaxel("copper_paxel", ModToolMaterial.COPPER, 1.0F, -2.8F, TheTruePaxelsConfig.copperDurability, false);
    public static final Item GOLDEN_PAXEL = registerPaxel("golden_paxel", ModToolMaterial.GOLD, 1.0F, -2.8F, TheTruePaxelsConfig.goldenDurability, false);
    public static final Item IRON_PAXEL = registerPaxel("iron_paxel", ModToolMaterial.IRON, 1.0F, -2.7F, TheTruePaxelsConfig.ironDurability, false);
    public static final Item DIAMOND_PAXEL = registerPaxel("diamond_paxel", ModToolMaterial.DIAMOND, 1.0F, -2.7F, TheTruePaxelsConfig.diamondDurability, false);
    public static final Item NETHERITE_PAXEL = registerPaxel("netherite_paxel", ModToolMaterial.NETHERITE, 1.0F, -2.7F, TheTruePaxelsConfig.netheriteDurability, true);

    private static Item registerPaxel(String name,
                                      ToolMaterial material,
                                      float attackDamage,
                                      float attackSpeed,
                                      int durability,
                                      boolean fireproof) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(TheTruePaxels.MOD_ID, name)
        );

        Item.Properties properties = new Item.Properties()
                .setId(itemKey)
                .durability(durability)
                .tool(material, ModBlockTags.PAXEL_MINEABLE, attackDamage, attackSpeed, 0.0F);

        if (fireproof) {
            properties = properties.fireResistant();
        }

        Item paxel = new PaxelItem(properties);
        return Registry.register(BuiltInRegistries.ITEM, itemKey, paxel);
    }

    public static void registerModItems() {
        TheTruePaxels.LOGGER.info("Registering Mod Items for {}", TheTruePaxels.MOD_ID);
    }
}
