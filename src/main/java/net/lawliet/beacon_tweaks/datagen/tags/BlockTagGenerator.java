package net.lawliet.beacon_tweaks.datagen.tags;

import net.lawliet.beacon_tweaks.BeaconTweaks;
import net.lawliet.beacon_tweaks.registries.Tags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, BeaconTweaks.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(Tags.Blocks.BEACON_BEAM_INTERRUPT)
                .add(Blocks.TINTED_GLASS);
        this.tag(Tags.Blocks.BEACON_BEAM_PASSTHROUGH)
                .add(Blocks.BEDROCK)
                .addTag(BlockTags.LEAVES);
    }
}
