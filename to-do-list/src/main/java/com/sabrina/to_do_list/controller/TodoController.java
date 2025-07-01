package com.sabrina.to_do_list.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sabrina.to_do_list.entity.Todo;
import com.sabrina.to_do_list.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoServicie;
    
    public TodoController(TodoService todoServicie) {
        this.todoServicie = todoServicie;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
        return todoServicie.create(todo);
    }

    @GetMapping
    List<Todo> list(){
        return todoServicie.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoServicie.update(todo);
    }

    //revisar -- por que isso acontece no deleete e não acontece também no update?
    @DeleteMapping("{id}") //entre {} para dizer que esse valor será recuperado da requisição
    List<Todo> delete(@PathVariable("id") Long id){
        return todoServicie.delete(id);
    }
}
