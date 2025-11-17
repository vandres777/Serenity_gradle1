package com.example.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchForm {

    public static final Target SEARCH_INPUT = Target.the("campo de búsqueda")
            .located(By.cssSelector("input[name='q'], input[type='text'], #search_form_input"));

    public static final Target SEARCH_BUTTON = Target.the("botón de búsqueda")
            .located(By.cssSelector("input[type='submit'], button[type='submit'], #search_button"));

    public static final Target SEARCH_RESULTS = Target.the("resultados de búsqueda")
            .located(By.id("links_wrapper"));

    public static final Target FIRST_RESULT_LINK = Target.the("primer resultado de búsqueda")
            .located(By.xpath("(//div[@id='react-layout']//a[@data-testid='result-title-a'])[1]"));
}