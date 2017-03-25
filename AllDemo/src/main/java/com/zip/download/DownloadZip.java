package com.zip.download;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by sunchong on 2016/8/5.
 */
public class DownloadZip{

    public static void main(String[] args){

        File file = new File("E:\\othercode\\AllDemo\\1.txt");
        File zipFile = new File("Download.zip");

        ZipOutputStream zipOutputStream = null;
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try{
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
            fileInputStream = new FileInputStream(file);
            byte[] bufferArea = new byte[1024 * 10];

            ZipEntry zipEntry = new ZipEntry("zip1.txt");
            zipOutputStream.putNextEntry(zipEntry);
            bufferedInputStream = new BufferedInputStream(fileInputStream,1024 * 10);
            int read = 0;

            while ((read = bufferedInputStream.read(bufferArea,0 ,1024 * 10)) != -1){
                zipOutputStream.write(bufferArea, 0, read);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                zipOutputStream.close();
                fileInputStream.close();
                bufferedInputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
