package standardClasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import runAutomation.RunAutomation;

public class Converter {

	// This method returns the letter corresponding with a number.
	// This is mainly used to convert Array positions into Columns for Excel and
	// Google Sheets.
	
	static Logger logger = LoggerFactory.getLogger(RunAutomation.class);
	
	public static String numbersToLetters(int position) {
		logger.info("Starting");
		String range = "";
		int tempInt = 0;
		logger.debug("Column Numeric Position:    " + position);
		
		String upperCaseAlphabet = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		while (position > 0) {
			if (position > upperCaseAlphabet.length() - 1) {
				tempInt = 1;
				position = position - (upperCaseAlphabet.length() - 1);
			} else {
				tempInt = position;
				position = position - tempInt;
			}
			logger.debug("Remainder: " + position);
			range = range + Character.toString(upperCaseAlphabet.charAt(tempInt));
		}
		logger.debug("Column Alphabetic Position: " + range);
		logger.info("Completed");
		return range;
	}
}
