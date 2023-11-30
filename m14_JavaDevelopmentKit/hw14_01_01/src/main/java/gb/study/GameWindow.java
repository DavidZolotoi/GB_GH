package gb.study;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public static final int WINDOW_HEIGHT = 555;
    public static final int WINDOW_WIDTH = 507;
    public static final int WINDOW_POSX = 1500;
    public static final int WINDOW_POSY = 100;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    Map map;
    SettingsWindow settings;

    public GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Крестики-нолики");
        setResizable(false);

        map = new Map();
        settings = new SettingsWindow(this);
        btnExit.addActionListener(e -> System.exit(0));
        btnStart.addActionListener(e -> settings.setVisible(true));
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        setVisible(true);

    }

    /**
     * Запускает новую игру с настроенными характеристиками
     * @param mode режим игры
     * @param fSzX размер X
     * @param fSzY размер Y
     * @param wLen длина победной линии
     */
    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }

}
