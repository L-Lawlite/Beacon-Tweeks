package net.lawliet.beacon_tweaks.mixin;

import com.llamalad7.mixinextras.injector.ModifyReceiver;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.lawliet.beacon_tweaks.duck.IDuckBeaconRendering;
import net.lawliet.beacon_tweaks.registries.Tags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Debug(export = true)
@Mixin(BeaconBlockEntity.class)
public class BeaconBlockEntityMixin {
    @WrapOperation(method = "tick", at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z")})
    private static boolean modifyPassthroughBlocks(BlockState blockState, Block block, Operation<Boolean> original) {
        // make a config to take care of original
        return blockState.is(Tags.Blocks.BEACON_BEAM_INTERRUPT) || blockState.is(Tags.Blocks.BEACON_BEAM_PASSTHROUGH);
    }

    @ModifyReceiver(method = "tick",
            slice = @Slice(from = @At(value = "INVOKE", ordinal = 0, target = "Ljava/util/List;clear()V")),
            at = {@At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/BeaconBlockEntity$BeaconBeamSection;increaseHeight()V")})
    private static BeaconBlockEntity.BeaconBeamSection interruptBeam(BeaconBlockEntity.BeaconBeamSection instance,  @Local(ordinal = 1) BlockState blockState) {
        if(blockState.is(Tags.Blocks.BEACON_BEAM_INTERRUPT)) {
            ((IDuckBeaconRendering) instance).beacon_tweaks$setRender(false);
        }
        return instance;
    }


}
