package src.main.java;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Endpoints {
	
	//static String base_url = "https://swapi.dev/api/";
	static String base_url = "https://api.stackexchange.com/2.3/";
	
	//Endpoint 1: Get Comments by article Id
    public static Boolean doesTheArticleHaveComments(int articleId) throws IOException {
    	//Define the endpoint config
		URL url = new URL(base_url + "articles/" + articleId + "/comments?order=desc&sort=creation&site=stackoverflow");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		//Call the endpoint
		Response response = given().get(url).then().extract().response();
		int items = response.path("items.size()");
		if (items>0) {
			//The article has items
			return true;
		}else {
			//The article has no item
			return false;
		}
    }
    
	//Endpoint 2: Get user name by user id
    public static String getUserNameByUserId(int userId) throws IOException {
    	//Define the endpoint config
		URL url = new URL(base_url + "users/" + userId + "?order=desc&sort=creation&site=stackoverflow");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		//Call the endpoint and get the user name
		Response response = given().get(url).then().extract().response();
		String userName = response.path("items.get(0).display_name");
		return userName;
    }
    
	//Endpoint 3: Get Article information by article id
    public static int getArticleInformationById(int articleId) throws IOException {
    	//Define the endpoint config
		URL url = new URL(base_url + "articles/" + articleId + "?order=desc&sort=creation&site=stackoverflow");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		//Call the endpoint
		Response response = given().get(url).then().extract().response();
		int userId = response.path("items.get(0).owner.user_id");
		return userId;
    }

}
