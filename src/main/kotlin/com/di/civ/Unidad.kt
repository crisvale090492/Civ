package com.di.civ

import kotlin.random.Random

abstract class Unidad (var nombre : String,var vidaMaxima: Int,var vidaActual : Int, var imagen : String,var seleccionado : Boolean = false,var personajeMio: Boolean = false) {

    override fun toString(): String {
        return nombre
    }

    abstract fun atacar(unidadEnemiga : Unidad)

    abstract fun curar()
}

class Caballero() : Unidad("Caballero", 100,100, "src\\main\\resources\\images\\Knight.png",false,false) {
    override fun atacar(unidadEnemiga : Unidad) {

        unidadEnemiga.vidaActual  -= Random.nextInt(25,50)

        vidaActual -= Random.nextInt(25,50)
    }
    override fun curar() {
        vidaActual += Random.nextInt(50,75)
    }
}

class Guerrero() : Unidad("Guerrero", 100,100, "src\\main\\resources\\images\\Warrior.png",false,false) {
    override fun atacar(unidadEnemiga : Unidad) {

        unidadEnemiga.vidaActual  -= Random.nextInt(25,50)

        vidaActual -= Random.nextInt(25,50)
    }
    override fun curar() {
        vidaActual += Random.nextInt(50,75)
    }
}

class Lancero() : Unidad("Lancero", 100,100, "src\\main\\resources\\images\\Lancer.png",false,false) {
    override fun atacar(unidadEnemiga : Unidad) {

        unidadEnemiga.vidaActual  -= Random.nextInt(25,50)

        vidaActual -= Random.nextInt(25,50)
    }
    override fun curar() {
        vidaActual += Random.nextInt(50,75)
    }
}

