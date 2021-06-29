package de.kolpa.mc.sleepmanager.handlers

import de.kolpa.mc.sleepmanager.util.scheduleSyncDelayed
import de.kolpa.mc.sleepmanager.util.toTextComponent
import org.bukkit.Server.BROADCAST_CHANNEL_USERS
import org.bukkit.World
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger
import kotlin.random.Random

class BedInteractionHandler(
        private val logger: Logger,
        private val plugin: JavaPlugin
) : Listener {
    @EventHandler
    private fun onBedEnter(event: PlayerBedEnterEvent) {
        logger.info("${event.player.name} wants to enter a bed at ${event.bed.location}")

        if (event.bedEnterResult != PlayerBedEnterEvent.BedEnterResult.OK) {
            logger.info("Canceling fast sleep due to invalid bed enter")
            return
        }

        logger.info("Scheduling time set task for $BED_ENTER_TIME_SET_DELAY ticks in the future")

        plugin.server.broadcast("${event.player.name} went to bed".toTextComponent(), BROADCAST_CHANNEL_USERS)

        plugin.scheduleSyncDelayed(BED_ENTER_TIME_SET_DELAY) {
            setTime(event.bed.world)
        }
    }

    private fun setTime(world: World) {
        logger.info("Setting Time")

        world.apply {
            val newTimeOffset = time + SLEEP_TIME_SKIP
            time = newTimeOffset - newTimeOffset % SLEEP_TIME_SKIP

            setStorm(false)
            isThundering = false
            weatherDuration = Random.nextInt(MIN_WEATHER_DURATION, MAX_WEATHER_DURATION)
        }
    }

    companion object {
        private const val BED_ENTER_TIME_SET_DELAY = 4L * 20L
        private const val SLEEP_TIME_SKIP = 24000L
        private const val MIN_WEATHER_DURATION = 12000
        private const val MAX_WEATHER_DURATION = 168000
    }
}
