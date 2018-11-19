package runAutomation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import globalVariables.StandardVariables;
import prompts.TestScopePrompt;
import workingWithTestSuites.GoogleSheetFunctions;

public class RunAutomation {

	TestScopePrompt testScopePrompt = new TestScopePrompt();
	
	//The following allows you to use the function "logger" to log different messages at different levels 
	// Ex.
	// logger.trace("Hello World");
    // logger.debug("Hello World");
    // logger.info("Hello World");
    // logger.warn("Hello World");
    // logger.error("Hello World");
	// If you are unsure which log level to use, use: logger.info("Example");
    Logger logger = LoggerFactory.getLogger(RunAutomation.class);

	boolean testSuiteReaderSetupIsComplete = false;

	@Before
	public void runAutomationSetup() {
		logger.info("RunAutomation.runAutomationSetup Starting");
		boolean usePrompts = true;
		// testScopePrompt.prompt(usePrompts);
		logger.info("RunAutomation.runAutomationSetup Completed");
	}

	@Test
	public void runTests() throws IOException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, GeneralSecurityException {
		logger.info("RunAutomation.runTests Starting");

		while (StandardVariables.carryOutTesting == true) {
			if (StandardVariables.carryOutApiTesting == true) {
				StandardVariables.currentlyTesting = "API";
				StandardVariables.carryOutApiTesting = false;
			} else if (StandardVariables.carryOutJMeterTesting == true) {
				StandardVariables.currentlyTesting = "JMETER";
				StandardVariables.carryOutJMeterTesting = false;
			} else if (StandardVariables.carryOutAppiumTesting == true) {
				StandardVariables.currentlyTesting = "APPIUM";
				StandardVariables.carryOutAppiumTesting = false;
			} else if (StandardVariables.carryOutSeleniumTesting == true) {
				StandardVariables.currentlyTesting = "SELENIUM";
				StandardVariables.carryOutSeleniumTesting = false;
			} else {
				StandardVariables.carryOutTesting = false;
			}
			if (StandardVariables.carryOutTesting) {
				if(!testSuiteReaderSetupIsComplete) {
					testSuiteReaderSetupIsComplete = GoogleSheetFunctions.generalSetup();
				}
				if (testSuiteReaderSetupIsComplete) {
					GoogleSheetFunctions.performTestCases();
				} else {
					logger.debug("Test Suite Setup Failed");
				}
			} else {
				logger.info("Automation Completed");
			}
		}
		logger.info("RunAutomation.runTests Completed");
	}

	@After
	public void sendReportsAndPerformTeardown() {
		logger.info("RunAutomation.sendReportsAndPerformTeardown Start");
		logger.info("RunAutomation.sendReportsAndPerformTeardown Completed");
	}
}
