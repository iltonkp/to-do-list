package com.todolist.configurations

import com.todolist.domain.exceptions.InvalidDateException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerConfig {

    @ExceptionHandler
    fun handleInvalidDateException(ex: InvalidDateException): ResponseEntity<ErrorDto> {
        val errorDto = ErrorDto(
            statusCode = HttpStatus.BAD_REQUEST.value(),
            message = ex.message
        )

        return ResponseEntity(errorDto, HttpStatus.BAD_REQUEST)
    }

    class ErrorDto(var statusCode: Int? = null, var message: String? = "")
}