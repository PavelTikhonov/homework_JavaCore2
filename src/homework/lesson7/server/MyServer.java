package homework.lesson7.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//        Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать
//        сообщения, как на клиентской стороне, так и на серверной. Т.е. если на клиентской стороне написать
//        «Привет», нажать Enter, то сообщение должно передаться на сервер и там отпечататься в консоли.
//        Если сделать то же самое на серверной стороне, то сообщение передается клиенту и печатается у него в консоли.
//        Есть одна особенность, которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд.
//        Такую ситуацию необходимо корректно обработать.
public class MyServer {

        ServerSocket server = null;
        Socket socket = null;
        DataOutputStream outputStream = null;
        DataInputStream inputStream = null;
        Scanner in = new Scanner(System.in);
        public MyServer() {
            try {
                server = new ServerSocket(8189);
                System.out.println("Сервер запущен, ожидаем подключения...");
                socket = server.accept();
                System.out.println("Клиент подключился");
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());

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
                    System.out.println("Client: " + inputStream.readUTF());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


}
