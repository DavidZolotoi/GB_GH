package org.example.demo4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    /* код ниже означает, что у одного читателя может быть несколько книг и
    * в таблице книг будет колонка reader_id, которая ссылается на id читателя*/
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
