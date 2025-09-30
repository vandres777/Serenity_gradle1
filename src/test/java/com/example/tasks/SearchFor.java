package com.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.Keys;
import com.example.ui.SearchForm;

public class SearchFor {

    public static Performable term(String term) {
        return Task.where("{0} busca el termino '" + term + "'",
                Open.url("https://duckduckgo.com/"),
                Enter.keyValues(term).into(SearchForm.SEARCH_INPUT)
                        .thenHit(Keys.ENTER)
        );
    }
}