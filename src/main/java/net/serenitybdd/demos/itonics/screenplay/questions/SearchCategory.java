package net.serenitybdd.demos.itonics.screenplay.questions;

import net.serenitybdd.demos.itonics.screenplay.user_interface.amazon.SearchBar;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.SelectedVisibleTextValue;

public class SearchCategory {
    public static Question<String> selectedCategory() {
        return SelectedVisibleTextValue.of(SearchBar.CATEGORY_DROPDOWN)
                .asAString();
    }
}
