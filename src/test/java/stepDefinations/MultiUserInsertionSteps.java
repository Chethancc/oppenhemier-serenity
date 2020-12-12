package stepDefinations;

import constants.Constant;
import fixtures.MultiUserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import specs.MultiUserInsertionSpec;

import java.util.List;

public class MultiUserInsertionSteps {
MultiUserInsertionSpec multiUserInsertionSpec = new MultiUserInsertionSpec();
    @Given("add insert multiple working heros with profile")
    public void add_insert_multiple_working_heros_with_profile(List<String> myProfile) {
             multiUserInsertionSpec.insertMulitpleData(MultiUserData.getMultipleUserData(myProfile));
    }

    @Then("details must be successufully updated in DB")
    public void details_must_be_successufully_updated_in_db() {
        System.out.println("Db details needed to verify if the data is added successfully");
    }

    @Given("insert multiple records of users via API")
    public void insert_multiple_records_of_users_via_api() {
        multiUserInsertionSpec.inserMultipleDataViaFile(Constant.fileToLoadPath);
    }
}
