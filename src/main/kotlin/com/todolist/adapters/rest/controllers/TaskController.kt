package com.todolist.adapters.rest.controllers

import com.todolist.adapters.rest.dto.TaskDto
import com.todolist.adapters.rest.dto.toTask
import com.todolist.domain.interactors.InteractorExecutor
import com.todolist.domain.interactors.task.CreateTaskInteractor
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/task")
class TaskController(
    private val interactorExecutor: InteractorExecutor,
    private val createTaskInteractor: CreateTaskInteractor
) {

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun addNewTask(@RequestBody task: TaskDto) =
        interactorExecutor(
            interactor = createTaskInteractor,
            requestDto = task,
            requestConverter = {it.toTask()},
            responseConverter = {_ -> ResponseEntity<Unit>(HttpStatus.CREATED)}
        )
}