package com.iron.kotlin.demo.service

import com.iron.kotlin.demo.model.DemoInfo
import org.springframework.stereotype.Service

@Service
class DemoService {

    fun createDemoInfo(): DemoInfo {
        val name: String = "whalen"
        val age: Int = 100

        return DemoInfo(name, age)
    }
}