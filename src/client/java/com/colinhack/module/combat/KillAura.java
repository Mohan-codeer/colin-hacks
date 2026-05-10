package com.colinhack.module.combat;

import com.colinhack.module.Module;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;

import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;

public class KillAura extends Module {
    public KillAura() {
        super("KillAura", "Automatically attacks entities around you", Category.COMBAT);
    }

    @Override
    public void onTick() {
        if (mc.player == null || mc.level == null) return;

        Iterable<Entity> entities = mc.level.entitiesForRendering();
        Entity target = StreamSupport.stream(entities.spliterator(), false)
                .filter(e -> e instanceof LivingEntity && e != mc.player && e.isAlive())
                .filter(e -> mc.player.distanceTo(e) < 4.5)
                .min(Comparator.comparingDouble(e -> mc.player.distanceTo(e)))
                .orElse(null);

        if (target != null) {
            mc.gameMode.attack(mc.player, target);
            mc.player.swing(InteractionHand.MAIN_HAND);
        }
    }
}
