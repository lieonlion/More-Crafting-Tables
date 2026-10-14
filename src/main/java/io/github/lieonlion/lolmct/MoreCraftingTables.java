package io.github.lieonlion.lolmct;

import io.github.lieonlion.lolmct.init.MctBlockInit;
import io.github.lieonlion.lolmct.init.MctItemInit;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class MoreCraftingTables implements ModInitializer {
    public static final String MODID = "lolmct";

    @Override
    public void onInitialize() {
        MctBlockInit.registerBlocks();
        MctItemInit.registerItems();
    }

    public static Identifier asId(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }
}