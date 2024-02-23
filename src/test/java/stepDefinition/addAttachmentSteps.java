package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import utils.APIutils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addAttachmentSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(addAttachmentSteps.class);

	@When("The user sends POST request to add attachment endpoint to specified issue id as {string} with png file")
	public void theUserSendsPOSTRequestToAddAttachmentEndpointToSpecifiedIssueWithPngFile(String key)
			throws IOException {
		String endpoint = issueEndpoint + "/" + key + "/attachments";

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/testData/team-3.txt");

		response = APIutils.sendPostRequest(request, endpoint, "file", file);

		attachmentId = response.jsonPath().getString("id");

		logger.info("The user sends POST request to add attachment endpoint to specified issue with txt file");
	}

	@And("The attachment id should not be empty or null")
	public void theAttachmentIdShouldNotBeEmptyOrNull() {
		Assertions.assertThat(attachmentId).isNotEmpty();
		Assertions.assertThat(attachmentId).isNotNull();
		logger.debug("The attachment id should not be empty or null");
	}

	@And("The response creation date must be the same with the date of creation date")
	public void theResponseCreationDateMustBeTheSameWithTheDateOfCreationDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String expectedDate = dateFormat.format(date);
		Assertions.assertThat(response.jsonPath().getString("created").contains(expectedDate)).isTrue();

		logger.debug("The response creation date must be the same with the date of creation date");
	}

	@When("The user sends POST request to add attachment endpoint with invalid {string} key with txt file")
	public void theUserSendsPOSTRequestToAddAttachmentEndpointWithInvalidIdWithTxtFile(String invalidIssueKey) {
		String endpoint = issueEndpoint + "/" + invalidIssueKey + "/attachments";

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/testData/team-3.txt");

		response = APIutils.sendPostRequest(request, endpoint, "file", file);

		logger.info("The user sends POST request to add attachment endpoint with invalid" + invalidIssueKey
				+ "key with txt file");
	}

}
