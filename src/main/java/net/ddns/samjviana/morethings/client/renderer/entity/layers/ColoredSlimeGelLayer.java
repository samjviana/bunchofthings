package net.ddns.samjviana.morethings.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.ddns.samjviana.morethings.entity.monster.ColoredSlimeEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SlimeModel;
import net.minecraft.entity.LivingEntity;

public class ColoredSlimeGelLayer<T extends LivingEntity> extends LayerRenderer<T, SlimeModel<T>> {
    private final EntityModel<T> slimeModel = new SlimeModel<>(0);

    public ColoredSlimeGelLayer(IEntityRenderer<T, SlimeModel<T>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ColoredSlimeEntity coloredSlimeEntity = null;
        if(entitylivingbaseIn instanceof ColoredSlimeEntity) {
            coloredSlimeEntity = (ColoredSlimeEntity)entitylivingbaseIn;
        }
        float[] slimeColor = ColoredSlimeEntity.getDyeRgb(coloredSlimeEntity.getSlimeColor());
        float red = slimeColor[0];
        float green = slimeColor[1];
        float blue = slimeColor[2];
        if (!entitylivingbaseIn.isInvisible()) {
          this.getEntityModel().copyModelAttributesTo(this.slimeModel);
          this.slimeModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
          this.slimeModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
          IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(this.getEntityTexture(entitylivingbaseIn)));
          this.slimeModel.render(matrixStackIn, ivertexbuilder, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0.0F), red, green, blue, 1.0F);
       }
    }
    
}