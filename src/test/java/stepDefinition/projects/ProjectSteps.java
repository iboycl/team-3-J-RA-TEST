package stepDefinition;

import com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import pojo.response.RecentProjects.Projects;
import utils.TestDataWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectSteps extends BaseSteps {
    List<Projects> projects;
    List<Projects> expectedProjects;
    @When("The user sends get request to the Get Recent Project endpoint")
    public void theUserSendsGetRequestToTheGetRecentProjectEndpoint() throws IOException {
        response = request.get(recentProjectEndpoint);
        projects = response.as(new TypeRef<>() {
        });
        expectedProjects = mapper.readValue(new File("src/test/resources/testData/projects.json"), new TypeReference<>() {
        });
    }
    @And("The user gets a list of projects")
    public void theUserGetsAListOfProjects() {
        projects = response.as(new TypeRef<>() {
        });
        Assertions.assertThat(!projects.isEmpty());
    }

    @And("The time should be under {int} ms on the response")
    public void theTimeShouldBeUnderMsOnTheResponse(int time) {
        Assertions.assertThat(response.getTime()).isLessThan(time);
    }

    @And("The project name text should be {string} and the other properties as expected")
    public void theProjectNameTextShouldBe(String name) {
        SoftAssertions softAssertions=new SoftAssertions();
        for (int i = 0; i < projects.size(); i++) {
            softAssertions.assertThat(projects.get(i).getKey()).isEqualTo(expectedProjects.get(i).getKey());
            softAssertions.assertThat(projects.get(i).getEntityId()).isEqualTo(expectedProjects.get(i).getEntityId());
            softAssertions.assertThat(projects.get(i).getExpand()).isEqualTo(expectedProjects.get(i).getExpand());
            softAssertions.assertThat(projects.get(i).getId()).isEqualTo(expectedProjects.get(i).getId());
            softAssertions.assertThat(projects.get(i).getName()).isEqualTo(expectedProjects.get(i).getName());
            softAssertions.assertThat(projects.get(i).isIsPrivate()).isEqualTo(expectedProjects.get(i).isIsPrivate());
        }
        softAssertions.assertAll();
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(name);

    }


    @When("The user sends get request to the Get Project endpoint with {string} key")
    public void theUserSendsGetRequestToTheGetProjectEndpointWithKey(String key) throws IOException {
        response = request.get(projectEndpoint+"/"+key);

        TestDataWriter testDataWriter=new TestDataWriter();
        testDataWriter.writeResponseBodyToJsonFile(response.asString(),"project");
        System.out.println(response.asString() );

    }


    @And("The project name text should  be {string}")
    public void theProjectNameTextShouldBe2(String name) {
        Assertions.assertThat(response.jsonPath().getString("name")).isEqualTo(name);
    }

}
