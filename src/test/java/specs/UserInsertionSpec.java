package specs;

import io.restassured.http.ContentType;
import model.request.UserRequest;
import net.thucydides.core.pages.PageObject;
import sun.jvm.hotspot.debugger.Page;

import static net.serenitybdd.rest.SerenityRest.rest;
import static constants.Constant.*;
public class UserInsertionSpec {

    public void insertNewUser(UserRequest request) {
        rest()
                .body(request)
                .log().all()
                .contentType(ContentType.JSON)
                .post(baseUrl+userInsertionURL)
                .then().log().all(true)
                .statusCode(202)
                .extract().response();
    }


}
