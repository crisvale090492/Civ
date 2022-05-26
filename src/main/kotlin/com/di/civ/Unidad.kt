package com.di.civ

class Unidad (var tipo : String,var vidaMaxima: Int){

    override fun toString(): String {
        return tipo
    }
    companion object {

        fun crearCaballero(): Unidad {
            return Unidad("Caballero",100)
        }

        fun crearGuerrero(): Unidad {
            return Unidad("Guerrero",100)
        }

        fun crearLancero(): Unidad {
            return Unidad("Lancero",100)
        }
    }

}