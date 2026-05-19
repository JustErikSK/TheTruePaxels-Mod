package net.withrage.thetruepaxels;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;
import net.withrage.thetruepaxels.item.custom.ModItemGroups;
import net.withrage.thetruepaxels.item.custom.ModItems;
import org.slf4j.Logger;

@Mod(TheTruePaxels.MOD_ID)
public class TheTruePaxels {
	public static final String MOD_ID = "thetruepaxels";
	public static final Logger LOGGER = LogUtils.getLogger();

	public TheTruePaxels() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		TheTruePaxelsConfig.load();

		ModItems.register(modEventBus);
		ModItemGroups.register(modEventBus);
	}
}