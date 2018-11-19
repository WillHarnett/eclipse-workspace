package stripe;

import standardClasses.LoadProperties;
import standardClasses.GlobalVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import junit.framework.Assert;

public class StripeUtils {

	private static String getAPIVersion() {
		return TestCases.apiVersion = LoadProperties.stripeApiProperties.get("stripe.api.version").toString();
	}

	private static String getAPIKey() {
		return TestCases.apiKey = LoadProperties.stripeApiProperties.get("stripe.api.key").toString();
	}

	private static void getAPIKey(Locale country) {
		getAPIVersion();
		if (country.equals(Locale.US)) {
			getAPIKey();
		} else {
			TestCases.apiKey = "Fail";
		}
	}

	public StripeUtils(Locale country) {
		getAPIKey(country);
	}

	private static StripeUtils setAPIKey(Locale country) {
		return new StripeUtils(country);
	}

	public CollectionOfCharges getListOfCharges(Integer limit) {
		CollectionOfCharges chargesRetrieved = new CollectionOfCharges();
		Gson gson = new Gson();
		URIBuilder uriBuilder = new URIBuilder();
		uriBuilder.setScheme("https").setHost("api.stripe.com").setPath("/v1/charges").setParameter("limit",
				limit.toString());
		try {
			URI uri = uriBuilder.build();
			HttpGet httpGet = new HttpGet(uri);
			BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(TestCases.apiKey, ""));
			CloseableHttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider)
					.build();
			HttpResponse response = client.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				String errorMessage = "ERROR: Attempting to Capture Charge: " + statusCode + "\n" + "Reason: "
						+ response.getStatusLine().getReasonPhrase();
				// throw new TestException (errorMessage);
				System.out.println(errorMessage);
			} else {
				System.out.println(statusCode);
			}
			String json = EntityUtils.toString(response.getEntity());
			chargesRetrieved = gson.fromJson(json, CollectionOfCharges.class);
			client.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chargesRetrieved;
	}

	/*
	 * curl https://api.stripe.com/v1/charges \ -u sk_test_4eC39HqLyjWDarjtT1zdp7dc:
	 * \ -d amount=2000 \ -d currency=usd \ -d source=tok_visa \ -d
	 * metadata[order_id]=6735
	 * 
	 * public void client() throws URISyntaxException, IOException {
	 * 
	 * CloseableHttpClient httpclient = HttpClients.createDefault();
	 */
	public void test() {

		CollectionOfCharges chargesRetrieved = new CollectionOfCharges();
		Gson gson = new Gson();
		
		String port = ":443";

		try {
			URI uri = new URIBuilder().setScheme("https").setHost("https://od-api-demo.oxforddictionaries.com" + port).setPath("/api/v1/entries/")
					.setParameter("source_lang", "en").setParameter("word_id", "ace").build();

			HttpGet httpGet = new HttpGet(uri);
			BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(TestCases.apiKey, ""));
			CloseableHttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider)
					.build();
			HttpResponse response = client.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				String errorMessage = "ERROR: Attempting to Capture Charge: " + statusCode + "\n" + "Reason: "
						+ response.getStatusLine().getReasonPhrase();
				// throw new TestException (errorMessage);
				System.out.println(errorMessage);
			} else {
				System.out.println(statusCode);
			}
			String json = EntityUtils.toString(response.getEntity());
			chargesRetrieved = gson.fromJson(json, CollectionOfCharges.class);
			client.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void simpleHTTPRequestCheck() throws ClientProtocolException, IOException, URISyntaxException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://targethost/homepage");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager. 
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    EntityUtils.consume(entity1);
		} finally {
		    response1.close();
		}
	}
}
