package stepDefinition;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.AutoCloseableBDDSoftAssertions;
import utils.APIutils;
import utils.ConfigManager;
import utils.TestDataWriter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BaseSteps {

	protected static TestDataWriter dataWriter = new TestDataWriter();

	protected static Response response;

	protected static RequestSpecification request;

	protected AutoCloseableBDDSoftAssertions soft = new AutoCloseableBDDSoftAssertions();

	protected ObjectMapper mapper = new ObjectMapper();

	protected String deleteIssue;
	protected String allUsersEndpoint;

	protected String issueEndpoint;

	protected String userEndpoint;

	protected String findUsersEndpoint;

	protected String recentProjectEndpoint;

	protected String projectEndpoint;

	protected String deleteIssueAttachmentEndpoint;
	protected static String attachmentId;

	protected String jiraUserName = System.getenv("jiraUserName");

	protected String jiraToken = System.getenv("jiraToken");

	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");
		allUsersEndpoint = ConfigManager.getProperty("api.all.users.endpoint");
		issueEndpoint = ConfigManager.getProperty("api.issue.endpoint");
		userEndpoint = ConfigManager.getProperty("api.user.endpoint");
		findUsersEndpoint = ConfigManager.getProperty("api.find.users.endpoint");
		recentProjectEndpoint = ConfigManager.getProperty("api.recent.project.endpoint");
		projectEndpoint = ConfigManager.getProperty("api.project.endpoint");
		deleteIssueAttachmentEndpoint = ConfigManager.getProperty("api.delete.issue.attachment.endpoint");

		jiraUserName = System.getenv("jiraUserName");
		jiraToken = System.getenv("jiraToken");
		deleteIssue= ConfigManager.getProperty("api.delete.issue.endpoint");

	}
}
