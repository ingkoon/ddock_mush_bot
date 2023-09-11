package com.eldenring.tarnished_bot.utils.component

import lombok.Getter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Getter
@Component
class DiscordBotToken {
    @Value("\${discord.api-key}")
    lateinit var discordBotToken : String
}