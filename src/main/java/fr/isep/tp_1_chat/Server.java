/**
 * @author Laurent Yu A3
 * 03/10/2020
 * Part 3 Server
 */
package fr.isep.tp_1_chat;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class server that link people
 */
class Server implements Runnable{
    private static List<Socket> connectionsSockets = new ArrayList<>();
    private Socket selfSocket;
    public Server(Socket socket){
        try{
            System.out.println("Client Got Connected  " );
            selfSocket = socket;
            connectionsSockets.add(socket);
        }catch(Exception e){e.printStackTrace();}
    }
    public void run(){
        try{
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(selfSocket.getInputStream()));
            while(true){
                String data1 = reader.readLine().trim();
                connectionsSockets.forEach(socket ->
                        {
                            try {
                                socket.getOutputStream().write((data1 + "\r\n").getBytes());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
                System.out.println("Received : "+data1);
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public static void main(String argv[]) throws Exception{
        System.out.println("Threaded Chat Server is Running  " );
        ServerSocket mysocket = new ServerSocket(5555);
        while(true){
            Socket sock = mysocket.accept();
            Server server=new Server(sock);
            Thread serverThread=new Thread(server);
            serverThread.start();
        }
    }
}
