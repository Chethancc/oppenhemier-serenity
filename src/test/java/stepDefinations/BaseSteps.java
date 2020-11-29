package stepDefinations;

import fileReaders.PropertiesReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.rest;

public class BaseSteps {
    @Before()
    public void initialStepUp(){
        OnStage.setTheStage(new Cast());
        PropertiesReader reader = new PropertiesReader();

    }

    @Given("I login as a clerk")
    public void i_login_as_a_clerk() {
        System.out.println("Logging steps to get the tokens base headers should be here ");
    }



}
