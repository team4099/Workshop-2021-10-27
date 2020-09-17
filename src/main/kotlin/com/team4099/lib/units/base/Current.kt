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

object Ampere : UnitKey

typealias Current = Value<Ampere>

val Double.amps: Current get() = Current(this)

val Number.amps: Current get() = this.toDouble().amps

fun Current.inAmperes() : Double = value

fun Current.inYottaamps() : Double = value.yotta
fun Current.inZetaamps() : Double = value.zeta
fun Current.inExaamps() : Double = value.exa
fun Current.inPetaamps() : Double = value.peta
fun Current.inTeraamps() : Double = value.tera
fun Current.inGigaaamps() : Double = value.giga
fun Current.inMegaamps() : Double = value.mega
fun Current.inKiloamps() : Double = value.kilo
fun Current.inHectoamps() : Double = value.hecto
fun Current.inDecaamps() : Double = value.deca
fun Current.inDeciamps() : Double = value.deci
fun Current.inCentiamps() : Double = value.centi
fun Current.inMilliamps() : Double = value.milli
fun Current.inMicroamps() : Double = value.micro
fun Current.inNanoamps() : Double = value.nano
fun Current.inPicoamps() : Double = value.pico
fun Current.inFemtoamps() : Double = value.femto
fun Current.inAttoamps() : Double = value.atto
fun Current.inZeptoamps() : Double = value.zepto
fun Current.inYoctoamps() : Double = value.yocto
