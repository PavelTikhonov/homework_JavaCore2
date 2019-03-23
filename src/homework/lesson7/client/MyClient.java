package homework.lesson7.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
        final String SERVER_ADDR = "localhost" ;
        final int SERVER_PORT = 8189 ;
        ServerSocket server = null;
        Socket socket = null;
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        Scanner in = new Scanner(System.in);

        public MyClient() {
            try {
                socket = new Socket(SERVER_ADDR, SERVER_PORT);
                outputStream = new DataOutputStream(socket.getOutputStream());
                inputStream = new DataInputStream(socket.getInputStream());

                Runnable r = ()->{
                    try {
                        while (true) {
                            outputStream.writeUTF(in.nextLine());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };
                Thread t = new Thread(r);
                t.start();
                while (true) {
                    System.out.println("Server: " + inputStream.readUTF());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
