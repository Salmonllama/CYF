package dev.salmonllama.cyf.items;

import dev.salmonllama.cyf.CyfArmorMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CyfArmorItem extends ArmorItem {
    public CyfArmorItem(CyfArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.addAll(((CyfArmorMaterial) type).getTooltips(slot));
    }

    @Override
    public CyfArmorMaterial getMaterial() {
        return (CyfArmorMaterial) super.getMaterial();
    }
}
