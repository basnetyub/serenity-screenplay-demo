package net.serenitybdd.demos.itonics.screenplay.user_interface.amazon;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBar {
    public static Target CATEGORY_DROPDOWN = Target.the("Amazon Category Dropdown").located(By.id("searchDropdownBox"));
}
