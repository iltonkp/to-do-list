package com.todolist.domain.ports

import com.todolist.domain.interactors.task.SearchTaskInteractor
import com.todolist.domain.interactors.task.UpsertTaskInteractor

interface TaskRepositoryPort : UpsertTaskInteractor.TaskRepository, SearchTaskInteractor.TaskRepository