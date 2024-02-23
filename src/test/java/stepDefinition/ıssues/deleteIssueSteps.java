package stepDefinition.ıssues;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepDefinition.BaseSteps;
import utils.APIutils;

public class deleteIssueSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(deleteIssueSteps.class);

	@When("The user sends DELETE request to the delete issue endpoint with issue id as {string}")
	public void theUserSendsDELETERequestToTheDeleteIssueEndpoint(String id) {
		String endpoint = deleteIssue + "/" + id;
		response = APIutils.sendDeleteRequest(request, endpoint);

		logger.info("The user sends DELETE request to the delete issue endpoint");
	}

}
