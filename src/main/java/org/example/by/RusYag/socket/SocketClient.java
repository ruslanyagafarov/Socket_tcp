package org.example.by.RusYag.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException{
        try (var Socket = new Socket("localhost",8080);
             var inputStream = new DataInputStream(Socket.getInputStream());
             var outputStream = new DataOutputStream(Socket.getOutputStream());
             var scanner = new Scanner(System.in)){
            while (scanner.hasNextLine()) {
                outputStream.writeUTF(scanner.nextLine());
                System.out.println(inputStream.readUTF());
            }
        }
    }
}
