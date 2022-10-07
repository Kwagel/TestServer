import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(54321)) {
            System.out.println("Server started");
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
           
            System.out.println("Client Connected");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            while(true){
                String echoString = input.readLine();
                if(echoString.equals("exit")){
                    System.out.println("Closing server...");
                    break;
                }
                System.out.println("Message from client: " + echoString);
                output.println("Response from server: " + echoString );
            }
        }catch(IOException e){
            System.out.println("Server exception " + e.getMessage());
        }
    }
    
}
