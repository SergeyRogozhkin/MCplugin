package com.mod.service;

import com.mod.dto.PlayerFullDto;
import com.mod.dto.PlayerShortDto;
import com.mod.initializer.ServerStartedModInitializer;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import jakarta.servlet.http.HttpServletResponse;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;
import java.util.List;

@Service
public class PlayersOnlineService {

    public PlayerFullDto getFullInfoById() {
        //TODO
        // Используй этот объект сервера
        MinecraftServer server = ServerStartedModInitializer.getServer();
        return null;
    }

    public List<PlayerShortDto> getAll() {
        //TODO
        return null;
    }
}
