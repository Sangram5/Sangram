package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Read
  {
	public static Workbook book;
	public static Sheet sheet;
	public static Cell cell;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\sangram.patil\\Desktop\\DICOM\\DICOM.xlsx";

	public static Object[][] getTestData(String sheetName) {
		// fetch the data from excel sheet:

		FileInputStream file = null;

		try {
			
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			
			book = WorkbookFactory.create(file);
			
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i <sheet.getLastRowNum(); i++) {
			
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				Cell _cell = sheet.getRow(i + 1).getCell(k);
				_cell.setCellType(Cell.CELL_TYPE_STRING);
					data[i][k] = _cell.toString();
			}
		}
		return data;

	}
	 
	
  }
