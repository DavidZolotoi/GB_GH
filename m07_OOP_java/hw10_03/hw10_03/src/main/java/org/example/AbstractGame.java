package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;

/**
 * Основная реализация игры
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractGame implements Game {

    /**
     * Длина слова
     */
    Integer sizeWord;
    /**
     * Количество попыток
     */
    private Integer attempts;
    /**
     * Загаданное (сгенерированное) слово
     */
    String word;
    /**
     * Статус игры
     */
    GameStatus gameStatus = GameStatus.INIT;

    /**
     * Запуск игры
     * @param sizeWord длина слова
     * @param attempts количество попыток
     */
    @Override
    public String start(Integer sizeWord, Integer attempts) {
        this.sizeWord = sizeWord;
        this.attempts = attempts;
        this.word = getGeneratedWorld(this.sizeWord, getGeneratedCharList());
        this.gameStatus = GameStatus.START;
        return "Старт. Нужно отгадать словой длиной [" + this.sizeWord + "] за кол-во попыток [" + this.attempts + "].";
    }

    /**
     * Запуск игры с загаданным случайным словом случайной длины
     */
    @Override
    public String start() {
        this.sizeWord = 2 + new Random().nextInt(3);
        this.attempts = sizeWord * 2;
        this.word = getGeneratedWorld(this.sizeWord, getGeneratedCharList());
        this.gameStatus = GameStatus.START;
        return "Старт. Нужно отгадать словой длиной [" + this.sizeWord + "] за кол-во попыток [" + this.attempts + "].";
    }

    /**
     * Формирование ответа
     * @param userInputValue введенное значение
     * @return ответ, как тип
     */
    @Override
    public Answer getAnswer(String userInputValue) {
        Integer bulls = 0;
        Integer cows = 0;
        Boolean isWin = false;
        for (int i = 0; i < userInputValue.length(); i++) {
            // Если совпадает и значение и индекс, то + бык
            if (userInputValue.charAt(i) == word.charAt(i)) {
                bulls++;
            }
            // Если совпадает только значение, а индекс - нет, то + корова
            if (word.contains(((Character)userInputValue.charAt(i)).toString())) {
                cows++;
            }
        }
        isWin = word.equals(userInputValue);
        String answerInfo = "Результат: коров - " + cows + ", быков - " + bulls + ".";
        return new Answer(userInputValue, cows, bulls, isWin, answerInfo);
    }

    /**
     * Завершает игру с победой пользователя
     * @return строку с итогом
     */
    @Override
    public String userWin() {
        this.gameStatus = GameStatus.WIN;
        return "Вы выиграли!";
    }

    /**
     * Заверашет игру с поражением пользователя
     * @return строку с итогом
     */
    @Override
    public String userLose() {
        this.gameStatus = GameStatus.LOSE;
        return "Вы проиграли! Было загано: " + word + ".";
    }

    /**
     * Возвращает статус игры.
     * @return статус игры
     */
    @Override
    public GameStatus getGameStatus() {
        return this.gameStatus;
    }

    /**
     * Возвращает количетсво попыток.
     * @return количетсво попыток
     */
    public Integer getAttempts() {
        return this.attempts;
    }

    /**
     * Генерация слова
     * @param sizeWord размер генерируемого слова
     * @param charList набор символов для генерации слова
     * @return сгененированное слово
     */
    private String getGeneratedWorld(Integer sizeWord, List<String> charList) {
        Random random = new Random();
        String resWorld = "";
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            resWorld = resWorld.concat(charList.get(randomIndex));
            charList.remove(randomIndex);
        }
        return resWorld;
    }

    /**
     * Возвращает набор символов для генерации слова
     * @return набор символов для генерации слова
     */
    abstract List<String> getGeneratedCharList();
}
