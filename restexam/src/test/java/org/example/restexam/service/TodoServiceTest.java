package org.example.restexam.service;

import org.example.restexam.domain.Todo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {
    @Autowired
    TodoService service;

    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);

    @Test
    void getTodos() {
        List<Todo> todos = service.getTodos();
        todos.forEach(todo -> log.info("Todo:::" + todo));
    }

    @Test
    void getTodo() {
        Todo todo1 = service.getTodo(3L);
        log.info("Todo::::" + todo1);
    }

//    @Test
//    void addTodo() {
//        Todo todo1 = service.addTodo("Todo1");
//        log.info("Todo::::" + todo1);
//    }

    @Test
    void updateToggleTodo() {
        log.info("Before::::::::" + service.getTodo(3L));
        Todo todo = service.updateTodo(2L);
        log.info("After Todo::::::::" + todo);
    }

    @Test
    void updateTodo() {
        Todo todo = new Todo();
        todo.saveId(3L);
        todo.saveTodo("Hello World");

        log.info("Before Todo:::::::: "+ service.getTodo(3L));
        service.updateTodo(todo);
        log.info("After Todo::::::::"+ service.getTodo(1L));
    }

    @Test
    void deleteTodo() {
        service.deleteTodo(2L);
        log.info("Todo::::" + service.getTodo(2L));
    }
}