package com.example.runners;

import com.example.config.WebDriverConfig;
import com.example.ui.SearchForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class DuckDuckGoSearchTest extends WebDriverConfig {

    private WebDriver browser;
    private Actor andres;

    @BeforeEach
    public void setTheStage() {
        andres = Actor.named("Andres");
        andres.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void andresShouldBeAbleToSearchInDuckDuckGo() {
        andres.attemptsTo(
                Open.url("https://duckduckgo.com/"),
                Enter.keyValues("Serenity bdd").into(SearchForm.SEARCH_INPUT)
                        .thenHit(Keys.ENTER),
                Click.on(SearchForm.FIRST_RESULT_LINK)
        );
    }
}