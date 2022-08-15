package com.chaoo.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author chaoo
 * @Date: 2022/08/11/ 15:21
 *
 * MD5 加密工具类
 */
public class MD5 {
    public static String encrypt(String str) {
        try {
            char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            bytes = md.digest(); // 通过执行填充等最终操作完成哈希计算。进行此调用后将重置摘要
            int len = bytes.length;
            char[] chars = new char[len * 2];
            int k = 0;
            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                chars[k++] = hexChars[b >>> 4 & 0xf];
                chars[k++] = hexChars[b & 0xf];
            }
            return new String(chars);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 加密出错: " + e);
        }
    }

    // MD5 测试
    public static void main(String[] args) {
        System.out.println(MD5.encrypt("123456"));
    }
}
