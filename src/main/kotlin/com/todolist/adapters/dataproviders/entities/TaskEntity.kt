package com.todolist.adapters.dataproviders.entities

import com.todolist.domain.models.Task
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.util.*


@Entity
@Table(name = "tasks")
data class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,
    val title: String? = null,
    @Column(nullable = false)
    val description: String,
    @Column(name = "is_active", nullable = false)
    val isActive: Boolean = true,
    @Column(name = "task_date", nullable = false)
    val date: LocalDate
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TaskEntity) return false
        return Objects.equals(id, other.id)
    }

    override fun hashCode(): Int = Objects.hash(id)

    override fun toString(): String {
        return "TaskEntity(id=$id, title=$title, description=$description, isActive=$isActive, date=$date)"
    }
}

fun TaskEntity.toTask() =
    Task(
        id = this.id,
        title = this.title,
        description = this.description,
        isActive = this.isActive,
        date = this.date
    )

fun Task.toTaskEntity() =
    TaskEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        isActive = this.isActive,
        date = this.date
    )