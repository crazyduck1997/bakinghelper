package com.qf.bakinghelper.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	public static String md5(String plainText) {
        //定义一个字节数组
        byte[] secretBytes = null;
        try {
              // 生成一个MD5计算摘要的对象  
            MessageDigest md = MessageDigest.getInstance("MD5");
            //对字符串进行hash处理
            md.update(plainText.getBytes());
            //获得hash运算后数据
            secretBytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        //将hash后的数据转换为16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
	
	public static void main(String[] args) {
		String md5 = md5("123");
		System.out.println(md5);
	}
}
