package com.todolist.adapters.dataproviders.repositories

import com.todolist.adapters.dataproviders.entities.TaskEntity
import com.todolist.adapters.dataproviders.entities.TaskEntity_
import jakarta.persistence.criteria.Predicate
import org.springframework.data.jpa.domain.Specification
import java.time.LocalDate

object TaskEntitySpecifications {

    fun by(date: LocalDate): Specification<TaskEntity> =
        Specification<TaskEntity> { root, _, builder ->
            builder.equal(root.get(TaskEntity_.date), date)
        }
}