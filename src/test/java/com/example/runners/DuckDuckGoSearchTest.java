package com.example.runners;

import com.example.ui.SearchForm;
import net.serenitybdd.annotations.Managed;
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
public class DuckDuckGoSearchTest {

    @Managed
    WebDriver browser;

    Actor andres = Actor.named("Andres");

    @Test
    public void andresShouldBeAbleToSearchInDuckDuckGo() {
        andres.can(BrowseTheWeb.with(browser));
        andres.attemptsTo(
                Open.url("https://duckduckgo.com/"),
                Enter.keyValues("Serenity bdd").into(SearchForm.SEARCH_INPUT)
                        .thenHit(Keys.ENTER),
                Click.on(SearchForm.FIRST_RESULT_LINK)
        );
    }
}