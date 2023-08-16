package com.todolist.domain.interactors.task

import com.todolist.domain.interactors.Interactor
import com.todolist.domain.models.Task
import com.todolist.domain.ports.TaskRepositoryPort
import org.springframework.stereotype.Service

@Service
class CreateTaskInteractor(
    private val taskRepositoryPort: TaskRepositoryPort
) : Interactor<Task, Unit> {
    override fun execute(request: Task) {
        taskRepositoryPort.save(request)
    }

    interface TaskRepository {
        fun save(task: Task)
    }

}

