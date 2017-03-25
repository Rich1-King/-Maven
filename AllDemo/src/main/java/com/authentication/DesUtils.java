package com.authentication;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Created by sunchong on 2016/11/9.
 */
public class DesUtils{

    //定义加密算法
    private static String DES = "DES";

    /**
     * 加密
     * @param data
     * @param key 密钥, 最少8个字节
     * @return
     * @throws Exception
     */
    public String encrypt(String data, String key) throws Exception{
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        return Base64.getEncoder().encodeToString(bt);
    }

    /**
     * 解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public String decrypt(String data, String key) throws Exception{
        if(data == null){
            return null;
        }
        byte[] buf = Base64.getDecoder().decode(data);
        byte[] bt = decrypt(buf, key.getBytes());
        return new String(bt);
    }


    private static byte[] encrypt(byte[] data, byte[] key) throws Exception{
        SecureRandom secureRandom = new SecureRandom();
        DESKeySpec deSedeKeySpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey secretKey = keyFactory.generateSecret(deSedeKeySpec);
        //加密操作对象
        Cipher cipher = Cipher.getInstance(DES);
        //用秘钥初始化cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);
        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception{
        SecureRandom sr = new SecureRandom();
        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance(DES);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);
        return cipher.doFinal(data);

    }



}
