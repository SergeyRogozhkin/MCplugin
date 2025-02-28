package com.mod.initializer;

import net.fabricmc.api.ModInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationModInitializer implements ModInitializer {
    @Override
    public void onInitialize() {
        SpringApplication.run(SpringApplicationModInitializer.class, System.getProperties().toString());
    }
}
