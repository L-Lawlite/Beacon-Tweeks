package net.lawliet.beacon_tweaks.mixin;

import net.lawliet.beacon_tweaks.duck.IDuckBeaconRendering;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BeaconBlockEntity.BeaconBeamSection.class)
public class BeaconBeamSectionMixin implements IDuckBeaconRendering {
    @Unique
    public boolean beacon_tweaks$isVisible = true;

    @Override
    public boolean beacon_tweaks$canRender() {
        return beacon_tweaks$isVisible;
    }

    @Override
    public void beacon_tweaks$setRender(boolean value) {
        beacon_tweaks$isVisible = value;
    }
}
