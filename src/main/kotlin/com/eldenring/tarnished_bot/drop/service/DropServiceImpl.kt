package com.eldenring.tarnished_bot.drop.service

import com.eldenring.tarnished_bot.drop.repository.DropRepository
import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.StringBuilder

@Slf4j
@Service
class DropServiceImpl @Autowired constructor(
    val dropRepository: DropRepository
    ) : ListenerAdapter(), DropService {

    private val log = KotlinLogging.logger {}

    override fun readAllByMonstername(monsterName: String): String {
        val dropList = dropRepository.findByMonsterName(monsterName);
        val sb = StringBuilder()
        sb.append("몬스터명: ").append(dropList.get(0).monsterName).append("\n")
        for (drop in dropList) {
            if(drop.dropRate == "100.00%")
                continue
            sb.append("아이템명: ")
                .append(drop.itemName)
                .append("\t 드랍률: ")
                .append(drop.dropRate)
                .append("\n")
        }
        return sb.toString()
    }

    override fun readAllByItemName(itemName: String): String {
        val dropList = dropRepository.findByItemName(itemName)
        val sb = StringBuilder()
        sb.append("아이템명: ").append(itemName).append("\n")
        for (drop in dropList) {
            sb.append("몬스터 명: ")
                .append(drop.monsterName)
                .append("\t 드랍률: ")
                .append(drop.dropRate)
                .append("\n")
        }
        return sb.toString()
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val user : User = event.author
        val channel : TextChannel = event.channel.asTextChannel()
        val message : Message = event.message

        val messageList : List<String> = message.contentDisplay.split(" ")

        if(messageList[0] == "버섯"){
            val messageArray: Array<String> = messageList.toTypedArray()
            val strings : Array<String> = messageArray.copyOfRange(1, messageArray.size)
            log.info { strings.contentToString() }

            if(strings.isEmpty()) {
                val returnMessage : String = "올바른 명령어가 아닙니다."
                channel.sendMessage(returnMessage).queue()
                return
            }
            val result = when (strings[0]) {
                "드랍" -> this.readAllByMonstername(strings[1]).toString()
//                "드랍" -> bossComponent.getBossInfo(strings[1]).toString()
                else -> "틀렸어요"
            }
            log.info { result }
            channel.sendMessage(result).queue()
//            for (s in strings) {
//                val returnMessage : String = sendMessage(event, s)
//                channel.sendMessage(returnMessage).queue()
//            }
        }
    }
}