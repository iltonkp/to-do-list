package com.todolist.adapters.dataproviders.repositories

import com.todolist.adapters.dataproviders.entities.TaskEntity
import com.todolist.adapters.dataproviders.entities.toTask
import com.todolist.adapters.dataproviders.entities.toTaskEntity
import com.todolist.domain.models.Task
import com.todolist.domain.ports.TaskRepositoryPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class JpaTaskRepository(
    private val postgresTaskRepository: PostgresTaskRepository
) : TaskRepositoryPort {

    @Transactional
    override fun upsertTask(task: Task) {
        postgresTaskRepository.run { save(task.toTaskEntity()) }
    }

    override fun searchTasksByDate(date: LocalDate): List<Task> =
        postgresTaskRepository.findAll(
            TaskEntitySpecifications.by(date)
        ).map(TaskEntity::toTask)
}