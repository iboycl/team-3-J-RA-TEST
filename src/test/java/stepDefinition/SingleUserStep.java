package stepDefinition;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.response.SingleUser;


import java.io.File;

import static io.restassured.RestAssured.given;

public class SingleUserStep extends BaseSteps {

	private static final Logger LOGGER = LogManager.getLogger(SingleUserStep.class);

	ObjectMapper mapper = new ObjectMapper();

	@When("I send a Get request user endpoint")
	public void ıSendAGetRequestUserEndpoint() {

		response = given().contentType("application/json")
			.auth()
			.preemptive()
			.basic(jiraUserName, jiraToken)
			.get(userEndpoint + "?accountId=63d64f5528cddcc7076fbafd");
		LOGGER.info("I send a Get request user endpoint");


	}

	@Then("User informations are must be true")
	public void userInformationsAreMustBeTrue() throws Exception {
		SingleUser actualProduct = response.as(SingleUser.class);

		File file = new File("src/test/resources/testData/get_a_user.json");

		SingleUser expectedProduct = mapper.readValue(file, new TypeReference<>() {
		});

		Assertions.assertThat(actualProduct.getAccountId()).isEqualTo(expectedProduct.getAccountId());
		Assertions.assertThat(actualProduct.getSelf()).isEqualTo(expectedProduct.getSelf());
		Assertions.assertThat(actualProduct.getAccountType()).isEqualTo(expectedProduct.getAccountType());
		Assertions.assertThat(actualProduct.getAvatarUrls().getA1616())
			.isEqualTo(expectedProduct.getAvatarUrls().getA1616());
		Assertions.assertThat(actualProduct.getAvatarUrls().getA2424())
			.isEqualTo(expectedProduct.getAvatarUrls().getA2424());
		Assertions.assertThat(actualProduct.getAvatarUrls().getA3232())
			.isEqualTo(expectedProduct.getAvatarUrls().getA3232());
		Assertions.assertThat(actualProduct.getAvatarUrls().getA4848())
			.isEqualTo(expectedProduct.getAvatarUrls().getA4848());
		Assertions.assertThat(actualProduct.getDisplayName()).isEqualTo(expectedProduct.getDisplayName());
		Assertions.assertThat(actualProduct.isActive()).isEqualTo(expectedProduct.isActive());
		Assertions.assertThat(actualProduct.getTimeZone()).isEqualTo(expectedProduct.getTimeZone());
		Assertions.assertThat(actualProduct.getLocale()).isEqualTo(expectedProduct.getLocale());
		Assertions.assertThat(actualProduct.getGroups().getSize()).isEqualTo(expectedProduct.getGroups().getSize());
		Assertions.assertThat(actualProduct.getGroups().getItems().length)
			.isEqualTo(expectedProduct.getGroups().getItems().length);
		Assertions.assertThat(actualProduct.getApplicationRoles().getItems().length)
			.isEqualTo(expectedProduct.getApplicationRoles().getItems().length);
		Assertions.assertThat(actualProduct.getApplicationRoles().getSize())
			.isEqualTo(expectedProduct.getApplicationRoles().getSize());
		Assertions.assertThat(actualProduct.getExpand()).isEqualTo(expectedProduct.getExpand());

		LOGGER.info("User informations are must be true");
	}

	@When("I send a Get request with wrong accountId")
	public void ıSendAGetRequestWithWrongAccountId() {

		response = given().contentType("application/json")
			.auth()
			.preemptive()
			.basic(jiraUserName, jiraToken)
			.get(userEndpoint + "?accountId=63d64f5528cddcc7076fba");
		LOGGER.info("I send a Get request user endpoint");
	}

	@Then("Error message must be  {string}")
	public void errorMessageMustBe(String errorMessage) {
		Assertions.assertThat(errorMessage).isEqualTo(response.jsonPath().getString("errorMessages"));
	}

}
