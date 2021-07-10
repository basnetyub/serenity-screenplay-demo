package net.serenitybdd.demos.itonics.screenplay.user_interface.amazon;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FacebookLoginPage {
    public static Target EMAIL_INPUT_FIELD = Target.the("Email or Phone Input Field")
            .located(By.id("email"));
    public static Target PASSWORD_INPUT_FIELD = Target.the("Password Input Field")
            .located(By.id("pass"));
    public static Target LOGIN_BUTTON = Target.the("Login Button")
            .located(By.id("loginbutton"));
}
