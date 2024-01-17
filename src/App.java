import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ServerSocket serverSocket = new ServerSocket(7777);

        Socket socket = serverSocket.accept();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        String chaine = (String)objectInputStream.readObject();

        System.out.println("Recu : " + chaine);

        System.out.println("Ca vient de : " + socket.getInetAddress() + " : " + socket.getPort());

        objectOutputStream.writeObject(new String("Bien Recu"));
    }
}
