package net.seanomik.tamablefoxes.versions.version_1_21_6_R1.pathfinding;

import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.seanomik.tamablefoxes.versions.version_1_21_6_R1.NMSUtil;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;
import net.seanomik.tamablefoxes.versions.version_1_21_6_R1.EntityTamableFox;

public class FoxPathfinderGoalOwnerHurtByTarget extends TargetGoal {
    private final EntityTamableFox tameAnimal;
    private LivingEntity ownerLastHurtBy;
    private int timestamp;

    public FoxPathfinderGoalOwnerHurtByTarget(EntityTamableFox entitytameableanimal) {
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
                this.ownerLastHurtBy = entityliving.getLastHurtByMob();
                int i = entityliving.getLastHurtByMobTimestamp();
                return i != this.timestamp && this.canAttack(this.ownerLastHurtBy, TargetingConditions.DEFAULT) && this.tameAnimal.wantsToAttack(this.ownerLastHurtBy, entityliving);
            }
        } else {
            return false;
        }
    }

    public void start() {
        NMSUtil.setTarget(this.mob, this.ownerLastHurtBy, TargetReason.TARGET_ATTACKED_OWNER);
        LivingEntity entityliving = this.tameAnimal.getOwner();
        if (entityliving != null) {
            this.timestamp = entityliving.getLastHurtByMobTimestamp();
        }

        tameAnimal.setDefending(false);

        super.start();
    }

    @Override
    public void stop() {
        tameAnimal.setDefending(false);

        super.stop();
    }
}
