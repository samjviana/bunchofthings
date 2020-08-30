package net.ddns.samjviana.morethings.client.particle;

import net.minecraft.client.particle.BreakingParticle;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;

public class ModBreakingParticle extends BreakingParticle {

    protected ModBreakingParticle(ClientWorld p_i232348_1_, double p_i232348_2_, double p_i232348_4_, double p_i232348_6_, ItemStack p_i232348_8_) {
        super(p_i232348_1_, p_i232348_2_, p_i232348_4_, p_i232348_6_, p_i232348_8_);
    }

    public static class ColoredSlimeFactory implements IParticleFactory<BasicParticleType> {
        private Item slimeBall; 
        public ColoredSlimeFactory(Item slimeBall) {
            this.slimeBall = slimeBall;
        }

        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            Particle coloredSlimeParticle = new ModBreakingParticle(worldIn, x, y, z, new ItemStack(this.slimeBall));
            return coloredSlimeParticle;
        }
    }  
}