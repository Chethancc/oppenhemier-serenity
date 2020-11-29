package specs;
import com.fasterxml.jackson.core.JsonProcessingException;
import constants.Constant;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.response.BookerResponse;
import net.thucydides.core.pages.PageObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.objectMapper;
import static net.serenitybdd.rest.SerenityRest.rest;
import static constants.Constant.*;
public class BookeeperSpec {
    List<BookerResponse> responseData;

    public void rakeDataBase() {
        rest()
                .contentType(ContentType.JSON)
                .post(baseUrl + rakeDBUrl)
                .then().log().all(true)
                .statusCode(200).extract().response();
    }

    public void insertRandomDataToDBViaAPI(int dataToBeInserted) {
        rest()
                .contentType(ContentType.JSON)
                .post(baseUrl + insertDBURL + dataToBeInserted)
                .then().log().all(true)
                .statusCode(200)
                .extract().response();
    }

    public List<BookerResponse> getDetailsOfInsertedData() {
        ObjectMapper objectMapper = new ObjectMapper();
        String response = rest()
                .contentType(ContentType.JSON)
                .get(baseUrl + dbDetailURL)
                .then().log().all()
                .statusCode(200).extract().asString();
        try {
            responseData = Arrays.asList(objectMapper.readValue(response, BookerResponse[].class));
        } catch (JsonProcessingException js) {
            js.printStackTrace();
        }

        return responseData;
    }

    public void verfiyResultData() {
        if (!responseData.isEmpty()) {
            for (BookerResponse bookerResponse : responseData) {
                int reliefAmount = (int) Float.parseFloat(bookerResponse.getRelief());
                if (reliefAmount <= 50) {
                    System.out.println("Name of user whose relief is less than 50 is " + bookerResponse.getName());

                }
            }
        } else {
            Assert.assertTrue("No Data is received", false);
        }
    }

        public void verifyUserWithGreaterThanFifty () {
            if (!responseData.isEmpty()) {
                for (BookerResponse bookerResponse : responseData) {
                    int reliefAmount = (int) Float.parseFloat(bookerResponse.getRelief());
                    if (reliefAmount > 50) {
                        System.out.println("Name of user whose relief is less than 50 is " + bookerResponse.getName());
                    }
                }
            } else {
                Assert.assertTrue("No Data is rewceived", false);
            }
        }

        public void verifyOnlyTwoDecimalPlacesArePresent(){
        if(!responseData.isEmpty()){
            for(BookerResponse bookerResponse : responseData) {
                String [] stringSplit = bookerResponse.getRelief().split("\\.");
                if (stringSplit[1].length()>2){
                    Assert.assertTrue("Decimal places are greater than 2 values",false  );
                }
            }
        }
        }
    }

