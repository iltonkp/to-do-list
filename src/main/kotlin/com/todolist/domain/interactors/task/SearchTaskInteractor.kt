package com.todolist.domain.interactors.task

import com.todolist.domain.interactors.Interactor
import com.todolist.domain.models.Task
import com.todolist.domain.ports.TaskRepositoryPort
import org.springframework.stereotype.Service

@Service
class SearchTaskInteractor(
    private val taskRepositoryPort: TaskRepositoryPort
) : Interactor<String, List<Task>> {

    override fun execute(request: String): List<Task> =
        taskRepositoryPort.findAll(request)

    interface TaskRepository {
        fun findAll(date: String): List<Task>
    }
}