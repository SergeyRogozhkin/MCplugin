package com.mod.initializer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class ServerStartedModInitializer implements ModInitializer {
    protected static MinecraftServer server;

    public static MinecraftServer getServer() {
        if (ServerStartedModInitializer.server == null || ServerStartedModInitializer.server.getPlayerManager() == null) {
            throw new RuntimeException("Minecraft server not started!");
        }
        return server;
    }

    private void setServer(MinecraftServer server) {
        ServerStartedModInitializer.server = server;
    }

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(this::setServer);
    }
}