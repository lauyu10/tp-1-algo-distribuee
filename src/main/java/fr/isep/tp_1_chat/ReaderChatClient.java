package fr.isep.tp_1_chat;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;

public class ReaderChatClient implements Runnable{

    private BufferedReader reader;
    private JTextArea jTextArea;

    public ReaderChatClient(BufferedReader reader, JTextArea jTextArea) {
        this.reader = reader;
        this.jTextArea = jTextArea;
    }

    @Override
    public void run() {
        while(true){
            try {
                String message = reader.readLine();
                if(message != null){
                    jTextArea.append(message + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
