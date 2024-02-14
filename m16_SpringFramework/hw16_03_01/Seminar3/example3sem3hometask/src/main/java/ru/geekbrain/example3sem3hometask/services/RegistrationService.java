package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //Поля UserService, NotificationService

    //Метод processRegistration


    /**
     * Геттер на
     * @return экземпляр службы обработки данных
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
}
