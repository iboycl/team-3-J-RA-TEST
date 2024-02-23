package stepDefinition.ıssues;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepDefinition.BaseSteps;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class GetIssueSteps extends BaseSteps {
    private static final Logger LOGGER = LogManager.getLogger(GetIssueSteps.class);


    @When("I send a GET request to issue endpoint")
    public void ıSendAGETRequestToIssueEndpoint() {
        response = given().contentType("application/json")
                .auth()
                .preemptive()
                .basic(jiraUserName, jiraToken)
                .get(issueEndpoint + "/SCRUM-180");
        LOGGER.info("I send a get request issue endpoint");


    }

    @Then("Response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        then(response.getStatusCode()).isEqualTo(statusCode);
        LOGGER.debug("Response status code is validated");

    }
    @And("The response contain id number as {string}")
    public void theResponseContainIdNumberAs(String idNumber) {
        Assertions.assertThat(idNumber).isEqualTo(response.jsonPath().getString("id"));
    }


    @When("The user sends get request with invalid key as {string}")
    public void theUserSendsGetRequestWithInvalidKeyAs(String key) {
        key = "/SCRUM-190";
        response = given().contentType("application/json")
                .auth()
                .preemptive()
                .basic(jiraUserName, jiraToken)
                .get(issueEndpoint + key);
        LOGGER.info("I send get request with invalid key");
    }

    @And("Error message must be {string}")
    public void errorMessageMustBe(String errorMessage) {
        Assertions.assertThat(errorMessage).isEqualTo(response.jsonPath().getString("errorMessages"));
    }



}
