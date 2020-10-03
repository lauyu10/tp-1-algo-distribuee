package fr.isep.tp_1_socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {
    public static void main(String argv[]) throws Exception{
        System.out.println(" Server is Running ");
        ServerSocket mySocket = new ServerSocket(5555);
        while(true){
            Socket connectionSocket = mySocket.accept();

            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(connectionSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter
                    (new OutputStreamWriter(connectionSocket.getOutputStream()));
            writer.write("*** Welcome to the Calculation Server (Addition Only) ***\r\n");
            writer.write("*** Please type in the first number and press Enter : \n");
            writer.flush();
            String data = reader.readLine().trim();
            writer.write("*** Please type in the second number and press Enter \n");
            writer.flush();
            String data2 = reader.readLine().trim();
            int num1 = Integer.parseInt(data);
            int num2 = Integer.parseInt(data2);
            int result = num1 + num2;
            System.out.println("Addition operation done ");
            writer.write("\r\n=== Result is : \n" +result+ "\n");
            writer.flush();
            connectionSocket.close();
        }
    }
}
