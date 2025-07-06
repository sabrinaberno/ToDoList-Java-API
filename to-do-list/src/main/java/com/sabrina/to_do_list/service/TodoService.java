package com.sabrina.to_do_list.service;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sabrina.to_do_list.entity.Todo;
import com.sabrina.to_do_list.repository.TodoRepository;

@Service
public class TodoService {
    //por que o repository que foi chamado aqui? Estudar melhor arquitetura MVC
    private TodoRepository todoRepository;
    
    // injeção de dependencias -- revisar --> https://www.youtube.com/watch?v=CSsB53HCC3A
    //poderia usar no lugar o @Autowired 
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list(); 
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Long id, Todo todo) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
        todo.setId(id);
        todoRepository.save(todo);
        }, () -> {
            //throw new BadRequestException("Todo %d não existe! ".formatted(id));
        });

        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
