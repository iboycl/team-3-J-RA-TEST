package stepDefinition.userSearch;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.response.User;
import stepDefinition.BaseSteps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;
import static utils.APIutils.sendGetRequest;

public class UserSearchSteps extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(UserSearchSteps.class);

	@When("I send a GET request to user search endpoint with {string}")
	public void iSendAGETRequestToUserSearchEndpointWith(String param) {
		Map<String, String> queryParams = new HashMap<>();

		if (!param.isBlank()) {
			queryParams.put("query", param);
			response = sendGetRequest(request, findUsersEndpoint, queryParams);
			LOGGER.debug("Get request sent to {} with Query: {}", findUsersEndpoint, param);
		}
		else {
			response = sendGetRequest(request, findUsersEndpoint);
			LOGGER.debug("Get request sent to {} without query", findUsersEndpoint);
		}

	}

	@And("The response should contain the {string}")
	public void theResponseShouldContainThe(String message) {
		then(response.asPrettyString().contains(message)).isTrue();
		LOGGER.debug("Response body contains {}", message);
	}

	@And("The response should show right user with {string} {string} {string}")
	public void theResponseShouldShowRightUserWith(String displayName, String locale, String message) {
		if (message.isBlank()) {
			List<User> actualUsers = response.as(new TypeRef<>() {
			});
			soft.then(actualUsers.get(0).getDisplayName()).isEqualTo(displayName);
			soft.then(actualUsers.get(0).getLocale()).isEqualTo(locale);
			LOGGER.debug("Response gives the right user with displayName: {} and locale: {}", displayName,
					locale);
		}
		else {
			then(response.asPrettyString().contains(message)).isTrue();
			LOGGER.debug("Response contains the error message: {}", message);
		}

	}

	@When("I send a GET request to user search endpoint without authorization")
	public void iSendAGETRequestToUserSearchEndpointWithoutAuthorization() {
		response = given().contentType(ContentType.JSON).get(findUsersEndpoint + "?query=ibo");

	}

}
