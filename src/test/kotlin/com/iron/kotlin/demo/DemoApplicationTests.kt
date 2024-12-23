package com.iron.kotlin.demo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class DemoApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun lotto() {
		repeat((0 .. 4).count()) {
			val lottoBall = mutableListOf<Int>()
			(1 .. 45).forEach { lottoBall.add(it) }

			val winBall = mutableListOf<Int>()
			repeat((0..5).count()) {
				val winIndex = Random.nextInt(lottoBall.size)
				winBall.add(lottoBall[winIndex])
				lottoBall.removeAt(winIndex)
			}

			winBall.sort()
			println(winBall)
		}
	}

	@Test
	fun pension() {
		repeat((0 .. 4).count()) {
			val winNumber = mutableListOf<Int>()
			repeat((0..5).count()) {
				winNumber.add(Random.nextInt(10))
			}

			println(winNumber)
		}
	}
}
