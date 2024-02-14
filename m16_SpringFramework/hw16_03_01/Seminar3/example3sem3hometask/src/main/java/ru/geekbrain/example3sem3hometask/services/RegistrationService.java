package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;

/**
 * Служба регистрации
 */
@Service
public class RegistrationService {

    /**
     * Экземпляр службы обработки данных
     */
    @Autowired
    private DataProcessingService dataProcessingService;
    /**
     * Экземпляр службы управления пользователями
     */
    @Autowired
    private UserService userService;
    /**
     * Экземпляр службы уведомлений
     */
    @Autowired
    private NotificationService notificationService;

    /**
     * Регистрация нового пользователя с полученными в параметрах:
     * @param name именем
     * @param age возрастом
     * @param email почтой
     */
    public void processRegistration(String name, int age, String email){
        User newUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(newUser);
        notificationService.sendNotification("Зарегистрирован новый пользователь с именем: " + newUser.getName());
    }

    /**
     * Геттер на
     * @return экземпляр службы обработки данных
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
}
