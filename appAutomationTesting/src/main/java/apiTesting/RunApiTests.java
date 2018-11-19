package apiTesting;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.utils.URIBuilder;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import stripe.TestCases;

public class RunApiTests {
			
	Setup setup = new Setup();
	BasicFunctions basicFunctions = new BasicFunctions();
	
	public void runApiTests() throws ClientProtocolException, IOException, URISyntaxException {
		setup.setup();
		
		String givenPath = "/forecast";
		String token = "/bc84fd452444931af92b8a4deca5711b";
		String latitudeAndLongitute = "/" + "42.3601" + "," + "-71.0589";
		
		List<String> allPathParts = new ArrayList<String>();
		allPathParts.add(givenPath);
		allPathParts.add(token);
		allPathParts.add(latitudeAndLongitute);
		
		String scheme = "https";
		String host = "api.darksky.net";
		String path = "";
		
		for(int i = 0; i < allPathParts.size(); i++) {
			path = path + allPathParts.get(i);
		}
		
		URIBuilder builder = new URIBuilder();
		builder.setScheme(scheme).setHost(host).setPath(path);
		URI uri = builder.build();
		
		basicFunctions.get("Mozilla/5.0", uri);
		basicFunctions.post("Mozilla/5.0", "https://selfsolve.apple.com/wcResults.do");
	}
	/*
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestCases.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
	*/
}
