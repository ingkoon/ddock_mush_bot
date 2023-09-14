package com.eldenring.tarnished_bot.utils.component

import com.eldenring.tarnished_bot.entity.Boss
import mu.KotlinLogging

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.util.UriComponentsBuilder
import java.util.NoSuchElementException


@Component
class WebClientComponent() {
    final val url: String = "https://eldenring.fanapis.com/api/"
    val log  = KotlinLogging.logger{};
    val webClientComponent : WebClient = WebClient
        .builder()
        .baseUrl(url)
        .build()
    fun getBossRequest(path: String, queryParam: String) : Boss? {
        val uri = UriComponentsBuilder
            .fromUriString(url)
            .path(path)
            .path(queryParam)
            .build().toUri()

        val resultMap = webClientComponent
            .get()
            .uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono<Map<String, Any>>()
            .block()

        if (resultMap != null) {
            log.info { resultMap.get("success") }
        }

        if (resultMap != null) {
            if(resultMap["success"] == true) {
                return toEntity(resultMap["data"] as Map<*, *>)
            }
            else{
                throw NoSuchElementException()
            }
        }
        return null
    }

    fun toEntity(map: Map<*, *>): Boss{
        log.info { map.get("drops")?.javaClass?.name }
        val boss : Boss = Boss(
            id = map["id"] as String,
            name = map["name"] as String,
            image = map["image"] as String,
            description = map["description"] as String,
            location = map["location"] as String,
            drops = map["drops"] as List<String>,
            healthPoints = map["healthPoints"] as String?
        )
        return boss
    }
}