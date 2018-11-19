package workingWithTestSuites;

import java.util.ArrayList;
import java.util.List;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.sheets.v4.Sheets;

public class GoogleSheetVariables {

	public static String APPLICATION_NAME = "APITest";
	public static String TOKENS_DIRECTORY_PATH = "tokens";
	public static String CREDENTIALS_FILE_PATH = "/Credentials.json";

	//If you modify t4h Scopes varibale, delete the /tokens folder 
	public static List<String> SCOPES = new ArrayList<String>();
	public static JsonFactory JSON_FACTORY = null;
	public static HttpTransport HTTP_TRANSPORT = null;
	public static Sheets sheetsService = null;
	
	//Standard googleSheets Variables
	public static String testSuiteNameAndRangeDivider = "!";
	public static String startColumnAndEndColumnDivider = ":";
	public static String firstColumn = "A";
	public static String lastColumn = "ZZZ";
	public static int currentRow = 1;
	
	public static List<String> columnTitles = new ArrayList<String>();
	public static List<String> eachPlatformColumn = new ArrayList<String>();
	public static List<String> sheetTestPlatformTitles = new ArrayList<String>();
	
	//Standard int columns
	public static int flagColumnPos = 0;
	public static int typeColumnPos = 0;
	public static int testCaseNumberColumnPos = 0;
	public static int priorityColumnPos = 0;
	public static int screenColumnPos = 0;
	public static int largeColumnPos = 0;
	public static int mediumColumnPos = 0;
	public static int smallColumnPos = 0;
	public static int stepsColumnPos = 0;
	public static int keywordsColumnPos = 0;
	public static int expectedResultsColumnPos = 0;
	public static int testDataColumnPos = 0;
	public static int ticketColumnPos = 0;
	public static int preTicketColumnPos = 0;
	public static int commentColumnPos = 0;
	
	//Standard String Columns
	public static String flagColumn = "";
	public static String typeColumn = "";
	public static String testCaseNumberColumn = "";
	public static String priorityColumn = "";
	public static String screenColumn = "";
	public static String largeColumn = "";
	public static String mediumColumn = "";
	public static String smallColumn = "";
	public static String stepsColumn = "";
	public static String keywordsColumn = "";
	public static String expectedResultsColumn = "";
	public static String testDataColumn = "";
	public static String ticketColumn = "";
	public static String preTicketColumn = "";
	public static String commentColumn = "";
	
	//Platform int Columns
	public static int iPhoneColumnPos = 0;
	public static int iPadColumnPos = 0;
	public static int androidColumnPos = 0;
	public static int androidTabletColumnPos = 0;
	public static int chromeColumnPos = 0;
	public static int firefoxColumnPos = 0;
	public static int edgeColumnPos = 0;
	public static int ieColumnPos = 0;
	public static int safariColumnPos = 0;
	public static int jMeterColumnPos = 0;
	public static int apiColumnPos = 0;
	
	public static int testerAColumnPos = 0;
	public static int testerBColumnPos = 0;
	public static int testerCColumnPos = 0;
	public static int testerDColumnPos = 0;
	public static int testerEColumnPos = 0;
	public static int testerFColumnPos = 0;
	public static int testerGColumnPos = 0;
	public static int testerHColumnPos = 0;
	public static int testerIColumnPos = 0;
	public static int testerJColumnPos = 0;
	public static int testerKColumnPos = 0;
	
	public static int versionAColumnPos = 0;
	public static int versionBColumnPos = 0;
	public static int versionCColumnPos = 0;
	public static int versionDColumnPos = 0;
	public static int versionEColumnPos = 0;
	public static int versionFColumnPos = 0;
	public static int versionGColumnPos = 0;
	public static int versionHColumnPos = 0;
	public static int versionIColumnPos = 0;
	public static int versionJColumnPos = 0;
	public static int versionKColumnPos = 0;
	
	public static int dateAColumnPos = 0;
	public static int dateBColumnPos = 0;
	public static int dateCColumnPos = 0;
	public static int dateDColumnPos = 0;
	public static int dateEColumnPos = 0;
	public static int dateFColumnPos = 0;
	public static int dateGColumnPos = 0;
	public static int dateHColumnPos = 0;
	public static int dateIColumnPos = 0;
	public static int dateJColumnPos = 0;
	public static int dateKColumnPos = 0;
	
	//Platform String Columns
	public static String iPhoneColumn = "";
	public static String iPadColumn = "";
	public static String androidColumn = "";
	public static String androidTabletColumn = "";
	public static String chromeColumn = "";
	public static String firefoxColumn = "";
	public static String edgeColumn = "";
	public static String ieColumn = "";
	public static String safariColumn = "";
	public static String jMeterColumn = "";
	public static String apiColumn = "";
	
	public static String testerAColumn = "";
	public static String testerBColumn = "";
	public static String testerCColumn = "";
	public static String testerDColumn = "";
	public static String testerEColumn = "";
	public static String testerFColumn = "";
	public static String testerGColumn = "";
	public static String testerHColumn = "";
	public static String testerIColumn = "";
	public static String testerJColumn = "";
	public static String testerKColumn = "";
	
	public static String versionAColumn = "";
	public static String versionBColumn = "";
	public static String versionCColumn = "";
	public static String versionDColumn = "";
	public static String versionEColumn = "";
	public static String versionFColumn = "";
	public static String versionGColumn = "";
	public static String versionHColumn = "";
	public static String versionIColumn = "";
	public static String versionJColumn = "";
	public static String versionKColumn = "";
	
	public static String dateAColumn = "";
	public static String dateBColumn = "";
	public static String dateCColumn = "";
	public static String dateDColumn = "";
	public static String dateEColumn = "";
	public static String dateFColumn = "";
	public static String dateGColumn = "";
	public static String dateHColumn = "";
	public static String dateIColumn = "";
	public static String dateJColumn = "";
	public static String dateKColumn = "";

}
