package com.ExcelAndCSV;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by rich1 on 4/9/17.
 */
public class ThreadExcelClient{

    public static void main(String[] args){
        Long beginTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("开始时间:"+ Calendar.getInstance().getTimeInMillis());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8,10,200,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        SXSSFWorkbook workbook = WorkBookUtils.createSXSSFWorkbook(10000);

        SXSSFSheet sheet = WorkBookUtils.addSheet(workbook, "测试数据量");
        for(int i=0; i<1; i++){
            System.out.println("开始"+i);
            ExcelThread thread = new ExcelThread();
            thread.setNum(i);
            thread.setSheet(sheet);
            threadPoolExecutor.submit(thread);
        }
        threadPoolExecutor.shutdown();
        try{
            // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔10秒循环一次
            while (!threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("over");
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("1.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            workbook.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("结束时间:"+Calendar.getInstance().getTimeInMillis());
        Long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("消耗时间:"+(endTime-beginTime));

    }
}
