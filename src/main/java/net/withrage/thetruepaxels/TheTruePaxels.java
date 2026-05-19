package net.withrage.thetruepaxels;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;
import net.withrage.thetruepaxels.item.custom.ModItemGroups;
import net.withrage.thetruepaxels.item.custom.ModItems;
import org.slf4j.Logger;

@Mod(TheTruePaxels.MOD_ID)
public class TheTruePaxels {
	public static final String MOD_ID = "thetruepaxels";
	public static final Logger LOGGER = LogUtils.getLogger();

	public TheTruePaxels(IEventBus modEventBus) {
		TheTruePaxelsConfig.load();
		ModItems.register(modEventBus);
		ModItemGroups.register(modEventBus);
	}
}