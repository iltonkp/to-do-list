package com.todolist.domain.interactors.task

import com.todolist.domain.interactors.Interactor
import com.todolist.domain.models.Task
import com.todolist.domain.ports.TaskRepositoryPort
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class SearchTaskInteractor(
    private val taskRepositoryPort: TaskRepositoryPort
) : Interactor<LocalDate?, List<Task>> {

    override fun execute(request: LocalDate?): List<Task> =
        taskRepositoryPort.findAll(request ?: LocalDate.now())

    interface TaskRepository {
        fun findAll(date: LocalDate): List<Task>
    }
}