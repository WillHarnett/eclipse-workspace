package apiTesting;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import globalVariables.APIVariables;

public class Setup {

	public void setup() {
		APIVariables.client = HttpClientBuilder.create().build();
	}
}
