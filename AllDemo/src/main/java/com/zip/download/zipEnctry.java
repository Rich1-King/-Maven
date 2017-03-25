package com.zip.download;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by rich1 on 12/24/16.
 */
public class zipEnctry{
    public static void main(String[] args){
        try{
            Zip4JEncryFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //压缩加密
    public static void Zip4JEncryFile() throws Exception{
        ZipFile zipFile = new ZipFile(System.getProperty("user.dir")+"/encryZip.zip");
        ArrayList<File> fileList = new ArrayList();
        fileList.add(new File(System.getProperty("user.dir")+"/1_encry.txt"));
        fileList.add(new File(System.getProperty("user.dir")+"/1.txt"));
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        parameters.setEncryptFiles(true);

        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);


        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        parameters.setPassword("123");

        zipFile.addFiles(fileList, parameters);

    }

    //解压有密码的文件
    public static void Zip4JDecrypFile() throws Exception{
        try {
            ZipFile zipFile = new ZipFile("/home/rich1/code/java/project/AllDemo/encryZip.zip");
            if(zipFile.isEncrypted()){
                zipFile.setPassword("123");
            }
            zipFile.extractAll("/home/rich1/code/java/project/AllDemo");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
