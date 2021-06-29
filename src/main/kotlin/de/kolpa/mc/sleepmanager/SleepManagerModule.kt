package de.kolpa.mc.sleepmanager

import de.kolpa.mc.sleepmanager.handlers.BedInteractionHandler
import de.kolpa.mc.sleepmanager.handlers.OpTheGamer
import org.koin.dsl.module

val sleepManagerModule = module {
    single { BedInteractionHandler(get(), get()) }
    single { OpTheGamer() }
}