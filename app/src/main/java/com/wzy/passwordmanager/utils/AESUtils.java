package com.wzy.passwordmanager.utils;

import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * =================================================================
 * <p>
 * 版    权：WZY 版权所有 (c) 2015
 * <p>
 * 作    者：lmejojo
 * <p>
 * 版    本：1.0
 * <p>
 * 创建日期： 2016/4/21 0021 14:59
 * <p>
 * 描    述：
 * <p>
 * 修订历史：
 * <p>
 * =================================================================
 **/
public class AESUtils {

    /**
     * AES加密
     */
    public static String encrypt(String seed, String cleartext) throws Exception {
        byte[] rawKey = getRawKey(seed.getBytes());
        byte[] result = encrypt(rawKey, cleartext.getBytes());
        return toHex(result);
    }

    /**
     * AES解密
     */
    public static String decrypt(String seed, String encrypted) throws Exception {
        byte[] rawKey = getRawKey(seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result);
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed);
        kgen.init(128, sr); // 192 and 256 bits may not be available
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        return raw;
    }


    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    public static String toHex(String txt) {
        return toHex(txt.getBytes());
    }
    public static String fromHex(String hex) {
        return new String(toByte(hex));
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length()/2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = Integer.valueOf(hexString.substring(2*i, 2*i+2), 16).byteValue();
        return result;
    }

    public static String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2*buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }
    private final static String HEX = "0123456789ABCDEF";
    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b>>4)&0x0f)).append(HEX.charAt(b&0x0f));
    }

    public static String getGeneratePwd(){
        String pwd = "";
        Random random = new Random();
        int i2 ;
        int i = 0;
        while (i<8) {
            i++;
            switch (random.nextInt(3)) {
                case 0:
                    i2 = random.nextInt(24);
                    pwd += new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "N", "V", "W", "X", "Y", "Z"}[i2];
                    break;
                case 1:
                    i2 = random.nextInt(24);
                    pwd += new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "n", "v", "w", "x", "y", "z"}[i2];
                    break;
                case 2:
                    i2 = random.nextInt(10);
                    pwd += new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}[i2];
                    break;
            }
        }
        return pwd;
    }

}
