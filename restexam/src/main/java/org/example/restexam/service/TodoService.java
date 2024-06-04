package org.example.restexam.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Todo getTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 " + id + "로 조회되는 todo 리스트는 존재하지 않습니다."));
    }

    public Todo addTodo(String todo) {
        Todo newTodo = new Todo();
        newTodo.saveTodo(todo);
        return todoRepository.save(newTodo);
    }

    public Todo updateTodo(Long id) { // id 값에 해당하는 done을 토글하도록
        Todo todo = getTodo(id);

        if(todo != null) {
            todo.saveDone(!todo.isDone());
            //return todoRepository.save(todo);
        }

        return todo;
    }


    public Todo updateTodo(Long id, String str) { // id에 해당하는 todo 정보를 바꾸도록
        Todo updateTodo = getTodo(id);

        if (updateTodo != null) {
            updateTodo.saveTodo(str);
        }

        return updateTodo;
    }

    public Todo updateTodo(Todo todo) { // todo 객체를 받아서 저장하도록
        Todo updateTodo = todoRepository.save(todo);

        return updateTodo;
    }

    public void deleteTodo(Long id) {
//        Optional<Todo> todo = todoRepository.findById(id);
//
//        if (todo.isPresent()) {
//            todoRepository.delete(todo.get());
//        }
//        todo.ifPresent(value -> todoRepository.delete(value));

        todoRepository.deleteById(id);
    }
}
