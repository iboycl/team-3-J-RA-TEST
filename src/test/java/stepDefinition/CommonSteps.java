package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;

public class CommonSteps extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class);
	static String jiraUserName;
	static String jiraToken;

	@Then("The response status code should be {int}")
	public void theResponseStatusCodeShouldBe(int statusCode) {
		then(response.getStatusCode()).isEqualTo(statusCode);
		LOGGER.debug("Response status code is validated");
	}

	@Given("The user has Authentication and ready to connect")
	public void theUserHasAuthenticationAndReadyToConnect() {
		if (jiraUserName == null || jiraToken == null) {
			jiraUserName = System.getenv("jiraUserName");
			jiraToken = System.getenv("jiraToken");
		}
		request = given().auth().preemptive().basic(jiraUserName, jiraToken)
				.contentType(ContentType.JSON);

	}
}
