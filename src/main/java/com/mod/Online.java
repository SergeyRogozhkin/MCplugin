package com.mod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.HttpServer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.transformer.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Online implements ModInitializer {
	private MinecraftServer minecraftServer;

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(this::onServerStaredEvent);

	}

	private void onServerStaredEvent(MinecraftServer server) {
		this.minecraftServer = server;
		try {
			ConfigProperties config = new ConfigProperties();
			HttpServer httpServer = HttpServer.create(new InetSocketAddress(config.getPort()), config.getBacklog());
			MonitorAction action = new MonitorAction(httpServer, minecraftServer);
			action.start();
			httpServer.start();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}