package com.iron.kotlin.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	var context = runApplication<DemoApplication>(*args) {
		setDefaultProperties(hashMapOf("spring.profiles.default" to "dev") as Map<String, Any>?)
	}
	SpringApplication.exit(context)
}
