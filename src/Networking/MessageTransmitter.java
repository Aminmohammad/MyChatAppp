package Networking;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Amin on 12/27/2015.
 */
public class MessageTransmitter extends Thread{

    String message, hostname;
    int port;
    public MessageTransmitter(){

    }

    public MessageTransmitter(String message, String hostname,int port){
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }

    public void run(){
        try {
            Socket s = new Socket( hostname, port);
            s.getOutputStream().write(message.getBytes());
            s.close();

        } catch (IOException e) {}
    }
}
