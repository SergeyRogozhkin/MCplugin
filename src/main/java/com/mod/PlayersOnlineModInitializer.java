package com.mod;

import com.mod.handler.PlayersOnlineHandler;
import com.mod.properties.ConfigurationProperties;
import com.mod.wrapper.HttpServerWrapper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class PlayersOnlineModInitializer implements ModInitializer {
    private final static ConfigurationProperties properties = new ConfigurationProperties();

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(this::onServerStaredEvent);
    }

    private void onServerStaredEvent(MinecraftServer server) {
        HttpServerWrapper httpServerWrapper = new HttpServerWrapper(properties.getServerPort());
        httpServerWrapper.bindHandler(properties.getPlayersOnlinePath(), new PlayersOnlineHandler(server));
    }
}