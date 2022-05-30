package ActividadBattleRoyal


import ActividadBattleRoyal.BattleRoyal.Companion.readFileAsLinesUsingReadLines
import java.io.File

// in intelJ project Modify run config args is test-2.in
class BattleRoyal {
    companion object {
        fun readFileAsLinesUsingReadLines(fileName: String): List<String> {
            val lineList = mutableListOf<String>()
            File("src/main/kotlin/ActividadBattleRoyal/$fileName").useLines { lines -> lines.forEach { lineList.add(it) } }
            return lineList
        }
    }


fun main(args: Array<String>) {
    var muertos = 0
    val linesList = readFileAsLinesUsingReadLines(args[0])
    val stretchNumber: Int
    val size = linesList[0].split(" ")
    val sizeX = size[1].trim().toInt()
    val sizeY = size[2].trim().toInt()
    val time = linesList[1].trim().toInt()

    stretchNumber = (time / 10)

    val listPlayer: MutableList<Any> = mutableListOf<Any>()

    linesList.withIndex().forEach { (index) ->
        if (!linesList[index].contains("#") && index > 1) {//line 0  tablet game line 1 time game
            val pos = linesList[index].split(" ")
            val posX = pos[1].trim().toInt()
            val posY = pos[2].trim().toInt()

            listPlayer.add(Pair(posX, posY))

        }
    }

//    println(listPlayer.toString())
    //Date game
    //println("sizeX $sizeX sizeY $sizeY Time $time xPositions $listPlayerX  yPositions $listPlayerY stretchValue $stretchNumber")
    for (value in listPlayer) {
        var posicion = value as Pair<Int, Int>

        if ((posicion.first <= stretchNumber) ||
            (posicion.first > (sizeX - stretchNumber)) ||
            (posicion.second <= stretchNumber) ||
            (posicion.second > (sizeY - stretchNumber))
        ) {
            muertos++
        }
    }

    val live = listPlayer.size
    val survivor = live - muertos
    println(survivor)//muertos
}


