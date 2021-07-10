package net.serenitybdd.demos.itonics.helper;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class SelectLocatorManupulator {
    public static List<String> getAllText(WebElementFacade selector) {
        return selector.getSelectOptions();
    }
}
