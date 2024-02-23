package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepDefinition.BaseSteps;
import utils.APIutils;

public class deleteAttachmentSteps extends BaseSteps{

    Logger logger = LogManager.getLogger(deleteAttachmentSteps.class);
    @When("The user sends DELETE request to delete attachment endpoint with attachment id")
    public void theUserSendsDELETERequestToDeleteAttachmentEndpointWithAttachmentId() {
        String endpoint = deleteIssueAttachmentEndpoint + "/" + attachmentId.substring(1, attachmentId.length() - 1);
        response = APIutils.sendDeleteRequest(request, endpoint);

        logger.info("The user sends DELETE request to delete attachment endpoint with attachment id");
    }

    @And("Validate that the specified attachment deleted")
    public void validateThatTheSpecifiedAttachmentDeleted() {
        Assertions.assertThat(response.jsonPath().getList("fields.attachment")).isEmpty();

        logger.debug("Validate that the specified attachment deleted");
    }
}
