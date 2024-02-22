package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import pojo.response.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
import static utils.APIutils.*;

public class UserSteps extends BaseSteps{
    @When("I send a GET request to users endpoint")
    public void iSendAGETRequestToUsersEndpoint() {
        response = request.get(allUsersEndpoint);
    }

    @Then("I get all users")
    public void iGetAllUsers() {

        List<User> users = response.as(new TypeRef<>(){});

        then(users.get(0).getAccountId()).isEqualTo("63d64f5528cddcc7076fbafd");

    }

    @When("I send a GET request to users endpoint with {string} and {string}")
    public void iSendAGETRequestToUsersEndpointWithAnd(String startAt, String maxResults) {
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("startAt", startAt);
        queryParams.put("maxResults", maxResults);

        response = sendGetRequest(request, allUsersEndpoint, queryParams);
    }

    @And("The response should contain {int} users")
    public void theResponseShouldContainUsers(int number) {
        List<User> users = response.as(new TypeRef<>() {});
        then(users.size()).isEqualTo(number);
    }
}
