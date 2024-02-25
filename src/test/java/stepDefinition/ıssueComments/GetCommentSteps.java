package stepDefinition.ıssueComments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepDefinition.BaseSteps;
import utils.APIutils;

public class GetCommentSteps extends BaseSteps {

	Logger LOGGER = LoggerFactory.getLogger(GetCommentSteps.class);

	String getCommentIssues;

	@When("The user sends get request to the Get Comment endpoint with specific key as {string} and specific id as {string}")
	public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndSpecificIdAs(String key, String id) {
		getCommentIssues = issueEndpoint + "/" + key + "/comment/" + id;
		response = request.get(getCommentIssues);
		LOGGER.info("Sending GET request to Get Comment endpoint with specific key {} and specific id {}", key, id);
	}

	@And("The Time should be under {int} ms on the response")
	public void theTimeShouldBeUnderMsOnTheResponse(int time) {
		Assertions.assertThat(response.getTime()).isLessThan(time);
		LOGGER.info("Checking if response time is under {} ms", time);
	}

	@And("The response text should be {string}")
	public void theResponseTextShouldBe(String text) {
		Assertions.assertThat(response.asPrettyString()).contains(text);
		LOGGER.info("Checking if response text contains {}", text);
	}

	@And("The id should not be null and empty on the response")
	public void theIdShouldNotBeNullAndEmptyOnTheResponse() {
		String id = response.jsonPath().getString("id");
		Assertions.assertThat(id).isNotNull();
		Assertions.assertThat(id).isNotEmpty();
		LOGGER.info("Checking if id is not null and empty on the response");
	}

	@When("The user sends get request to the Get Comment endpoint with specific key as {string} and invalid id as {string}")
	public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndInvalidIdAs(String key, String id) {
		getCommentIssues = issueEndpoint + key + "/comment/" + id;
		response = APIutils.sendGetRequest(request, getCommentIssues);
		LOGGER.info("Sending GET request to Get Comment endpoint with specific key {} and invalid id {}", key, id);
	}

	@And("The user should receive an error message as {string}")
	public void theUserShouldReceiveAnErrorMessage(String errorMessage) {
		String actualErrorMessage = response.asPrettyString();
		Assertions.assertThat(actualErrorMessage).contains(errorMessage);
		LOGGER.info("Checking if user receives an error message: {}", errorMessage);
	}

}
