package com.example.test.selfMQ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName MyClient
 * @Description 消息队列的客户端
 * @Author created by Zwb
 * @Date 2019/11/20 10:20
 * @Version 1.0
 */
public class MyClient {
    public void producer(String msg) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVER_PORT);
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println(msg);
            out.flush();
        }
    }

    public String consumer() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVER_PORT);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println("CONSUMER");
            out.flush();
            String message = in.readLine();
            return message;
        }
    }
}
