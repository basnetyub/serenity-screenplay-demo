package net.serenitybdd.demos.itonics.screenplay.tasks;

import net.serenitybdd.demos.itonics.screenplay.user_interface.amazon.FacebookLoginPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class FillForm {
    public static Performable theFacebookLoginPage(String email, String password) {
        return Task.where("{0} fills Facebook Login Page",
                Enter.keyValues(email).into(FacebookLoginPage.EMAIL_INPUT_FIELD),
                Enter.keyValues(password).into(FacebookLoginPage.PASSWORD_INPUT_FIELD)
        );
    }
}
