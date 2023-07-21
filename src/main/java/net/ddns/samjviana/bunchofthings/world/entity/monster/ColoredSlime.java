package net.ddns.samjviana.bunchofthings.world.entity.monster;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import net.ddns.samjviana.bunchofthings.BunchOfThings;
import net.ddns.samjviana.bunchofthings.core.particles.ModParticleTypes;
import net.ddns.samjviana.bunchofthings.loot.ModLootTables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

public class ColoredSlime extends Slime {
    private static final EntityDataAccessor<Byte> SLIME_COLOR = SynchedEntityData.defineId(
        ColoredSlime.class,
        EntityDataSerializers.BYTE
    );
    private static final Map<DyeColor, float[]> COLORARRAY_BY_COLOR = Maps.newHashMap(
        Arrays.stream(DyeColor.values()).collect(Collectors.toMap(
            (DyeColor dyeColor) -> {
                return dyeColor;
            },
            ColoredSlime::createSlimeColor
        ))
    );

    public ColoredSlime(EntityType<? extends Slime> p_33588_, Level p_33589_) {
        super(p_33588_, p_33589_);
    }

    private static float[] createSlimeColor(DyeColor dyeColorIn) {
        float[] dyeColorValues = dyeColorIn.getTextureDiffuseColors();
        return new float[]{
            dyeColorValues[0] * 0.75f,
            dyeColorValues[1] * 0.75f,
            dyeColorValues[2] * 0.75f
        };
    }

    public static float[] getDyeRgb(DyeColor dyeColor) {
        return COLORARRAY_BY_COLOR.get(dyeColor);
    }
    
    public DyeColor getSlimeColor() {
        return DyeColor.byId(this.entityData.get(SLIME_COLOR) & 15); 
    }

    private void setSlimeColor(DyeColor dyeColor) {
        byte byteZero = this.entityData.get(SLIME_COLOR);
        this.entityData.set(SLIME_COLOR, (byte)(byteZero & 240 | dyeColor.getId() & 15));
    }

    private static DyeColor getRandomSlimeColor(RandomSource random) {
        int id = random.nextInt(16);
        switch (id) {
            case 0:
                return DyeColor.WHITE;
            case 1:
                return DyeColor.ORANGE;
            case 2:
                return DyeColor.MAGENTA;
            case 3:
                return DyeColor.LIGHT_BLUE;
            case 4:
                return DyeColor.YELLOW;
            case 5:
                return DyeColor.LIME;
            case 6:
                return DyeColor.PINK;
            case 7:
                return DyeColor.GRAY;
            case 8:
                return DyeColor.LIGHT_GRAY;
            case 9:
                return DyeColor.CYAN;
            case 10:
                return DyeColor.PURPLE;
            case 11:
                return DyeColor.BLUE;
            case 12:
                return DyeColor.BROWN;
            case 13:
            default:
                return DyeColor.GREEN;
            case 14:
                return DyeColor.RED;
            case 15:
                return DyeColor.BLACK;
        }
    }

    // public static AttributeModifierMap getAttributes() {
    //     AttributeModifierMap.MutableAttribute attributes = Slime.func_233666_p_();

    //     attributes.createMutableAttribute(Attributes.ATTACK_DAMAGE);

    //     return attributes.create();
    // }

    public static boolean _checkSlimeSpawnRules(EntityType<ColoredSlime> p_219113_, LevelAccessor p_219114_, MobSpawnType p_219115_, BlockPos p_219116_, RandomSource p_219117_) {
        if (p_219114_.getDifficulty() != Difficulty.PEACEFUL) {
            boolean allowSurfaceSpawn = p_219114_.getBiome(p_219116_).is(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS);
            boolean allowedHeight = p_219116_.getY() > 50 && p_219116_.getY() < 70;
            if (allowSurfaceSpawn && allowedHeight && p_219117_.nextFloat() < 0.5F && p_219117_.nextFloat() < p_219114_.getMoonBrightness() && p_219114_.getMaxLocalRawBrightness(p_219116_) <= p_219117_.nextInt(8)) {
                return checkMobSpawnRules(p_219113_, p_219114_, p_219115_, p_219116_, p_219117_);
            }

            if (!(p_219114_ instanceof WorldGenLevel)) {
                return false;
            }

            ChunkPos chunkpos = new ChunkPos(p_219116_);
            boolean flag = WorldgenRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, ((WorldGenLevel)p_219114_).getSeed(), 987234911L).nextInt(10) == 0;
            if (p_219117_.nextInt(10) == 0 && flag && p_219116_.getY() < 40) {
                return checkMobSpawnRules(p_219113_, p_219114_, p_219115_, p_219116_, p_219117_);
            }
        }

        return false;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        this.setSlimeColor(getRandomSlimeColor(worldIn.getRandom()));
        return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SLIME_COLOR, (byte)0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putByte("Color", (byte)this.getSlimeColor().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setSlimeColor(DyeColor.byId(compound.getByte("Color")));
    }

