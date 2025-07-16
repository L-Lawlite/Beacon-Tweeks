package net.lawliet.beacon_tweaks.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import net.lawliet.beacon_tweaks.duck.IDuckBeaconRendering;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BeaconRenderer.class)
public class BeaconRendererMixin {

    @WrapWithCondition(method = "render", at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/BeaconRenderer;renderBeaconBeam(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;FJIII)V")})
    private boolean modifyRender(PoseStack poseStack, MultiBufferSource bufferSource, float partialTick, long gameTime, int yOffset, int height, int color, @Local(ordinal = 0)BeaconBlockEntity.BeaconBeamSection beamSection) {
        return ((IDuckBeaconRendering) beamSection).beacon_tweaks$canRender();
    }
}
