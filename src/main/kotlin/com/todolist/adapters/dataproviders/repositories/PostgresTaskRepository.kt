package com.todolist.adapters.dataproviders.repositories

import com.todolist.adapters.dataproviders.entities.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostgresTaskRepository : JpaRepository<TaskEntity, String>