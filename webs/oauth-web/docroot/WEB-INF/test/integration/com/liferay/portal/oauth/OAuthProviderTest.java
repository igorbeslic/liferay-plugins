/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.oauth;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * To run this test you need to have installed one of Firefox versions:
 * 3.0, 3.6, 5, 6, 7, or 8. If your installation is not in default installation
 * directory(depends on OS) you can set VM option "webdriver.firefox.bin" to
 * set alternative path to Firefox while running this test
 *
 * @author Ivica Cardic
 */
public class OAuthProviderTest {

	@After
	public void after() {
		_driver.quit();
	}

	@Before
	public void before() {
		_service = new ServiceBuilder()
				.provider(LiferayApi.class)
				//test1
				.apiKey("55198b22-c6a4-4253-9f92-e2681013e3de")
				.apiSecret("1b642ba1a7290d31d302d6e2cdf68fa59248e459")
				//test2
				//.apiKey("0461edb1-9dce-4003-a29b-7d02cdb26f2c")
				//.apiSecret("2f9653e2b3e3baaa22ca3d3a6f9c3e7fba20a7a2")
				.build();

		_driver = new FirefoxDriver();
	}

	@Test
	public void testGetAccessToken() {

	}

	@Test
	public void testGetAccessTokenWithCallbackUrl() {
		Token requestToken = _service.getRequestToken();

		Assert.assertNotNull(requestToken.getToken());

		String authorizationUrl = LiferayApi.AUTHORIZE_URL.replace(
				"%s", requestToken.getToken());

		//
		_driver.get(TEST_PORTAL_URL);

		WebElement element = _driver.findElement(By.name("_58_login"));
		element.clear();
		element.sendKeys(TEST_USER_LOGIN);

		element = _driver.findElement(By.name("_58_password"));
		element.sendKeys(TEST_USER_PASSWORD);

		element.submit();

		_driver.get(authorizationUrl);

		element = _driver.findElement(By.id("authorize"));
		element.submit();

		String[] params = extractParams(_driver.getCurrentUrl());

		Assert.assertNotNull(params[0]);
		Assert.assertNotNull(params[1]);

		Verifier verifier = new Verifier(params[1]);

		Token accessToken = _service.getAccessToken(requestToken, verifier);

		Assert.assertNotNull(accessToken.getToken());
	}

	private String[] extractParams(String url) {
		int beginIndex = url.indexOf("oauth_token");
		int endIndex = url.length();

		url = url.substring(beginIndex, endIndex);

		beginIndex = "oauth_token=".length();
		endIndex = url.indexOf("&oauth_verifier");

		String oauthToken =url.substring(beginIndex, endIndex);

		beginIndex = url.indexOf("&oauth_verifier");
		endIndex = url.length();

		url = url.substring(beginIndex, endIndex);

		beginIndex = "oauth_verifier=".length();
		endIndex = url.length();

		String oauthVerifier =url.substring(beginIndex, endIndex);

		return new String[]{oauthToken, oauthVerifier};
	}

	private OAuthService _service;
	private WebDriver _driver;

	public static final String TEST_PORTAL_URL = "http://localhost:8080";
	private static final String TEST_USER_LOGIN = "test@liferay.com";
	private static final String TEST_USER_PASSWORD = "test";

}