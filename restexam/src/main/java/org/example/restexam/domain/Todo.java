package org.example.restexam.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "todos")
@Getter
@NoArgsConstructor
@ToString
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String todo;
    private boolean done;

    public void saveId(Long id) {
        this.id = id;
    }

    public void saveTodo(String todo) {
        this.todo = todo;
    }

    public void saveDone(boolean done) {
        this.done = done;
    }
}