    @Override
    public void remove(Entity.RemovalReason keepData) {
        int i = this.getSize();
        if (!this.level.isClientSide && i > 1 && this.isDeadOrDying()) {
            Component itextcomponent = this.getCustomName();
            boolean flag = this.isNoAi();
            float f = (float) i / 4.0F;
            int j = i / 2;
            int k = 2 + this.random.nextInt(3);

            for (int l = 0; l < k; ++l) {
                float f1 = ((float) (l % 2) - 0.5F) * f;
                float f2 = ((float) (l / 2) - 0.5F) * f;
                ColoredSlime coloredSlimeEntity = (ColoredSlime) this.getType().create(this.level);
                if (this.isPersistenceRequired()) {
                    coloredSlimeEntity.setPersistenceRequired();
                }

                coloredSlimeEntity.setCustomName(itextcomponent);
                coloredSlimeEntity.setNoAi(flag);
                coloredSlimeEntity.setInvulnerable(this.isInvulnerable());
                coloredSlimeEntity.setSlimeColor(this.getSlimeColor());
                coloredSlimeEntity.setSize(j, true);
                coloredSlimeEntity.moveTo(this.getX() + (double) f1, this.getY() + 0.5D,
                        this.getZ() + (double) f2, this.random.nextFloat() * 360.0F, 0.0F);
                this.level.addFreshEntity(coloredSlimeEntity);
            }
        }

        int sizeBuffer = this.getSize();
        // Set size to 0 to prevent spawning normal slimes
        this.setSize(0, true);
        super.remove(keepData);
        this.setSize(sizeBuffer, true);
    }

    @Override
    protected boolean spawnCustomParticles() {
        int i = this.getSize();

        for (int j = 0; j < i * 8; ++j) {
            float f = this.random.nextFloat() * ((float) Math.PI * 2F);
            float f1 = this.random.nextFloat() * 0.75F + 0.75F;
            float f2 = Mth.sin(f) * (float) i * 0.75F * f1;
            float f3 = Mth.cos(f) * (float) i * 0.75F * f1;
            this.level.addParticle(this.getParticleType(), this.getX() + (double)f2, this.getY(), this.getZ() + (double)f3, 0.0D, 0.0D, 0.0D);
        }
        return true;
    }

    @Override
    protected ParticleOptions getParticleType() {
        switch (this.getSlimeColor()) {
            case WHITE:
            default:
                return (SimpleParticleType)ModParticleTypes.WHITE_SLIME_PARTICLE.get();
            case ORANGE:
                return (SimpleParticleType)ModParticleTypes.ORANGE_SLIME_PARTICLE.get();
            case MAGENTA:
                return (SimpleParticleType)ModParticleTypes.MAGENTA_SLIME_PARTICLE.get();
            case LIGHT_BLUE:
                return (SimpleParticleType)ModParticleTypes.LIGHT_BLUE_SLIME_PARTICLE.get();
            case YELLOW:
                return (SimpleParticleType)ModParticleTypes.YELLOW_SLIME_PARTICLE.get();
            case LIME:
                return (SimpleParticleType)ModParticleTypes.LIME_SLIME_PARTICLE.get();
            case PINK:
                return (SimpleParticleType)ModParticleTypes.PINK_SLIME_PARTICLE.get();
            case GRAY:
                return (SimpleParticleType)ModParticleTypes.GRAY_SLIME_PARTICLE.get();
            case LIGHT_GRAY:
                return (SimpleParticleType)ModParticleTypes.LIGHT_GRAY_SLIME_PARTICLE.get();
            case CYAN:
                return (SimpleParticleType)ModParticleTypes.CYAN_SLIME_PARTICLE.get();
            case PURPLE:
                return (SimpleParticleType)ModParticleTypes.PURPLE_SLIME_PARTICLE.get();
            case BLUE:
                return (SimpleParticleType)ModParticleTypes.BLUE_SLIME_PARTICLE.get();
            case BROWN:
                return (SimpleParticleType)ModParticleTypes.BROWN_SLIME_PARTICLE.get();
            case GREEN:
                return (SimpleParticleType)ModParticleTypes.GREEN_SLIME_PARTICLE.get();
            case RED:
                return (SimpleParticleType)ModParticleTypes.RED_SLIME_PARTICLE.get();
            case BLACK:
                return (SimpleParticleType)ModParticleTypes.BLACK_SLIME_PARTICLE.get();
        }
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        if (this.getSize() == 1) {
            switch (this.getSlimeColor()) {
                case WHITE:
                default:
                    return ModLootTables.ENTITIES_SLIME_WHITE;
                case ORANGE:
                    return ModLootTables.ENTITIES_SLIME_ORANGE;
                case MAGENTA:
                    return ModLootTables.ENTITIES_SLIME_MAGENTA;
                case LIGHT_BLUE:
                    return ModLootTables.ENTITIES_SLIME_LIGHT_BLUE;
                case YELLOW:
                    return ModLootTables.ENTITIES_SLIME_YELLOW;
                case LIME:
                    return ModLootTables.ENTITIES_SLIME_LIME;
                case PINK:
                    return ModLootTables.ENTITIES_SLIME_PINK;
                case GRAY:
                    return ModLootTables.ENTITIES_SLIME_GRAY;
                case LIGHT_GRAY:
                    return ModLootTables.ENTITIES_SLIME_LIGHT_GRAY;
                case CYAN:
                    return ModLootTables.ENTITIES_SLIME_CYAN;
                case PURPLE:
                    return ModLootTables.ENTITIES_SLIME_PURPLE;
                case BLUE:
                    return ModLootTables.ENTITIES_SLIME_BLUE;
                case BROWN:
                    return ModLootTables.ENTITIES_SLIME_BROWN;
                case GREEN:
                    return ModLootTables.ENTITIES_SLIME_GREEN;
                case RED:
                    return ModLootTables.ENTITIES_SLIME_RED;
                case BLACK:
                    return ModLootTables.ENTITIES_SLIME_BLACK;
            }
        }
        else {
            return BuiltInLootTables.EMPTY;
        }
    }
}