package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static utils.APIutils.sendGetRequest;

public class ProjectSteps extends BaseSteps {

	@When("I send a get request to projects endpoint")
	public void iSendAGetRequestToProjectsEndpoint() {
		response = sendGetRequest(request, recentProjectEndpoint);
	}

	@Then("Response should contain the last projects")
	public void responseShouldContainTheLastProjects() {
		response.prettyPrint();
	}

}
