package dev.salmonllama.cyf;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.TextColor;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;


public abstract class CyfArmorMaterial implements ArmorMaterial {
    public abstract int getSetBonuses();
    public abstract int getPieceBonuses();
    public abstract boolean isPartialSet();

    public void armorTick(World world, Entity entity, int count) {}

    public final void armorTick(World world, Entity entity) { armorTick(world, entity, 4); }

    public void noArmorTick(World world, Entity entity) {}

    public void movementTick(World world, Entity entity) {}

    public MutableText getTooltip(int n, EquipmentSlot slot, boolean isSetBonus, Object ...args) {
        String key = isSetBonus ? "set" : "piece";
        return new TranslatableText("item." + CYF.MOD_ID + "." + getName().toLowerCase() + "." + key + n, args).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xb37fc9)));
    }

    public List<MutableText> getTooltips(EquipmentSlot slot) {
        List<MutableText> output = new ArrayList<>();
        if (getSetBonuses() > 0) {
            output.add(new TranslatableText("cyf.set").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x8e51a8)).withBold(true)));
            for (int i = 1; i < getSetBonuses(); i++) {
                output.add(getTooltip(i, slot, true));
            }
        }

        if (getPieceBonuses() > 0) {
            output.add(new TranslatableText("cyf.piece").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x8e51a8)).withBold(true)));
            for (int i = 1; i < getPieceBonuses(); i++) {
                output.add(getTooltip(i, slot, false));
            }
        }

        return output;
    }
}
