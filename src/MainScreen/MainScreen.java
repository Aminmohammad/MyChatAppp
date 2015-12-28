package MainScreen;

import Networking.MessageListener;
import Networking.MessageTransmitter;
import Networking.WritableGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Amin on 12/26/2015.
 */
public class MainScreen implements WritableGUI, ActionListener{
    private JPanel panel1;
    private JButton listenButton;
    private JTextField receivePort;
    private JTextField ipTextField;
    private JTextField targetPort;
    private JTextField message;
    private JButton sendButton;
    private JTextArea chat;

    public MainScreen() {


        JFrame jf = new JFrame ();
        jf.setContentPane(panel1);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(500,500);

        listenButton.addActionListener(this);
        sendButton.addActionListener(this );


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void write(String s) {
        chat.append(s + System.lineSeparator());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listenButton){
            MessageListener listener = new MessageListener( MainScreen.this, Integer.parseInt(receivePort.getText()));
            listener.start();

        }
        else if(e.getSource() == sendButton){
            MessageTransmitter transmitter = new MessageTransmitter( message.getText(), ipTextField.getText(), Integer.parseInt(targetPort.getText()) );
            transmitter.start();

        }
    }
}
