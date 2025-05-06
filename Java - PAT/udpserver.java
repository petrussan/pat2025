import java.net.*;
import java.nio.charset.StandardCharsets;

public class udpserver {
    public udpserver() throws Exception {
        DatagramSocket ds = new DatagramSocket(2222);
        byte[] receive = new byte[65535];
        DatagramPacket dp = null;

        while(true) {
            dp = new DatagramPacket(receive, receive.length);
            ds.receive(dp);

            String s = new String(receive, StandardCharsets.UTF_8);
            System.out.println("Received: "+s);

            receive = new byte[65535];

        }

    }
}