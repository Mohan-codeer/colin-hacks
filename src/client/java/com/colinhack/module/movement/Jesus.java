package com.colinhack.module.movement;

import com.colinhack.module.Module;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;

public class Jesus extends Module {
    public Jesus() {
        super("Jesus", "Allows you to walk on water", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player == null) return;
        if (mc.player.isInWater() || mc.player.isInLava()) {
            Vec3 motion = mc.player.getDeltaMovement();
            mc.player.setDeltaMovement(motion.x, 0.1, motion.z);
        }
    }
}
