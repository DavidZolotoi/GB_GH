package ru.geekbrain.example3sem3hometask.services;

import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;

/**
 * Служба уведомлений
 */
@Service
public class NotificationService {

    /**
     * Уведомление о
     * @param user новом пользователе
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Отправка
     * @param s уведомления
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
