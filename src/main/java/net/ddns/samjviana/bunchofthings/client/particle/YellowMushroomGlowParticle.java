package net.ddns.samjviana.bunchofthings.client.particle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class YellowMushroomGlowParticle extends SpriteTexturedParticle {
    private YellowMushroomGlowParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
        float f = this.rand.nextFloat() * 0.1F + 0.2F;
        this.particleRed = f;
        this.particleGreen = f;
        this.particleBlue = f;
        this.setSize(0.02F, 0.02F);
        this.particleScale *= this.rand.nextFloat() * 0.6F + 0.5F;
        this.motionX *= (double)0.05F;
        this.motionY *= (double)0.05F;
        this.motionZ *= (double)0.05F;
        this.maxAge = (int)(50.0D / (Math.random() * 0.8D + 0.2D));
    }

    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double x, double y, double z) {
        this.setBoundingBox(this.getBoundingBox().offset(x, y, z));
        this.resetPositionToBB();
    }

    public void tick() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.maxAge-- <= 0) {
            this.setExpired();
        } else {
            this.move(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.99D;
            this.motionY *= 0.99D;
            this.motionZ *= 0.99D;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GlowParticleFactory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public GlowParticleFactory(IAnimatedSprite spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            YellowMushroomGlowParticle yellowMushroomGlowParticle = new YellowMushroomGlowParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            yellowMushroomGlowParticle.setColor(0.97F, 0.81F, (float)(worldIn.rand.nextInt(160) / 255.0));
            yellowMushroomGlowParticle.selectSpriteRandomly(this.spriteSet);
            yellowMushroomGlowParticle.setAlphaF(1.0F - worldIn.rand.nextFloat() * 0.7F);
            yellowMushroomGlowParticle.setMaxAge(yellowMushroomGlowParticle.getMaxAge() / 2);
            return yellowMushroomGlowParticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z,
                double xSpeed, double ySpeed, double zSpeed) {
                    YellowMushroomGlowParticle yellowMushroomGlowParticle = new YellowMushroomGlowParticle(worldIn, x, y, z, xSpeed, ySpeed,
                    zSpeed);
            yellowMushroomGlowParticle.selectSpriteRandomly(this.spriteSet);
            return yellowMushroomGlowParticle;
        }
    }
}
