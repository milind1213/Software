package TestComponents;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class DataDriven {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/home/milind/Desktop/Frameworks/Software/resources/TestData/caldata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int numberOfSheets = workbook.getNumberOfSheets();
        System.out.println("Number of sheets in the workbook: " + numberOfSheets);

        for (int i = 0; i < numberOfSheets; i++) {
            String sheetName = workbook.getSheetName(i);
            System.out.println("Sheet name at index " + i + ": " + sheetName);

            if (sheetName.equalsIgnoreCase("firstSheet")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                System.out.println("Found 'firstSheet': " + sheet);
                Iterator<Row> rows = sheet.iterator();
                Row frstrow = rows.next();
                Iterator<Cell> cl = frstrow.cellIterator();
                int column = 0;
                int k = 0;

                // Find the column index where "Principle" is located
                while (cl.hasNext()) {
                    Cell value = cl.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Maturity Value")) {
                        column = k;
                    }
                    k++;
                }

                System.out.println("Column index for 'Principle': " + column);

                // Iterate through rows to find the cell with value "75001" in the 'Principle' column
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equals("75001")) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            System.out.println(cv.next().getStringCellValue());
                        }
                    }
                }
            }
        }
    }
}
