/**
 * @author Laurent Yu A3
 * 03/10/2020
 * Part 2
 */
package fr.isep.tp_1_thread.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    public Socket mySocket;
    public Server(Socket socket){
        mySocket = socket;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket mySocket = new ServerSocket(5555);
        System.out.println("Server is on");
        while(true){
            Thread serverThread = new Thread(new Server(mySocket.accept()));
            serverThread.start();
        }

    }

    public void run() {
        try{
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(mySocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter
                    (new OutputStreamWriter(mySocket.getOutputStream()));
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
            mySocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
