package globalVariables;

import java.util.List;

public class ReportingVariables {
	String[] testCasesReportingFilePaths;
	String[] quickReportingFilePath;

	int numberOfRequiredTestRuns = 0;
	int numberOfCompletedTestRuns = 0;
	int averageRunTime = 0;
	int maxRunTime = 0;
	int minRunTime = 0;

	int totalAttemptedTestCases = 0;
	int maxFailedTestCases = 0;
	int minFailedTestCases = 0;
	int averageNumberOfFailedTestCases = 0;

	int testCasesAttemtedTotal = 0;
	int testCasesPassedTotal = 0;
	int testCasesFailedTotal = 0;
	int testCasesNITotal = 0;
	int testCasesNATotal = 0;

	int priority1TestCasesTotal = 0;
	int priority2TestCasesTotal = 0;
	int priority3TestCasesTotal = 0;
	int priority4TestCasesTotal = 0;
	int priority5TestCasesTotal = 0;
}

class AppiumReporting extends ReportingVariables {
	List<String> platformsTitles;

	int[] attemptedTestCasesPerPlatform;

	int NumberOfPlatforms = 0;
}
class SeleniumReporting extends ReportingVariables {
}
class JmeterReporting extends ReportingVariables {
}
class APIReporting extends ReportingVariables {
}