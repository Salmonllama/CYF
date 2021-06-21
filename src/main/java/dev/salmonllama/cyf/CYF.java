package dev.salmonllama.cyf;

import dev.salmonllama.cyf.items.CyfArmorItem;
import dev.salmonllama.cyf.items.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CYF implements ModInitializer {
    public static final String MOD_ID = "cyf";
    public static final String MOD_NAME = "cyf";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("cyf", "general"),
            () -> new ItemStack(RegisterItems.APPLE_PIE)
    );

    @Override
    public void onInitialize() {
        RegisterItems.register();
    }

    public static Map<CyfArmorMaterial, List<EquipmentSlot>> getModdedArmor(LivingEntity livingEntity) {
        Map<CyfArmorMaterial, List<EquipmentSlot>> armor = new HashMap<>();
        if (!(livingEntity instanceof PlayerEntity playerEntity)) { return armor; }

        for (ItemStack itemStack : playerEntity.getInventory().armor) {
            if (itemStack.getItem() instanceof CyfArmorItem item) {
                CyfArmorMaterial material = item.getMaterial();
                List<EquipmentSlot> equippedItems = armor.getOrDefault(material, new ArrayList<>());
                equippedItems.add(item.getSlotType());
                armor.put(material, equippedItems);
            }
        }

        return armor;
    }

    @Nullable public static CyfArmorMaterial getPlayerMaterial(LivingEntity entity) {
        if (!(entity instanceof PlayerEntity playerEntity)) { return null; }

        CyfArmorMaterial material = null;

        for (ItemStack piece : playerEntity.getInventory().armor) {
            if (!(piece.getItem() instanceof CyfArmorItem armorItem)) { return null; }
            CyfArmorMaterial mat = armorItem.getMaterial();
            if (material == null) { material = mat; }
            else if (material != mat) { return null; }
        }

        return material;
    }
}
