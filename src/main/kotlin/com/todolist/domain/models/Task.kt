package com.todolist.domain.models


import java.time.LocalDate

data class Task(
    val id: String? = null ,
    val title: String? = null,
    val description: String,
    val isActive: Boolean = true,
    val taskDate: LocalDate
)
