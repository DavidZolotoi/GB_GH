package ru.geekbrain.example3sem3hometask.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrain.example3sem3hometask.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий пользователей - хранилище
 */
@Repository
public class UserRepository {
    /**
     * Коллекция пользователей
     */
    private List<User> users = new ArrayList<>();

    //region Геттеры, сеттеры

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    //endregion
}
