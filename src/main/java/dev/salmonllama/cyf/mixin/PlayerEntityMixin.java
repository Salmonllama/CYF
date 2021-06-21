package dev.salmonllama.cyf.mixin;

import dev.salmonllama.cyf.CYF;
import dev.salmonllama.cyf.CyfArmorMaterial;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    private CyfArmorMaterial armorSet = null;
    private Set<CyfArmorMaterial> prevMats = new HashSet<>();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo ci) {
        if (!this.world.isClient) {
            Map<CyfArmorMaterial, List<EquipmentSlot>> matMap = CYF.getModdedArmor(this);
            CyfArmorMaterial newMat = null;

            for (Map.Entry<CyfArmorMaterial, List<EquipmentSlot>> mapElement : matMap.entrySet()) {
                CyfArmorMaterial localMat = mapElement.getKey();
                List<EquipmentSlot> localVals = mapElement.getValue();
                if (localVals.size() == 4) {
                    newMat = localMat;
                } else if (localMat.isPartialSet()){
                    localMat.armorTick(this.world, this, localVals.size());
                }
            }

            Set<CyfArmorMaterial> matList = matMap.keySet();
            prevMats.stream().filter(x -> !matList.contains(x) && x.isPartialSet()).forEach(x -> x.noArmorTick(this.world, this));
            prevMats = matList;

            if (newMat != armorSet) {
                if (armorSet != null) {
                    armorSet.noArmorTick(this.world, this);
                }

                armorSet = newMat;
            }

            if (armorSet != null) {
                armorSet.armorTick(this.world, this);
            }
        }
    }
}
