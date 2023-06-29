package org.example;

/**
 * Игра
 */
public interface Game {
    /**
     * Запуск игры с заданными параметрами
     * @param sizeWord длина слова
     * @param attempts количество попыток
     */
    String start(Integer sizeWord, Integer attempts);

    /**
     * Запуск игры с загаданным случайным словом случайной длины и случайным количеством попыток
     */
    String start();

    /**
     * Завершает игру с победой пользователя
     */
    String userWin();

    /**
     * Заверашет игру с поражением пользователя
     */
    String userLose();

    /**
     * Обработка введенного значения
     * @param userInputValue введенное значение
     * @return ответ, как тип
     */
    Answer getAnswer(String userInputValue);

    /**
     * Возвращает статус игры
     * @return статус игры
     */
    GameStatus getGameStatus();
}
