package com.todolist.domain.interactors.task

import com.todolist.domain.exceptions.InvalidDateException
import com.todolist.domain.interactors.Interactor
import com.todolist.domain.models.Task
import com.todolist.domain.ports.TaskRepositoryPort
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UpsertTaskInteractor(
    private val taskRepositoryPort: TaskRepositoryPort
) : Interactor<Task, Unit> {
    override fun execute(request: Task) {

        if (request.date.isBefore(LocalDate.now()))
            throw InvalidDateException("The task date can not be before today.")

        taskRepositoryPort.upsertTask(request)
    }
}

