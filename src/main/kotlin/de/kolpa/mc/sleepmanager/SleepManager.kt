package de.kolpa.mc.sleepmanager

import de.kolpa.mc.sleepmanager.handlers.BedInteractionHandler
import de.kolpa.mc.sleepmanager.handlers.OpTheGamer
import de.kolpa.mc.sleepmanager.koin.KoinPlugin
import org.bukkit.event.HandlerList
import org.koin.core.component.inject

class SleepManager : KoinPlugin(arrayOf(sleepManagerModule)) {
    override fun onEnable() {
        super.onEnable()

        val bedInteractionHandler by inject<BedInteractionHandler>()
        server.pluginManager.registerEvents(bedInteractionHandler, this)

        val opTheGamer by inject<OpTheGamer>()
        server.pluginManager.registerEvents(opTheGamer, this)
    }

    override fun onDisable() {
        val bedInteractionHandler by inject<BedInteractionHandler>()
        HandlerList.unregisterAll(bedInteractionHandler)

        val opTheGamer by inject<OpTheGamer>()
        HandlerList.unregisterAll(opTheGamer)

        super.onDisable()
    }
}