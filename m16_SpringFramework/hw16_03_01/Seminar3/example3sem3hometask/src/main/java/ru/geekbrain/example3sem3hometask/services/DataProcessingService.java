package ru.geekbrain.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Служба обработки данных
 */
@Service
public class DataProcessingService {

    /**
     * Экземпляр репозитория
     */
    @Autowired
    private UserRepository repository;

    /**
     * Сортировка по возрасту пользоватлей
     * @param users полученного репозитория.
     * @return Сортированный репозиторий.
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация пользоватлей
     * @param users полученного репозитория
     * @param age по возрасту.
     * @return Фильтрованный репозиторий.
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Подсчет среднего возраста
     * @param users полученного репозитория пользователей.
     * @return Средний возраст.
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Добавить в репощиторий
     * @param user полученного пользователя.
     */
    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }

    /**
     * Геттер на репозиторий.
     * @return ссылка на репозиторий.
     */
    public UserRepository getRepository() {
        return repository;
    }
}
