package com.iron.kotlin.demo.controller

import com.iron.kotlin.demo.model.Person
import com.iron.kotlin.demo.service.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/demo")
class DemoController(val demoService: DemoService) {

    @GetMapping("/info")
    fun demoInfo(): List<Person> {
        return demoService.createPersons()
    }
}