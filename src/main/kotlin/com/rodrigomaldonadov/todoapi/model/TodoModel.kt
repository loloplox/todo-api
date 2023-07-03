package com.rodrigomaldonadov.todoapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class TodoModel(
    @Id
    val id: String? = null,
    val title: String,
    val complete: Boolean = false
)

data class TodoRequest(
    val title: String,
    val complete: Boolean = false
)

data class IdObjectRequest(
    @JsonProperty("timestamp")
    val timestamp: String,
    @JsonProperty("date")
    val date: String,
)
