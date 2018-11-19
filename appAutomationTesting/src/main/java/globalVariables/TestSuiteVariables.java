package globalVariables;

public class TestSuiteVariables {
	
	public static String[] testSuiteTypes = { "Google Sheets", "Excel", "JUnit" };
	
	public static int numberOfPlatforms = 0;//How many testable platforms are on the current sheet
	public static int currentTestingPlatform = 1;//The current Platform (column) that is being tested

	public static String testingCylce  = "column"; //The value should be either "column" or "row"
	//column = testing all test cases for a single platform before moving to the next platform (ie. Testing all Chrome test cases before moving on to Edge test cases) 
	//row = Testing all platforms for a single test case before moving on to the next test case
	
	//API Test Suites
	public static boolean useAPIGoogleSheet = false;
	public static boolean useAPIExcel = false;
	public static boolean useAPIJUnit = false;
	
	public static String apiTestSuiteGoogleSheetsID = "1z1HmoHgdqRRbMd4kSXprDJOXt-0K3x0WWAdzLtOk710";
	public static String apiExcelFilePath = "";
	public static String apiJUnit = "";
	
	public static String apiTestSuiteSheetName = "TestSuite-API"; //This is for both Google Sheets and Excel
	
	//Appium Test Suites
	public static boolean useAppiumGoogleSheet = false;
	public static boolean useAppiumExcel = false;
	public static boolean useAppiumJUnit = false;
	
	public static String appiumTestSuiteGoogleSheetsID = "1z1HmoHgdqRRbMd4kSXprDJOXt-0K3x0WWAdzLtOk710";
	public static String appiumExcelFilePath = "";
	public static String appiumJUnit = "";
	
	public static String appiumTestSuiteSheetName = "TestSuite-Appium"; //This is for both Google Sheets and Excel
	
	//JMeter Test Suites
	public static boolean useJMeterGoogleSheet = false;
	public static boolean useJMeterExcel = false;
	public static boolean useJMeterJUnit = false;
	
	public static String jMeterTestSuiteGoogleSheetsID = "1z1HmoHgdqRRbMd4kSXprDJOXt-0K3x0WWAdzLtOk710";
	public static String jMeterExcelFilePath = "";
	public static String jMeterJUnit = "";
	
	public static String jMeterTestSuiteSheetName = "TestSuite-JMeter"; //This is for both Google Sheets and Excel
	
	//Selenium Test Suites
	public static boolean useSeleniumGoogleSheet = false;
	public static boolean useSeleniumExcel = false;
	public static boolean useSeleniumJUnit = false;
	
	public static String seleniumTestSuiteGoogleSheetsID = "1z1HmoHgdqRRbMd4kSXprDJOXt-0K3x0WWAdzLtOk710";
	public static String seleniumExcelFilePath = "";
	public static String seleniumJUnit = "";
	
	public static String seleniumTestSuiteSheetName = "TestSuite-Selenium"; //This is for both Google Sheets and Excel
}
