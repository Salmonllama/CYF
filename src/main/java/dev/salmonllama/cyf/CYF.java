package dev.salmonllama.cyf;

import dev.salmonllama.cyf.items.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CYF implements ModInitializer {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("cyf", "general"),
            () -> new ItemStack(RegisterItems.APPLE_PIE)
    );

    @Override
    public void onInitialize() {
        RegisterItems.register();
    }
}
