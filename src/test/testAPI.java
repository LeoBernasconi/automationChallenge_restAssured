package test;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.main.java.Endpoints;

public class testAPI {
	static String base_url = "https://swapi.dev/api/";
	Endpoints endpoints = new Endpoints();

	
	@Test
	public  void testMain() throws IOException {
		int[] articleIds = new int[] {75885876, 76578325, 76250498, 75918495};
		ArrayList<String> UserNamesWithArticlesWithNoComments = new ArrayList<>();
		//Call the each endpoint in the array
		for (int i = 0; i < articleIds.length; i++) {
			Boolean haveComments = endpoints.doesTheArticleHaveComments(articleIds[i]);
			if (haveComments = false) {
				int userId = endpoints.getArticleInformationById(articleIds[i]);
				String UsernName = endpoints.getUserNameByUserId(userId);
				UserNamesWithArticlesWithNoComments.add(UsernName + "(id: " + articleIds[i] + ").");
			}
		}	
		//Prepare data for reporting
		int amount_userNames = UserNamesWithArticlesWithNoComments.size();
		if (amount_userNames > 0) {
			System.out.println("List of user names with articles (with no comments)");
			for (String item : UserNamesWithArticlesWithNoComments) {
			       System.out.println(item);
			   }
			Assert.fail("Test fail: " + amount_userNames + " users have articles with no comments.");
			}
		}
  
}
