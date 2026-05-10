package com.colinhack.module.combat;

import com.colinhack.module.Module;
import com.colinhack.client.mixin.MinecraftAccessor;

public class AutoClicker extends Module {
    private int timer;

    public AutoClicker() {
        super("AutoClicker", "Automatically clicks for you", Category.COMBAT);
    }

    @Override
    public void onTick() {
        if (mc.options.keyAttack.isDown()) {
            timer++;
            if (timer >= 2) {
                ((MinecraftAccessor) mc).callStartAttack();
                timer = 0;
            }
        }
    }
}
