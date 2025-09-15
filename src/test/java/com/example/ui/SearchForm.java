package com.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchForm {

    public static final Target SEARCH_INPUT = Target.the("campo de búsqueda")
            .located(By.cssSelector("input[name='q'], input[type='text'], #search_form_input"));

    public static final Target SEARCH_BUTTON = Target.the("botón de búsqueda")
            .located(By.cssSelector("input[type='submit'], button[type='submit'], #search_button"));

    public static final Target SEARCH_RESULTS = Target.the("resultados de búsqueda")
            .located(By.cssSelector("[data-testid='results'], .results, #links, .react-results--main"));
}