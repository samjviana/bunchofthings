package net.ddns.samjviana.bunchofthings.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.ddns.samjviana.bunchofthings.client.model.ColoredSlimeModel;
import net.ddns.samjviana.bunchofthings.world.entity.monster.ColoredSlime;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;

public class ColoredSlimeOuterLayer<T extends LivingEntity> extends RenderLayer<T, ColoredSlimeModel<T>> {
    private final EntityModel<T> slimeModel;

    public ColoredSlimeOuterLayer(RenderLayerParent<T, ColoredSlimeModel<T>> rendererIn, EntityModelSet modelSet) {
        super(rendererIn);
        this.slimeModel = new SlimeModel<>(modelSet.bakeLayer(ModelLayers.SLIME_OUTER));
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ColoredSlime coloredSlimeEntity = null;
        if(entitylivingbaseIn instanceof ColoredSlime) {
            coloredSlimeEntity = (ColoredSlime)entitylivingbaseIn;
        }
        
        float[] slimeColor = ColoredSlime.getDyeRgb(coloredSlimeEntity.getSlimeColor());
        float red = slimeColor[0];
        float green = slimeColor[1];
        float blue = slimeColor[2];
        if (!entitylivingbaseIn.isInvisible()) {
          this.getParentModel().copyPropertiesTo(this.slimeModel);
          this.slimeModel.prepareMobModel(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
          this.slimeModel.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
          VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(entitylivingbaseIn)));
          this.slimeModel.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, LivingEntityRenderer.getOverlayCoords(entitylivingbaseIn, 0.0F), red, green, blue, 1.0F);
       }
    }
}
