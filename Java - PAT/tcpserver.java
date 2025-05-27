import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tcpserver {
 
    private Socket s = null;
    private ServerSocket ss = null;
    private DataInputStream i = null;
    private DataOutputStream o = null;

    public tcpserver(int port) {
        try {
            ss = new ServerSocket(port);
            System.out.println("Server started, waiting for connection ...");
            s = ss.accept();
            o = new DataOutputStream(s.getOutputStream());
            o.writeUTF("Welcome to My Server");
            System.out.println("Client accepted");
            i = new DataInputStream(s.getInputStream());
            String msg = "";
            while(!msg.equals("quit")) {
                System.out.println("Accepting message");
                msg = i.readUTF();
                System.out.println(msg);
            }
            s.close();
            i.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
