package com.todolist.domain.ports

import com.todolist.domain.interactors.task.SearchTaskInteractor
import com.todolist.domain.interactors.task.UpsertTaskInteractor
import com.todolist.domain.models.Task
import java.time.LocalDate

interface TaskRepositoryPort {
    fun searchTasksByDate(date: LocalDate): List<Task>
    fun upsertTask(task: Task)
}