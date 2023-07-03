package com.rodrigomaldonadov.todoapi.service

import com.rodrigomaldonadov.todoapi.model.TodoModel
import com.rodrigomaldonadov.todoapi.model.TodoRequest
import com.rodrigomaldonadov.todoapi.repository.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TodoService(
    val todoRepository: TodoRepository
) {

    fun getTodo(id: String): ResponseEntity<TodoModel> {
        val todo = todoRepository.findById(id)
            .orElseThrow { Exception("Todo not found") }

        return ResponseEntity(todo, HttpStatus.OK)
    }

    fun getTodos(): ResponseEntity<List<TodoModel>> {
        val todos = todoRepository.findAll()

        return ResponseEntity(todos, HttpStatus.OK)
    }

    fun createTodo(todo: TodoRequest): ResponseEntity<TodoModel> {
        val newTodo = todoRepository.save(TodoModel(title = todo.title))

        return ResponseEntity(newTodo, HttpStatus.CREATED)
    }

    fun updateTodo(id: String, todo: TodoRequest): ResponseEntity<TodoModel> {
        val updatedTodo = todoRepository.findById(id)
            .orElseThrow { Exception("Todo not found") }
            .let {
                todoRepository.save(it.copy(title = todo.title, complete = todo.complete))
            }

        return ResponseEntity(updatedTodo, HttpStatus.OK)
    }

    fun deleteTodo(id: String): ResponseEntity<List<TodoModel>> {
        todoRepository.deleteById(id)
        val allTodos = todoRepository.findAll()

        return ResponseEntity(allTodos, HttpStatus.OK)
    }
}