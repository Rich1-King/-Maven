package com.captcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Random;

/**
 * Created by sunchong on 2016/11/7.
 */
public class CaptachaUtil{
    private Captacha captacha;
    private int width = 160;
    private int height = 40;
    private int codeCount = 5;
    private int lineCount = 300;

    private String code = null;

    private BufferedImage bufferedImage = null;

    private char[] codeValues={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9','0'};


    public void createCaptha(){
        int x=0, fontHeight=0, codeY=0;
        int red=0, green=0, blue=0;

        x = width / (codeCount +2);
        fontHeight = height -2;

        codeY = height -4;

        bufferedImage = new BufferedImage(width, height, bufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        Random random = new Random();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        Font font = new Font("Arial", Font.PLAIN, fontHeight);
        g.setFont(font);

        for(int i=0; i<lineCount; i++){
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width/8);
            int ye = ys + random.nextInt(height/8);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawLine(xs,ys,xe,ye);
        }

        StringBuffer stringBuffer = new StringBuffer();

        for(int i=0; i<codeCount; i++){
            String strRand = String.valueOf(codeValues[random.nextInt(codeValues.length)]);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, (i+1)*x, codeY);
            stringBuffer.append(strRand);
        }
        code = stringBuffer.toString();
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException{
        ImageIO.write(bufferedImage,"png",sos);
        sos.close();
    }

    public String getCaptha() throws IOException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        this.write(out);
        return new String(Base64.getEncoder().encode(out.toByteArray()));
    }

    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }

    public String getCode(){
        return code;
    }

    public Captacha getCaptacha() throws IOException{
        this.captacha.setCode(getCode());
        this.captacha.setBase64Image(getCaptha());
        return this.captacha;
    }

}
