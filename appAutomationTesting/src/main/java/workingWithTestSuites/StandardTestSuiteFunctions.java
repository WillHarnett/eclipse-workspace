package workingWithTestSuites;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import globalVariables.TestCaseVariables;
import globalVariables.TestSuiteVariables;
import runAutomation.RunAutomation;
import standardClasses.Converter;

public class StandardTestSuiteFunctions {

	static Logger logger = LoggerFactory.getLogger(RunAutomation.class);

	// This can be reused when reading from Excel
	public static void readAndSaveHeaderColumns(List<Object> headerValues) {
		logger.info("Starting");
		headerValues.add(0, "Place Holder");

		String tempStringValue = "";

		TestSuiteVariables.numberOfPlatforms = 0;
		GoogleSheetVariables.eachPlatformColumn = new ArrayList<String>();
		GoogleSheetVariables.sheetTestPlatformTitles = new ArrayList<String>();
		GoogleSheetVariables.eachPlatformColumn.add("");
		GoogleSheetVariables.sheetTestPlatformTitles.add("");

		for (int i = 0; i < headerValues.size(); i++) {
			tempStringValue = String.valueOf(headerValues.get(i));
			switch (tempStringValue) {
			// Standard Column Titles
			case "FLAG":
				GoogleSheetVariables.flagColumnPos = i;
				GoogleSheetVariables.flagColumn = Converter.numbersToLetters(i);
				break;
			case "TYPE":
				GoogleSheetVariables.typeColumnPos = i;
				GoogleSheetVariables.typeColumn = Converter.numbersToLetters(i);
				break;
			case "TC #":
				GoogleSheetVariables.testCaseNumberColumnPos = i;
				GoogleSheetVariables.testCaseNumberColumn = Converter.numbersToLetters(i);
				break;
			case "PRIORITY":
				GoogleSheetVariables.priorityColumnPos = i;
				GoogleSheetVariables.priorityColumn = Converter.numbersToLetters(i);
				break;
			case "SCREEN":
				GoogleSheetVariables.screenColumnPos = i;
				GoogleSheetVariables.screenColumn = Converter.numbersToLetters(i);
				break;
			case "LARGE":
				GoogleSheetVariables.largeColumnPos = i;
				GoogleSheetVariables.largeColumn = Converter.numbersToLetters(i);
				break;
			case "MEDIUM":
				GoogleSheetVariables.mediumColumnPos = i;
				GoogleSheetVariables.mediumColumn = Converter.numbersToLetters(i);
				break;
			case "SMALL":
				GoogleSheetVariables.smallColumnPos = i;
				GoogleSheetVariables.smallColumn = Converter.numbersToLetters(i);
				break;
			case "STEPS":
				GoogleSheetVariables.stepsColumnPos = i;
				GoogleSheetVariables.stepsColumn = Converter.numbersToLetters(i);
				break;
			case "KEYWORDS":
				GoogleSheetVariables.keywordsColumnPos = i;
				GoogleSheetVariables.keywordsColumn = Converter.numbersToLetters(i);
				break;
			case "E RESULTS":
				GoogleSheetVariables.expectedResultsColumnPos = i;
				GoogleSheetVariables.expectedResultsColumn = Converter.numbersToLetters(i);
				break;
			case "TESTDATA":
				GoogleSheetVariables.testDataColumnPos = i;
				GoogleSheetVariables.testDataColumn = Converter.numbersToLetters(i);
				break;
			case "TICKET #":
				GoogleSheetVariables.ticketColumnPos = i;
				GoogleSheetVariables.ticketColumn = Converter.numbersToLetters(i);
				break;
			case "PRE TICKET #":
				GoogleSheetVariables.preTicketColumnPos = i;
				GoogleSheetVariables.preTicketColumn = Converter.numbersToLetters(i);
				break;
			case "COMMENTS":
				GoogleSheetVariables.commentColumnPos = i;
				GoogleSheetVariables.commentColumn = Converter.numbersToLetters(i);
				break;

			// Column Titles for each platform
			case "IPHONE":
				GoogleSheetVariables.iPhoneColumnPos = i;
				GoogleSheetVariables.iPhoneColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.iPhoneColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "IPAD":
				GoogleSheetVariables.iPadColumnPos = i;
				GoogleSheetVariables.iPadColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.iPadColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "ANDROID":
				GoogleSheetVariables.androidColumnPos = i;
				GoogleSheetVariables.androidColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.androidColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "ANDROID TABLET":
				GoogleSheetVariables.androidTabletColumnPos = i;
				GoogleSheetVariables.androidTabletColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.androidTabletColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "CHROME":
				GoogleSheetVariables.chromeColumnPos = i;
				GoogleSheetVariables.chromeColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.chromeColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "EDGE":
				GoogleSheetVariables.edgeColumnPos = i;
				GoogleSheetVariables.edgeColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.edgeColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "FIREFOX":
				GoogleSheetVariables.firefoxColumnPos = i;
				GoogleSheetVariables.firefoxColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.firefoxColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "IE":
				GoogleSheetVariables.ieColumnPos = i;
				GoogleSheetVariables.ieColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.ieColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "SAFARI":
				GoogleSheetVariables.safariColumnPos = i;
				GoogleSheetVariables.safariColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.safariColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "JMETER":
				GoogleSheetVariables.jMeterColumnPos = i;
				GoogleSheetVariables.jMeterColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.jMeterColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "API":
				GoogleSheetVariables.apiColumnPos = i;
				GoogleSheetVariables.apiColumn = Converter.numbersToLetters(i);
				GoogleSheetVariables.eachPlatformColumn.add(GoogleSheetVariables.apiColumn);
				GoogleSheetVariables.sheetTestPlatformTitles.add(tempStringValue);
				TestSuiteVariables.numberOfPlatforms = TestSuiteVariables.numberOfPlatforms + 1;
				break;
			case "TESTERA":
				GoogleSheetVariables.testerAColumnPos = i;
				GoogleSheetVariables.testerAColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERB":
				GoogleSheetVariables.testerBColumnPos = i;
				GoogleSheetVariables.testerBColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERC":
				GoogleSheetVariables.testerCColumnPos = i;
				GoogleSheetVariables.testerCColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERD":
				GoogleSheetVariables.testerDColumnPos = i;
				GoogleSheetVariables.testerDColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERE":
				GoogleSheetVariables.testerEColumnPos = i;
				GoogleSheetVariables.testerEColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERF":
				GoogleSheetVariables.testerFColumnPos = i;
				GoogleSheetVariables.testerFColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERG":
				GoogleSheetVariables.testerGColumnPos = i;
				GoogleSheetVariables.testerGColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERH":
				GoogleSheetVariables.testerHColumnPos = i;
				GoogleSheetVariables.testerHColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERI":
				GoogleSheetVariables.testerIColumnPos = i;
				GoogleSheetVariables.testerIColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERJ":
				GoogleSheetVariables.testerJColumnPos = i;
				GoogleSheetVariables.testerJColumn = Converter.numbersToLetters(i);
				break;
			case "TESTERK":
				GoogleSheetVariables.testerKColumnPos = i;
				GoogleSheetVariables.testerKColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONA":
				GoogleSheetVariables.versionAColumnPos = i;
				GoogleSheetVariables.versionAColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONB":
				GoogleSheetVariables.versionBColumnPos = i;
				GoogleSheetVariables.versionBColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONC":
				GoogleSheetVariables.versionCColumnPos = i;
				GoogleSheetVariables.versionCColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIOND":
				GoogleSheetVariables.versionDColumnPos = i;
				GoogleSheetVariables.versionDColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONE":
				GoogleSheetVariables.versionEColumnPos = i;
				GoogleSheetVariables.versionEColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONF":
				GoogleSheetVariables.versionFColumnPos = i;
				GoogleSheetVariables.versionFColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONG":
				GoogleSheetVariables.versionGColumnPos = i;
				GoogleSheetVariables.versionGColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONH":
				GoogleSheetVariables.versionHColumnPos = i;
				GoogleSheetVariables.versionHColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONI":
				GoogleSheetVariables.versionIColumnPos = i;
				GoogleSheetVariables.versionIColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONJ":
				GoogleSheetVariables.versionJColumnPos = i;
				GoogleSheetVariables.versionJColumn = Converter.numbersToLetters(i);
				break;
			case "VERSIONK":
				GoogleSheetVariables.versionKColumnPos = i;
				GoogleSheetVariables.versionKColumn = Converter.numbersToLetters(i);
				break;
			case "DATEA":
				GoogleSheetVariables.dateAColumnPos = i;
				GoogleSheetVariables.dateAColumn = Converter.numbersToLetters(i);
				break;
			case "DATEB":
				GoogleSheetVariables.dateBColumnPos = i;
				GoogleSheetVariables.dateBColumn = Converter.numbersToLetters(i);
				break;
			case "DATEC":
				GoogleSheetVariables.dateCColumnPos = i;
				GoogleSheetVariables.dateCColumn = Converter.numbersToLetters(i);
				break;
			case "DATED":
				GoogleSheetVariables.dateDColumnPos = i;
				GoogleSheetVariables.dateDColumn = Converter.numbersToLetters(i);
				break;
			case "DATEE":
				GoogleSheetVariables.dateEColumnPos = i;
				GoogleSheetVariables.dateEColumn = Converter.numbersToLetters(i);
				break;
			case "DATEF":
				GoogleSheetVariables.dateFColumnPos = i;
				GoogleSheetVariables.dateFColumn = Converter.numbersToLetters(i);
				break;
			case "DATEG":
				GoogleSheetVariables.dateGColumnPos = i;
				GoogleSheetVariables.dateGColumn = Converter.numbersToLetters(i);
				break;
			case "DATEH":
				GoogleSheetVariables.dateHColumnPos = i;
				GoogleSheetVariables.dateHColumn = Converter.numbersToLetters(i);
				break;
			case "DATEI":
				GoogleSheetVariables.dateIColumnPos = i;
				GoogleSheetVariables.dateIColumn = Converter.numbersToLetters(i);
				break;
			case "DATEJ":
				GoogleSheetVariables.dateJColumnPos = i;
				GoogleSheetVariables.dateJColumn = Converter.numbersToLetters(i);
				break;
			case "DATEK":
				GoogleSheetVariables.dateKColumnPos = i;
				GoogleSheetVariables.dateKColumn = Converter.numbersToLetters(i);
				break;
			default:
				break;
			}
		}
		logger.debug("Each Platform Type to be Tested: " + GoogleSheetVariables.eachPlatformColumn);
		logger.info("Completed");
	}

