package ru.geekbrain.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrain.example3sem3hometask.domain.User;
import ru.geekbrain.example3sem3hometask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * Экземпляр службы обработки данных
     */
    @Autowired
    private DataProcessingService service;

    /**
     * @return коллекцию всех задач
     */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    /**
     * @return коллекцию сортированных по возрасту пользователей
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * @return коллекцию фильтрованных по возрасту пользователей
     */
    @GetMapping("/filter/{age}")//localhost:8080/tasks/filter/{age}
    public List<User> filterUsersByAge(@PathVariable("age") Integer age)
    {
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * @return средний возраст пользователей
     */
    @GetMapping("/calc")//localhost:8080/calc
    public double calculateAverageAge()
    {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
