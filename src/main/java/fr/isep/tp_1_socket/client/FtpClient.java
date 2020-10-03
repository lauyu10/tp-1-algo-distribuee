package fr.isep.tp_1_socket.client;

import java.io.*;
import java.net.Socket;

public class FtpClient {
    public static String file = "./src/main/resources/myfile.txt";
    public static void main(String[] args) throws IOException {
        try{
            Socket socketClient = new Socket( "localhost" , 5555 );
            System.out.println( "Client: " + "Connection Established" );

            BufferedWriter writer = new BufferedWriter
                    (new OutputStreamWriter(socketClient.getOutputStream()));
            FileInputStream fileInputStream = new FileInputStream(new File(file));
            int fileMessage;
            while((fileMessage = fileInputStream.read()) >= 0){
                writer.write(fileMessage);
            }
            writer.flush();
            socketClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
