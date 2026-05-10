package com.colinhack.gui;

import com.colinhack.module.Module;
import com.colinhack.module.ModuleManager;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.input.MouseButtonEvent;

import java.util.List;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Component.literal("ColinHack Click GUI"));
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor extractor, int mouseX, int mouseY, float partialTick) {
        this.extractTransparentBackground(extractor);

        int x = 20;
        for (Module.Category category : Module.Category.values()) {
            extractor.text(this.font, category.name(), x, 20, 0xFFFFFF00);
            
            int y = 40;
            List<Module> modules = ModuleManager.INSTANCE.getModulesByCategory(category);
            for (Module module : modules) {
                int color = module.isEnabled() ? 0xFF00FF00 : 0xFFFF0000;
                extractor.text(this.font, module.getName(), x, y, color);
                y += 12;
            }
            x += 80;
        }
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean handled) {
        double mouseX = event.x();
        double mouseY = event.y();
        
        int x = 20;
        for (Module.Category category : Module.Category.values()) {
            int y = 40;
            List<Module> modules = ModuleManager.INSTANCE.getModulesByCategory(category);
            for (Module module : modules) {
                if (mouseX >= x && mouseX <= x + 70 && mouseY >= y && mouseY <= y + 10) {
                    module.toggle();
                    return true;
                }
                y += 12;
            }
            x += 80;
        }
        return super.mouseClicked(event, handled);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
