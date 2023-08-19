package org.example;

import java.io.IOException;

public class WriteInFileException extends IOException {
    /**
     * Ошибка связанная с сохранением
     * @param message текст ошибки
     * @param cause причина ошибки
     */
    public WriteInFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
