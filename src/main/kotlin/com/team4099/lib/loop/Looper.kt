package com.team4099.lib.loop

class Looper(vararg loops: Loop) : Loop {
  private val loops = mutableListOf(*loops)

  fun register(loop: Loop) {
    loops.add(loop)
  }

  override fun onStart() {
    loops.forEach { it.onStart() }
  }

  override fun onLoop() {
    loops.forEach { it.onLoop() }
  }

  override fun onStop() {
    loops.forEach { it.onStop() }
  }
}
