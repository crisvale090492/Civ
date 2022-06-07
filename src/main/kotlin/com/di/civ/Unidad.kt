package com.di.civ

import kotlin.random.Random

open class Unidad (var nombre : String,var vidaMaxima: Int, var imagen : String) {

    override fun toString(): String {
        return nombre
    }
}

class Caballero() : Unidad("Caballero", 100, "src\\main\\resources\\images\\Knight.png") {
}

class Guerrero() : Unidad("Guerrero", 100, "src\\main\\resources\\images\\Warrior.png") {
}

class Lancero() : Unidad("Lancero", 100, "src\\main\\resources\\images\\Lancer.png") {
}

