package com.example.runners;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import com.example.tasks.SearchFor;
import com.example.config.WebDriverConfig;
import com.example.questions.ThePageTitle;
import com.example.ui.SearchForm;

import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

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
                seeThat(the(SearchForm.FIRST_RESULT_LINK), isVisible())
        );
    }

    @Test
    public void andresShouldBeAbleToSearchAndClickFirstResult() {
        andres.attemptsTo(
                SearchFor.term("Serenity BDD")
        );

        andres.should(
                seeThat(the(SearchForm.FIRST_RESULT_LINK), isVisible())
        );

        andres.attemptsTo(
                Click.on(SearchForm.FIRST_RESULT_LINK)
        );

        andres.should(
                seeThat(ThePageTitle.is(), containsString("Serenity BDD"))
        );
    }
}