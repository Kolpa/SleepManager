package de.kolpa.mc.sleepmanager

import org.koin.dsl.module

val sleepManagerModule = module {
    single { BedInteractionHandler(get(), get()) }
}