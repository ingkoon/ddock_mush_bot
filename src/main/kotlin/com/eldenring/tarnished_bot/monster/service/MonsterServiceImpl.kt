package com.eldenring.tarnished_bot.monster.service

import com.eldenring.tarnished_bot.monster.repository.MonsterRepository
import com.eldenring.tarnished_bot.drop.dto.DropInfo
import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.StringBuilder

@Slf4j
@Service
class MonsterServiceImpl @Autowired constructor(
    val monsterRepository: MonsterRepository) : MonsterService{

    private val log = KotlinLogging.logger {}

    override fun readByName(name: String): String {
        val monster = monsterRepository.findByMonstername(name)
        val sb : StringBuilder = StringBuilder()
        sb.append(monster.name).append("\n")

        sb.append("체력: ").append(monster.hp)


        TODO("Not yet implemented")
    }

    override fun readById(id: Long): String {
        TODO("Not yet implemented")
    }

//    override fun onMessageReceived(event: MessageReceivedEvent) {
//        val user : User = event.author
//        val channel : TextChannel = event.channel.asTextChannel()
//        val message : Message = event.message
//
//        val messageList : List<String> = message.contentDisplay.split(" ")
//
//        if(messageList[0] == "드랍"){
//            val messageArray: Array<String> = messageList.toTypedArray()
//            val strings : Array<String> = messageArray.copyOfRange(1, messageArray.size)
//            log.info { strings.contentToString() }
//            if(strings.isEmpty()) {
//                val returnMessage : String = "몬스터 이름이 유효하지 않습니다."
//                channel.sendMessage(returnMessage).queue()
//                return
//            }
//            val result = when (strings[0]) {
//
//                "보스" -> bossComponent.getBossInfo(strings[1]).toString()
//                else -> "이 너머 오타있다"
//            }
//            log.info { result }
//            channel.sendMessage(result).queue()
////            for (s in strings) {
////                val returnMessage : String = sendMessage(event, s)
////                channel.sendMessage(returnMessage).queue()
////            }
//        }
//    }
}