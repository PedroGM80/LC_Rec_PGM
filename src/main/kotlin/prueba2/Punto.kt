package prueba2

import prueba2.Punto.Companion.distancia
import prueba2.Punto.Companion.localizacionGeograficaNStoString
import prueba2.Punto.Companion.mostrarComponenteDeVector
import kotlin.math.pow
import kotlin.math.sqrt


class Punto(private val id: String) {
    private var x: Int = 0
    private var y: Int = 0

    constructor(id: String, x: Int, y: Int) : this(id) {
        this.x = x
        this.y = y
    }

    companion object {
        @JvmStatic
        fun distancia(pA: Punto, pB: Punto): Double {
            val d1 = ((pB.x - pA.x).toDouble()).pow(2.0)
            val d2 = (pB.y - pA.y).toDouble().pow(2.0)
            return sqrt(d1 + d2)
        }

        @JvmStatic
        fun componenteDeVector(pA: Punto, pB: Punto): Punto {
            return Punto("${pA.id}${pB.id}", pB.x - pA.x, pB.y - pA.y)
        }

        @JvmStatic
        fun mostrarComponenteDeVector(pA: Punto, pB: Punto) {
            println(pA)
            println(pB)
            println("Componente AB: " + componenteDeVector(pA, pB))
        }

        @JvmStatic
        fun localizacionGeograficaNS(puntos: Array<Punto>): Map<String, MutableList<Punto>> {
            val mapa = mutableMapOf<String, MutableList<Punto>>()
            val puntosSur: MutableList<Punto> = mutableListOf()
            val puntosNorte: MutableList<Punto> = mutableListOf()
            for (i in puntos.indices) {
                if (puntos[i].y >= 0) {
                    puntosNorte.add(puntos[i])
                } else {
                    puntosSur.add(puntos[i])
                }
            }
            mapa["Norte"] = puntosNorte
            mapa["Sur"] = puntosSur
            return mapa
        }

        @JvmStatic
        fun localizacionGeograficaNStoString(puntos: List<Punto>): String {
            val mapa = localizacionGeograficaNS(puntos.toTypedArray())
            var listPuntos = "Lista de puntos: "
            val mapaPuntosNorte: Map<String, MutableList<Punto>> = mapa.filter { it.key == "Norte" }
            val mapaPuntosSur: Map<String, MutableList<Punto>> = mapa.filter { it.key == "Sur" }
            listPuntos += "$puntos \n  Localización Geográfica NS:  $mapaPuntosNorte  $mapaPuntosSur "
            return listPuntos + "\n"
        }
    }


    override fun toString(): String {
        return "punto $id -> [$x,$y]"
    }

    fun obtenerCoordenadas(): Pair<Int, Int> {
        return Pair(x, y)
    }
}


fun main() {
    val p1 = Punto("p1", 10, 11)
    val p2 = Punto("p2", 10, -2)
    val p3 = Punto("p3", 10, 6)
    val p4 = Punto("p4", 10, -1)
    val p5 = Punto("p5", 10, 8)
    val p6 = Punto("p6", 10, -11)
    val misPuntos = listOf(p1, p2, p3, p4, p5, p6)
    print(localizacionGeograficaNStoString(misPuntos))
    mostrarComponenteDeVector(p1, p2)
    println(p1.obtenerCoordenadas())
    println("Distancia entre p1 y p2 : " + distancia(p1, p2))

}