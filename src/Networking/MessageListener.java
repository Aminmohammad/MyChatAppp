package Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Amin on 12/26/2015.
 */
public class MessageListener extends Thread{
    ServerSocket server;
    int port = 8878;
    WritableGUI gui;


    public MessageListener(WritableGUI gui, int port){
        this.port = port;
        this.gui = gui;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {}

    }
    public MessageListener(){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {}
    }

    public void run(){
        Socket clientSocket = null;
        try {
            while ( ( clientSocket = server.accept() ) != null){
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader( new InputStreamReader(is));
                String line = br.readLine();
                if ( line != null ){
                    gui.write(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
