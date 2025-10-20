package org.delivery.apigw

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiGWApplication {

}

fun main(args: Array<String>) {
    runApplication<ApiGWApplication>(*args)
}