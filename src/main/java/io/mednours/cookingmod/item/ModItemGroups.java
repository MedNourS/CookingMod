package io.mednours.cookingmod.item;

import io.mednours.cookingmod.CookingMod;
import io.mednours.cookingmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    // Item Groups
    public static final ItemGroup COOKING_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(CookingMod.MOD_ID,
                    "cooking_items" // Put Name Here
            ), FabricItemGroup.builder().icon(() -> new ItemStack(
                    ModItems.COOKING_KNIFE // Put Item Group Icon Item Here
            )).displayName(Text.translatable(
                    "itemgroup.cookingmod.cooking_items" // Put Name Here
            )).entries((displayContext, entries) -> {
                entries.add(ModItems.COOKING_KNIFE); // Add Items or Blocks Here
                entries.add(ModItems.COOKBOOK);
                entries.add(ModBlocks.COOKING_TABLE);
            }).build()
    );

    // Helper method to register an item group
    public static void registerItemGroups() {
        CookingMod.LOGGER.info("Registering ModItemGroups for " + CookingMod.MOD_ID);
    }
}
