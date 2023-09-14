package com.eldenring.tarnished_bot.utils.component

import com.eldenring.tarnished_bot.entity.Boss
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import com.google.gson.stream.JsonReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.Reader
import java.io.StringReader
import java.util.*


@SpringBootTest
internal class WebClientComponentTest(
    @Autowired
    var webClientComponent: WebClientComponent
    ){

    @Test
    fun getBossData(){
        val path : String = "bosses/"
        val queryParam : String = "17f69590896l0i1ul0hnmor8iyf9xd"
        val mono = webClientComponent.getBossRequest(path, queryParam)

        val result = mono.toString()
        if (mono != null) {
            println(println(result));
        }
    }
}