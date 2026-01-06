package net.withrage.thetruepaxels.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;

import static net.withrage.thetruepaxels.TheTruePaxels.MOD_ID;

public class ModItems {
    public static final Item WOODEN_PAXEL  = registerPaxel("wooden_paxel",  ModToolMaterial.WOOD, 1, -2.8f, false);
    public static final Item STONE_PAXEL  = registerPaxel("stone_paxel",  ModToolMaterial.STONE, 1, -2.8f, false);
    public static final Item GOLDEN_PAXEL = registerPaxel("golden_paxel", ModToolMaterial.GOLD, 1, -2.8f, false);
    public static final Item IRON_PAXEL   = registerPaxel("iron_paxel",   ModToolMaterial.IRON, 1, -2.7f, false);
    public static final Item DIAMOND_PAXEL= registerPaxel("diamond_paxel",ModToolMaterial.DIAMOND, 1, -2.7f, false);
    public static final Item NETHERITE_PAXEL= registerPaxel("netherite_paxel",ModToolMaterial.NETHERITE, 1, -2.7f, true);

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

    public static void registerModItems() {
        TheTruePaxels.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
