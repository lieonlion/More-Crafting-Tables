package io.github.lieonlion.lolmct.init;

import io.github.lieonlion.lolmct.MoreCraftingTables;
import io.github.lieonlion.lolmct.block.MoreCraftingTableBlock;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class MctItemInit {
    public static BlockItem SPRUCE_TABLE_I = itemFromBlock(MctBlockInit.SPRUCE_TABLE);
    public static BlockItem BIRCH_TABLE_I = itemFromBlock(MctBlockInit.BIRCH_TABLE);
    public static BlockItem JUNGLE_TABLE_I = itemFromBlock(MctBlockInit.JUNGLE_TABLE);
    public static BlockItem ACACIA_TABLE_I = itemFromBlock(MctBlockInit.ACACIA_TABLE);
    public static BlockItem DARK_OAK_TABLE_I = itemFromBlock(MctBlockInit.DARK_OAK_TABLE);
    public static BlockItem MANGROVE_TABLE_I = itemFromBlock(MctBlockInit.MANGROVE_TABLE);
    public static BlockItem CHERRY_TABLE_I = itemFromBlock(MctBlockInit.CHERRY_TABLE);
    public static BlockItem PALE_OAK_TABLE_I = itemFromBlock(MctBlockInit.PALE_OAK_TABLE);
    public static BlockItem BAMBOO_TABLE_I = itemFromBlock(MctBlockInit.BAMBOO_TABLE);
    public static BlockItem CRIMSON_TABLE_I = itemFromBlock(MctBlockInit.CRIMSON_TABLE);
    public static BlockItem WARPED_TABLE_I = itemFromBlock(MctBlockInit.WARPED_TABLE);

    public static void registerItems() {
        registerItem(SPRUCE_TABLE_I, Items.CRAFTING_TABLE);
        registerItem(BIRCH_TABLE_I, SPRUCE_TABLE_I);
        registerItem(JUNGLE_TABLE_I, BIRCH_TABLE_I);
        registerItem(ACACIA_TABLE_I, JUNGLE_TABLE_I);
        registerItem(DARK_OAK_TABLE_I, ACACIA_TABLE_I);
        registerItem(MANGROVE_TABLE_I, DARK_OAK_TABLE_I);
        registerItem(CHERRY_TABLE_I, MANGROVE_TABLE_I);
        registerItem(PALE_OAK_TABLE_I, CHERRY_TABLE_I);
        registerItem(BAMBOO_TABLE_I, PALE_OAK_TABLE_I);
        registerItem(CRIMSON_TABLE_I, BAMBOO_TABLE_I);
        registerItem(WARPED_TABLE_I, CRIMSON_TABLE_I);
    }

    // Thank You to Pnku (https://github.com/pnk2u) for making these functions. *
    public static BlockItem itemFromBlock(Block block) {
        return new BlockItem(block, setProperties(block));
    }

    // **
    public static Item.Properties setProperties(Block block) {
        return new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, BuiltInRegistries.BLOCK.getKey(block))).useBlockDescriptionPrefix();
    }

    public static void registerItem(Item item, Item after) {
        String name = ((MoreCraftingTableBlock)((BlockItem) item).getBlock()).woodType + "_crafting_table";
        Registry.register(BuiltInRegistries.ITEM, MoreCraftingTables.asId(name), item);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(output -> output.insertAfter(after, item));
    }
}