import java.io.IOException;
import java.net.*;

public class mttcpserver {
 
    public mttcpserver(int port)  {
        ServerSocket ss;
        try {
            ss = new ServerSocket(port);
            System.out.println("Server started at port "+port);

            while (true) {
                Socket s = ss.accept();
                tcpserverthread tcpthread = new tcpserverthread(s,this);
                Thread thread = new Thread(tcpthread);
                thread.start();
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private int clientid = 0;

    public int getClientId() {
        return clientid++;
    }

    
}
