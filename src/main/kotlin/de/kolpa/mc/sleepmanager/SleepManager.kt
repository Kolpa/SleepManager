package de.kolpa.mc.sleepmanager

import de.kolpa.mc.sleepmanager.koin.KoinPlugin
import org.bukkit.event.HandlerList
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.inject

@KoinApiExtension
class SleepManager : KoinPlugin(arrayOf(sleepManagerModule)) {
    override fun onEnable() {
        super.onEnable()

        val bedInteractionHandler by inject<BedInteractionHandler>()
        server.pluginManager.registerEvents(bedInteractionHandler, this)
    }

    override fun onDisable() {
        val bedInteractionHandler by inject<BedInteractionHandler>()
        HandlerList.unregisterAll(bedInteractionHandler)

        super.onDisable()
    }
}