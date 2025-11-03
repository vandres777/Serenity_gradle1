package com.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverConfig.class);

    @BeforeAll
    public static void setupWebDriver() {
        String environment = System.getProperty("environment", "chrome"); // Default to chrome
        try {
            logger.info("Configurando WebDriverManager para {}...", environment);
            switch (environment.toLowerCase()) {
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    break;
                case "firefox":
                    if (Boolean.parseBoolean(System.getProperty("headless"))) {
                        WebDriverManager.firefoxdriver().setup();
                    } else {
                        WebDriverManager.firefoxdriver().setup();
                    }
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    break;
            }
            logger.info("WebDriverManager para {} configurado exitosamente", environment);
        } catch (Exception e) {
            logger.error("Error configurando WebDriverManager para {}: {}", environment, e.getMessage(), e);
            throw new RuntimeException("No se pudo configurar WebDriverManager para " + environment, e);
        }
    }

    public static void setupBrowser() {
        // Opcional: puedes crear el WebDriver aquí si es necesario
    }
}