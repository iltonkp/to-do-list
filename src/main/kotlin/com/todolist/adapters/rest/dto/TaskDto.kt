package com.todolist.adapters.rest.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.todolist.domain.models.Task
import java.time.LocalDate

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class TaskDto(
    val title: String? = null,
    val description: String,
    val isActive: Boolean = true,
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    val date: LocalDate
)

fun Task.toTaskDto() =
    TaskDto(
        title = this.title,
        description = this.description,
        date = this.date
    )

fun TaskDto.toTask() =
    Task(
        title = this.title,
        description = this.description,
        date = this.date,
    )