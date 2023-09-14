package com.eldenring.tarnished_bot.service

import com.eldenring.tarnished_bot.entity.Boss
import com.eldenring.tarnished_bot.utils.component.WebClientComponent
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Slf4j
@Service
class BossService(
    @Autowired
    var webClientComponent: WebClientComponent
    ) {

}