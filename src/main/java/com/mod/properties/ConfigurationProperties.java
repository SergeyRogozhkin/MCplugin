package com.mod.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties {
    private final static String SERVER_PORT = "server.port";
    private final static String PLAYERS_ONLINE_PATH = "players.online.path";
    private final static String PROPERTY_FILE_NAME = "/configuration.properties";
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final Properties properties;

    public ConfigurationProperties() {
        this.properties = new Properties();
        try (InputStream input = ConfigurationProperties.class.getResourceAsStream(PROPERTY_FILE_NAME)) {
            properties.load(input);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public int getServerPort() {
        return Integer.parseInt(properties.getProperty(SERVER_PORT));
    }

    public String getPlayersOnlinePath() {
        return properties.getProperty(PLAYERS_ONLINE_PATH);
    }
}
