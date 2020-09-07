package net.ddns.samjviana.bunchofthings.client.renderer.tileentity;

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.block.ColoredStickyPistonBlock;
import net.ddns.samjviana.bunchofthings.block.ColoredStickyPistonHeadBlock;
import net.ddns.samjviana.bunchofthings.block.ModBlocks;
import net.ddns.samjviana.bunchofthings.tileentity.ColoredPistonTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.block.PistonHeadBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.PistonType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;

public class ColoredPistonTileEntityRenderer extends TileEntityRenderer<ColoredPistonTileEntity> {
    private BlockRendererDispatcher blockRenderer = Minecraft.getInstance().getBlockRendererDispatcher();

    public ColoredPistonTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(ColoredPistonTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        World world = tileEntityIn.getWorld();

        if (world != null) {
            BlockPos blockpos = tileEntityIn.getPos().offset(tileEntityIn.getMotionDirection().getOpposite());
            BlockState blockstate = tileEntityIn.getPistonState();
            if (!blockstate.isAir()) {
                BlockModelRenderer.enableCache();
                matrixStackIn.push();
                matrixStackIn.translate((double) tileEntityIn.getOffsetX(partialTicks), (double) tileEntityIn.getOffsetY(partialTicks), (double) tileEntityIn.getOffsetZ(partialTicks));
                if (blockstate.isIn(ModBlocks.COLORED_STICKY_PISTON_HEAD.get()) && tileEntityIn.getProgress(partialTicks) <= 4.0F) {
                    blockstate = blockstate.with(ColoredStickyPistonHeadBlock.SHORT, Boolean.valueOf(tileEntityIn.getProgress(partialTicks) <= 0.5F));
                    this.func_228876_a_(blockpos, blockstate, matrixStackIn, bufferIn, world, false, combinedOverlayIn);
                }
                else if (tileEntityIn.shouldPistonHeadBeRendered() && !tileEntityIn.isExtending()) {
                    PistonType pistontype = PistonType.STICKY;
                    BlockState blockstate1 = ModBlocks.COLORED_STICKY_PISTON_HEAD.get().getDefaultState().with(
                        ColoredStickyPistonHeadBlock.TYPE, pistontype
                    ).with(
                        ColoredStickyPistonHeadBlock.FACING, blockstate.get(ColoredStickyPistonBlock.FACING)
                    ).with(
                        ColoredStickyPistonHeadBlock.COLOR, blockstate.get(ColoredStickyPistonBlock.COLOR)
                    );
                    blockstate1 = blockstate1.with(ColoredStickyPistonHeadBlock.SHORT,
                            Boolean.valueOf(tileEntityIn.getProgress(partialTicks) >= 0.5F));
                    this.func_228876_a_(blockpos, blockstate1, matrixStackIn, bufferIn, world, false,
                            combinedOverlayIn);
                    BlockPos blockpos1 = blockpos.offset(tileEntityIn.getMotionDirection());
                    matrixStackIn.pop();
                    matrixStackIn.push();
                    blockstate = blockstate.with(ColoredStickyPistonBlock.EXTENDED, Boolean.valueOf(true));
                    this.func_228876_a_(blockpos1, blockstate, matrixStackIn, bufferIn, world, true, combinedOverlayIn);
                } else {
                    this.func_228876_a_(blockpos, blockstate, matrixStackIn, bufferIn, world, false, combinedOverlayIn);
                }

                matrixStackIn.pop();
                BlockModelRenderer.disableCache();
            }
        }
    }

    private void func_228876_a_(BlockPos p_228876_1_, BlockState p_228876_2_, MatrixStack p_228876_3_, IRenderTypeBuffer p_228876_4_, World p_228876_5_, boolean p_228876_6_, int p_228876_7_) {
        RenderType.getBlockRenderTypes().stream().filter(t -> RenderTypeLookup.canRenderInLayer(p_228876_2_, t)).forEach(rendertype -> {
            ForgeHooksClient.setRenderLayer(rendertype);
            IVertexBuilder ivertexbuilder = p_228876_4_.getBuffer(rendertype);
            if (blockRenderer == null) {
                blockRenderer = Minecraft.getInstance().getBlockRendererDispatcher();
            }
            this.blockRenderer.getBlockModelRenderer().renderModel(p_228876_5_, this.blockRenderer.getModelForState(p_228876_2_), p_228876_2_, p_228876_1_, p_228876_3_, ivertexbuilder, p_228876_6_, new Random(), p_228876_2_.getPositionRandom(p_228876_1_), p_228876_7_);
        });
        ForgeHooksClient.setRenderLayer(null);
    }
}
