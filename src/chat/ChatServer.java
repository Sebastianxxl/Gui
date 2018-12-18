package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    ArrayList<Socket> clientSockets;

    public void run() {
        try {
            ServerSocket socket = new ServerSocket(5000);

            Socket clientSocket;
            while ((clientSocket = socket.accept()) !=null) {
                clientSockets.add(clientSocket);
                Thread clientThread = new Thread();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHangler implements Runnable{
        Socket clientSocket;

        public ClientHangler (Socket clientSocket){
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try{
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())
                );
                String message;
                while ((message = reader.readLine()) != null){
                   sendToAll(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
