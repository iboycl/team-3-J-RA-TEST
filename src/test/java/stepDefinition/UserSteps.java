package stepDefinition;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.response.User;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;
import static utils.APIutils.*;

public class UserSteps extends BaseSteps {

    private static final Logger LOGGER = LogManager.getLogger(UserSteps.class);

    ObjectMapper mapper = new ObjectMapper();

import io.restassured.http.ContentType;
import pojo.response.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
import static utils.APIutils.*;


    @When("I send a GET request to users endpoint")
    public void iSendAGETRequestToUsersEndpoint() {
        response = request.get(allUsersEndpoint);


        response = given().contentType("application/json").auth().preemptive().basic(jiraUserName, jiraToken).get(allUsersEndpoint);

        LOGGER.info("I send a GET request to users endpoint");
    }


    @Then("All user informations are true")
    public void allUserInformationsAreTrue() throws Exception {
        List<User> actualUserList = mapper.readValue(response.asString(), new TypeReference<>() {
        });

        File file = new File("src/test/resources/testData/get_all_users.json");

        List<User> expectedUserList = mapper.readValue(file, new TypeReference<>() {
        });


        actualUserList.forEach(
                item -> {
                    Assertions.assertThat(item.getAccountId()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getAccountId());
                    Assertions.assertThat(item.getAccountType()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getAccountType());
                    Assertions.assertThat(item.getAccountType()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getAccountType());
                    Assertions.assertThat(item.isActive()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).isActive());
                    Assertions.assertThat(item.getDisplayName()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getDisplayName());
                    Assertions.assertThat(item.getKey()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getKey());
                    Assertions.assertThat(item.getName()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getName());
                    Assertions.assertThat(item.getSelf()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getSelf());
                    Assertions.assertThat(item.getAvatarUrls().getA1616()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getAvatarUrls().getA1616());
                    Assertions.assertThat(item.getAvatarUrls().getA2424()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getAvatarUrls().getA2424());
                    Assertions.assertThat(item.getAvatarUrls().getA3232()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getAvatarUrls().getA3232());
                    Assertions.assertThat(item.getAvatarUrls().getA4848()).isEqualTo(expectedUserList.get(actualUserList.indexOf(item)).getAvatarUrls().getA4848());


                }
        );
        LOGGER.info("All user informations are true");

    }

    @When("I send a GET request to users endpoint with {string} and {string}")
    public void iSendAGETRequestToUsersEndpointWithAnd(String startAt, String maxResults) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("startAt", startAt);
        queryParams.put("maxResults", maxResults);

        response = sendGetRequest(request, allUsersEndpoint, queryParams);
        LOGGER.info("I send a GET request to users endpoint with {string} and {string}");
    }

    @And("The response should contain {int} users")
    public void theResponseShouldContainUsers(int number) {
        List<User> users = response.as(new TypeRef<>() {
        });
        then(users.size()).isEqualTo(number);
        LOGGER.info("The response should contain {int} users");

    }

    @When("I send a Get request to users with wrong endpoint")
    public void ıSendAGetRequestToUsersWithWrongEndpoint() {
        response = request.get(allUsersEndpoint);

        response = given().contentType("application/json").auth().preemptive().basic(jiraUserName, jiraToken).get("/rest/api/3/user/search");

        LOGGER.info("I send a Get request to users with wrong endpoint");

    }


    @Then("Error message should be  {string}")
    public void errorMessageShouldBe(String message) {
        Assertions.assertThat(message.equals(response.jsonPath().getString("message")));

    @When("I send a GET request to users endpoint with {string} and {string}")
    public void iSendAGETRequestToUsersEndpointWithAnd(String startAt, String maxResults) {
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("startAt", startAt);
        queryParams.put("maxResults", maxResults);

        response = sendGetRequest(request, allUsersEndpoint, queryParams);
    }

    @And("The response should contain {int} users")
    public void theResponseShouldContainUsers(int number) {
        List<User> users = response.as(new TypeRef<>() {});
        then(users.size()).isEqualTo(number);

    }
}

