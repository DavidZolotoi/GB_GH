package ru.geekbrains.junior.chat.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    //region Поля

    private final Socket socket;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private final String name;

    //endregion


    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        try {
            //переменная для ввода данных (связь с сокетом)
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //переменная для чтения данных (связь с сокетом)
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }


    }

    /**
     * Отправить сообщение
     */
    public void sendMessage(){

        try {
            bufferedWriter.write(name); bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {                          //при подключении
                System.out.println("Введите адресат для отправки ему сообщения");
                String recipient = scanner.nextLine();              //получить адресат для отправки пиьсма

                System.out.println("Введите текст сообщения для отправки адресату: " + recipient);
                String message = scanner.nextLine();                //получить сообщение для отправки

                bufferedWriter.write(name + "@" + recipient + ": " + message);    //и записать их в стандартизированном формате
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }

    }

    /**
     * Слушатель для входящих сообщений
     */
    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String message;
                while (socket.isConnected()){                   //при появлении подключения
                    try {
                        message = bufferedReader.readLine();    //читать данные
                        System.out.println(message);            //и выводить их на консоль
                    }
                    catch (IOException e){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }

        }).start();
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            // Завершаем работу буфера на чтение данных
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            // Завершаем работу буфера для записи данных
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            // Завершаем работу клиентского сокета
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
