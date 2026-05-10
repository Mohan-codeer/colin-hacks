package com.colinhack.client.mixin;

import com.colinhack.client.ColinHackClient;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftTickMixin {
    @Inject(at = @At("RETURN"), method = "tick")
    private void onTick(CallbackInfo info) {
        ColinHackClient.onTick((Minecraft) (Object) this);
    }
}
