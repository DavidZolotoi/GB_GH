package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ответ, как тип, после хода в игре
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    /**
     * Введенное значение для обработки (хода)
     */
    private String userInputValue;
    /**
     * Посчитанное количество коров
     */
    private Integer cow;
    /**
     * Посчитанное количество быков
     */
    private Integer bull;
    /**
     * Ответ на вопрос отгадал или нет
     */
    private Boolean isWin;
    /**
     * Инофрмация об ответе в виде строки
     */
    private String answerInfo;
}
