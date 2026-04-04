package net.withrage.thetruepaxels.item.custom;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.withrage.thetruepaxels.TheTruePaxels;

public class ModItemGroups {

    public static final ResourceKey<CreativeModeTab> THE_TRUE_PAXELS_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TheTruePaxels.MOD_ID, "the_true_paxels")
    );

    public static final CreativeModeTab THE_TRUE_PAXELS = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.DIAMOND_PAXEL))
            .title(Component.translatable("itemgroup.thetruepaxels"))
            .displayItems((params, output) -> {
                output.accept(ModItems.WOODEN_PAXEL);
                output.accept(ModItems.STONE_PAXEL);
                output.accept(ModItems.COPPER_PAXEL);
                output.accept(ModItems.GOLDEN_PAXEL);
                output.accept(ModItems.IRON_PAXEL);
                output.accept(ModItems.DIAMOND_PAXEL);
                output.accept(ModItems.NETHERITE_PAXEL);
            })
            .build();

    public static void registerItemGroups() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, THE_TRUE_PAXELS_KEY, THE_TRUE_PAXELS);
        TheTruePaxels.LOGGER.info("Registering Item Groups for " + TheTruePaxels.MOD_ID);
    }
}
