package net.ddns.samjviana.morethings.entity.monster;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

import net.ddns.samjviana.morethings.loot.ModLootTables;
import net.ddns.samjviana.morethings.particles.ModParticleTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;

public class ColoredSlimeEntity extends SlimeEntity {
    private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.createKey(
        SlimeEntity.class,
        DataSerializers.BYTE
    );
    private static final Map<DyeColor, float[]> DYE_TO_RGB = Maps.newHashMap(
        Arrays.stream(DyeColor.values()).collect(Collectors.toMap(
            (DyeColor dyeColor) -> {
                return dyeColor;
            },
            ColoredSlimeEntity::createSlimeColor
        ))
    );

    public ColoredSlimeEntity(EntityType<? extends SlimeEntity> type, World worldIn) {
        super(type, worldIn);
    }
    
    private static float[] createSlimeColor(DyeColor dyeColorIn) {
        float[] dyeColorValues = dyeColorIn.getColorComponentValues();
        return new float[]{
            dyeColorValues[0] * 0.75f,
            dyeColorValues[1] * 0.75f,
            dyeColorValues[2] * 0.75f
        };
    }

    public static float[] getDyeRgb(DyeColor dyeColor) {
        return DYE_TO_RGB.get(dyeColor);
    }
    
    public DyeColor getSlimeColor() {
        return DyeColor.byId(this.dataManager.get(DYE_COLOR) & 15); 
    }

    private void setSlimeColor(DyeColor dyeColor) {
        byte byteZero = this.dataManager.get(DYE_COLOR);
        this.dataManager.set(DYE_COLOR, (byte)(byteZero & 240 | dyeColor.getId() & 15));
    }

