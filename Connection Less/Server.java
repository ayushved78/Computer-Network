import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException{
        DatagramSocket server = new DatagramSocket(5000);
        BufferedReader server_inp = new BufferedReader(new InputStreamReader(System.in));
        InetAddress add = InetAddress.getByName("localhost");
        //byte[] out_data = new byte[1024];
        byte[] in_data = new byte[1024];
        byte[] out_data = new byte[1024];
        while (true){
            DatagramPacket p2 = new DatagramPacket(in_data,in_data.length);
            server.receive(p2);
            String res = new String(p2.getData());
            System.out.println(res);

            InetAddress ip_add = p2.getAddress();
            int port = p2.getPort();
            String res2 = server_inp.readLine();
            out_data = res2.getBytes();
            DatagramPacket p3 = new DatagramPacket(out_data,out_data.length,ip_add,port);
            server.send(p3);
            //server.close();
        }
    }
}
