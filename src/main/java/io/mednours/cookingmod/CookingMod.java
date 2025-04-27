package io.mednours.cookingmod;

import io.mednours.cookingmod.block.ModBlocks;
import io.mednours.cookingmod.item.ModItemGroups;
import io.mednours.cookingmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookingMod implements ModInitializer {
	public static final String MOD_ID = "cookingmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		LOGGER.info("Initializing " + MOD_ID);

		// Register item groups, items, and blocks
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}