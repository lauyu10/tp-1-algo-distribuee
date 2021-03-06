/**
 * @author Laurent Yu A3
 * 03/10/2020
 * Part 1-3 Client
 */
package fr.isep.tp_1_socket.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientClass {
    public static void main (String argv[])
    {
        try {
            Socket socketClient= new Socket( "localhost" , 5555 );
            System.out.println( "Client: " + "Connection Established" );
            BufferedReader reader = new BufferedReader( new
                    InputStreamReader(socketClient.getInputStream()));
            BufferedWriter writer= new BufferedWriter( new
                    OutputStreamWriter(socketClient.getOutputStream()));
            String serverMsg;
            writer.write( "8\r\n" );
            writer.write( "10\r\n" );
            writer.flush();
            while ((serverMsg = reader.readLine())!= null ) {
                System.out.println( "Client:" + serverMsg);
            }
        } catch (Exception e){e.printStackTrace();}
    }
}
