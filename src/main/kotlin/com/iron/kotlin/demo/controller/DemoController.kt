package com.iron.kotlin.demo.controller

import com.iron.kotlin.demo.model.Person
import com.iron.kotlin.demo.service.DemoService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("api/demo")
class DemoController(val demoService: DemoService) : DefaultController() {

    @GetMapping("/info")
    fun demoInfo(): List<Person> {
        return demoService.createPersons()
    }

    @GetMapping("/nullable")
    fun nullTest(): List<Int> {
        val list = mutableListOf(1, 2, 3)
        logger.info { "first list : $list" }

        list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'

        logger.info { "last list : $list" }

        return list
    }
}