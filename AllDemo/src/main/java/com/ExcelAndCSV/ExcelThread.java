package com.ExcelAndCSV;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;

/**
 * Created by rich1 on 4/9/17.
 */
public class ExcelThread implements Runnable{
    private SXSSFSheet sheet;
    private Integer num;

    @Override
    public void run(){
        try{
            for (int i = 0; i < 1000000; i++){
                synchronized (sheet){
                    int lastRow = sheet.getLastRowNum();
                    SXSSFRow row = sheet.createRow(lastRow + 1);
                    row.createCell(0).setCellValue(num.toString());
                    row.createCell(1).setCellValue(i);
                    row.createCell(2).setCellValue("sunchong");
                    row.createCell(3).setCellValue("18239506520");
                }
            }
        }catch (Exception e){
            System.out.println("线程出现异常");
            e.printStackTrace();
        }
        System.out.println(num+"over");
    }

    public void setNum(Integer num){
        this.num = num;
    }

    public void setSheet(SXSSFSheet sheet){
        this.sheet = sheet;
    }
}
