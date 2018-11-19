package workingWithTestSuites;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import globalVariables.StandardVariables;
import globalVariables.TestSuiteVariables;
import runAutomation.RunAutomation;
import standardClasses.PerformTest;

public class GoogleSheetFunctions {

	static Logger logger = LoggerFactory.getLogger(RunAutomation.class);

	public static boolean generalSetup() throws GeneralSecurityException, IOException {
		logger.info("Starting");
		GoogleSheetVariables.SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
		GoogleSheetVariables.JSON_FACTORY = JacksonFactory.getDefaultInstance();
		GoogleSheetVariables.HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		GoogleSheetVariables.sheetsService = createSheetsService();
		logger.info("Completed");
		return true;
	}
	
	public static void performTestCases()
			throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		logger.info("Starting");
		String continueTesting = "";
		while (!continueTesting.equals("no")) {
			setupNextRoundOFTests();
			continueTesting = "";
			while(!continueTesting.equals("next") && !continueTesting.equals("no")) {
				List<Object> tempRowValues = getValuesInRow();

				continueTesting = StandardTestSuiteFunctions.readAndSaveTestCaseValues(tempRowValues);
				// perform actual tests
				logger.debug("continueTesting: " + continueTesting);
				if (continueTesting.equals("yes")) {
					String result = PerformTest.performTest(); // perform test and find result

					if (result.equals("skip")) {

					} else {
						String resultCell = constructCell(); // find the correct cell to save results to
						logger.info(resultCell + " " + result);
						writeToTestSuite(resultCell, result);
					}
				}
				GoogleSheetVariables.currentRow++;
			}
		}
		logger.info("Completed");
	}
	
	public static void setupNextRoundOFTests() throws IOException {
		logger.info("Starting");
		GoogleSheetVariables.currentRow = 1;
		List<Object> headerValues = getValuesInRow();

		if (headerValues == null || headerValues.isEmpty()) {
			logger.error("No header data found");
		} else {
			StandardTestSuiteFunctions.readAndSaveHeaderColumns(headerValues);
			for (int i = 0; i < headerValues.size(); i++) {
				GoogleSheetVariables.columnTitles.add((String) headerValues.get(i));
			}
		}
		GoogleSheetVariables.currentRow++;
		logger.info("Completed");
	}

	// setup and perform tests methods
	public static String constructCurrentRange() {
		logger.info("Starting");
		
		String tempSheetName = "";
		String tempRange = "";
		switch (StandardVariables.currentlyTesting) {
		case "API":
			tempSheetName = TestSuiteVariables.apiTestSuiteSheetName;
			break;
		case "APPIUM":
			tempSheetName = TestSuiteVariables.appiumTestSuiteSheetName;
			break;
		case "SELENIUM":
			tempSheetName = TestSuiteVariables.seleniumTestSuiteSheetName;
			break;
		case "JMETER":
			tempSheetName = TestSuiteVariables.jMeterTestSuiteSheetName;
			break;
		default:
			logger.error("Could not find valid value for switch statment: StandardVariables.currentlyTesting = "
							+ StandardVariables.currentlyTesting);
			break;
		}
		tempRange = tempSheetName + GoogleSheetVariables.testSuiteNameAndRangeDivider
				+ GoogleSheetVariables.firstColumn + GoogleSheetVariables.currentRow
				+ GoogleSheetVariables.startColumnAndEndColumnDivider + GoogleSheetVariables.lastColumn
				+ GoogleSheetVariables.currentRow;
		logger.debug("tempRange: " + tempRange);
		logger.info("Completed");
		return tempRange;
	}

	public static String constructCell() {
		logger.info("Starting");
		
		String tempCell = "";
		String tempSheetName = "";
		String tempColumn = "";
		switch (StandardVariables.currentlyTesting) {
		case "API":
			tempSheetName = TestSuiteVariables.apiTestSuiteSheetName;
			break;
		case "APPIUM":
			tempSheetName = TestSuiteVariables.appiumTestSuiteSheetName;
			break;
		case "SELENIUM":
			tempSheetName = TestSuiteVariables.seleniumTestSuiteSheetName;
			break;
		case "JMETER":
			tempSheetName = TestSuiteVariables.jMeterTestSuiteSheetName;
			break;
		default:
			logger.error("Could not find valid value for switch statment: StandardVariables.currentlyTesting = "
							+ StandardVariables.currentlyTesting);
			break;
		}
		tempCell = tempSheetName + GoogleSheetVariables.testSuiteNameAndRangeDivider
				+ GoogleSheetVariables.eachPlatformColumn.get(TestSuiteVariables.currentTestingPlatform) + +GoogleSheetVariables.currentRow;
		logger.debug("tempCell: " + tempCell);
		logger.info("Completed");
		return tempCell;
	}

	public static List<Object> getValuesInRow() throws IOException {
		logger.info("Starting");
		
		String tempRange = constructCurrentRange();
		String tempSpreadSheetID = "";
		switch (StandardVariables.currentlyTesting) {
		case "API":
			tempSpreadSheetID = TestSuiteVariables.apiTestSuiteGoogleSheetsID;
			break;
		case "APPIUM":
			tempSpreadSheetID = TestSuiteVariables.appiumTestSuiteGoogleSheetsID;
			break;
		case "SELENIUM":
			tempSpreadSheetID = TestSuiteVariables.seleniumTestSuiteGoogleSheetsID;
			break;
		case "JMETER":
			tempSpreadSheetID = TestSuiteVariables.jMeterTestSuiteGoogleSheetsID;
			break;
		default:
			logger.error("Could not find valid value for switch statment: StandardVariables.currentlyTesting = "
							+ StandardVariables.currentlyTesting);
			break;
		}
		logger.debug("Getting values from Google Sheet");
		ValueRange tempValueRangeResponse = GoogleSheetVariables.sheetsService.spreadsheets().values()
				.get(tempSpreadSheetID, tempRange).execute();

		List<List<Object>> tempValuesList = tempValueRangeResponse.getValues();
		List<Object> valuesInRow = tempValuesList.get(0);
		logger.info("Completed");
		return valuesInRow;
	}

	// Setup methods
	public static Credential authorize(final HttpTransport httpTransport) throws IOException {
		logger.info("Starting");
		
		// Load client secrets.
		InputStream in = GoogleSheetFunctions.class.getResourceAsStream(GoogleSheetVariables.CREDENTIALS_FILE_PATH);
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(GoogleSheetVariables.JSON_FACTORY,
				new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport,
				GoogleSheetVariables.JSON_FACTORY, clientSecrets, GoogleSheetVariables.SCOPES)
						.setDataStoreFactory(
								new FileDataStoreFactory(new java.io.File(GoogleSheetVariables.TOKENS_DIRECTORY_PATH)))
						.setAccessType("offline").build();
		LocalServerReceiver receier = new LocalServerReceiver.Builder().setPort(8888).build();
		
		logger.info("Completed");
		return new AuthorizationCodeInstalledApp(flow, receier).authorize("user");
	}

	public static Sheets createSheetsService() throws IOException, GeneralSecurityException {
		logger.info("Starting");
		
		Sheets tempSheets = new Sheets.Builder(GoogleSheetVariables.HTTP_TRANSPORT, GoogleSheetVariables.JSON_FACTORY,
				authorize(GoogleSheetVariables.HTTP_TRANSPORT)).setApplicationName("Google-SheetsSample/0.1").build();
		
		logger.info("Completed");	
		return tempSheets;		
	}

	// perform tests methods
	public static void writeToTestSuite(String resultCell, String result) throws IOException {
		logger.info("Starting");
		// resultCell needs to be in the following format "SheetName + "!" + Column +
		// Row" Ex. "TestSuite!A2"

		List<Object> resultList = new ArrayList<Object>();
		List<List<Object>> resultListOfLists = new ArrayList<List<Object>>();
		resultList.add(result);
		resultListOfLists.add(resultList);

		ValueRange body = new ValueRange().setValues(resultListOfLists);

		String tempSpreadSheetID = "";
		switch (StandardVariables.currentlyTesting) {
		case "API":
			tempSpreadSheetID = TestSuiteVariables.apiTestSuiteGoogleSheetsID;
			break;
		case "APPIUM":
			tempSpreadSheetID = TestSuiteVariables.appiumTestSuiteGoogleSheetsID;
			break;
		case "SELENIUM":
			tempSpreadSheetID = TestSuiteVariables.seleniumTestSuiteGoogleSheetsID;
			break;
		case "JMETER":
			tempSpreadSheetID = TestSuiteVariables.jMeterTestSuiteGoogleSheetsID;
			break;
		default:
			logger.error("Could not find valid value for switch statment: StandardVariables.currentlyTesting = "
							+ StandardVariables.currentlyTesting);
			break;
		}
		
		logger.debug("Results have been Written to Google Sheet ID: " + tempSpreadSheetID);
		logger.debug("Results have been Written to Sheet & Cell: " + resultCell);
		logger.debug("Results are: " + body);
		GoogleSheetVariables.sheetsService.spreadsheets().values()
				.update(tempSpreadSheetID, resultCell, body).setValueInputOption("RAW").execute();
		logger.info("Completed");
	}
}
