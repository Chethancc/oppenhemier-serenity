package stepDefinations;

import fixtures.UserInsertionData;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.request.UserRequest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import specs.UserInsertionSpec;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.rest;

public class UserInsertionSteps {
UserInsertionSpec userInsertionSpec = new UserInsertionSpec();

    @Given("add the details of the working hero")
    public void add_the_details_of_the_working_hero() {
        UserRequest userRequest = UserInsertionData.getDefaultData();
        userInsertionSpec.insertNewUser(userRequest);

    }

    @Then("details must be successfully updated")
    public void details_must_be_successfully_updated() {
        System.out.println("Validate the db");
    }
}
