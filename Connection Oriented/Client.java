import java.net.*;
import java.io.*;

public class Client {
    private Socket socket = null;
    private  DataInputStream inp = null;
    private DataOutputStream out = null;

    public Client(String address, int port){
        try{
            socket = new Socket(address,port);
            System.out.println("Connected......");
            inp = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch (UnknownHostException u){
            System.out.println(u);
        }
        catch (IOException i){
            System.out.println(i);
        }

        String line = "";
        while(!line.equals("exit")){
            try{
                line = inp.readLine();
                out.writeUTF(line);
            }
            catch (IOException i){
                System.out.println(i);
            }
        }

        try{
            inp.close();;
            out.close();;
            socket.close();;
        }
        catch (IOException i){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.2",5000);
    }

}
