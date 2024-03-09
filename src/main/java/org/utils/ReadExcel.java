package org.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ReadExcel {

    // write the code to read the data from the excel sheet and pass the data to the test method
    public Map<String, Map<String, String>> readExcel(String sheetname) {
        File filepath = new File(System.getProperty("user.dir") + "/src/test/resources/Readexcel.xlsx");
        Map<String, Map<String, String>> completesheetdata = new HashMap<String, Map<String, String>>();
        try {
            FileInputStream file = new FileInputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetname);
            int rowcount = sheet.getLastRowNum();
            int colcount = sheet.getRow(0).getLastCellNum();
            List<String> columnheader = new ArrayList<String>();
            Row columnrow = sheet.getRow(0);
            Iterator<Cell> cellIterator = columnrow.cellIterator();
            while (cellIterator.hasNext()) {
                columnheader.add(cellIterator.next().getStringCellValue());
            }
            for (int i = 1; i <=rowcount; i++) {
                HashMap<String, String> singlerowdata = new HashMap<String, String>();
                Row datarow = sheet.getRow(i);
                for (int j = 0; j < colcount; j++) {
                    Cell cell = datarow.getCell(j);
                    CellType celltype = cell.getCellType();
                    switch (celltype) {
                        case STRING:
                            singlerowdata.put(columnheader.get(j), cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            singlerowdata.put(columnheader.get(j), String.valueOf(cell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            singlerowdata.put(columnheader.get(j), String.valueOf(cell.getBooleanCellValue()));
                            break;
                    }
                }
                completesheetdata.put(String.valueOf(i), singlerowdata);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return completesheetdata;
    }

    public static void main(String[] args) {
        ReadExcel readExcel = new ReadExcel();
        Map<String, Map<String, String>> excelData =readExcel.readExcel("Sheet1");
        System.out.println("Excel Data for 2nd row and column- username : "+excelData.get("2").get("username"));
        System.out.println("excelData as Map: "+excelData);

    }
}
