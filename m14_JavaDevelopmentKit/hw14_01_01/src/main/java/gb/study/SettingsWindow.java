package gb.study;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start new game");
    JLabel gameMode = new JLabel("Выберите режим игры");
    JLabel gameField = new JLabel("Установленный размер поля:");
    JLabel winCount = new JLabel("Установленная длина:");
    JSlider fieldSlider = new JSlider(3,10);
    JSlider winLengthSlider = new JSlider(3,10);
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    ButtonGroup gameModeButtonsGroup = new ButtonGroup();
    JPanel panBottom;

    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        panBottom = new JPanel(new GridLayout(8, 1));
        gameModeButtonsGroup.add(humanVsAi);
        gameModeButtonsGroup.add(humanVsHuman);
        panBottom.add(gameMode);
        panBottom.add(humanVsAi);
        panBottom.add(humanVsHuman);
        panBottom.add(gameField);
        panBottom.add(fieldSlider);
        panBottom.add(winCount);
        panBottom.add(winLengthSlider);
        panBottom.add(btnStart);
        humanVsAi.setSelected(true);
        fieldSlider.addChangeListener(e -> gameField.setText("Установленный размер поля: " + fieldSlider.getValue()));
        winLengthSlider.addChangeListener(e -> winCount.setText("Установленная длина: " + winLengthSlider.getValue()));

        btnStart.addActionListener(e -> {
            gameWindow.startNewGame(humanVsAi.isSelected()?0:1,
                    fieldSlider.getValue(),
                    fieldSlider.getValue(),
                    winLengthSlider.getValue());
            setVisible(false);
        });
        add(panBottom);
    }
}
