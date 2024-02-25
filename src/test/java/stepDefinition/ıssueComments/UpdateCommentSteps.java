package stepDefinition.ıssueComments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.request.UpdateComment;
import stepDefinition.BaseSteps;
import utils.APIutils;
import utils.TestDataReader;

import java.io.IOException;

public class UpdateCommentSteps extends BaseSteps {

	Logger LOGGER = LogManager.getLogger(UpdateCommentSteps.class);

	String updateEndpoint;

	UpdateComment updateComment;

	@When("The user sends PUT request to the Update Comment endpoint with specific issue key {string} and comment id as {string}")
	public void theUserSendsPUTRequestToTheUpdateCommentEndpointWithSpecificIssueKeyAndCommentIdAs(String key,
			String id) throws IOException {
		updateEndpoint = issueEndpoint + "/" + key + "/comment/" + id;
		updateComment = TestDataReader.readData("update_comment.json", UpdateComment.class);
		response = APIutils.sendPutRequest(request, updateEndpoint, updateComment);
		LOGGER
			.debug("The user sends PUT request to the Update Comment endpoint with specific issue key and comment id");
	}

	@And("The content of request should match with the content of the response")
	public void theContentOfRequestShouldMatchWithTheContentOfTheResponse() {
		String actualText = response.jsonPath().getString("body.content[0].content[0].text");
		String expectedText = updateComment.getBody().getContent().get(0).getContent().get(0).getText();
		Assertions.assertThat(expectedText).isEqualTo(actualText);
		LOGGER.info("The content of request should match with the content of the response");
	}

	@When("The user sends PUT request to the Update Comment endpoint with specific issue key {string} and invalid comment id as {string}")
	public void theUserSendsPUTRequestToTheUpdateCommentEndpointWithSpecificIssueKeyAndInvalidCommentIdAs(String key,
			String id) throws IOException {
		updateEndpoint = issueEndpoint + "/" + key + "/comment/" + id;
		updateComment = TestDataReader.readData("update_comment.json", UpdateComment.class);
		response = APIutils.sendPutRequest(request, updateEndpoint, updateComment);
		LOGGER.debug(
				"The user sends PUT request to the Update Comment endpoint with specific issue key and invalid comment id");
	}

	@And("The error message should be displayed")
	public void theErrorMessageShouldBeDisplayed() {
		String errorMessage = response.asPrettyString();
		Assertions.assertThat(errorMessage).contains("error");
		LOGGER.info("The error message should be displayed");
	}

}
