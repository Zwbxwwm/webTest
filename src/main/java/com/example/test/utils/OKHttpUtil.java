package com.example.test.utils;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

//https://www.jianshu.com/p/da4a806e599b
public class OKHttpUtil {

    public final static Logger logger = LoggerFactory.getLogger(OKHttpUtil.class);

    public static void main(String[] args) {
        //异步GET请求
        String url = "http://wwww.baidu.com";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                logger.error(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                logger.info("get message...");
                logger.info(response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    logger.info(headers.name(i) + ":" + headers.value(i));
                }
                logger.info("onResponse: " + response.body().string());
            }
        });

        //POST方式提交
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "I am Jdqm.";
        Request request1 = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(mediaType, requestBody))
                .build();
        OkHttpClient okHttpClient1 = new OkHttpClient();
        okHttpClient1.newCall(request1).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                logger.error("failure.."+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                logger.info(response.protocol() + " " +response.code() + " " + response.message());
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    logger.info(headers.name(i) + ":" + headers.value(i));
                }
                logger.info("onResponse: " + response.body().string());
            }
        });


    }
}
