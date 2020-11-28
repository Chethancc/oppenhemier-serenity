package specs;
import constants.Constant;
import io.restassured.http.ContentType;
import net.thucydides.core.pages.PageObject;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.rest;
import static constants.Constant.*;
public class MultiUserInsertionSpec extends PageObject {

    public void insertMulitpleData(String request){
        rest()
                .body(request)
                .log().all()
                .contentType(ContentType.JSON)
                .post(baseUrl+"/calculator/insertMultiple")
                .then().log().all(true)
                .statusCode(202)
                .extract().response();

    }

    public void inserMultipleDataViaFile(String filePath){
          rest()
                  .body(filePath)
                  .log().all()
                  .multiPart("file",new File(fileToLoadPath))
                  .post(baseUrl+"/calculator/uploadLargeFileForInsertionToDatabase")
                  .then().log().all(true)
                  .statusCode(200)
                  .extract().response().prettyPrint();
    }
}
