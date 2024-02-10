package com.example.empl4sem2CRUD.repositories;

import com.example.empl4sem2CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    /**
     * jdbc для работы с БД
     */
    private final JdbcTemplate jdbc;

    /**
     * Объект для запросов в БД
     * @param jdbc для запросов в БД
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Запрос на получение всех строк таблицы пользователей
     * @return всех пользователей из БД
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Запрос на добавление пользователя в таблицу пользователей в БД
     * @param user пользователь, которого необходимо добавить
     * @return  пользователь, которого добавили
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";

        jdbc.update(sql, user.getFirstName(), user.getLastName());

        return  user;
    }

    /**
     * Запрос для удаления из таблицы с пользователями строку с пользователем с указанным id
     * @param id пользователя, которого надо удалить из БД
     */
    public void deleteById(int id){
        String sql = "DELETE FROM userTable WHERE id=?";

        jdbc.update(sql, id);
    }

}
