package net.serenitybdd.demos.itonics.cucumber.steps;


import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.demos.itonics.helper.SelectLocatorManupulator;
import net.serenitybdd.demos.itonics.screenplay.model.FacebookUser;
import net.serenitybdd.demos.itonics.screenplay.questions.SearchCategory;
import net.serenitybdd.demos.itonics.screenplay.questions.TheText;
import net.serenitybdd.demos.itonics.screenplay.tasks.FillForm;
import net.serenitybdd.demos.itonics.screenplay.tasks.OpenUrl;
import net.serenitybdd.demos.itonics.screenplay.user_interface.amazon.FacebookLoginPage;
import net.serenitybdd.demos.itonics.screenplay.user_interface.amazon.SearchBar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitions {

    @ParameterType(".*")
    public Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }

    @DataTableType
    public FacebookUser facebookUserEntry(Map<String, String> entry) {
        FacebookUser facebookUser = new FacebookUser();
        facebookUser.setEmail(entry.get("UserName"));
        facebookUser.setPassword(entry.get("Password"));
        return facebookUser;
    }

    @Before
    public void set_the_stage() {
        setTheStage(new OnlineCast());
    }

    @Given("{actor} is on amazon website")
    public void john_is_on_amazon_website(Actor actor) {
        actor.attemptsTo(OpenUrl.theAmazonWebsite());
    }

    @When("{actor} randomly selects a category from search dropdown")
    public void john_randomly_selects_a_category_from_search_dropdown(Actor actor) {
        List<String> categories = SelectLocatorManupulator.getAllText(SearchBar.CATEGORY_DROPDOWN.resolveFor(actor));
        String randomCategory = categories.get((int) (Math.random() * categories.size()));
        actor.remember("selectedCategory", randomCategory);
        actor.attemptsTo(SelectFromOptions.byVisibleText(randomCategory).from(SearchBar.CATEGORY_DROPDOWN));
    }

    @Then("the category is selected")
    public void the_category_is_selected() {
        String selectedCategory = theActorInTheSpotlight().recall("selectedCategory");
        theActorInTheSpotlight().should(seeThat(SearchCategory.selectedCategory(), org.hamcrest.Matchers.equalTo(selectedCategory)));
    }

    @Given("{actor} is on Facebook login page")
    public void john_is_on_facebook_login_page(Actor actor) {
        actor.attemptsTo(OpenUrl.theFacebookLogin());
    }

    @When("{actor} enters following credentials")
    public void john_enters_following_credentials(Actor actor, FacebookUser userData) {
        actor.attemptsTo(FillForm.theFacebookLoginPage(userData.getEmail(), userData.getPassword()));
        actor.attemptsTo(Click.on(FacebookLoginPage.LOGIN_BUTTON));
    }

    @Then("{actor} gets {string} error")
    public void john_gets_error(Actor actor, String text) {
        actor.should(seeThat(TheText.isPresent(text, 2)));
    }
}
