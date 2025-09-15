package com.example.runners;

import com.example.ui.SearchForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import com.example.tasks.SearchFor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import com.example.config.WebDriverConfig;

@ExtendWith(SerenityJUnit5Extension.class)
public class DuckDuckGoSearchWithTasksTest extends WebDriverConfig {

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
                SearchFor.term("Serenity bdd")
        );

        andres.should(
                seeThat(the(SearchForm.SEARCH_RESULTS), isVisible())
        );
    }
}