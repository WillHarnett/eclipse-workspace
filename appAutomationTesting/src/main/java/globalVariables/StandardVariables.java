package globalVariables;

public class StandardVariables {
	public static boolean carryOutTesting = true;
	
	public static boolean carryOutApiTesting = true;
	public static boolean carryOutAppiumTesting = true;
	public static boolean carryOutJMeterTesting = true;
	public static boolean carryOutSeleniumTesting = true;
	
	public static String currentlyTesting = "";
	
	public static int numberOfTestTypes = 5;//This is simply the total number of Different types of tests there are (Api, Stress, Appium etc.)
	
	public static int[] prioritiyTestCasesToTest = new int[numberOfTestTypes];//The different priority for each different test type
}
