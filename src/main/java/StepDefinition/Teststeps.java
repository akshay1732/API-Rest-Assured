package StepDefinition;




import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;



public class Teststeps {


    private static Response response;


    @Given("^Test API get request$")
    public void Test_API_GET_request() {
        //RestAssured.baseURI=BASE_URL;
        response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.asString());
        System.out.println(response.getHeader("content-type"));

    }

    @Then("^Test API get request with conditions$")
    public void Test_API_GET_request_with_conditions(){
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
        given().get("https://reqres.in/api/users?page=2").then().body("data.id[0]",is(7));

    }

    @And("^Test API POST request$")
    public void click_on_i_am_feeling_lucky_button() {

    }

    @Given("^Test API post request$")
    public void Test_POST_API_request() {
        Map<String, Object> map =new HashMap<>();
        JSONObject parameters = new JSONObject();
        parameters.put("name","Akshay");
        parameters.put("job","leader");
        given().body(parameters.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);


    }

    @Then("^Test API post request with conditions$")
    public void Test_POST_API_request_with_conditions(){
        Map<String, Object> map =new HashMap<>();
        JSONObject parameters = new JSONObject();
        parameters.put("name","Akshay");
        parameters.put("job","leader");
        given().body(parameters.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);

    }

    @Given("^Test API put request$")
    public void Test_PUT_API_request() {
        JSONObject parameters = new JSONObject();
        parameters.put("name","Akshay");
        parameters.put("job","leader");
        given().body(parameters.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200);


    }

    @Then("^Test API put request with conditions$")
    public void Test_PUT_API_request_with_conditions(){
        JSONObject parameters = new JSONObject();
        parameters.put("name","Akshay");
        parameters.put("job","leader");
        given().body(parameters.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200);

    }

    @Given("^Test API patch request$")
    public void Test_PATCH_API_request() {
        JSONObject parameters = new JSONObject();
        parameters.put("name","Akshay");
        parameters.put("job","leader");
        given().body(parameters.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200);

    }

    @Then("^Test API patch request with conditions$")
    public void Test_PATCH_API_request_with_conditions(){
        JSONObject parameters = new JSONObject();
        parameters.put("name","Akshay");
        parameters.put("job","leader");
        given().body(parameters.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200);

    }


    @Given("^Test API delete request$")
    public void Test_DELETE_API_request() {
        given().delete("https://reqres.in/api/users/2").then().statusCode(204);

    }

    @Then("^Test API delete request with conditions$")
    public void Test_DELETE_API_request_with_conditions(){
        given().delete("https://reqres.in/api/users/2").then().statusCode(204);

    }

}
