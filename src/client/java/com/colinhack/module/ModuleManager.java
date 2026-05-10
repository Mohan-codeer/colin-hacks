package com.colinhack.module;

import com.colinhack.module.movement.*;
import com.colinhack.module.combat.*;
import com.colinhack.module.player.*;
import com.colinhack.module.render.*;
import com.colinhack.module.world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // Movement
        modules.add(new Fly());
        modules.add(new Speed());
        modules.add(new Jesus());
        modules.add(new Step());
        
        // Combat
        modules.add(new KillAura());
        modules.add(new AutoClicker());
        modules.add(new AimBot());

        // Player
        modules.add(new NoFall());
        
        // Render
        modules.add(new FullBright());
        modules.add(new ESP());
        modules.add(new Tracers());

        // World
        modules.add(new Scaffold());
        modules.add(new XRay());
        modules.add(new Timer());
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getModulesByCategory(Module.Category category) {
        return modules.stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }

    public Module getModuleByName(String name) {
        return modules.stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
