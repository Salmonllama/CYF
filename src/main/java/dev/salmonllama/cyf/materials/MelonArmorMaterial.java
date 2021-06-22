package dev.salmonllama.cyf.materials;

import dev.salmonllama.cyf.CyfArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class MelonArmorMaterial extends CyfArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {3, 6, 7, 3};

    public static final MelonArmorMaterial INSTANCE = new MelonArmorMaterial();

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 40;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_TURTLE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.MELON_SLICE);
    }

    @Override
    public String getName() {
        return "melon";
    }

    @Override
    public float getToughness() {
        return 1.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 1.0F;
    }

    @Override
    public int getSetBonuses() {
        return 2;
    }

    @Override
    public int getPieceBonuses() {
        return 0;
    }

    @Override
    public boolean isPartialSet() {
        return false;
    }

    @Override
    public void armorTick(World world, Entity entity, int count) {
        StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SATURATION, 15, 0, false, false);
        LivingEntity player = (LivingEntity) entity;
        player.addStatusEffect(effect);
    }
}
