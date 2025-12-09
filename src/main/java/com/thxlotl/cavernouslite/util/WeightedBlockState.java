package com.thxlotl.cavernouslite.util;

import net.minecraft.world.level.block.state.BlockState;

public class WeightedBlockState {
    public BlockState state;
    public int weight;

    public WeightedBlockState(BlockState state, int weight) {
        this.state = state;
        this.weight = weight;
    }
    public WeightedBlockState(BlockState state) {
        this.state = state;
        this.weight = 1;
    }
}
