package standardClasses;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import runAutomation.RunAutomation;

public class Parser {
	static Logger logger = LoggerFactory.getLogger(RunAutomation.class);
	
	public static List<String> parse(String stringToBeParsed){
		List<String> tempList = new ArrayList<String>();
		logger.info("Starting");
		logger.debug("String to be Parsed: " + stringToBeParsed);
		String[] keywordArray = stringToBeParsed.split(" ");    

		for ( String keywords : keywordArray) {
			tempList.add(keywords);
			logger.debug("Parsed Results: " + keywords);
		}
		logger.info("Completed");
		return tempList;	
	}
}