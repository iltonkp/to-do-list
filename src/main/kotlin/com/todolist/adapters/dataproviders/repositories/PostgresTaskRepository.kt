package com.todolist.adapters.dataproviders.repositories

import com.todolist.adapters.dataproviders.entities.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PostgresTaskRepository : JpaRepository<TaskEntity, String>,
    JpaSpecificationExecutor<TaskEntity>