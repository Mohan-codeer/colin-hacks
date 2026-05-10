package com.colinhack.client;

import com.colinhack.gui.ClickGuiScreen;
import com.colinhack.module.Module;
import com.colinhack.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class ColinHackClient implements ClientModInitializer {
    public static KeyMapping guiKeyBinding;

    @Override
    public void onInitializeClient() {
        guiKeyBinding = new KeyMapping(
                "key.colinhack.gui",
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KeyMapping.Category.MISC
        );
        // We will register this via Mixin to Options if needed, 
        // or just check it manually in a tick mixin.
    }
    
    public static void onTick(Minecraft client) {
        if (guiKeyBinding != null && guiKeyBinding.consumeClick()) {
            client.setScreen(new ClickGuiScreen());
        }

        if (client.player != null) {
            for (Module module : ModuleManager.INSTANCE.getModules()) {
                if (module.isEnabled()) {
                    module.onTick();
                }
            }
        }
    }
}
