package stepDefinition.ıssueComments;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinition.BaseSteps;

public class DeleteComment_StepDefs extends BaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(DeleteComment_StepDefs.class);


    @When("the user sends  DELETE request to Delete Comments endpoint with specific key as {string} and specific id as {string}")
    public void theUserSendsDELETERequestToDeleteCommentsEndpointWithSpecificKeyAsAndSpecificIdAs(String key, String id) {
        String endPoint = issueEndpoint + "/" + key + "/comment/" + id;
        response = request.when().delete(endPoint);

        LOGGER.debug("DELETE response sent to {}", endPoint);
    }

}
