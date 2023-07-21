package net.ddns.samjviana.bunchofthings.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.ddns.samjviana.bunchofthings.client.model.ColoredSlimeModel;
import net.ddns.samjviana.bunchofthings.client.renderer.entity.layers.ColoredSlimeOuterLayer;
import net.ddns.samjviana.bunchofthings.world.entity.monster.ColoredSlime;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SlimeOuterLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

@OnlyIn(Dist.CLIENT)
public class ColoredSlimeRenderer extends MobRenderer<ColoredSlime, ColoredSlimeModel<ColoredSlime>> {
    private static final ResourceLocation COLORED_SLIME_TEXTURES = new ResourceLocation("bunchofthings:textures/entity/colored_slime/colored_slime.png");

    public ColoredSlimeRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ColoredSlimeModel<ColoredSlime>(renderManagerIn.bakeLayer(ModelLayers.SLIME)), 0.25F);
        this.addLayer(new ColoredSlimeOuterLayer<>(this, renderManagerIn.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(ColoredSlime entity) {
        return COLORED_SLIME_TEXTURES;
    }
    
    @Override
    public void render(ColoredSlime entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        this.shadowRadius = 0.25F * (float)entityIn.getSize();

        float[] slimeColor = ColoredSlime.getDyeRgb(entityIn.getSlimeColor());
        float red = slimeColor[0];
        float green = slimeColor[1];
        float blue = slimeColor[2];

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    protected void scale(ColoredSlime entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.999F, 0.999F, 0.999F);
        matrixStackIn.translate(0.0D, (double)0.001F, 0.0D);
        float f1 = (float)entitylivingbaseIn.getSize();
        float f2 = Mth.lerp(partialTickTime, entitylivingbaseIn.oSquish, entitylivingbaseIn.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        matrixStackIn.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);

        super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }
}
