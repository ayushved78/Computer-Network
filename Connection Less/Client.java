import java.net.*;
        import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception{
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket client = new DatagramSocket();
        InetAddress add = InetAddress.getByName("localhost");
        byte[] in_data = new byte[1024];
        byte[] out_data = new byte[1024];
        String r = inp.readLine();
        out_data = r.getBytes();
        DatagramPacket p1 = new DatagramPacket(out_data,out_data.length,add,5000);
        client.send(p1);
        DatagramPacket p4 = new DatagramPacket(in_data,in_data.length,add,5000);
        client.receive(p4);
        String str = new String(p4.getData());
        System.out.println(str);
        client.close();
    }
}
