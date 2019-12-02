package com.example.test.selfMQ;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName BrokerServer
 * @Description 向外提供处理消息处理中心的接口
 * @Author created by Zwb
 * @Date 2019/11/20 9:56
 * @Version 1.0
 */
public class BrokerServer implements Runnable {

    public final static int SERVER_PORT = 9999;

    private final Socket socket;


    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter out  = new PrintWriter(socket.getOutputStream())
        ){
            while (true) {
                String str = in.readLine();
                if (str == null) {
                    continue;
                }
                System.out.println("接收到的原始数据是："+str);
                if (str.equals("CONSUMER")) {
                    String message = Broker.consumer();
                    out.println(message);
                    out.flush();
                }else{
                    Broker.produce(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        while (true) {
            BrokerServer brokerServer = new BrokerServer(serverSocket.accept());
            new Thread(brokerServer).start();
        }
    }
}
