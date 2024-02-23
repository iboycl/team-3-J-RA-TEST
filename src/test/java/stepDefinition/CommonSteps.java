package stepDefinition;

import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.assertj.core.api.Assertions;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class CommonSteps extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class);
	Logger logger = LogManager.getLogger(CommonSteps.class);
	@Given("The user has Authentication and ready to connect")
	public void theUserHasAuthenticationAndReadyToConnect() {
		if (jiraUserName == null || jiraToken == null) {
			jiraUserName = System.getenv("jiraUserName");
			jiraToken = System.getenv("jiraToken");
		}
		request = given().auth().preemptive().basic(jiraUserName, jiraToken)
				.contentType(ContentType.JSON);

	}
	@And("The authentication is completed to reach jira apis")
	public void theAuthenticationIsCompletedToReachJiraApis() {
		String username = System.getenv("jiraUserName");
		String token = System.getenv("jiraToken");

		request = request.auth().preemptive().basic(username, token);

		logger.info("The authentication is completed to reach jira apis");
	}

	@Then("The status code should be {int}")
	public void theStatusCodeShouldBe(int statusCode) {
		Assertions.assertThat(response.getStatusCode()).isEqualTo(statusCode);
		logger.debug("The status code should be " + statusCode);
	}

	@Then("The response status code should be {int}")
	public void theResponseStatusCodeShouldBe(int statusCode) {
		then(response.getStatusCode()).isEqualTo(statusCode);
		LOGGER.debug("Response status code is validated");
	}

}
