package com.eldenring.tarnished_bot.utils.component

import com.eldenring.tarnished_bot.entity.Boss
import com.eldenring.tarnished_bot.enums.Bosses
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
class BossComponent (@Autowired
                     var webClientComponent: WebClientComponent){

    fun getBossInfo(bossName:String): Boss?{
        val array = enumValues<Bosses>()
        var bossId:String? = null
        for (boss in array) {
            if(boss.bossName == bossName){
                bossId = boss.bossId
                break
            }
        }
        if(bossId == null){
            return null
        }

        val result = webClientComponent.getBossRequest("bosses/", bossId)
        return result
    }
}