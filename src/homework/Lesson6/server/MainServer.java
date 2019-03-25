//        1. Разобраться с кодом.
//        2.
//        3. Сделать проверку занят ли ник.
//        4. *Реализовать личные сообщения так: если клиент пишет «/w nick3 Привет», то только клиенту с ником
//        nick3 должно прийти сообщение «Привет».

package homework.lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class MainServer {
    private Vector<ClientHandler> clients;

    public MainServer() throws SQLException {
        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }

        } catch (IOException e) {
             e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        try {
            AuthService.setActivityByNick(client.getNick(), "inactive");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        clients.remove(client);
    }

    public void sendPrivateMsg(String comType, String nickIn, String nickOut, String msg){
        for (ClientHandler o : clients) {
            if(nickIn.equals(o.getNick()) || nickOut.equals(o.getNick())){
                o.sendMsg(nickIn + " : " + msg.substring((comType + " " + nickIn + " ").length()));
            }
        }
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }
}
