package org.example;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Выберите игру:\n1 - цифра,\n2 - англ.буквы,\n3 - русск.буквы.\n(1,2,3)? ");
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        Integer num = Integer.parseInt(scanner.nextLine());
        switch (num) {
            case 1:
                game = new NumberGame();
                break;
            case 2:
                game = new EnGame();
                break;
            case 3:
                game = new RuGame();
                break;
            default:
                System.out.println("данная игра еще не добавлена!");
        }
        String gameStartInfo = game.start();
        System.out.println(gameStartInfo);
        Integer attemptsMax = ((AbstractGame) game).getAttempts();
        Integer attemptsCount = 1;
        while (game.getGameStatus().equals(GameStatus.START)){
            System.out.printf("%d-я попытка: ", attemptsCount);
            String userInputValue = scanner.nextLine(); //todo проверку
            Answer answerGame = game.getAnswer(userInputValue);
            System.out.println(answerGame.getAnswerInfo());
            if (answerGame.getIsWin()) {
                System.out.println(game.userWin());
                continue;
            }
            if (attemptsMax == attemptsCount) {
                System.out.println(game.userLose());
                continue;
            }
            attemptsCount++;
        }

    }
}
