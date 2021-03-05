package de.kolpa.mc.sleepmanager.util

import org.bukkit.plugin.java.JavaPlugin

fun JavaPlugin.scheduleSyncDelayed(delay: Long, func: () -> Unit) {
    this.server.scheduler.scheduleSyncDelayedTask(this, func, delay)
}
