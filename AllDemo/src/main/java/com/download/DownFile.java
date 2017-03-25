package com.download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rich1 on 6/2/16.
 */
public class DownFile{

    public static void main(String[] args)
    {
        //String path = "https://ss0.bdstatic
        // .com/l4oZeXSm1A5BphGlnYG/skin/611.jpg?2";
        String path = "http://schongking.cn/Image/beijing.JPG";
       // String path = "/home/rich1/Pictures/1.jpg";
        try
        {
            new DownFile().download(path, 3);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param path 下载路径
     * @param threadsize 下载线程个数
     * @throws IOException
     */
    public void download(String path, int threadsize) throws IOException{
        try
        {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setReadTimeout(5*1000);
            int fileLength = conn.getContentLength();
            //String fileName = getFilename(path);
            String fileName = "/home/rich1/Pictures/3.jpg";
            File saveFile = new File(fileName);
            int block = fileLength % threadsize == 0 ? fileLength /
                    threadsize : fileLength / threadsize + 1; //每个线程下载大小
            for(int threadid=0; threadid < threadsize; threadid++)
            {
                new DownloadThread(url, saveFile, block, threadid).start();
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    public static String getFilename(String path)
    {
        return path.substring(path.lastIndexOf('/')+1);
    }

    private final class DownloadThread extends Thread
    {
        private URL url; //下载地址
        private File saveFile; //下载保存路径
        private int block; //下载块大小
        private int threadid; //线程编号

        public DownloadThread(URL url, File saveFile, int block, int threadid)
        {
            this.url = url;
            this.saveFile = saveFile;
            this.block = block;
            this.threadid = threadid;
        }

        public void run()
        {
            int startposition = threadid * block; //下载开始位置
            int endposition = (threadid+1)*block - 1; //下载结束位置
            try
            {
                try
                {
                    RandomAccessFile accessFile = new RandomAccessFile
                            (saveFile, "rwd");
                    accessFile.seek(startposition);
                    HttpURLConnection conn = (HttpURLConnection)url
                            .openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5*1000);
                    conn.setRequestProperty("RANGE", "bytes=" + startposition
                            + "-" + endposition);
                    InputStream inStream = conn.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while((len = inStream.read(buffer)) != -1)
                    {
                        accessFile.write(buffer, 0, len);
                    }
                    inStream.close();
                    accessFile.close();
                    System.out.println("线程id: " + threadid + "下载完成" + "RANGE"+"   bytes=" + startposition
                            + "-" + endposition);

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }
}
