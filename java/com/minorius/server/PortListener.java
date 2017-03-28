package com.minorius.server;

import com.minorius.service.CategoryService;

import java.net.ServerSocket;
import java.net.Socket;

public class PortListener {

    public static void portListenerOn(CategoryService categoryService){

        System.out.println("Start");

        int port = 1701;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting...");

            while(true){

                Socket socket = serverSocket.accept();
                System.out.println("Connecting...");
                Sender.sendData(socket, categoryService);

            }
        } catch(Exception x) {
            x.printStackTrace();
        }
        System.out.println("Finish");
    }
}
