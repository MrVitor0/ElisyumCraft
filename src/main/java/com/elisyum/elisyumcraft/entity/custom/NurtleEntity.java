package com.elisyum.elisyumcraft.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.MeleeAttack;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class NurtleEntity extends Monster implements IAnimatable{

    private AnimationFactory factory = new AnimationFactory(this);

    public NurtleEntity(EntityType<? extends Monster> monster, Level level) {
        super(monster, level);
    }

    public static AttributeSupplier setAttributes(){
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, 20.0D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D)
            .add(Attributes.ATTACK_DAMAGE, 3.0D)
            .add(Attributes.ATTACK_SPEED, 35.0D).build();
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this,1.20,false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this,1.00));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Creeper.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.nurtle.walk", true));
            return PlayState.CONTINUE;
        }

       
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.nurtle.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController( new AnimationController<NurtleEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
      return factory;
    }


    protected void playStepSound(BlockPos pos, BlockState blockIn){
        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound(){
        return SoundEvents.CHICKEN_AMBIENT;
    }

    protected SoundEvent getHurtSound(){
        return SoundEvents.CHICKEN_HURT;
    }

    protected SoundEvent getDeathSound(){
        return SoundEvents.CHICKEN_DEATH;
    }

    protected float getSoundVolume(){
        return 0.2F;
    }
    
}
