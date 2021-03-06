package com.di.civ

import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import java.io.File

class DetailsController {

    lateinit var lTerreno: Label
    lateinit var lColorTerreno: Label
    lateinit var lColorTexto: Label
    lateinit var nombreUnidad: Label
    lateinit var lImagen: ImageView
    lateinit var imagenUnidad: ImageView
    lateinit var lTransitable: Label
    lateinit var boton1 : Button
    lateinit var boton2 : Button
    lateinit var botonCurarse : Button
    lateinit var imagen2: ImageView
    var mapController:MapController? = null
    var terreno:Terreno?=null


    var granja = File("src\\main\\resources\\images\\ic_granja.png")
    var saquear = File("src\\main\\resources\\images\\ic_saqueo.png")
    var conquistar = File("src\\main\\resources\\images\\ic_corona.png")
    var mina = File("src\\main\\resources\\images\\ic_mina.png")

    fun enviarTerreno(terreno: Terreno) {
        this.terreno = terreno
        lTerreno.text = terreno.nombre
        nombreUnidad.text = terreno.unidad?.nombre
        lColorTerreno.style = "-fx-background-color: ${terreno.colorTerreno};"
        lColorTexto.style = "-fx-background-color: ${terreno.colorTexto};"
        terreno.unidad?.imagen?.let {
            val g = File(it)
            imagenUnidad.image = Image(g.toURI().toURL().toString())
        }
        val f = File(terreno.imagen)
        lImagen.image = Image(f.toURI().toURL().toString())
        if (terreno.sePuedeAndarSobreEl) {
            lTransitable.text = "Transitable"
        } else
            lTransitable.text = "No transitable"

        if (terreno.unidad?.personajeMio == true){
            botonCurarse.text = "Curarse"
            botonCurarse.isVisible = true
        }
        else {
            botonCurarse.isVisible = false
        }


        when (terreno.nombre) {
            "Llanura" -> {
                boton1.text = "Crear Granja"
                boton2.isVisible = false
            }
            "Ciudad" -> {
                boton1.text = "Saquear"
                boton2.text = "Conquistar"
            }
            "Colina" -> {
                boton1.text = "Crear mina"
                boton2.isVisible = false
            }
            "Bosque" -> {
                boton1.isVisible = false
                boton2.isVisible = false
            }
            "Mar" -> {
                boton1.isVisible = false
                boton2.isVisible = false
            }
            "Monta??a" -> {
                boton1.isVisible = false
                boton2.isVisible = false
            }
            "Desconocido" -> {
                boton1.isVisible = false
                boton2.isVisible = false
            }

        }
        when (terreno.estado) {
            "Con Granja" -> {
                imagen2.image = Image(granja.toURI().toURL().toString())
            }
            "Con Mina" -> {
                imagen2.image = Image(mina.toURI().toURL().toString())
            }
            "Conquistado" -> {
                imagen2.image = Image(conquistar.toURI().toURL().toString())
            }
            "Saqueado" -> {
                imagen2.image = Image(saquear.toURI().toURL().toString())
            }
        }

    }

    fun enviarMapController(mapController: MapController){
        this.mapController = mapController
    }

    fun presionaBoton1() {
       when ( boton1.text ) {
           "Crear Granja" -> {
               imagen2.image = Image(granja.toURI().toURL().toString())
               terreno?.estado = Terreno.CON_GRANJA
               mapController?.posiActual()

           }
           "Saquear" -> {
               imagen2.image = Image(saquear.toURI().toURL().toString())
               terreno?.estado = Terreno.SAQUEADO
               mapController?.posiActual()

           }
           "Crear mina" -> {
               imagen2.image = Image(mina.toURI().toURL().toString())
               terreno?.estado = Terreno.CON_MINA
               mapController?.posiActual()

           }
       }
    }
    fun presionaBoton2() {
        if (boton2.text == "Conquistar") {
            imagen2.image = Image(conquistar.toURI().toURL().toString())
            terreno?.estado = Terreno.CONQUISTADO
            mapController?.posiActual()

        }

    }

}
