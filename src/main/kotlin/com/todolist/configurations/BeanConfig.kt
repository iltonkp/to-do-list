package com.todolist.configurations

import com.todolist.domain.interactors.InteractorExecutorImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

    @Bean
    fun interactorExecutor() = InteractorExecutorImpl()
}