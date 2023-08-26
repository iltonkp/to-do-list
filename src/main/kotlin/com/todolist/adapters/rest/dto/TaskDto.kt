package com.todolist.adapters.rest.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.todolist.domain.models.Task
import java.time.LocalDate

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TaskDto(
    val id: String? = null,
    val title: String? = null,
    val description: String,
    val isActive: Boolean = true,
    val date: LocalDate
)

fun TaskDto.toTask() =
    Task(
        id = this.id,
        title = this.title,
        description = this.description,
        isActive = this.isActive,
        date = this.date,
    )

fun Task.toTaskDto() =
    TaskDto(
        id = this.id,
        title = this.title,
        description = this.description,
        isActive = this.isActive,
        date = this.date,
    )