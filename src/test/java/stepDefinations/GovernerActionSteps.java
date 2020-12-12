package stepDefinations;

import constants.Constant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class GovernerActionSteps extends PageObject {

    @Given("I login as a Governer")
    public void i_login_as_a_governer() {
        waitABit(2000);
        getDriver().get(Constant.baseUrl);
    }

    @Given("able to see the tax relief details")
    public void able_to_see_the_tax_relief_details() {
        getDriver().findElement(By.cssSelector(("table.table.table-hover.table-dark"))).isDisplayed();

    }

    @Then("should be able to dipense the amount")
    public void should_be_able_to_dipense_the_amount() {
        WebElementFacade  element = find(By.xpath("//a[text()='Dispense Now']"));
        //verifying if button is displayed and colour is red
        if(element.isDisplayed() && element.getAttribute("class").contains("btn-danger")){
            clickOn(getDriver().findElement(By.xpath("//a[text()='Dispense Now']")));
            Assert.assertTrue("Cash Might not be dispensed please check",getDriver().findElement(By.xpath("//div[text()='Cash dispensed']")).isDisplayed());
            waitABit(2000);
            getDriver().close();
        }

    }

}
