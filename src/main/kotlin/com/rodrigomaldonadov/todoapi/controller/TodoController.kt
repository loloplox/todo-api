package com.rodrigomaldonadov.todoapi.controller

import com.rodrigomaldonadov.todoapi.model.TodoRequest
import com.rodrigomaldonadov.todoapi.service.TodoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
@CrossOrigin(
    origins = ["http://localhost:5173"],
    methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE]
)
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping("/todos/{id}")
    fun getTodo(@PathVariable id: String) = todoService.getTodo(id)

    @GetMapping("/todos")
    fun getTodos() = todoService.getTodos()

    @PostMapping("/todos")
    fun createTodo(@RequestBody todo: TodoRequest) = todoService.createTodo(todo)

    @PutMapping("/todos/{id}")
    fun updateTodo(@RequestBody todo: TodoRequest, @PathVariable id: String) = todoService.updateTodo(id, todo)

    @DeleteMapping("/todos/{id}")
    fun deleteTodoById(@PathVariable id: String) = todoService.deleteTodo(id)
}