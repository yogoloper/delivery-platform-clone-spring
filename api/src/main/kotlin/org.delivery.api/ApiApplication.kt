package org.delivery.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
public class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}