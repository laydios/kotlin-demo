package com.iron.kotlin.demo.service

import com.iron.kotlin.demo.model.Person
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class DemoService {

    fun createPersons(): List<Person> {
        val name: String = "whalen"
        val age: Int = 100

        var personList = mutableListOf<Person>()
        personList.add(Person("whalen dumb and", 47))
        personList.add(Person("laydios", 47))

        logger.info { "this is createPersons function!!" }

        return personList
    }

    fun createPerson(name: String,  age:Int ): Person {
        return Person(name, age)
    }

}