import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class tcpclient {
    private Socket s = null;
    private DataInputStream k = null;
    private DataInputStream i = null;
    private DataOutputStream o = null;
    String msg;

    public tcpclient(String addr, int port) {
        try {
            s = new Socket(addr,port);
            System.out.println("Connected");
            k = new DataInputStream(System.in);
            i = new DataInputStream(s.getInputStream());
            o = new DataOutputStream(s.getOutputStream());
            msg = i.readUTF();
            System.out.println(msg);
            String m = "";
            while(!m.equals("quit")) {
                m = k.readLine();
                o.writeUTF(m);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
