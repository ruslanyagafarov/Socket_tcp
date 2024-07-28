package org.example.by.RusYag.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(8080);
             //метод accept будет ждать клиента и когда он подключиться кроме него никто этого сделать не сможет
             var socket = serverSocket.accept();
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {

            var scanner = new Scanner(System.in);
            var request = inputStream.readUTF();
            while (!request.equals("exit")) {
                System.out.println("Клиент: " + request);
                outputStream.writeUTF(scanner.nextLine());
                request = inputStream.readUTF();
            }
        }
    }
}
