package com.colinhack.module.movement;

import com.colinhack.module.Module;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class Step extends Module {
    public Step() {
        super("Step", "Allows you to step up blocks", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player != null) {
            mc.player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(1.0);
        }
    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.getAttribute(Attributes.STEP_HEIGHT).setBaseValue(0.6);
        }
    }
}
