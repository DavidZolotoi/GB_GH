package gb.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля,
IP-адреса сервера, порта подключения к серверу, область ввода сообщений, JTextArea
область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
Желательно сразу сгруппировать компоненты, относящиеся к серверу сгруппировать на JPanel
сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу
 */
public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 700;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    private static final String logFilePath = "./chatLogs.txt";
    private JButton sendButton = new JButton("Отправить");
    private JButton connectButton = new JButton("Соединиться с сервером");
    private JLabel loginLabel = new JLabel("Login: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    private JLabel IpLabel = new JLabel("IP: ");
    private JLabel messageLabel = new JLabel("Сообщение: ");
    private JTextField loginTextField = new JTextField(22);
    private JTextField passwordTextField = new JTextField(22);
    private JTextField IpTextField = new JTextField(16);
    private JTextField messageTextField = new JTextField();
    private JTextArea messageTextArea = new JTextArea(30, 40);
    private JPanel serverPanel;
    private JPanel messagePanel;
    private JPanel clientPanel;
    private Boolean serverStatus = false;

    Chat() {
        logFileCreate(logFilePath);
        // Получение размеров экрана и окна
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int windowWidth = (int)(screenSize.width * 0.30);
        int windowHeigh = (int)(screenSize.height * 0.75);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chat");

        messageTextArea.setEnabled(false);
        messageTextArea.setLineWrap(true);
        messageTextArea.setWrapStyleWord(true);
        serverPanel = new JPanel();
        messagePanel = new JPanel();
        clientPanel = new JPanel();

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader fileReader = new BufferedReader(new FileReader(logFilePath))){
                    String dataLine;
                    while ((dataLine = fileReader.readLine()) != null) {
                        messageTextArea.append(dataLine.toString());
                    }
                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }
                serverStatus = true;
            }
        });

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        messageTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //todo дописать код для этой заглушки
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //todo дописать код для этой заглушки
            }
        });

        //РАЗМЕТКА и размеры
        setSize(windowWidth, windowHeigh);
        setLocationRelativeTo(null);
        add(serverPanel, BorderLayout.NORTH);
            serverPanel.setLayout(new GridLayout(3, 2 ));
            serverPanel.add(loginLabel);
            serverPanel.add(loginTextField);
            serverPanel.add(passwordLabel);
            serverPanel.add(passwordTextField);
            serverPanel.add(IpLabel);
            serverPanel.add(IpTextField);
        add(messagePanel, BorderLayout.CENTER);
            messagePanel.setLayout(new GridLayout(1, 1));
            messagePanel.add(messageLabel);
            messagePanel.add(new JScrollPane(messageTextArea));
        add(clientPanel, BorderLayout.SOUTH);
            clientPanel.setLayout(new GridLayout(3, 1));
            clientPanel.add(messageTextField);
            clientPanel.add(sendButton);
            clientPanel.add(connectButton);

        // ПОКАЗАТЬ
        setVisible(true);
    }

    /**
     * Отправит сообщение и запишет в лог
     * или попросит подключиться к серверу.
     */
    private void sendMessage() {
        if (!serverStatus) {
            messageTextArea.append("Подключитесь к серверу! Сообщение не отправлено");
            return;
        }
        String message = loginTextField.getText() + ": " + messageTextField.getText() + System.lineSeparator();
        messageTextArea.append(message);
        messageTextField.setText(null);
        logFileWrite(message);
    }

    /**
     * Метод создаст файл, если он еще не существует
     */
    private static void logFileCreate(String filePath) {
        Path logPath = Paths.get(filePath);
        File logFile = new File(filePath);
        if (!Files.exists(logPath)) {
            try {
                logFile.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Запишет лог в файл
     * @param log лог
     */
    private void logFileWrite(String log) {
        try (FileWriter fileWriter = new FileWriter(logFilePath, true)) {
            fileWriter.write(log);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
