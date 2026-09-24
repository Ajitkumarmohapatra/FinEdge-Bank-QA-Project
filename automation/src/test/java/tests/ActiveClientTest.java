package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ActiveClientPage;

public class ActiveClientTest {
	private ActiveClientPage activeClientPage;
	
	@Test
	public void getRecentClientNamesTest() {

	    List<String> names =activeClientPage.getRecentClientNames();
	            

	    Assert.assertFalse(
	            names.isEmpty(),
	            "No client names found."
	    );

	    for (String name : names) {
	        System.out.println("Client Name: " + name);
	    }
	}

}
