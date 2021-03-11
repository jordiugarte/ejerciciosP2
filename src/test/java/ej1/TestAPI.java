package ej1;

import configuration.Config;
import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilsJson.JsonHelper;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class TestAPI {
    Response response;
    RequestInformation request = new RequestInformation();
    Map<String, String> data = new HashMap<>();

    @Given("i have access to the Todo.ly")
    public void iHaveAccessToTheTodoLy() {
    }

    @When("i send GET request to url {}")
    public void iSendGETRequestToUrlHttpTodoLyApiAuthenticationJson(String url) {
        request.setAuthType(Config.AUTH_BASIC);
        request.setAuthValue(Config.AUTH_BASIC_VALUE);
        request.setUrl(replaceAllData(url));
        response = FactoryRequest.make("GET").send(request);
    }

    @And("i get the property {} and save it in {}")
    public void iGetPropertyTokenAndSaveItInTokenValue(String property, String varName) {
        data.put(varName, response.then().extract().path(property) + "");
    }

    @When("i send {} request to url {} with")
    public void iSendPOSTRequestToUrlHttpTodoLyApiProjectsJsonWith(String requestMethod, String url, String body) {
        request.setAuthType(Config.TOKEN);
        request.setAuthValue(replaceAllData("TokenValue"));
        request.setUrl(replaceAllData(url));
        request.setBody(replaceAllData(body));
        response = FactoryRequest.make(requestMethod).send(request);
    }

    @Then("i expect the status code {}")
    public void iExpectTheStatusCode(int expectedStatus) {
        response.then().statusCode(expectedStatus);
    }

    @And("i expect the response body")
    public void iExpectTheResponseBody(String expectedBody) {
        Assert.assertTrue("Mal", JsonHelper.areEqualJson(replaceAllData(expectedBody), response.getBody().asString()));
    }

    private String replaceAllData(String value) {
        for (String key : data.keySet()) {
            value = value.replace(key, data.get(key));
        }
        return value;
    }
}