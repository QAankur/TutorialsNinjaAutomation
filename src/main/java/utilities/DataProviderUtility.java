package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderUtility {

	public static Object[][] provideData(String requiredSheetName) {
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		try {
			fis = new FileInputStream(
					"C:\\Users\\Anuj\\Selenium_Utilities\\TutorialsNinja_Automation_Framework\\src\\main\\java\\resources\\DataTest.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("userRegistration");
		int noofrows = sheet.getPhysicalNumberOfRows();
		int noofcols = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] object = new Object[noofrows - 1][noofcols];
		for (int i = 0; i < noofrows - 1; i++) {
			for (int j = 0; j < noofcols; j++) {
				if (sheet.getRow(i + 1).getCell(j).getCellType() == CellType.STRING) {
					object[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
				} else if (sheet.getRow(i + 1).getCell(j).getCellType() == CellType.NUMERIC) {
					object[i][j] = NumberToTextConverter.toText(sheet.getRow(i + 1).getCell(j).getNumericCellValue());
				}
			}
			System.out.println(" ");
		}

		return object;

	}
}
