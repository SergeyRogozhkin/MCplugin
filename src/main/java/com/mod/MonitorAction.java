package com.mod;

import com.sun.net.httpserver.HttpServer;
import net.minecraft.server.MinecraftServer;

import java.io.OutputStream;

public class MonitorAction {

    private MinecraftServer minecraftServer;
    private HttpServer httpServer;


    public MonitorAction(HttpServer server, MinecraftServer minecraftServer) {
        this.httpServer = server;
        this.minecraftServer = minecraftServer;
    }

    public void start() {
        ConfigProperties config = new ConfigProperties();
        httpServer.createContext(config.getStatus(), exchange -> {
            String response = "";
            if (this.minecraftServer != null) {
                response = String.join(", ", minecraftServer.getPlayerNames());
            }
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
    }


}
