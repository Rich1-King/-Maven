package com.ExcelAndCSV;

import au.com.bytecode.opencsv.CSVWriter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sunchong on 2016/11/15.
 */
public class ExcelAndCSVUtils{

    public void readExcel(){
        String url = "";

        Workbook workbook = null;
        FileInputStream fileInputStream = null;
        List<String> companyList = new ArrayList<String>();
        try{
            fileInputStream = new FileInputStream(url);
            workbook = new HSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for(Row row : sheet){
                if(row.getRowNum() < 1){
                    continue;
                }
                String companyName = row.getCell(3).getStringCellValue();
                companyList.add(companyName);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void excel2csv(){
        try{
            String xlsPath = "";
            String csvFilePath = "";

            CSVWriter writer = null;
            File tempFile = null;
            FileWriter fwriter = null; // 写数据
            try{
                tempFile = new File(csvFilePath);
                fwriter = new FileWriter(tempFile);
                writer = new CSVWriter(fwriter);
            }catch(IOException ioex){
                ioex.printStackTrace();
            }
            /*读取Excel文件时，首先生成一个POIFSFileSystem对象，
             * 由POIFSFileSystem对象构造一个HSSFWorkbook，
             * 该HSSFWorkbook对象就代表了Excel文档*/
            POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(xlsPath));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);


            HSSFRow row = null;
            HSSFCell cell = null;
            String cellStr = "";

            //循环读取行与列的值,并将值写入CSV文件
            for(int i=0;i<=sheet.getLastRowNum();i++){
                row = sheet.getRow(i);
                String[] cellArray = new String[row.getLastCellNum()];
                for(int j=0;j<row.getLastCellNum();j++){
                    cell = row.getCell((short) j);
                    // 判断储存格的格式
                    if (cell == null){
                        cellStr = "";
                    }else {
                        switch (cell.getCellType()) {
                            case HSSFCell.CELL_TYPE_NUMERIC://数字格式
                                cellStr = cell.getNumericCellValue() + "";
                                // getNumericCellValue()会回传double值，若不希望出现小数点，请自行转型为int
                                break;
                            case HSSFCell.CELL_TYPE_STRING://字符格式
                                cellStr = cell.getStringCellValue();
                                break;
                            // case HSSFCell.CELL_TYPE_FORMULA:
                            // System.out.print(cell.getNumericCellValue());
                            // //读出公式储存格计算後的值
                            // //若要读出公式内容，可用cell.getCellFormula()
                            // break;
                            default://不明的格式
                                break;
                        }
                    }
                    System.out.println("-----row-"+i+"-----cell-"+j+"---:"+cellStr);
                    cellArray[j] = cellStr;
                }
                writer.writeNext(cellArray);// 把Excel一行记录写入CSV文件
            }

            fwriter.flush();
            fwriter.close();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Map> readCSV(){
        try{
            FileInputStream fins = new FileInputStream("");//填写文件名*.csv
            InputStreamReader gbReader = new InputStreamReader(fins,"GBK");
            BufferedReader reader = new BufferedReader(gbReader);//换成你的文件名
            reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            List<String> companyName = new ArrayList<String>();
            String line = null;
            List<Map> mapList = new ArrayList<Map>();
            while ((line = reader.readLine()) != null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分

                String last = item[2];//这就是你要的数据了
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                companyName.add(last);

                Map map = new HashMap();
                map.put("id",deleteTwoQuotationsOfString(item[0]));
                map.put("balance",deleteTwoQuotationsOfString(item[1]));
                map.put("companyName",deleteTwoQuotationsOfString(item[2]));
                map.put("createTime",deleteTwoQuotationsOfString(item[3]));
                map.put("version",deleteTwoQuotationsOfString(item[4]));
                map.put("emailCCs",deleteTwoQuotationsOfString(item[5]));
                map.put("emailTos",deleteTwoQuotationsOfString(item[6]));
                map.put("isSend",deleteTwoQuotationsOfString(item[7]));
                map.put("principal",deleteTwoQuotationsOfString(item[8]));
                map.put("ischeck",deleteTwoQuotationsOfString(item[9]));
                map.put("location",deleteTwoQuotationsOfString(item[10]));
                map.put("isBill",deleteTwoQuotationsOfString(item[11]));
                map.put("name",deleteTwoQuotationsOfString(item[12]));
//                map.put("businessRegistrationNumber",item[13]);
//                map.put("additionalInformation",item[14]);
                mapList.add(map);
            }
            return mapList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void writeExcel(List<Map> map){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-HH");
        Calendar calendar = Calendar.getInstance();
        String date = simpleDateFormat.format(calendar.getTime());
        String filePath = "";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("balance");
        row.createCell(2).setCellValue("companyName");
        row.createCell(3).setCellValue("createTime");
        row.createCell(4).setCellValue("version");
        row.createCell(5).setCellValue("emailCCs");
        row.createCell(6).setCellValue("emailTos");
        row.createCell(7).setCellValue("isSend");
        row.createCell(8).setCellValue("principal");
        row.createCell(9).setCellValue("ischeck");
        row.createCell(10).setCellValue("location");
        row.createCell(11).setCellValue("isBill");
        row.createCell(12).setCellValue("name");
        row.createCell(13).setCellValue("businessRegistrationNumber");
        row.createCell(14).setCellValue("additionalInformation");

        for (int i = 1; i <= map.size(); i++){
            try{
                Row row1 = sheet.createRow(i);
                row1.createCell(0).setCellValue(map.get(i - 1).get("id").toString());
                row1.createCell(1).setCellValue(map.get(i - 1).get("balance").toString());
                row1.createCell(2).setCellValue(map.get(i - 1).get("companyName").toString());
                row1.createCell(3).setCellValue(map.get(i - 1).get("createTime").toString());
                row1.createCell(4).setCellValue(map.get(i - 1).get("version").toString());
                row1.createCell(5).setCellValue(map.get(i - 1).get("emailCCs").toString());
                row1.createCell(6).setCellValue(map.get(i - 1).get("emailTos").toString());
                row1.createCell(7).setCellValue(map.get(i - 1).get("isSend").toString());
                row1.createCell(8).setCellValue(map.get(i - 1).get("principal").toString());
                row1.createCell(9).setCellValue(map.get(i - 1).get("ischeck").toString());
                row1.createCell(10).setCellValue(map.get(i - 1).get("location").toString());
                row1.createCell(11).setCellValue(map.get(i - 1).get("isBill").toString());
                row1.createCell(12).setCellValue(map.get(i - 1).get("name").toString());
                row1.createCell(13).setCellValue(map.get(i - 1).get("businessRegistrationNumber").toString());
                row1.createCell(14).setCellValue(map.get(i - 1).get("additionalInformation").toString());
            }catch (Exception e){
                continue;
            }
        }


        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            workbook.close();
            fileOutputStream.close();
        }catch (IOException e){
            System.out.println("失败");
        }
    }

    /**
     * 如果字符串开头和结尾具有引号，那么将两边的引号删除
     * @param str
     */
    public String deleteTwoQuotationsOfString(String str){
        if(str.indexOf("\"")==0){
            str = str.substring(1,str.length());
        }
        if(str.lastIndexOf("\"")==(str.length()-1)){
            str = str.substring(0,str.length() - 1);
        }
        return str;
    }


    public List<Map> readNullExcel(){
        String url = "";

        Workbook workbook = null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(url);
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            List<Map> mapList = new ArrayList<Map>();
            for(Row row : sheet){
                if(row.getRowNum() < 1){
                    continue;
                }
                Map map = new HashMap();
                try{
                    double d = row.getCell(13).getNumericCellValue();
                }catch (Exception e){
                    map.put("id",deleteTwoQuotationsOfString(row.getCell(0).getStringCellValue()));
                    map.put("balance",deleteTwoQuotationsOfString(row.getCell(1).getStringCellValue()));
                    map.put("companyName",deleteTwoQuotationsOfString(row.getCell(2).getStringCellValue()));
                    map.put("createTime",deleteTwoQuotationsOfString(row.getCell(3).getStringCellValue()));
                    map.put("version",deleteTwoQuotationsOfString(row.getCell(4).getStringCellValue()));
                    map.put("emailCCs",deleteTwoQuotationsOfString(row.getCell(5).getStringCellValue()));
                    map.put("emailTos",deleteTwoQuotationsOfString(row.getCell(6).getStringCellValue()));
                    map.put("isSend",deleteTwoQuotationsOfString(row.getCell(7).getStringCellValue()));
                    map.put("principal",deleteTwoQuotationsOfString(row.getCell(8).getStringCellValue()));
                    map.put("ischeck",deleteTwoQuotationsOfString(row.getCell(9).getStringCellValue()));
                    map.put("location",deleteTwoQuotationsOfString(row.getCell(10).getStringCellValue()));
                    map.put("isBill",deleteTwoQuotationsOfString(row.getCell(11).getStringCellValue()));
                    map.put("name",deleteTwoQuotationsOfString(row.getCell(12).getStringCellValue()));
                    map.put("businessRegistrationNumber","");
                    map.put("additionalInformation",deleteTwoQuotationsOfString(row.getCell(14).getStringCellValue()));
                    mapList.add(map);
                }
            }
            return mapList;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
