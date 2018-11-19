package standardClasses;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import automation_api.APIKeywordActions;
import automation_appium.AppiumKeywordActions;
import automation_jmeter.JMeterKeywordActions;
import automation_selenium.SeleniumKeywordActions;
import globalVariables.TestCaseVariables;
import globalVariables.TestSuiteVariables;
import runAutomation.RunAutomation;
import workingWithTestSuites.GoogleSheetVariables;

public class PerformTest {
	static Logger logger = LoggerFactory.getLogger(RunAutomation.class);

	public static List<String> keywordList = new ArrayList<String>();

	public static APIKeywordActions apiKeywordActions;
	public static AppiumKeywordActions appiumKeywordActions;
	public static JMeterKeywordActions jMeterKeywordActions;
	public static SeleniumKeywordActions seleniumKeywordActions;

	public static String actionKeyword = "";
	public static Method method[];

	public static String performTest()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Here we are instantiating a new object class of keyword Libraries for Each
		// Type of Automation
		logger.info("Starting");
		apiKeywordActions = new APIKeywordActions();
		appiumKeywordActions = new AppiumKeywordActions();
		jMeterKeywordActions = new JMeterKeywordActions();
		seleniumKeywordActions = new SeleniumKeywordActions();

		String result = "P";
		keywordList = Parser.parse(TestCaseVariables.keywordsValue);

		logger.debug("Test Case Type: " + TestCaseVariables.typeValue);

		if (TestCaseVariables.typeValue.equals("MANUAL")) {
			result = "skip";
		} else if (TestCaseVariables.typeValue.equals("API")) {
			if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("API")) {
				if (!TestCaseVariables.apiValue.equals("N/I") && !TestCaseVariables.apiValue.equals("N/A")) {
					method = apiKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(apiKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else {
				result = "skip";
			}
		} else if (TestCaseVariables.typeValue.equals("APPIUM")) {
			if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("IPHONE")) {
				if (!TestCaseVariables.iPhoneValue.equals("N/I") && !TestCaseVariables.iPhoneValue.equals("N/A")) {
					method = appiumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(appiumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("IPAD")) {
				if (!TestCaseVariables.iPadValue.equals("N/I") && !TestCaseVariables.iPadValue.equals("N/A")) {
					method = appiumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(appiumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("ANDROID")) {
				if (!TestCaseVariables.androidValue.equals("N/I") && !TestCaseVariables.androidValue.equals("N/A")) {
					method = appiumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(appiumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("ANDROID TABLET")) {
				if (!TestCaseVariables.androidTabletValue.equals("N/I")
						&& !TestCaseVariables.androidTabletValue.equals("N/A")) {
					method = appiumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(appiumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else {
				result = "skip";
			}
		} else if (TestCaseVariables.typeValue.equals("SELENIUM")) {
			if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("CHROME")) {
				if (!TestCaseVariables.chromeValue.equals("N/I") && !TestCaseVariables.chromeValue.equals("N/A")) {
					method = seleniumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(seleniumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("EDGE")) {
				if (!TestCaseVariables.edgeValue.equals("N/I") && !TestCaseVariables.edgeValue.equals("N/A")) {
					method = seleniumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(seleniumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("FIREFOX")) {
				if (!TestCaseVariables.firefoxValue.equals("N/I") && !TestCaseVariables.firefoxValue.equals("N/A")) {
					method = seleniumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(seleniumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("IE")) {
				if (!TestCaseVariables.ieValue.equals("N/I") && !TestCaseVariables.ieValue.equals("N/A")) {
					method = seleniumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(seleniumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("SAFARI")) {
				logger.debug(TestCaseVariables.safariValue);
				if (!TestCaseVariables.safariValue.equals("N/I") && !TestCaseVariables.safariValue.equals("N/A")) {
					method = seleniumKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(seleniumKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else {
				result = "skip";
			}
		} else if (TestCaseVariables.typeValue.equals("JMETER")) {
			logger.debug("This is the JMeter Value: " + TestCaseVariables.jMeterValue);
			if (GoogleSheetVariables.sheetTestPlatformTitles.get(TestSuiteVariables.currentTestingPlatform)
					.equals("JMETER")) {
				if (!TestCaseVariables.jMeterValue.equals("N/I") && !TestCaseVariables.jMeterValue.equals("N/A")) {
					method = jMeterKeywordActions.getClass().getMethods();
					for (int i = 0; i < keywordList.size(); i++) {
						actionKeyword = keywordList.get(i);
						for (int j = 0; j < method.length; j++) {
							if (method[j].getName().equals(actionKeyword)) {
								method[j].invoke(jMeterKeywordActions);
								/// Need to add Find Result Method Here
								break;
							}
						}
					}
				} else {
					result = "skip";
				}
			} else {
				result = "skip";
			}
		} else {
			result = "skip";
		}
		logger.info("Completed");
		return result;
	}
}