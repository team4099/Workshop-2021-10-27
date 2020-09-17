package com.team4099.lib.units

import kotlin.math.absoluteValue

inline class Value<T: UnitKey>(internal val value: Double) : Comparable<Value<T>> {
  val absoluteValue: Value<T> get() = Value<T>(value.absoluteValue)

  operator fun plus(o: Value<T>): Value<T> { return Value(value + o.value) }
  operator fun minus(o: Value<T>): Value<T> { return Value(value - o.value) }

  operator fun times(k: Double): Value<T> { return Value(value * k) }
  operator fun times(k: Number): Value<T> { return div(k.toDouble()) }

  operator fun div(k: Double): Value<T> { return Value(value / k) }
  operator fun div(k: Number): Value<T> { return div(k.toDouble()) }

  override operator fun compareTo(o: Value<T>): Int = value.compareTo(o.value)
}
