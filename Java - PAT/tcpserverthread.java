import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class tcpserverthread implements Runnable {
    private Socket s;
    private mttcpserver mtmain;

    public tcpserverthread(Socket s, mttcpserver mttcpserver) {
        this.s = s;
        this.mtmain = mttcpserver;
    }

    @Override
    public void run() {
        int clientid = mtmain.getClientId();
        System.out.println("Client "+clientid +" at "+s.getInetAddress());

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"UTF-8"),true);
            out.println("Welcome to Multithreaded TCP Server");
            String msg = in.readLine();
            System.out.println("Client " + clientid+" : "+msg);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
