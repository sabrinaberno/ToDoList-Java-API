package com.sabrina.to_do_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sabrina.to_do_list.entity.Todo;
import com.sabrina.to_do_list.repository.TodoRepository;

@Service
public class TodoService {
    //por que o repository que foi chamado aqui? Estudar melhor arquitetura MVC
    private TodoRepository tododRepository;
    
    // injeção de dependencias -- revisar --> https://www.youtube.com/watch?v=CSsB53HCC3A
    //poderia usar no lugar o @Autowired 
    public TodoService(TodoRepository tododRepository) {
        this.tododRepository = tododRepository;
    }


    public List<Todo> create(Todo todo) {
        tododRepository.save(todo);
        return list(); 
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("name").ascending()
        );
        return tododRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        tododRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        tododRepository.deleteById(id);
        return list();
    }
}
