package com.colinhack.module.movement;

import com.colinhack.module.Module;
import net.minecraft.world.phys.Vec3;

public class Speed extends Module {
    public Speed() {
        super("Speed", "Increases your movement speed", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player != null && mc.player.input != null && (mc.player.input.keyPresses.left() || mc.player.input.keyPresses.right() || mc.player.input.keyPresses.forward() || mc.player.input.keyPresses.backward())) {
            float yaw = mc.player.getYRot();
            Vec3 velocity = mc.player.getDeltaMovement();
            double speed = 0.2;
            double motionX = -Math.sin(Math.toRadians(yaw)) * speed;
            double motionZ = Math.cos(Math.toRadians(yaw)) * speed;
            mc.player.setDeltaMovement(velocity.x + motionX, velocity.y, velocity.z + motionZ);
        }
    }
}
