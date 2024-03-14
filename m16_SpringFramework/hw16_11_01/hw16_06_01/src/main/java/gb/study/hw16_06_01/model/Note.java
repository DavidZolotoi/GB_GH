package gb.study.hw16_06_01.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    //должен автоматически устанавливается при создании
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTimeCreated;

    //метод должен быть вызван перед сохранением новой сущности в базу данных
    @PrePersist
    public void recordCreationDate() {
        dateTimeCreated = LocalDateTime.now();
    }
}