package com.ExcelAndCSV;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by rich1 on 2/11/17.
 */
public class WorkBookUtils{

    public static HSSFWorkbook createHSSFWorkbook(){
        HSSFWorkbook workbook = new HSSFWorkbook();
        return workbook;
    }

    public static XSSFWorkbook createXSSFWorkbook(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        return workbook;
    }

    //存储大数据量的workbook
    public static SXSSFWorkbook createSXSSFWorkbook(int rowNum){
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(rowNum);
        return sxssfWorkbook;
    }

    public static SXSSFWorkbook createSXSSFWorkbook(XSSFWorkbook workbook, int rowNum){
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook, rowNum);
        return sxssfWorkbook;
    }

    public static SXSSFSheet addSheet(SXSSFWorkbook workbook,String sheetName){
        return workbook.createSheet(sheetName);
    }

    //添加sheet
    public static SXSSFWorkbook addSheets(SXSSFWorkbook workbook, String[] sheetNames){
        for(String sheetName : sheetNames){
            workbook.createSheet(sheetName);
        }
        return workbook;
    }

    public static HSSFSheet addSheet(HSSFWorkbook workbook, String sheetName){
        return workbook.createSheet(sheetName);
    }

    //添加sheet
    public static HSSFWorkbook addSheets(HSSFWorkbook workbook, String[] sheetNames){
        for(String sheetName : sheetNames){
            workbook.createSheet(sheetName);
        }
        return workbook;
    }

    public static void mergeCell2Sheet(HSSFSheet sheet, int rowBegin, int rowEnd, int cloumnBegin, int cloumnEnd){
        CellRangeAddress cellRangeAddress = new CellRangeAddress(rowBegin, rowEnd, cloumnBegin, cloumnEnd);
        sheet.addMergedRegion(cellRangeAddress);
    }

    public static HSSFCell createCell(HSSFSheet sheet, int rowNum, int columnNum){
        HSSFRow row = sheet.createRow(rowNum);
        HSSFCell cell = row.createCell(columnNum);
        return cell;
    }

    //设置居中格式
    public static HSSFCellStyle createHSSFCellStyle(HSSFWorkbook workbook,short alignment, short verticalAlignment){
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFCellStyle cellStyle1 = workbook.createCellStyle(); //不同的style
        cellStyle.setAlignment(alignment);
        cellStyle.setVerticalAlignment(verticalAlignment);
        return cellStyle;
    }
}
