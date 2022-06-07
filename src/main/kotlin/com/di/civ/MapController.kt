package com.di.civ

import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import java.io.File
import java.io.InputStream
import kotlin.random.Random

class MapController {

    lateinit var root: GridPane
    lateinit var posicion: Label
    lateinit var labelTerreno: Label
    private val mapa = Mapa()
    private var subMapa = mapa.obtenerSubMapa()


    fun initialize() {
        iniciarGridPane()
        rellenarGirdPaneConMapa(subMapa)
    }

    private fun iniciarGridPane() {
        for (fila in 0 until Configuracion.filasCampoVision)
            for (columna in 0 until Configuracion.columnasCampoVision) {
                val anchorPane = AnchorPane()
                anchorPane.children.add(0, ImageView())
                anchorPane.children.add(1, Label("fila $fila columna $columna"))
                anchorPane.children.add(2, ImageView())
                root.add(anchorPane, columna, fila)
            }
        root.hgap = 5.0
        root.vgap = 5.0
        root.padding = Insets(50.0, 50.0, 50.0, 50.0)
    }


    private fun rellenarGirdPaneConMapa(subMapa: MutableList<MutableList<Terreno>>) {
        var pos = 0
        subMapa.forEach { terrenos ->
            terrenos.forEach { terreno ->
                val anchorPane = root.children[pos]
                anchorPane as AnchorPane
                anchorPane.style = "-fx-background-color: ${terreno.colorTerreno};" // $terreno.color
                anchorPane.setOnMouseClicked {

                    abrirVentanaDetails(terreno)
                }

                val imageView = anchorPane.children[0] as ImageView
                val f = File(terreno.imagen)
                imageView.fitHeight = 80.0
                imageView.fitWidth = 80.0
                imageView.image = Image(f.toURI().toURL().toString())

                val label = anchorPane.children[1] as Label
                label.text = terreno.nombre
                label.maxWidth = 80.0
                label.minWidth = 80.0
                label.style = "-fx-background-color: ${terreno.colorTexto};"
                label.alignment = Pos.CENTER
                label.layoutX = 0.0
                label.layoutY = 70.0
                if (terreno.estado.isEmpty()) {
                    label.text = mostrarTerrenoActual(terreno)
                }
                else
                    label.text = terreno.estado



                val imagenUnidad = anchorPane.children[2] as ImageView
                terreno.unidad?.let {
                    imagenUnidad.isVisible = true
                    val f = File(it.imagen)
                    imagenUnidad.fitHeight = 20.0
                    imagenUnidad.fitWidth = 20.0
                    imagenUnidad.image = Image(f.toURI().toURL().toString())
                    imagenUnidad.layoutX = 0.0
                    imagenUnidad.layoutY = 0.0
                } ?: kotlin.run {
                    imagenUnidad.image = null
                    imagenUnidad.isVisible = false
                }
                pos++
            }
        }
        mostrarPosicionActual()

    }

    fun moverArriba() {
        println("moverArriba")
        mapa.moverArriba()
        rellenarGirdPaneConMapa(mapa.obtenerSubMapa())
        mostrarPosicionActual()
    }

    fun moverAbajo() {
        println("moverAbajo")
        mapa.moverAbajo()
        rellenarGirdPaneConMapa(mapa.obtenerSubMapa())
        mostrarPosicionActual()
    }

    fun moverIzquierda() {
        println("moverIzquierda")
        mapa.moverIzquierda()
        rellenarGirdPaneConMapa(mapa.obtenerSubMapa())
        mostrarPosicionActual()
    }

    fun moverDerecha() {
        println("moverDerecha")
        mapa.moverDerecha()
        rellenarGirdPaneConMapa(mapa.obtenerSubMapa())
        mostrarPosicionActual()
    }

    fun posiActual() {
        subMapa = mapa.obtenerSubMapa()
        rellenarGirdPaneConMapa(subMapa)
        mostrarPosicionActual()
    }

    fun posiInicial(){
        mapa.centrarAlCero()
        subMapa = mapa.obtenerSubMapa()
        rellenarGirdPaneConMapa(subMapa)
        mostrarPosicionActual()
    }
    fun mostrarPosicionActual(){
        posicion.text="Mi posicion es ("+mapa.obtenerFilaActual()+","+mapa.obtenerColumnaActual()+")"
    }
    fun mostrarTerrenoActual(terreno: Terreno): String{
        return terreno.nombre

    }

    fun abrirVentanaDetails(terreno: Terreno){

        val stage = Stage()
        val loader = FXMLLoader(javaClass.getResource("details.fxml"))
        val root = loader.load<AnchorPane>()
        val scene = Scene(root,500.0,500.0)
        stage.scene = scene
        stage.show()
        val detailsController = loader.getController<DetailsController>()
        detailsController.enviarTerreno(terreno)
        detailsController.enviarMapController(this)
    }


}