package com.liferay.portal.oauth;

import java.io.Console;
import java.io.IOException;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

/**
 * @author Ivica Cardic
 */
public class OAuthProviderTest {

	public static void main(String args[]) throws IOException {
		OAuthProviderTest t = new OAuthProviderTest();

		t.setup();
		t.testRequestToken();
	}

	//@Before
	public void setup() {
		_service = new ServiceBuilder()
			.provider(LiferayApi.class)
			.apiKey("key11")
			.apiSecret("secret11")
			.build();
	}

	//@Test
	public void testRequestToken() {
		Token requestToken = _service.getRequestToken();

		//Assert.assertNotNull(requestToken);

		String authorizationUrl = LiferayApi.AUTHORIZE_URL.replace(
			"%s", requestToken.getToken());

		System.out.println(authorizationUrl);

		Console c = System.console();

		String verifierString = c.readLine("Enter verifier: ");

		Verifier verifier = new Verifier(verifierString);

		Token accessToken = _service.getAccessToken(requestToken, verifier);

		System.out.println(accessToken.getToken());

		//OAuthRequest request = new OAuthRequest(Verb.GET,
		// "http://api.twitter.com/1/account/verify_credentials.xml");
		//_service.signRequest(accessToken, request); // the access token
		// from step 4
		//Response response = request.send();
		//System.out.println(response.getBody());
	}

	private OAuthService _service;

}