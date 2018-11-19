package stripe;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import standardClasses.CheckFinalTestResults;
import standardClasses.GlobalVariables;

public class TestCases {
	public static String apiKey = "Fail";
	public static String apiVersion = "Fail";

	//@Test
	public void test_validCountry() {
		StripeUtils stripe = new StripeUtils(Locale.US);
		// This will always pass.
	}

	//@Test
	public void test() {
		StripeUtils stripe = new StripeUtils(Locale.GERMANY);
		// This will always fail: ERROR: Stripe is used only for US. Country entered:
		// de_DE
	}

	//@Test
	public void test_printCollectionOfChargesParameters() {
		String expectedObjectType = "list";
		String expectedUrl = "/v1/charges";
		Integer numberOfChargesReturned = 2;
		StripeUtils stripe = new StripeUtils(Locale.US);
		CollectionOfCharges charges = stripe.getListOfCharges(numberOfChargesReturned);

		String actualObjectType = charges.getObjectType();
		CheckFinalTestResults.checkMatchingValues("Verify that the Returned Collection Object types match",
				actualObjectType, expectedObjectType);
		assertEquals(actualObjectType, expectedObjectType);

		String actualUrl = charges.getUrl();
		CheckFinalTestResults.checkMatchingValues("Verify that the Returned Collection URLs match", actualUrl,
				expectedUrl);
		assertEquals(actualUrl, expectedUrl);
	}
	
	@Test
	public void basicTest() throws ClientProtocolException, IOException, URISyntaxException {
		
		StripeUtils stripe = new StripeUtils(Locale.US);
		
		stripe.simpleHTTPRequestCheck();
		
	}
}