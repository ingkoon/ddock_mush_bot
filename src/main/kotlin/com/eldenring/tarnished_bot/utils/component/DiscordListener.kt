package com.eldenring.tarnished_bot.utils.component

import com.eldenring.tarnished_bot.drop.service.DropService
import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.StringBuilder

@Slf4j
@Component
class DiscordListener(
    @Autowired
    var dropService: DropService,
) : ListenerAdapter() {
    private val log = KotlinLogging.logger {}

    @Override
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
                val returnMessage = "올바른 명령어가 아닙니다."
                channel.sendMessage(returnMessage).queue()
                return
            }

            val sb = StringBuilder()
            for (i:Int in 1 until strings.size)
                sb.append(strings[i]).append(" ")
            sb.deleteCharAt(sb.length-1)
            log.info { sb.toString() }
            val result = when (strings[0]) {
                "드랍" -> dropService.readAllByMonstername(sb.toString())
                "아이템" -> dropService.readAllByItemName(sb.toString())
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

    fun sendMessage(
        event: MessageReceivedEvent,
        message: String
    ) : String{
        val user : User = event.author
        var returnMessage : String = ""
        returnMessage = when(message){
            "보스" -> "개발중"
            else -> "돌아가고 싶어"
        }
        return returnMessage
    }
}