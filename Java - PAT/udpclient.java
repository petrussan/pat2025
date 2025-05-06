import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class udpclient {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buff[] = null;
        
        System.out.print("Masukkan pesan yang akan dikirim: ");
        String i = sc.nextLine();
        buff = i.getBytes();

        DatagramPacket dp = new DatagramPacket(buff,buff.length,ip,2222);
        ds.send(dp);   

    }
    
}
