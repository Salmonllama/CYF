package dev.salmonllama.cyf;

import dev.salmonllama.cyf.items.ApplePie;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CYF implements ModInitializer {

    public static final Item APPLE_PIE = new ApplePie(new FabricItemSettings()
            .group(ItemGroup.FOOD)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(10).build())
            .maxCount(63)
    );

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("cyf", "apple_pie"), APPLE_PIE);
    }
}
