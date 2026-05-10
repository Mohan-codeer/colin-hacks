package com.colinhack.module.player;

import com.colinhack.module.Module;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", "Prevents fall damage", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (mc.player != null && mc.player.fallDistance > 2f) {
            mc.player.connection.send(new ServerboundMovePlayerPacket.StatusOnly(true, mc.player.horizontalCollision));
        }
    }
}
