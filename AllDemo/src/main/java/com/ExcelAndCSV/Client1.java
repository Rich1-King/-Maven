package com.ExcelAndCSV;

import java.util.List;
import java.util.Map;

/**
 * Created by sunchong on 2016/11/16.
 */
public class Client1{

    public static void main(String[] args){
        ExcelAndCSVUtils excelAndCSVUtils = new ExcelAndCSVUtils();
        List<Map> mapList = excelAndCSVUtils.readNullExcel();
        System.out.println("没有工商注册号的读取完毕");

        excelAndCSVUtils.writeExcel(mapList);
        System.out.println("写入完成");

    }
}
