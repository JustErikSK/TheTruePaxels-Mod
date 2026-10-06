package net.withrage.thetruepaxels.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.withrage.thetruepaxels.TheTruePaxels;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheTruePaxels.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> THE_TRUE_PAXELS =
            CREATIVE_MODE_TABS.register("the_true_paxels", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemgroup.thetruepaxels"))
                            .icon(() -> new ItemStack(ModItems.DIAMOND_PAXEL.get()))
                            .displayItems((parameters, output) -> {
                                output.accept(ModItems.WOODEN_PAXEL.get());
                                output.accept(ModItems.STONE_PAXEL.get());
                                output.accept(ModItems.COPPER_PAXEL.get());
                                output.accept(ModItems.GOLDEN_PAXEL.get());
                                output.accept(ModItems.IRON_PAXEL.get());
                                output.accept(ModItems.DIAMOND_PAXEL.get());
                                output.accept(ModItems.NETHERITE_PAXEL.get());
                            }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
        TheTruePaxels.LOGGER.info("Registering Item Groups for " + TheTruePaxels.MOD_ID);
    }
}