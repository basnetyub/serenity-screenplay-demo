package net.serenitybdd.demos.itonics.screenplay.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenUrl {
    public static Performable theAmazonWebsite() {
        return Task.where("{0} opens the Amazon home page",
                Open.browserOn().thePageNamed("amazon.homepage")
        );
    }
}
