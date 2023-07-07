package net.ddns.samjviana.bunchofthings.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class YellowMushroomGlowParticle extends TextureSheetParticle {

    protected YellowMushroomGlowParticle(
        ClientLevel level,
        double x,
        double y,
        double z,
        double motionX,
        double motionY,
        double motionZ
    ) {
        super(level, x, y, z, motionX, motionY, motionZ);
        float f = this.random.nextFloat() * 0.1F + 0.2F;
        this.rCol = f;
        this.gCol = f;
        this.bCol = f;
        this.setSize(0.02F, 0.02F);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.5F;
        this.xd *= (double) 0.02F;
        this.yd *= (double) 0.02F;
        this.zd *= (double) 0.02F;
        this.lifetime = (int) (20.0D / (Math.random() * 0.8D + 0.2D));
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void move(double x, double y, double z) {
        this.setBoundingBox(this.getBoundingBox().move(x, y, z));
        this.setLocationFromBoundingbox();
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.xd *= 0.99D;
            this.yd *= 0.99D;
            this.zd *= 0.99D;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GlowParticleFactory
        implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public GlowParticleFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(
            SimpleParticleType typeIn,
            ClientLevel levelIn,
            double x,
            double y,
            double z,
            double xSpeed,
            double ySpeed,
            double zSpeed
        ) {
            YellowMushroomGlowParticle yellowMushroomGlowParticle =
                new YellowMushroomGlowParticle(
                    levelIn,
                    x,
                    y,
                    z,
                    xSpeed,
                    ySpeed,
                    zSpeed
                );
            yellowMushroomGlowParticle.setColor(
                0.97F,
                0.81F,
                (float) (levelIn.random.nextInt(160) / 255.0)
            );
            yellowMushroomGlowParticle.pickSprite(this.spriteSet);
            yellowMushroomGlowParticle.setAlpha(
                1.0F - levelIn.random.nextFloat() * 0.7F
            );
            yellowMushroomGlowParticle.setLifetime(
                yellowMushroomGlowParticle.getLifetime() / 2
            );
            return yellowMushroomGlowParticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory
        implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle createParticle(
            SimpleParticleType typeIn,
            ClientLevel levelIn,
            double x,
            double y,
            double z,
            double xSpeed,
            double ySpeed,
            double zSpeed
        ) {
            YellowMushroomGlowParticle yellowMushroomGlowParticle =
                new YellowMushroomGlowParticle(
                    levelIn,
                    x,
                    y,
                    z,
                    xSpeed,
                    ySpeed,
                    zSpeed
                );
            yellowMushroomGlowParticle.pickSprite(this.spriteSet);
            return yellowMushroomGlowParticle;
        }
    }
}
