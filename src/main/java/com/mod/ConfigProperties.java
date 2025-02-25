package com.mod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    Properties properties = new Properties();
    private int port;
    private int backlog;
    private String status;

    public String getStatus() {
        return status;
    }

    public int getPort() {
        return port;
    }

    public int getBacklog() {
        return backlog;
    }

    public ConfigProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new FileNotFoundException("Файл config.properties не найден в classpath");
            }
            properties.load(input);
            port = Integer.parseInt(properties.getProperty("server.port"));
            backlog = Integer.parseInt(properties.getProperty("server.backlog"));
            status = properties.getProperty("http.context.path");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
