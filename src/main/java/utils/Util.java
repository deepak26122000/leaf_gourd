package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Util {
    public static Properties prop;
    public static Workbook wb;

    public static void loadProperty() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(("/Users/softsuave/IdeaProjects/leafground-table-bdd/config.properties"));
            prop.load(fis);
            fis.close();

        } catch (Exception e) {
            throw new RuntimeException("Could not load the property ");
        }
    }


    public static String getProperty(String key) {
        if (prop == null) {
        }
        return prop.getProperty(key);

    }

    public static void loadExcel(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            wb = WorkbookFactory.create(fis);
            fis.close();
        } catch (Exception e) {
            throw new RuntimeException("error loading the excel file");
        }
    }

    public static String getData(String sheetname, int row, int col) {
        return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
    }

    public static int lastRow(String sheetname) {
        return wb.getSheet(sheetname).getLastRowNum();
    }

    public static void writeTestData(String sheetname, int row, int col) {
        try {
            Row r = wb.getSheet(sheetname).getRow(row);
            if (r == null) {
                r = wb.getSheet(sheetname).createRow(row);
            }
            Cell c = r.getCell(col);
            if (c == null) {
                c = r.createCell(col);
            }
            c.setCellValue("used");

            FileOutputStream fos = new FileOutputStream("src/Data/testdata.xlsx");
            wb.write(fos);
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("Unable to write: " + e.getMessage());
        }
    }


}


