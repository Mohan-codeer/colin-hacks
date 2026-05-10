package com.colinhack.module.render;

import com.colinhack.module.Module;

public class FullBright extends Module {
    private double oldGamma;

    public FullBright() {
        super("FullBright", "Makes everything bright", Category.RENDER);
    }

    @Override
    public void onEnable() {
        oldGamma = mc.options.gamma().get();
        mc.options.gamma().set(100.0);
    }

    @Override
    public void onDisable() {
        mc.options.gamma().set(oldGamma);
    }
}
