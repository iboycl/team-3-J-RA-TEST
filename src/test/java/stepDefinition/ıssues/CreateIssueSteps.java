package stepDefinition.ıssues;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.request.Issue;
import stepDefinition.BaseSteps;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;
import static utils.APIutils.sendPostRequest;

public class CreateIssueSteps extends BaseSteps {

	Logger LOGGER = LogManager.getLogger(CreateIssueSteps.class);

	Issue issue = new Issue();

	String requestBody;

	@When("I set the request body for creating a new issue")
	public void iSetTheRequestBodyForCreatingANewIssue(DataTable data) {
		Map<String, String> issueData = data.asMap();

		issue.getFields().getProject().setKey(issueData.get("projectKey"));
		issue.getFields().setSummary(issueData.get("summary"));
		issue.getFields().setLabels(List.of(issueData.get("labels").split(";")));
		issue.getFields().getDescription().setType(issueData.get("descriptionType"));
		issue.getFields().getDescription().setVersion(Integer.parseInt(issueData.get("descriptionVersion")));
		issue.getFields().getDescription().getContent().get(0).setType(issueData.get("contentType"));
		issue.getFields()
				.getDescription()
				.getContent()
				.get(0)
				.getContent()
				.get(0)
				.setType(issueData.get("contContentType"));
		issue.getFields()
				.getDescription()
				.getContent()
				.get(0)
				.getContent()
				.get(0)
				.setText(issueData.get("contContentText"));
		issue.getFields().getIssuetype().setName(issueData.get("issueTypeName"));

		requestBody = gson.toJson(issue);
		LOGGER.debug("Request body created");
	}

	@And("I send a POST request to create a new issue")
	public void iSendAPOSTRequestToCreateANewIssue() {
		response = sendPostRequest(request, issueEndpoint, requestBody);
		LOGGER.debug("Request sent to {}", issueEndpoint);
	}

	@And("The response should contain right {string}")
	public void theResponseShouldContainRight(String message) {
		if (message.equalsIgnoreCase("valid")) {
			soft.then(Optional.ofNullable(response.jsonPath().get("id"))).isNotEmpty().isNotNull();
			soft.then(Optional.ofNullable(response.jsonPath().get("key"))).isNotEmpty().isNotNull();
			soft.then(Optional.ofNullable(response.jsonPath().get("self"))).isNotEmpty().isNotNull();
		}
		else {
			then(response.asPrettyString().contains(message)).isTrue();
		}
		LOGGER.debug("Response validated");
	}

	@And("I send a POST request to create a new issue without authorization")
	public void iSendAPOSTRequestToCreateANewIssueWithoutAuthorization() {
		response = given().auth()
				.preemptive()
				.basic("jiraUserName", "jiraToken")
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post(issueEndpoint);

		LOGGER.debug("Request sent to {} without authorization", issueEndpoint);
	}

}
