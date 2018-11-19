package apiTesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import globalVariables.APIVariables;

import java.util.ArrayList;
import java.util.List;

public class BasicFunctions {
	
	//private final String USER_AGENT = "Mozilla/5.0";
	
	//get method
	//private final String url = "http://www.google.com/search?q=httpClient";

	//post method
	//private final String url = "https://selfsolve.apple.com/wcResults.do";
	
	//https://api.darksky.net/forecast/0123456789abcdef9876543210fedcba/42.3601,-71.0589
	
	public void get(final String USER_AGENT, final URI uri2) throws ClientProtocolException, IOException, URISyntaxException {	
		HttpGet request = new HttpGet(uri2);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = APIVariables.client.execute(request);

		System.out.println("Response Code : " 
	                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
			new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		
		rd.close();
		
		System.out.println("get function: " + result);
		
		JSONObject theResponse = new JSONObject(result.toString());
		
		System.out.println(theResponse);
		
		System.out.println(theResponse.getString("timezone"));
		System.out.println(theResponse.getFloat("longitude"));
		System.out.println(theResponse.getNames("currently"));
		theResponse = theResponse.getJSONObject("currently");
		System.out.println(theResponse.getString("summary"));
	}
	
	public void post(final String USER_AGENT, final String url) throws ClientProtocolException, IOException {
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = APIVariables.client.execute(post);
		System.out.println("Response Code : " 
	                + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println("post function: " + result);
	}
	
	public void put() {
		
	}
	
	public void head() {
		
	}
	
	public void delete() {
		
	}
	
	public void patch() {
		
	}
	
	public void options() {
		
	}
}