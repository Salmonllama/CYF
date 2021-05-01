package dev.salmonllama.cyf.items;

import dev.salmonllama.cyf.CYF;
import dev.salmonllama.cyf.items.foods.ApplePie;
import dev.salmonllama.cyf.items.tools.*;
import dev.salmonllama.cyf.materials.MelonArmorMaterial;
import dev.salmonllama.cyf.materials.MelonToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

    // Melon Armor
    private static final Item.Settings MELON_ARMOR_SETTINGS = new Item.Settings().group(CYF.ITEM_GROUP);
    public static final Item MELON_HELMET = new ArmorItem(MelonArmorMaterial.INSTANCE, EquipmentSlot.HEAD, MELON_ARMOR_SETTINGS);
    public static final Item MELON_CHESTPLATE = new ArmorItem(MelonArmorMaterial.INSTANCE, EquipmentSlot.CHEST, MELON_ARMOR_SETTINGS);
    public static final Item MELON_LEGGINGS = new ArmorItem(MelonArmorMaterial.INSTANCE, EquipmentSlot.LEGS, MELON_ARMOR_SETTINGS);
    public static final Item MELON_BOOTS = new ArmorItem(MelonArmorMaterial.INSTANCE, EquipmentSlot.FEET, MELON_ARMOR_SETTINGS);

    // Melon Tools
    private static final Item.Settings MELON_TOOL_SETTINGS = new Item.Settings().group(CYF.ITEM_GROUP).food(new FoodComponent.Builder().hunger(6).saturationModifier(15).build());
    public static final Item MELON_SWORD = new MelonSword(MelonToolMaterial.INSTANCE, 7, -2.4F, MELON_TOOL_SETTINGS);
    public static final Item MELON_PICKAXE = new MelonPickaxe(MelonToolMaterial.INSTANCE, 1, -3.0F, MELON_TOOL_SETTINGS);
    public static final Item MELON_AXE = new MelonAxe(MelonToolMaterial.INSTANCE, 8, -3.2F, MELON_TOOL_SETTINGS);
    public static final Item MELON_SHOVEL = new MelonShovel(MelonToolMaterial.INSTANCE, 1, -3.0F, MELON_TOOL_SETTINGS);
    public static final Item MELON_HOE = new MelonHoe(MelonToolMaterial.INSTANCE, 1, -3.0F, MELON_TOOL_SETTINGS);

    // Foods
    public static final Item APPLE_PIE = new ApplePie(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(4).saturationModifier(10).build()).maxCount(64));

    public static void register() {
        // Melon Armor
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_helmet"), MELON_HELMET);
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_chestplate"), MELON_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_leggings"), MELON_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_boots"), MELON_BOOTS);

        // Melon Tools
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_sword"), MELON_SWORD);
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_pickaxe"), MELON_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_axe"), MELON_AXE);
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_shovel"), MELON_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("cyf", "melon_hoe"), MELON_HOE);

        // Foods
        Registry.register(Registry.ITEM, new Identifier("cyf", "apple_pie"), APPLE_PIE);
    }
}
