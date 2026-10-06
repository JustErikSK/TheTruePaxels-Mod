package net.withrage.thetruepaxels.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.withrage.thetruepaxels.TheTruePaxels;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;

import static net.withrage.thetruepaxels.TheTruePaxels.MOD_ID;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheTruePaxels.MOD_ID);

    public static final DeferredItem<Item> WOODEN_PAXEL = registerPaxel("wooden_paxel", ModToolMaterial.WOOD, 1, -2.8F, TheTruePaxelsConfig.woodenDurability, false);
    public static final DeferredItem<Item> STONE_PAXEL = registerPaxel("stone_paxel", ModToolMaterial.STONE, 1, -2.8F, TheTruePaxelsConfig.stoneDurability, false);
    public static final DeferredItem<Item> COPPER_PAXEL = registerPaxel("copper_paxel", ModToolMaterial.COPPER, 1, -2.7F, TheTruePaxelsConfig.copperDurability, false);
    public static final DeferredItem<Item> GOLDEN_PAXEL = registerPaxel("golden_paxel", ModToolMaterial.GOLD, 1, -2.8F, TheTruePaxelsConfig.goldenDurability, false);
    public static final DeferredItem<Item> IRON_PAXEL = registerPaxel("iron_paxel", ModToolMaterial.IRON, 1, -2.7F, TheTruePaxelsConfig.ironDurability, false);
    public static final DeferredItem<Item> DIAMOND_PAXEL = registerPaxel("diamond_paxel", ModToolMaterial.DIAMOND, 1, -2.7F, TheTruePaxelsConfig.diamondDurability, false);
    public static final DeferredItem<Item> NETHERITE_PAXEL = registerPaxel("netherite_paxel", ModToolMaterial.NETHERITE, 1, -2.7F, TheTruePaxelsConfig.netheriteDurability, true);

    private static ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(TheTruePaxels.MOD_ID, name)
        );
    }

    private static DeferredItem<Item> registerPaxel(String name,
                                                    ToolMaterial material,
                                                    int attackDamage,
                                                    float attackSpeed,
                                                    int durability,
                                                    boolean fireproof) {
        return ITEMS.register(name, () -> {
            Item.Properties properties = new Item.Properties()
                    .setId(itemKey(name))
                    .stacksTo(1)
                    .durability(durability);
            if (fireproof) {
                properties = properties.fireResistant();
            }
            return new PaxelItem(material, attackDamage, attackSpeed, durability, properties);
        });
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        TheTruePaxels.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}