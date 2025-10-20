package org.delivery.api.domain

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/temp")
class TempApiController {

    @GetMapping("")
    fun temp(): String {
        return "Hello kotlin spring boot"
    }
}