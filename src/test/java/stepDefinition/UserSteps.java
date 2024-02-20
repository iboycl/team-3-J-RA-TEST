package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import pojo.response.User;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class UserSteps extends BaseSteps{
    @When("I send a GET request to users endpoint")
    public void iSendAGETRequestToUsersEndpoint() {

        response = given().contentType("application/json").auth().preemptive().basic(jiraUserName, jiraToken).get(allUsersEndpoint);
    }

    @Then("I get all users")
    public void iGetAllUsers() {

        List<User> users = response.as(new TypeRef<>(){});

        then(users.get(0).getAccountId()).isEqualTo("63d64f5528cddcc7076fbafd");

    }
}
