package com.eldenring.tarnished_bot.utils.config

import com.eldenring.tarnished_bot.utils.component.DiscordBotToken
import com.eldenring.tarnished_bot.utils.component.DiscordListener
import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.context.annotation.Configuration

@Slf4j
@Configuration
class JdaConfiguration(
    final val discordBotToken: DiscordBotToken,
    final val discordListener: DiscordListener,
) {
    final val message : String = "버섯 동네로 탈바꿈"
    val log = KotlinLogging.logger{}

    val jda : JDA = JDABuilder.createDefault(discordBotToken.discordBotToken)
        .setActivity(Activity.playing(message))
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .addEventListeners(discordListener)
        .build()
}
