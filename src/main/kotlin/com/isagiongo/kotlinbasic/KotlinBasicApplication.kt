package com.isagiongo.kotlinbasic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KotlinBasicApplication

fun main(args: Array<String>) {
	runApplication<KotlinBasicApplication>(*args)
}
