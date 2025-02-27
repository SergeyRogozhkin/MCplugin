package com.mod.handler;

import net.minecraft.server.MinecraftServer;
import org.apache.http.HttpException;

public class PlayersOnlineHandler extends AbstractHandler {
    private final MinecraftServer minecraftServer;

    public PlayersOnlineHandler(MinecraftServer minecraftServer) {
        this.minecraftServer = minecraftServer;
    }

    @Override
    protected byte[] createResponse() throws HttpException {
        /* TODO расширить логику, чтобы не только ники отображались, но и еще какая-либо информация на твое усмотрение
            Если сможешь 2D головы доставать и выводить, то вообще гений.
            Проверь что находится в объекте PlayerManager, что в MinecraftServer.
            В режиме debug сервера поставь точку остановы на строчку "byte[] response;" и посмотри объект MinecraftServer
        */
        byte[] response;
        if (this.minecraftServer != null) {
            response = String.join(", ", minecraftServer.getPlayerNames()).getBytes();
        } else {
            throw new HttpException("Server is null");
        }
        return response;
    }
}