	// This can be reused when reading from Excel
	public static String readAndSaveTestCaseValues(List<Object> testCase) {
		logger.info("Starting");
		String continueTesting = "yes";

		testCase.add(0, "Place Holder");

		logger.debug("Flag Value: " + (String) testCase.get(GoogleSheetVariables.flagColumnPos));
		if (((String) testCase.get(GoogleSheetVariables.flagColumnPos)).equals("END")) {
			if (TestSuiteVariables.currentTestingPlatform == TestSuiteVariables.numberOfPlatforms) {
				continueTesting = "no";
				TestSuiteVariables.numberOfPlatforms = 0;
				TestSuiteVariables.currentTestingPlatform = 1;
			} else {
				continueTesting = "next";
				TestSuiteVariables.currentTestingPlatform = TestSuiteVariables.currentTestingPlatform + 1;
			}
		} else if (((String) testCase.get(GoogleSheetVariables.flagColumnPos)).equals("DELETE")
				|| ((String) testCase.get(GoogleSheetVariables.typeColumnPos)).equals("MANUAL")) {
			continueTesting = "skip";
		} else {
			// Need to add logic in that accounts for the different kinds of test cases
			TestCaseVariables.flagValue = (String) testCase.get(GoogleSheetVariables.flagColumnPos);
			TestCaseVariables.typeValue = (String) testCase.get(GoogleSheetVariables.typeColumnPos);
			TestCaseVariables.testCaseNumberValue = (String) testCase.get(GoogleSheetVariables.testCaseNumberColumnPos);
			TestCaseVariables.priorityValue = (String) testCase.get(GoogleSheetVariables.priorityColumnPos);
			TestCaseVariables.screenValue = (String) testCase.get(GoogleSheetVariables.screenColumnPos);
			TestCaseVariables.largeValue = (String) testCase.get(GoogleSheetVariables.largeColumnPos);
			TestCaseVariables.mediumValue = (String) testCase.get(GoogleSheetVariables.mediumColumnPos);
			TestCaseVariables.smallValue = (String) testCase.get(GoogleSheetVariables.smallColumnPos);
			TestCaseVariables.stepsValue = (String) testCase.get(GoogleSheetVariables.stepsColumnPos);
			TestCaseVariables.keywordsValue = (String) testCase.get(GoogleSheetVariables.keywordsColumnPos);
			TestCaseVariables.expectedResultsValue = (String) testCase
					.get(GoogleSheetVariables.expectedResultsColumnPos);
			TestCaseVariables.testDataValue = (String) testCase.get(GoogleSheetVariables.testDataColumnPos);
			TestCaseVariables.ticketValue = (String) testCase.get(GoogleSheetVariables.ticketColumnPos);
			TestCaseVariables.preTicketValue = (String) testCase.get(GoogleSheetVariables.preTicketColumnPos);
			TestCaseVariables.commentValue = (String) testCase.get(GoogleSheetVariables.commentColumnPos);

			if (TestCaseVariables.typeValue.equals("API")) {
				TestCaseVariables.apiValue = (String) testCase.get(GoogleSheetVariables.apiColumnPos);

				TestCaseVariables.testerJValue = (String) testCase.get(GoogleSheetVariables.testerJColumnPos);
				TestCaseVariables.versionJValue = (String) testCase.get(GoogleSheetVariables.versionJColumnPos);
				TestCaseVariables.dateJValue = (String) testCase.get(GoogleSheetVariables.dateJColumnPos);
			} else if (TestCaseVariables.typeValue.equals("APPIUM")) {

				TestCaseVariables.iPhoneValue = (String) testCase.get(GoogleSheetVariables.iPhoneColumnPos);
				TestCaseVariables.iPadValue = (String) testCase.get(GoogleSheetVariables.iPadColumnPos);
				TestCaseVariables.androidValue = (String) testCase.get(GoogleSheetVariables.androidColumnPos);
				TestCaseVariables.androidTabletValue = (String) testCase
						.get(GoogleSheetVariables.androidTabletColumnPos);

				TestCaseVariables.testerAValue = (String) testCase.get(GoogleSheetVariables.testerAColumnPos);
				TestCaseVariables.testerBValue = (String) testCase.get(GoogleSheetVariables.testerBColumnPos);
				TestCaseVariables.testerCValue = (String) testCase.get(GoogleSheetVariables.testerCColumnPos);
				TestCaseVariables.testerDValue = (String) testCase.get(GoogleSheetVariables.testerDColumnPos);
				TestCaseVariables.versionAValue = (String) testCase.get(GoogleSheetVariables.versionAColumnPos);
				TestCaseVariables.versionBValue = (String) testCase.get(GoogleSheetVariables.versionBColumnPos);
				TestCaseVariables.versionCValue = (String) testCase.get(GoogleSheetVariables.versionCColumnPos);
				TestCaseVariables.versionDValue = (String) testCase.get(GoogleSheetVariables.versionDColumnPos);
				TestCaseVariables.dateAValue = (String) testCase.get(GoogleSheetVariables.dateAColumnPos);
				TestCaseVariables.dateBValue = (String) testCase.get(GoogleSheetVariables.dateBColumnPos);
				TestCaseVariables.dateCValue = (String) testCase.get(GoogleSheetVariables.dateCColumnPos);
				TestCaseVariables.dateDValue = (String) testCase.get(GoogleSheetVariables.dateDColumnPos);
			} else if (TestCaseVariables.typeValue.equals("SELENIUM")) {
				TestCaseVariables.chromeValue = (String) testCase.get(GoogleSheetVariables.chromeColumnPos);
				TestCaseVariables.firefoxValue = (String) testCase.get(GoogleSheetVariables.firefoxColumnPos);
				TestCaseVariables.edgeValue = (String) testCase.get(GoogleSheetVariables.edgeColumnPos);
				TestCaseVariables.ieValue = (String) testCase.get(GoogleSheetVariables.ieColumnPos);
				TestCaseVariables.safariValue = (String) testCase.get(GoogleSheetVariables.safariColumnPos);

				TestCaseVariables.testerEValue = (String) testCase.get(GoogleSheetVariables.testerEColumnPos);
				TestCaseVariables.testerFValue = (String) testCase.get(GoogleSheetVariables.testerFColumnPos);
				TestCaseVariables.testerGValue = (String) testCase.get(GoogleSheetVariables.testerGColumnPos);
				TestCaseVariables.testerHValue = (String) testCase.get(GoogleSheetVariables.testerHColumnPos);
				TestCaseVariables.testerIValue = (String) testCase.get(GoogleSheetVariables.testerIColumnPos);
				TestCaseVariables.versionEValue = (String) testCase.get(GoogleSheetVariables.versionEColumnPos);
				TestCaseVariables.versionFValue = (String) testCase.get(GoogleSheetVariables.versionFColumnPos);
				TestCaseVariables.versionGValue = (String) testCase.get(GoogleSheetVariables.versionGColumnPos);
				TestCaseVariables.versionHValue = (String) testCase.get(GoogleSheetVariables.versionHColumnPos);
				TestCaseVariables.versionIValue = (String) testCase.get(GoogleSheetVariables.versionIColumnPos);
				TestCaseVariables.dateEValue = (String) testCase.get(GoogleSheetVariables.dateEColumnPos);
				TestCaseVariables.dateFValue = (String) testCase.get(GoogleSheetVariables.dateFColumnPos);
				TestCaseVariables.dateGValue = (String) testCase.get(GoogleSheetVariables.dateGColumnPos);
				TestCaseVariables.dateHValue = (String) testCase.get(GoogleSheetVariables.dateHColumnPos);
				TestCaseVariables.dateIValue = (String) testCase.get(GoogleSheetVariables.dateIColumnPos);
			} else if (TestCaseVariables.typeValue.equals("JMETER")) {
				TestCaseVariables.jMeterValue = (String) testCase.get(GoogleSheetVariables.jMeterColumnPos);
				TestCaseVariables.testerKValue = (String) testCase.get(GoogleSheetVariables.testerKColumnPos);
				TestCaseVariables.versionKValue = (String) testCase.get(GoogleSheetVariables.versionKColumnPos);
				TestCaseVariables.dateKValue = (String) testCase.get(GoogleSheetVariables.dateKColumnPos);
			} else {
				logger.error("Test Case Type Value does not Exist: " + TestCaseVariables.typeValue);
			}
		}

		logger.debug("This is continueTesting Value: " + continueTesting);
		logger.info("Completed");
		return continueTesting;
	}
}
