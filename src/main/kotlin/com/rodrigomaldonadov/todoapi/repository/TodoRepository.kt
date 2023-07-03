package com.rodrigomaldonadov.todoapi.repository

import com.rodrigomaldonadov.todoapi.model.TodoModel
import org.springframework.data.mongodb.repository.MongoRepository

interface TodoRepository : MongoRepository<TodoModel, String>