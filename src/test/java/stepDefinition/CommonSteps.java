package stepDefinition;

import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.BDDAssertions.then;

public class CommonSteps extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class);

	@Then("The response status code should be {int}")
	public void theResponseStatusCodeShouldBe(int statusCode) {
		then(response.getStatusCode()).isEqualTo(statusCode);
		LOGGER.debug("Response status code is validated");
	}

}
