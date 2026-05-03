package api.Utilities;

	import java.io.FileInputStream;
	import java.util.HashMap;
	import java.util.Map;

	//import org.apache.poi.sl.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReader {

		    public static Map<String, String> getTestData(String sheetname,String scenarioType) {
		        Map<String, String> dataMap = new HashMap<>();

		        try {
		            FileInputStream fis = new FileInputStream("src/test/resources/testData/Team5Data.xlsx");
		            XSSFWorkbook workbook = new XSSFWorkbook(fis);
		            XSSFSheet sheet = workbook.getSheet(sheetname);

		            Row headerRow = sheet.getRow(0);

		            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		                Row currentRow = sheet.getRow(i);

		                if (currentRow.getCell(0).getStringCellValue().equalsIgnoreCase(scenarioType)) {

		                    for (int j = 0; j < currentRow.getLastCellNum(); j++) {
		                        String key = headerRow.getCell(j).getStringCellValue();
		                        String value = new DataFormatter().formatCellValue(currentRow.getCell(j));

		                        dataMap.put(key, value);
		                    }
		                    break;
		                }
		            }

		            workbook.close();

		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        return dataMap;
		    }
		}


	
	
	

