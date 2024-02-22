package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class APIutils {

	public static Response sendGetRequest(RequestSpecification request, String endpoint) {
		return request
			// .when().log().all()
			.get(endpoint);
	}

	public static Response sendGetRequest(RequestSpecification request, String endpoint,
			Map<String, String> queryParams) {
		return request
			// .when().log().all()
			.queryParams(queryParams)
			.get(endpoint)
		/*
		 * .then().log().all() .extract().response()
		 */;
	}

	public static Response sendPostRequest(RequestSpecification request, String endpoint, String payload) {
		return request.body(payload)/* .log().all() */
			.post(endpoint)
		/* .then().extract().response() */;
	}

}
