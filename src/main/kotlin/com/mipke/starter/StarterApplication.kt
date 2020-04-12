package com.mipke.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.mipke")
class StarterApplication

fun main(args: Array<String>) {
    runApplication<StarterApplication>(*args)
}
