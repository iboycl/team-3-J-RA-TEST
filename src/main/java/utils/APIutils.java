package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pojo.request.Add_Comment.AddComment;

import java.io.File;
import java.util.Map;

public class APIutils {

	public static Response sendGetRequest(RequestSpecification request, String endpoint) {
		return request.log().all().when().accept("application/json").get(endpoint);
	}

	public static Response sendGetRequest(RequestSpecification request, String endpoint,
			Map<String, String> queryParams) {
		return request.queryParams(queryParams).when().get(endpoint);
	}

	public static Response sendGetRequest(RequestSpecification request, String endpoint, String key, String value) {
		return request.queryParam(key, value).when().get(endpoint);
	}

	public static Response sendPostRequest(RequestSpecification request, String endpoint, Object body) {
		return request.contentType(ContentType.JSON).accept(ContentType.JSON).body(body).when().post(endpoint);
	}

	public static Response sendPostRequest(RequestSpecification request, String endpoint, String key, File value) {
		// .multiPart("file", new File(filePath), "image/png")
		return request.header("X-Atlassian-Token", "no-check")
			.contentType(ContentType.MULTIPART)
			.multiPart(key, value)
			.when()
			.log()
			.all()
			.post(endpoint);
	}


	public static Response sendDeleteRequest(RequestSpecification request, String endpoint) {
		return request.when().delete(endpoint);
	}

	public static Response sendPostRequest(RequestSpecification request, String endpoint, String payload) {

		return request.contentType("application/json").body(payload).when().post(endpoint);
	}

	public static JsonObject createCommentRequestBody(Map<String, String> commentDetails) {
		JsonObject commentPayload = new JsonObject();
		JsonObject body = new JsonObject();
		JsonObject content = new JsonObject();
		JsonObject innerContent = new JsonObject();

		innerContent.addProperty("text", commentDetails.get("conContentText"));
		innerContent.addProperty("type", commentDetails.get("conContentType"));

		JsonArray array = new JsonArray();
		array.add(innerContent);
		content.add("content", array);
		content.addProperty("type", commentDetails.get("contentType"));

		array = new JsonArray();
		array.add(content);
		body.add("content", array);
		body.addProperty("type", commentDetails.get("type"));
		body.addProperty("version", Integer.parseInt(commentDetails.get("version")));

		commentPayload.add("body", body);
		return commentPayload;
	}

	public static String getIssueKey() {
		String issueRes = TestDataReader.readData2("issue.json");
		JSONObject issue = new JSONObject(issueRes);
		return issue.getString("key");
	}

	public static String getCommentId() {
		String commentRes = TestDataReader.readData2("comment.json");
		JSONObject commentObject = new JSONObject(commentRes);
		return commentObject.getString("id");
	}

	public static Response sendPutRequest(RequestSpecification request, String url, Object payload){
		return request
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.get(url)
				.then().log().all()
				.extract().response();
	}
}
