package com.todolist.adapters.dataproviders.repositories

import com.todolist.adapters.dataproviders.entities.TaskEntity
import com.todolist.adapters.dataproviders.entities.toTask
import com.todolist.adapters.dataproviders.entities.toTaskEntity
import com.todolist.domain.models.Task
import com.todolist.domain.ports.TaskRepositoryPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class JpaTaskRepository(
    private val postgresTaskRepository: PostgresTaskRepository
) : TaskRepositoryPort {

    @Transactional
    override fun save(task: Task) {
        postgresTaskRepository.run { save(task.toTaskEntity()) }
    }

    override fun findAll(date: String): List<Task> =
        postgresTaskRepository.findAll().map(TaskEntity::toTask)
}