package net.withrage.thetruepaxels;

import net.fabricmc.api.ModInitializer;

import net.withrage.thetruepaxels.config.TheTruePaxelsConfig;
import net.withrage.thetruepaxels.item.custom.ModItemGroups;
import net.withrage.thetruepaxels.item.custom.ModItems;
import net.withrage.thetruepaxels.item.custom.ModToolMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheTruePaxels implements ModInitializer {
	public static final String MOD_ID = "thetruepaxels";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TheTruePaxelsConfig.load();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}