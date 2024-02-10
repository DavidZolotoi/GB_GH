package com.example.empl4sem2CRUD.controllers;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    /**
     * Сервис для работы с БД пользователей
     */
    @Autowired
    private UserService userService;

    /**
     * Получить всех пользователей
     * @param model //todo спросить преподавателя
     * @return //todo спросить преподавателя
     */
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    /**
     * //todo спросить преподавателя
     * @param user
     * @return
     */
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    /**
     * //todo спросить преподавателя
     * @param user
     * @return
     */
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * //todo спросить преподавателя
     * @param user
     * @return
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(User user){
        userService.deleteById(user.getId());
        return "user-list";
    }

}
