package stepDefinition;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;


public class EditIssueSteps extends BaseSteps {
    String requestBody="{\n" +
            "    \"fields\": {},\n" +
            "    \"update\": {\n" +
            "        \"labels\": [\n" +
            "            {\n" +
            "                \"add\": \"PUT\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"remove\": \"POST\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"remove\": \"CREATE-ISSUE\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"summary\": [\n" +
            "            {\n" +
            "                \"set\": \"TEST - isimsiz2a\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "}";
    private static final Logger LOGGER = LogManager.getLogger(GetIssueSteps.class);

    @When("I send a PUT request to edit issue endpoint")
    public void ıSendAPUTRequestToEditIssueEndpoint() {
        response = given().contentType("application/json")
                .auth()
                .preemptive()
                .basic(jiraToken, jiraUserName)
                .put(issueEndpoint + "/SCRUM-180");
        LOGGER.info("I send a PUT request to issue endpoint");
    }

    @When("I send a PUT request to rename with new body but different key")
    public void ıSendAPUTRequestToRenameWithNewBodyButDifferentKey() {
        response=given().contentType("application/json")
                .auth()
                .preemptive()
                .basic(jiraToken,jiraUserName)
                .body(requestBody)
                .put(issueEndpoint+"/SCRUM-200");
        LOGGER.info("I send a Put request with new request body");
    }
}
