package com.di.civ

data class Terreno(var nombre : String, val imagen  : String, val sePuedeAndarSobreEl : Boolean, val colorTerreno: String, val colorTexto: String, var estado : String = "") {

    override fun toString(): String {
        return nombre
    }
    companion object {

        const val  SAQUEADO = "Saqueado"
        const val  CONQUISTADO = "Conquistado"
        const val  CON_MINA = "Con mina"
        const val  CON_GRANJA = "Con Granja"

        fun crearLlanura(): Terreno {
            return Terreno("Llanura", "src\\main\\resources\\images\\llanura.png", true, "#70e9f5", "#22750b")
        }

        fun crearColina(): Terreno {
            return Terreno("Colina", "src\\main\\resources\\images\\colina.png", true, "#f1b07c", "#9af742")
        }

        fun crearBosque(): Terreno {
            return Terreno("Bosque", "src\\main\\resources\\images\\bosque.png", true, "#024705", "#55f866")
        }

        fun crearCiudad(): Terreno {
            return Terreno("Ciudad", "src\\main\\resources\\images\\pueblo.png", true, "#7c7f7c", "#bdc3bc")
        }

        fun crearMar(): Terreno {
            return Terreno("Mar", "src\\main\\resources\\images\\mar.png", false, "#2663e7", "#3054f7")
        }

        fun crearMontana(): Terreno {
            return Terreno("Montaña", "src\\main\\resources\\images\\montana.png", false, "#4ff31f", "#a8fb92")
        }

        fun crearTerrenoDesconocido(): Terreno {
            return Terreno("Desconocido", "src\\main\\resources\\images\\desconocido.png", false, "#32113a", "#dfe5dd")
        }
    }
}