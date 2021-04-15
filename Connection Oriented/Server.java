import java.net.*;
import java.io.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream inp = null;

    public Server(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("server started......");
            System.out.println("waiting for the client.....");

            socket = server.accept();
            System.out.println("Client accepted.....");

            inp = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";
            while (!line.equals("exit")){
                try{
                    line = inp.readUTF();
                    System.out.println(line);
                }
                catch (IOException i){
                    System.out.println(i);
                }
            }

            System.out.println("close connection");
            socket.close();
            inp.close();
        }
        catch (IOException i){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
