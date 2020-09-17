package com.team4099.lib.units.base

import com.team4099.lib.units.UnitKey
import com.team4099.lib.units.Value
import com.team4099.lib.units.atto
import com.team4099.lib.units.centi
import com.team4099.lib.units.deca
import com.team4099.lib.units.deci
import com.team4099.lib.units.exa
import com.team4099.lib.units.femto
import com.team4099.lib.units.giga
import com.team4099.lib.units.hecto
import com.team4099.lib.units.kilo
import com.team4099.lib.units.mega
import com.team4099.lib.units.micro
import com.team4099.lib.units.milli
import com.team4099.lib.units.nano
import com.team4099.lib.units.peta
import com.team4099.lib.units.pico
import com.team4099.lib.units.tera
import com.team4099.lib.units.yocto
import com.team4099.lib.units.yotta
import com.team4099.lib.units.zepto
import com.team4099.lib.units.zeta

object Gram : UnitKey

typealias Mass = Value<Gram>

internal const val GRAMS_PER_POUND = 453.5924

val Double.grams: Mass get() = Mass(this)
val Double.pounds: Mass get() = Mass(this * GRAMS_PER_POUND)

val Number.grams: Mass get() = toDouble().grams
val Number.pounds: Mass get() = toDouble().pounds

val Mass.inGrams : Double get() = value
val Mass.inPounds : Double get() = value / GRAMS_PER_POUND

val Mass.inYottagrams : Double get() = value.yotta
val Mass.inZetagrams : Double get() = value.zeta
val Mass.inExagrams : Double get() = value.exa
val Mass.inPetagrams : Double get() = value.peta
val Mass.inTeragrams : Double get() = value.tera
val Mass.inGigaagrams : Double get() = value.giga
val Mass.inMegagrams : Double get() = value.mega
val Mass.inKilograms : Double get() = value.kilo
val Mass.inHectograms : Double get() = value.hecto
val Mass.inDecagrams : Double get() = value.deca
val Mass.inDecigrams : Double get() = value.deci
val Mass.inCentigrams : Double get() = value.centi
val Mass.inMilligrams : Double get() = value.milli
val Mass.inMicrograms : Double get() = value.micro
val Mass.inNanograms : Double get() = value.nano
val Mass.inPicograms : Double get() = value.pico
val Mass.inFemtograms : Double get() = value.femto
val Mass.inAttograms : Double get() = value.atto
val Mass.inZeptograms : Double get() = value.zepto
val Mass.inYoctograms : Double get() = value.yocto
