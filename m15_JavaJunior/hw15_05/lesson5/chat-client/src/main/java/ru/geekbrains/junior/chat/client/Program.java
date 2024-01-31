package ru.geekbrains.junior.chat.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        try {
            //Идентификация
            System.out.print("Введите своё имя: ");
            String name = (new Scanner(System.in)).nextLine();
            //Связь
            InetAddress address = InetAddress.getLocalHost();
            Socket socket = new Socket(address, 4500);
            //Создать клиента, передав в конструктор сокет и имя
            Client client = new Client(socket, name);
            //Инфо
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("InetAddress: " + inetAddress);
            String remoteIp = inetAddress.getHostAddress();
            System.out.println("Remote IP: " + remoteIp);
            System.out.println("LocalPort:" + socket.getLocalPort());

            //Запуск прослушивания сообщений в отдельном потоке
            client.listenForMessage();
            //Зациклить основной поток на вводе сообщения для отправки
            client.sendMessage();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }

}
