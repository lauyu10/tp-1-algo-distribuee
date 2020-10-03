package fr.isep.tp_1_chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class MyChat {
    public JTextField jTextField;
    public JTextArea jTextArea;
    BufferedWriter writer;
    BufferedReader reader;

    public MyChat(String name){

        JFrame f=new JFrame("Chat from : " + name);
        f.setSize(400,400);

        JPanel p1=new JPanel();
        p1.setLayout(new BorderLayout());

        JPanel p2=new JPanel();
        p2.setLayout(new BorderLayout());

        jTextField =new JTextField();
        p1.add(jTextField, BorderLayout.CENTER);

        JButton b1=new JButton("Send");
        p1.add(b1, BorderLayout.EAST);

        jTextArea =new JTextArea();
        p2.add(jTextArea, BorderLayout.CENTER);
        p2.add(p1, BorderLayout.SOUTH);

        f.setContentPane(p2);

        try{
            Socket socketClient= new Socket("localhost",5555);
            writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        }catch(Exception e){
            e.printStackTrace();
        }

        b1.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent ev){
                 String s = name +" : "+ jTextField.getText();
                 jTextField.setText("");
                 try{
                     writer.write(s);
                     writer.write("\r\n");
                     writer.flush();
                 }catch(Exception e){e.printStackTrace();}
             }
            }
        );

        f.setVisible(true);
        new Thread(new ReaderChatClient(reader, jTextArea)).start();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
