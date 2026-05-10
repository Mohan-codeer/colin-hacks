package com.colinhack.module;

import net.minecraft.client.Minecraft;

public abstract class Module {
    private String name;
    private String description;
    private Category category;
    private int key;
    private boolean enabled;

    protected static final Minecraft mc = Minecraft.getInstance();

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.enabled = false;
        this.key = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onTick() {}

    public enum Category {
        COMBAT, MOVEMENT, PLAYER, RENDER, WORLD, MISC
    }
}
