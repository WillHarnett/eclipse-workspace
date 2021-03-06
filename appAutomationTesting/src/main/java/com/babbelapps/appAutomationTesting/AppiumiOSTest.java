package com.babbelapps.appAutomationTesting;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.*;

import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.*;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import prompts.TestScopePrompt;
import io.appium.java_client.ios.IOSElement;

public class AppiumiOSTest {

	GlobalVariables globalVariables = new GlobalVariables();
	CapabilitiesPrompt capabilitiesPrompt = new CapabilitiesPrompt();
	AppiumBasicFunctions appiumBasicFunctions = new AppiumBasicFunctions();
	TestScopePrompt testScopePrompt = new TestScopePrompt();

	private List<Integer> values;

	private static final int MINIMUM = 0;
	private static final int MAXIMUM = 10;

	//@Before
	public void setUp() throws Exception {
		capabilitiesPrompt.capabilitiesPrompt();
		DesiredCapabilities capabilities = new DesiredCapabilities();

		String udid = "";
		String deviceName = "";

		/*
		if (globalVariables.isEmulator) {
			capabilities.setCapability("app", globalVariables.appLocation); // Required
			udid = globalVariables.emulatorUdid;
			deviceName = globalVariables.emulatorDeviceName;
		} else {
			capabilities.setCapability("bundleId", globalVariables.bubndleID);
			udid = globalVariables.connectedDeviceUdid;
			deviceName = globalVariables.connectedDeviceDeviceName;
			// capabilities.setCapability("xcodeOrgId", globalVariables.teamID); //Required
			// capabilities.setCapability("xcodeSigningId", globalVariables.signingID);
			// //Required
		}
		*/

		capabilities.setCapability("platformName", globalVariables.platformName); // Required
		capabilities.setCapability("automationName", globalVariables.automationName); // Required
		capabilities.setCapability("deviceName", deviceName); // Required
		capabilities.setCapability("udid", udid);

		WebDriver webDriver;
		AndroidDriver androidDriver;
		IOSDriver iosDriver;

		iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		iosDriver.findElementByAccessibilityId("Niku Jaga").click();

		values = new ArrayList<Integer>();

		Set<String> logTypes = iosDriver.manage().logs().getAvailableLogTypes();
		// LogEntries logEntries1 = iosDriver.manage().logs().get("syslog");
		// LogEntries logEntries2 = iosDriver.manage().logs().get("crashlog");
		// LogEntries logEntries3 = iosDriver.manage().logs().get("performance");
		// LogEntries logEntries4 = iosDriver.manage().logs().get("server");
		// LogEntries logEntries5 = iosDriver.manage().logs().get("safariConsole");
		// LogEntries logEntries6 = iosDriver.manage().logs().get("safariNetwork");
		// LogEntries logEntries7 = iosDriver.manage().logs().get("client");

		System.out.println(logTypes);
		// System.out.println(logEntries1 + " " + logEntries2 + " " + logEntries3 + " "
		// + logEntries4 + " " + logEntries5 + " " + logEntries6 + " " + logEntries7);

		System.out.println("Finished Setup");
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void testScriptGoesHere() throws Exception {
		
		globalVariables.iosDriver.findElementByAccessibilityId("Niku Jaga").click();
		
		appiumBasicFunctions.tap("//XCUIElementTypeImage[@name=\"sampleRecipe_MisoSoup\"]");
		// globalVariables.driver.findElement(By.xpath("//XCUIElementTypeImage[@name=\"sampleRecipe_MisoSoup\"]")).click();
		System.out.println("Test Output From Within the test");
		System.out.println("Here goes your test script");

	}
}
