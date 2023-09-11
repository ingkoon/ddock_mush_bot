package com.eldenring.tarnished_bot.utils.config

import com.eldenring.tarnished_bot.utils.component.DiscordBotToken
import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Slf4j
@Configuration
class JdaConfiguration(
    final val discordBotToken: DiscordBotToken,
    final val discordListener: DiscordListener,
) {
    final val message : String = "고리의 포즈"
    val log = KotlinLogging.logger{}

    val jda : JDA = JDABuilder.createDefault(discordBotToken.discordBotToken)
        .setActivity(Activity.playing(message))
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .addEventListeners(discordListener)
        .build()
}
