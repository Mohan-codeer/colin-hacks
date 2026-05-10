package com.colinhack.module.combat;

import com.colinhack.module.Module;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;

import java.util.Comparator;
import java.util.stream.StreamSupport;

public class AimBot extends Module {
    public AimBot() {
        super("AimBot", "Automatically aims at entities", Category.COMBAT);
    }

    @Override
    public void onTick() {
        if (mc.player == null || mc.level == null) return;

        Entity target = StreamSupport.stream(mc.level.entitiesForRendering().spliterator(), false)
                .filter(e -> e instanceof LivingEntity && e != mc.player && e.isAlive())
                .filter(e -> mc.player.distanceTo(e) < 6.0)
                .min(Comparator.comparingDouble(e -> mc.player.distanceTo(e)))
                .orElse(null);

        if (target != null) {
            double diffX = target.getX() - mc.player.getX();
            double diffY = (target.getY() + target.getEyeHeight()) - (mc.player.getY() + mc.player.getEyeHeight());
            double diffZ = target.getZ() - mc.player.getZ();
            double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);

            float yaw = (float) (Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0);
            float pitch = (float) (-Math.toDegrees(Math.atan2(diffY, diffXZ)));

            mc.player.setYRot(yaw);
            mc.player.setXRot(pitch);
        }
    }
}
