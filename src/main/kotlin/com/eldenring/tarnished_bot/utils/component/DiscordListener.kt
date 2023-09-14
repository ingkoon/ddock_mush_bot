package com.eldenring.tarnished_bot.utils.component

import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
class DiscordListener : ListenerAdapter() {
    @Autowired
    private lateinit var bossComponent: BossComponent
    private val log = KotlinLogging.logger {}

    @Override
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val user : User = event.author
        val channel : TextChannel = event.channel.asTextChannel()
        val message : Message = event.message

        val messageList : List<String> = message.contentDisplay.split(" ")

        if(messageList[0] == "오오"){
            val messageArray: Array<String> = messageList.toTypedArray()
            val strings : Array<String> = messageArray.copyOfRange(1, messageArray.size)
            log.info { strings.contentToString() }
            if(strings.isEmpty()) {
                val returnMessage : String = "돌아가고 싶어..."
                channel.sendMessage(returnMessage).queue()
                return
            }
            val result = when (strings[0]) {
                "보스" -> bossComponent.getBossInfo(strings[1]).toString()
                else -> "이 너머 오타있다"
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