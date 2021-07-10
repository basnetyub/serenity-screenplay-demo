package net.serenitybdd.demos.itonics.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class
TheText implements Question<Boolean> {
    private final String text;
    private final int waitTimeSeconds;

    public TheText(String text, int waitTimeSeconds) {
        this.text = text;
        this.waitTimeSeconds = waitTimeSeconds;
    }

    public static TheText isPresent(String text, int waitTimeSeconds) {
        return new TheText(text, waitTimeSeconds);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Target containOnPage = Target.the("Element with text" + text)
                .located(By.xpath("//*[contains(text(), '" + text + "')]"));
        Boolean isPresent = containOnPage.waitingForNoMoreThan(Duration.ofSeconds(waitTimeSeconds)).resolveFor(actor).isDisplayed();
        return isPresent;
    }
}
