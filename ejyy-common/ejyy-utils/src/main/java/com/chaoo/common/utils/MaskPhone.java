package com.chaoo.common.utils;

/**
 * 屏蔽手机号中间4位
 */
public final class MaskPhone {
    /**
     * 屏蔽手机号中间4位
     * @param phone 手机号
     * @return 返回屏蔽后的号码
     */
    public static String mask(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
    }
}
