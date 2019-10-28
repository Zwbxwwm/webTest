package com.example.test.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName EmailUtil
 * @Description 邮件发送工具
 * @Author created by Zwb
 * @Date 2019/10/14 16:44
 * @Version 1.0
 */
public class EmailUtil {
    public static boolean sendEmail(String to, String cc, String subject, String content) {
        if (StringUtils.isNoneBlank(to)) {
            return false;
        }
        return true;
    }
}
