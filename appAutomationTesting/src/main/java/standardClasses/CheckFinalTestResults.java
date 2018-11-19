package standardClasses;

public class CheckFinalTestResults {
	public static boolean checkMatchingValues(String testHeading, Object actualValue, Object expectedValue) {
		String successMessage = "\t* The Expected and Actual Values match. (PASS)\n";
		String failureMessage = "\t* The Expected and Actual Values do not match! (FAIL)\n";

		boolean doValuesMatch = false;

		System.out.println(testHeading);
		System.out.println("\t* Expected Value: " + expectedValue);
		System.out.println("\t* Actual Value: " + actualValue);

		if (actualValue.equals(expectedValue)) {
			System.out.println(successMessage);
			doValuesMatch = true;
		} else {
			System.out.println(failureMessage);
			doValuesMatch = false;
		}
		return doValuesMatch;
	}
}
