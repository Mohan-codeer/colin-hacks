package com.colinhack.module.movement;

import com.colinhack.module.Module;

public class Fly extends Module {
    public Fly() {
        super("Fly", "Allows you to fly", Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if (mc.player != null) {
            mc.player.getAbilities().flying = true;
        }
    }

    @Override
    public void onDisable() {
        if (mc.player != null && !mc.player.isCreative()) {
            mc.player.getAbilities().flying = false;
        }
    }
}
