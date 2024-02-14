package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;

/**
 * Служба управления пользователями
 */
@Service
public class UserService {

    /**
     * Экземпляр службы уведомлений
     */
    @Autowired
    private NotificationService notificationService;

    //    public UserService(NotificationService notificationService) {
    //        this.notificationService = notificationService;
    //    }

    /**
     * Создать нового пользователя по полученным:
     * @param name имени,
     * @param age возрасту,
     * @param email почте.
     * @return Нового пользователя.
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
