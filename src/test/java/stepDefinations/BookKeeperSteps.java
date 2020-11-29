package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import specs.BookeeperSpec;

public class BookKeeperSteps {
    BookeeperSpec spec = new BookeeperSpec();

    @Given("I login as a Bookeeper")
    public void i_login_as_a_bookeeper() {

    }

    @Given("Rake the database via API")
    public void rake_the_database_via_api() {
        spec.rakeDataBase();
    }

    @Given("Insert data to DB via API")
    public void insert_data_to_db_via_api() {
        spec.insertRandomDataToDBViaAPI(10);
    }

    @Given("get the users with tax releif")
    public void get_the_users_with_tax_releif(){
        spec.getDetailsOfInsertedData();
    }

    @Then("proper users must be present for tax releif <{int}")
    public void proper_users_must_be_present_for_tax_releif(Integer int1)  {
         spec.verfiyResultData();
    }

    @Then("proper user data for tax relief >{int} must be present")
    public void proper_user_data_for_tax_relief_must_be_present(Integer int1){
        spec.verifyUserWithGreaterThanFifty();
    }

    @Then("response should contain tax relief amount with only {int} decimal places")
    public void response_should_contain_tax_relief_amount_with_only_decimal_places(Integer int1) {
        spec.verifyOnlyTwoDecimalPlacesArePresent();
    }


}
