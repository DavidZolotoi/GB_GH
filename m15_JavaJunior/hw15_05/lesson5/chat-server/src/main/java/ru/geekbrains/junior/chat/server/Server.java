package ru.geekbrains.junior.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //region Поля

    /**
     * Серверный сокет
     */
    private final ServerSocket serverSocket;

    //endregion


    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void runServer(){

        try {
            while (!serverSocket.isClosed()) {                              //если подключение не закрыто
                Socket socket = serverSocket.accept();                      //слушать в основном потоке
                System.out.println("Подключен новый клиент!");
                ClientManager clientManager = new ClientManager(socket);    //Если ожидание прервалось (появилось подключение), то:
                                                                            //-создать ClientManager передав ему socket
                Thread thread = new Thread(clientManager);                  //-создать поток с clientManager с методом run()
                thread.start();                                             //-и запустить этот поток
            }
        }
        catch (IOException e){
            closeSocket();
        }

    }

    private void closeSocket(){
        try{
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
