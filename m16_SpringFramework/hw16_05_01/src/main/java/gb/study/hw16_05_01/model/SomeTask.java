package gb.study.hw16_05_01.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sometasks")
public class SomeTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;

//    //должен автоматически устанавливается при создании
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime dateCreate;
//
//    //метод должен быть вызван перед сохранением новой сущности в базу данных
//    @PrePersist
//    public void recordCreationDate() {
//        dateCreate = LocalDateTime.now();
//    }
}

