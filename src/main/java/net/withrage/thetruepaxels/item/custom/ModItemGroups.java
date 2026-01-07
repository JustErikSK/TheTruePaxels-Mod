package net.withrage.thetruepaxels.item.custom;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withrage.thetruepaxels.TheTruePaxels;

public class ModItemGroups {
    public static final ItemGroup THE_TRUE_PAXELS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TheTruePaxels.MOD_ID, "diamond_paxel"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.thetruepaxels"))
                    .icon(() -> new ItemStack(ModItems.DIAMOND_PAXEL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.WOODEN_PAXEL);
                        entries.add(ModItems.STONE_PAXEL);
                        entries.add(ModItems.GOLDEN_PAXEL);
                        entries.add(ModItems.IRON_PAXEL);
                        entries.add(ModItems.DIAMOND_PAXEL);
                        entries.add(ModItems.NETHERITE_PAXEL);
                    }).build());

    public static void registerItemGroups() {
        TheTruePaxels.LOGGER.info("Registering Item Groups for " + TheTruePaxels.MOD_ID);
    }
}
