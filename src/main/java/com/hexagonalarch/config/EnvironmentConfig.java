package com.hexagonalarch.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;


@Component
public class EnvironmentConfig {

    public static String OPEN_AI_KEY;

    static {
        Dotenv dotenv = Dotenv.load();
        OPEN_AI_KEY = dotenv.get("OPEN_AI_KEY");
    }
}
