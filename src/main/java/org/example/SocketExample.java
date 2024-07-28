package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketExample {
    public static void  main(String[] argc) throws IOException {
        try (var socket = new Socket("google.com", 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeUTF("Hello from client");
            var response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}