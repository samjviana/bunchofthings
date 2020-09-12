package net.ddns.samjviana.bunchofthings.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.ddns.samjviana.bunchofthings.client.renderer.entity.layers.ColoredSlimeGelLayer;
import net.ddns.samjviana.bunchofthings.entity.monster.ColoredSlimeEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class ColoredSlimeRenderer extends MobRenderer<ColoredSlimeEntity, SlimeModel<ColoredSlimeEntity>> {
    private static final ResourceLocation COLORED_SLIME_TEXTURES = new ResourceLocation("bunchofthings:textures/entity/colored_slime/colored_slime.png");

    public ColoredSlimeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SlimeModel<>(16), 0.25f);
        this.addLayer(new ColoredSlimeGelLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(ColoredSlimeEntity entity) {
        return COLORED_SLIME_TEXTURES;
    }
    
    @Override
    public void render(ColoredSlimeEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        this.shadowSize = 0.25F * (float)entityIn.getSlimeSize();

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    protected void preRenderCallback(ColoredSlimeEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.999F, 0.999F, 0.999F);
        matrixStackIn.translate(0.0D, (double)0.001F, 0.0D);
        float f1 = (float)entitylivingbaseIn.getSlimeSize();
        float f2 = MathHelper.lerp(partialTickTime, entitylivingbaseIn.prevSquishFactor, entitylivingbaseIn.squishFactor) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        matrixStackIn.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);

        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }
}