package net.seanomik.tamablefoxes.versions.version_1_21_5_R1.pathfinding;

import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.seanomik.tamablefoxes.versions.version_1_21_5_R1.NMSUtil;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import net.seanomik.tamablefoxes.versions.version_1_21_5_R1.EntityTamableFox;

public class FoxPathfinderGoalOwnerHurtTarget extends TargetGoal {
    private final EntityTamableFox tameAnimal;
    private LivingEntity ownerLastHurt;
    private int timestamp;

    public FoxPathfinderGoalOwnerHurtTarget(EntityTamableFox entitytameableanimal) {
        super(entitytameableanimal, false);
        this.tameAnimal = entitytameableanimal;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        if (this.tameAnimal.isTamed() && !this.tameAnimal.isOrderedToSit() && !this.tameAnimal.isOrderedToSleep()) {
            LivingEntity entityliving = this.tameAnimal.getOwner();
            if (entityliving == null) {
                return false;
            } else {
                this.ownerLastHurt = entityliving.getLastHurtMob();
                int i = entityliving.getLastHurtMobTimestamp();
                return i != this.timestamp && this.canAttack(this.ownerLastHurt, TargetingConditions.DEFAULT) && this.tameAnimal.wantsToAttack(this.ownerLastHurt, entityliving);
            }
        } else {
            return false;
        }
    }

    public void start() {
        NMSUtil.setTarget(this.mob, this.ownerLastHurt, TargetReason.OWNER_ATTACKED_TARGET);
        LivingEntity entityliving = this.tameAnimal.getOwner();
        if (entityliving != null) {
            this.timestamp = entityliving.getLastHurtMobTimestamp();
        }

        tameAnimal.setDefending(true);

        super.start();
    }


    @Override
    public void stop() {
        tameAnimal.setDefending(false);

        super.stop();
    }
}
