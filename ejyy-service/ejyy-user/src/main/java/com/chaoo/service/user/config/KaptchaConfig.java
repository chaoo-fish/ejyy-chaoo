package com.chaoo.service.user.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码功能配置类
 */
@Configuration
public class KaptchaConfig {
    private final static String CODE_LENGTH = "4";

    @Bean
    public DefaultKaptcha defaultKaptcha() {
        Properties properties = new Properties();
        // 设置边框
        properties.setProperty("kaptcha.border", "yes");
        // 设置边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 设置字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "0,153,153");
        // 设置图片宽度
        properties.setProperty("kaptcha.image.width", "118");
        // 设置图片高度
        properties.setProperty("kaptcha.image.height", "36");
        // 设置字体尺寸
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        // 设置字体
        properties.setProperty("kaptcha.textproducer.font.names", "Blackletter,Hakuu,Tahoma");
        // 背景颜色渐变，开始颜色
        properties.setProperty("kaptcha.background.clear.from","153,255,204");
        // 背景颜色渐变， 结束颜色
        properties.setProperty("kaptcha.background.clear.to","153,204,153");
        // 验证码字符串
        properties.setProperty("kaptcha.textproducer.char.string", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYAZ");
        // 设置验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", CODE_LENGTH);
        // 图片干扰线：无干扰线
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(properties);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
