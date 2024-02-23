package stepDefinition.ıssueComments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import stepDefinition.BaseSteps;
import utils.APIutils;

public class GetCommentSteps extends BaseSteps {

	String getCommentIssues;

	@When("The user sends get request to the Get Comment endpoint with specific key as {string} and specific id as {string}")
	public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndSpecificIdAs(String key, String id) {
		getCommentIssues = issueEndpoint + "/" + key + "/comment/" + id;
		System.out.println(getCommentIssues);
		// response = APIutils.sendGetRequest(request,getCommentIssues);
		response = request.get(getCommentIssues);
	}

	@And("The Time should be under {int} ms on the response")
	public void theTimeShouldBeUnderMsOnTheResponse(int time) {
		Assertions.assertThat(response.getTime()).isLessThan(time);
	}

	@And("The response text should be {string}")
	public void theResponseTextShouldBe(String text) {
		Assertions.assertThat(response.jsonPath().getString("body.content[0].content[0].text")).isEqualTo(text);
	}

	@And("The id should not be null and empty on the response")
	public void theIdShouldNotBeNullAndEmptyOnTheResponse() {
		String id = response.jsonPath().getString("id");
		Assertions.assertThat(id).isNotNull();
		Assertions.assertThat(id).isNotEmpty();
	}

	@When("The user sends get request to the Get Comment endpoint with specific key as {string} and invalid id as {string}")
	public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndInvalidIdAs(String key, String id) {
		getCommentIssues = issueEndpoint + key + "/comment/" + id;
		response = APIutils.sendGetRequest(request, getCommentIssues);
	}

	@And("The user should receive an error message as {string}")
	public void theUserShouldReceiveAnErrorMessage(String errorMessage) {
		String actualErrorMessage = response.asPrettyString();
		Assertions.assertThat(actualErrorMessage).contains(errorMessage);
	}

}
