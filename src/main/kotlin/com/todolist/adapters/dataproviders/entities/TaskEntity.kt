package com.todolist.adapters.dataproviders.entities

import com.todolist.domain.models.Task
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "Tasks")
data class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,
    val title: String? = null,
    val description: String? = null,
    @Column(name = "is_active")
    val isActive: Boolean? = true,
    val taskDate: LocalDate? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TaskEntity) return false

        return id != null && id == other.id
    }

    override fun hashCode(): Int = 31

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}

fun TaskEntity.toTask() =
    Task(
        id = this.id,
        title = this.title,
        description = this.description!!,
        isActive = this.isActive!!,
        taskDate = this.taskDate!!
    )

fun Task.toTaskEntity() =
    TaskEntity(
        title = this.title,
        description = this.description,
        isActive = this.isActive,
        taskDate = this.taskDate
    )