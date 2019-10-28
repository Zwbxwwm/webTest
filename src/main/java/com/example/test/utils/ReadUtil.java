package com.example.test.utils;

/**
 * @ClassName ReadUtil
 * @Description 解析apk包
 * @Author created by Zwb
 * @Date 2019/10/23 15:27
 * @Version 1.0
 */

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;


import java.io.File;
import java.io.IOException;
/**
 *
 * @author laijunfeng816
 *
 */
public final class ReadUtil {
    /**
     * 读取apk
     */
    public static void readApkSelf(String filePath) throws IOException {
        ApkFile apkParser = new ApkFile(new File(filePath));
        String xml = apkParser.getManifestXml();
        System.out.println(xml);
        ApkMeta apkMeta = apkParser.getApkMeta();
        System.out.println(apkMeta);
        apkParser.close();
    }


    public static void main(String[] args) throws IOException {
        System.out.println();
        //C:\Test
        String filePath = "C:\\Test/KugouPlayer_219_V9.3.5.apk";
        ReadUtil.readApkSelf(filePath);
    }
}