    private static DyeColor getRandomSlimeColor(Random random) {
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

    public static AttributeModifierMap getAttributes() {
        AttributeModifierMap.MutableAttribute attributes = SlimeEntity.func_233666_p_();

        attributes.func_233814_a_(Attributes.field_233823_f_);

        return attributes.func_233813_a_();
    }

    public static boolean _canSpawn(EntityType<ColoredSlimeEntity> entityType, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        if (worldIn.getDifficulty() != Difficulty.PEACEFUL) {
            if (Objects.equals(worldIn.func_242406_i(pos), Optional.of(Biomes.SWAMP)) && pos.getY() > 50 && pos.getY() < 70 && randomIn.nextFloat() < 0.5F && randomIn.nextFloat() < worldIn.func_242413_ae() && worldIn.getLight(pos) <= randomIn.nextInt(8)) {
               return canSpawnOn(entityType, worldIn, reason, pos, randomIn);
            }
   
            if (!(worldIn instanceof ISeedReader)) {
               return false;
            }
   
            ChunkPos chunkpos = new ChunkPos(pos);
            boolean flag = SharedSeedRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, ((ISeedReader)worldIn).getSeed(), 987234911L).nextInt(10) == 0;
            if (randomIn.nextInt(10) == 0 && flag && pos.getY() < 40) {
               return canSpawnOn(entityType, worldIn, reason, pos, randomIn);
            }
         }
   
         return false;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        // TODO Auto-generated method stub
        return super.canSpawn(worldIn, spawnReasonIn);
    }
    
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
        this.setSlimeColor(getRandomSlimeColor(worldIn.getRandom()));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(DYE_COLOR, (byte)0);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte("Color", (byte)this.getSlimeColor().getId());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setSlimeColor(DyeColor.byId(compound.getByte("Color")));
    }

    @Override
    @SuppressWarnings("deprecation") /* this.removed is deprecated */
    public void remove(boolean keepData) {
        int i = this.getSlimeSize();
        if (!this.world.isRemote && i > 1 && this.func_233643_dh_() && !this.removed) {
            ITextComponent itextcomponent = this.getCustomName();
            boolean flag = this.isAIDisabled();
            float f = (float) i / 4.0F;
            int j = i / 2;
            int k = 2 + this.rand.nextInt(3);

            for (int l = 0; l < k; ++l) {
                float f1 = ((float) (l % 2) - 0.5F) * f;
                float f2 = ((float) (l / 2) - 0.5F) * f;
                ColoredSlimeEntity coloredSlimeEntity = (ColoredSlimeEntity) this.getType().create(this.world);
                if (this.isNoDespawnRequired()) {
                    coloredSlimeEntity.enablePersistence();
                }

                coloredSlimeEntity.setCustomName(itextcomponent);
                coloredSlimeEntity.setNoAI(flag);
                coloredSlimeEntity.setInvulnerable(this.isInvulnerable());
                coloredSlimeEntity.setSlimeColor(this.getSlimeColor());
                coloredSlimeEntity.setSlimeSize(j, true);
                coloredSlimeEntity.setLocationAndAngles(this.getPosX() + (double) f1, this.getPosY() + 0.5D,
                        this.getPosZ() + (double) f2, this.rand.nextFloat() * 360.0F, 0.0F);
                this.world.addEntity(coloredSlimeEntity);
            }
        }

        this.removed = true;

        super.remove(keepData);
    }

    @Override
    protected boolean spawnCustomParticles() {
        int i = this.getSlimeSize();

        for (int j = 0; j < i * 8; ++j) {
            float f = this.rand.nextFloat() * ((float) Math.PI * 2F);
            float f1 = this.rand.nextFloat() * 0.75F + 0.75F;
            float f2 = MathHelper.sin(f) * (float) i * 0.75F * f1;
            float f3 = MathHelper.cos(f) * (float) i * 0.75F * f1;
            this.world.addParticle(
                this.getSquishParticle(), 
                this.getPosX() + (double) f2, 
                this.getPosY(),
                this.getPosZ() + (double) f3, 0.5D, 0.5D, 0.5D
            );
        }
        return true;
    }

    @Override
    protected IParticleData getSquishParticle() {
        switch (this.getSlimeColor()) {
            case WHITE:
            default:
                return (BasicParticleType)ModParticleTypes.WHITE_SLIME_PARTICLE.get();
            case ORANGE:
                return (BasicParticleType)ModParticleTypes.ORANGE_SLIME_PARTICLE.get();
            case MAGENTA:
                return (BasicParticleType)ModParticleTypes.MAGENTA_SLIME_PARTICLE.get();
            case LIGHT_BLUE:
                return (BasicParticleType)ModParticleTypes.LIGHT_BLUE_SLIME_PARTICLE.get();
            case YELLOW:
                return (BasicParticleType)ModParticleTypes.YELLOW_SLIME_PARTICLE.get();
            case LIME:
                return (BasicParticleType)ModParticleTypes.LIME_SLIME_PARTICLE.get();
            case PINK:
                return (BasicParticleType)ModParticleTypes.PINK_SLIME_PARTICLE.get();
            case GRAY:
                return (BasicParticleType)ModParticleTypes.GRAY_SLIME_PARTICLE.get();
            case LIGHT_GRAY:
                return (BasicParticleType)ModParticleTypes.LIGHT_GRAY_SLIME_PARTICLE.get();
            case CYAN:
                return (BasicParticleType)ModParticleTypes.CYAN_SLIME_PARTICLE.get();
            case PURPLE:
                return (BasicParticleType)ModParticleTypes.PURPLE_SLIME_PARTICLE.get();
            case BLUE:
                return (BasicParticleType)ModParticleTypes.BLUE_SLIME_PARTICLE.get();
            case BROWN:
                return (BasicParticleType)ModParticleTypes.BROWN_SLIME_PARTICLE.get();
            case GREEN:
                return (BasicParticleType)ModParticleTypes.GREEN_SLIME_PARTICLE.get();
            case RED:
                return (BasicParticleType)ModParticleTypes.RED_SLIME_PARTICLE.get();
            case BLACK:
                return (BasicParticleType)ModParticleTypes.BLACK_SLIME_PARTICLE.get();
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        if (this.getSlimeSize() == 1) {
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
        } else {
            return LootTables.EMPTY;
        }
    }
}