package fr.isep.tp_1_socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FtpServer {
    public static String file = "./src/main/resources/answer.txt";
    public static void main(String[] args) throws IOException {

        System.out.println(" Server is Running ");
        ServerSocket mySocket = new ServerSocket(5555);
        while(true){
            Socket connectionSocket = mySocket.accept();

            BufferedReader reader = new BufferedReader( new
                    InputStreamReader(connectionSocket.getInputStream()));
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file));
            int serverMsg;
            while ((serverMsg = reader.read()) >= 0) {
                fileOutputStream.write(serverMsg);
                System.out.println( "Client:" + serverMsg);
            }
        }
    }
}
