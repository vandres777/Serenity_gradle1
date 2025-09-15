package com.example.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverConfig.class);
    protected WebDriver browser;

    @BeforeAll
    public static void setupWebDriver() {
        try {
            logger.info("Configurando WebDriverManager para Chrome...");
            WebDriverManager.chromedriver().setup();
            logger.info("WebDriverManager configurado exitosamente");
        } catch (Exception e) {
            logger.error("Error configurando WebDriverManager: {}", e.getMessage(), e);
            throw new RuntimeException("No se pudo configurar WebDriverManager", e);
        }
    }

    @BeforeAll
    public static void setupBrowser() {
        // Opcional: puedes crear el WebDriver aquí si es necesario
    }
}