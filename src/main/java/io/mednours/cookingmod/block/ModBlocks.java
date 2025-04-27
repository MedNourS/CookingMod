package io.mednours.cookingmod.block;

import io.mednours.cookingmod.CookingMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // Blocks
    public static final Block COOKING_TABLE = registerBlock(
            "cooking_table",
            AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CookingMod.MOD_ID,
                                            "cooking_table"
                    )))
                    // Add properties for the block here
                    .strength(1.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOD)
    );

    // Helper method to register a block with an item
    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(CookingMod.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    // Helper method to register a block item
    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CookingMod.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    // Method to register all mod blocks
    public static void registerModBlocks() {
        CookingMod.LOGGER.info("Registering ModBlocks for " + CookingMod.MOD_ID);

        // Add blocks to FUNCTIONAL item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(COOKING_TABLE);
        });
    }
}
