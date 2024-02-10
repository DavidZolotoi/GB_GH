package com.example.empl4sem2CRUD.service;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    /**
     * Объект для запросов в БД
     */
    private final UserRepository userRepository;
    /**
     * Сервис для работы с БД пользователей
     * @param userRepository объект для запросов в БД
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @return коллекцию из всех пользователей
     */
    public List<User> findAll(){
        return userRepository.findAll();
    }

    /**
     * Добавить нового пользователя user в таблицу БД
     * @param user пользователь, которого необходимо добавить в БД
     * @return пользователя, которого добавили в БД
     */
    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Удалить пользователя с указанным id
     * @param id пользователя, которого необходимо удалить
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}
