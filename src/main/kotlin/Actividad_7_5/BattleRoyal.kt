package Actividad_7_5

import Actividad_7_5.BattleRoyal.Companion.readFileAsLinesUsingReadLines
import java.io.File
// in intelJ project Modify run config args is test-2.in
class BattleRoyal {
    companion object {
        fun readFileAsLinesUsingReadLines(fileName: String): List<String> {
            val lineList = mutableListOf<String>()
            File("src/$fileName").useLines { lines -> lines.forEach { lineList.add(it) } }
            return lineList
        }
    }
}

fun main(args: Array<String>) {
    val linesList = readFileAsLinesUsingReadLines(args[0])
    val stretchNumber: Int
    val size = linesList[0].split(" ")
    val sizeX = size[1].trim().toInt()
    val sizeY = size[2].trim().toInt()
    val time = linesList[1].trim().toInt()

    stretchNumber = (time / 10)
    val listPlayerX: MutableList<Int> = mutableListOf<Int>()
    val listPlayerY: MutableList<Int> = mutableListOf<Int>()

    linesList.withIndex().forEach { (index) ->
        if (!linesList[index].contains("#") && index > 1) {//line 0  tablet game line 1 time game
           // println("indice->$index")
            val pos = linesList[index].split(" ")
            val posX = pos[1].trim().toInt()
            val posY = pos[2].trim().toInt()
            listPlayerX.add(posX)
            listPlayerY.add(posY)
        }
    }
    //Date game
    //println("sizeX $sizeX sizeY $sizeY Time $time xPositions $listPlayerX  yPositions $listPlayerY stretchValue $stretchNumber")

    listPlayerX.withIndex().forEach { (index) ->
        if (listPlayerX[index] <= stretchNumber) {
            listPlayerX.removeAt(index)
        }
        if (listPlayerY[index] <= stretchNumber) {
            listPlayerY.removeAt(index)
        }
    }
    //Player survivors
    println((listPlayerX.size + listPlayerY.size) / 2)
}


