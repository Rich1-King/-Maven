package com.ExcelAndCSV;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by rich1 on 2/11/17.
 */
public class WorkBookClient{
    public static void main(String[] args) throws IOException, InterruptedException{
        String[] sheetNames = new String[]{"上海", "北京", "深圳", "成都"};
        HSSFWorkbook workbook = WorkBookUtils.createHSSFWorkbook();
        workbook = WorkBookUtils.addSheets(workbook, sheetNames);
        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFCellStyle style = WorkBookUtils.createHSSFCellStyle(workbook, HSSFCellStyle.ALIGN_LEFT, HSSFCellStyle.VERTICAL_CENTER);//创建单元格水平样式
        sheet.setColumnWidth(0, 1000*5);

        WorkBookUtils.mergeCell2Sheet(workbook.getSheetAt(0), 0, 5, 0, 0);
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("公司１");
        cell.setCellStyle(style);

        WorkBookUtils.mergeCell2Sheet(workbook.getSheetAt(0), 6, 11, 0, 0);
        HSSFRow row1 = sheet.createRow(6);
        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("公司2");
        cell1.setCellStyle(style);

        String fileName = "城市.xls";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        workbook.write(fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
