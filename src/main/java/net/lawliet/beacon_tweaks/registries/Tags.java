package net.lawliet.beacon_tweaks.registries;

import net.lawliet.beacon_tweaks.BeaconTweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class Tags {

    public static class Blocks {
        public static final TagKey<Block> BEACON_BEAM_PASSTHROUGH;
        public static final TagKey<Block> BEACON_BEAM_INTERRUPT;

        static {
            BEACON_BEAM_PASSTHROUGH = createBlockKey("beacon_beam_passthrough");
            BEACON_BEAM_INTERRUPT = createBlockKey("beacon_beam_interrupt");
        }

        public static TagKey<Block> createBlockKey(String path) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BeaconTweaks.MODID, path));
        }
    }
}
