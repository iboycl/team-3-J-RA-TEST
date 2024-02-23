package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import utils.APIutils;

public class GetCommentSteps extends BaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(GetCommentSteps.class);
    String getCommentIssues;

    @When("The user sends get request to the Get Comment endpoint with specific key as {string} and specific id as {string}")
    public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndSpecificIdAs(String key, String id) {
        getCommentIssues = issueEndpoint + "/" + key + "/comment/" + id;
        System.out.println(getCommentIssues);
        //response = APIutils.sendGetRequest(request,getCommentIssues);
        response = request.get(getCommentIssues);
        LOGGER.debug("The user sends get request to the Get Comment endpoint with specific key as and specific id as");
    }

    @And("The Time should be under {int} ms on the response")
    public void theTimeShouldBeUnderMsOnTheResponse(int time) {
        Assertions.assertThat(response.getTime()).isLessThan(time);
        LOGGER.info("The Time should be under defined ms on the response");
    }

    @And("The response text should be {string}")
    public void theResponseTextShouldBe(String text) {
        Assertions.assertThat(response.jsonPath().getString("body.content[0].content[0].text")).isEqualTo(text);
        LOGGER.info("The response text should be as expected");
    }

    @And("The id should not be null and empty on the response")
    public void theIdShouldNotBeNullAndEmptyOnTheResponse() {
        String id = response.jsonPath().getString("id");
        Assertions.assertThat(id).isNotNull();
        Assertions.assertThat(id).isNotEmpty();
        LOGGER.info("The id should not be null and empty on the response");
    }

    @When("The user sends get request to the Get Comment endpoint with specific key as {string} and invalid id as {string}")
    public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndInvalidIdAs(String key, String id) {
        getCommentIssues = issueEndpoint + key + "/comment/" + id;
        response = APIutils.sendGetRequest(request, getCommentIssues);
        LOGGER.debug("The user sends get request to the Get Comment endpoint with specific key and invalid id");
    }

    @And("The user should receive an error message as {string}")
    public void theUserShouldReceiveAnErrorMessage(String errorMessage) {
        String actualErrorMessage = response.asPrettyString();
        Assertions.assertThat(actualErrorMessage).contains(errorMessage);
        LOGGER.info("The user should receive an error message");
    }
}
