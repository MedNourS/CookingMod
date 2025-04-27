package io.mednours.cookingmod.item;

import io.mednours.cookingmod.CookingMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Items
    public static final Item COOKING_KNIFE = registerItem(
                "cooking_knife" // Put Name Here
            , new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CookingMod.MOD_ID,
                "cooking_knife" // Put Name Here
            )))
                // Add properties for the item here
                .maxCount(1)
    );
    public static final Item COOKBOOK = registerItem(
                "cookbook" // Put Name Here
            , new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CookingMod.MOD_ID,
                "cookbook" // Put Name Here
            )))
                // Add properties for the item here
                .maxCount(1)
    );

    // Helper method to register an item
    private static Item registerItem(String name, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CookingMod.MOD_ID, name));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    // Method to register all mod items
    public static void registerModItems() {
        CookingMod.LOGGER.info("Registering Mod Items for " + CookingMod.MOD_ID);

        // Add items to FOOD_AND_DRINK item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {

        });

        // Add items to TOOLS item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(COOKING_KNIFE);
        });
    }
}
