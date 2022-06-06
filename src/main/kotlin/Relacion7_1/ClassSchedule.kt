package Relacion7_1

import de.m3y.kformat.Table
import de.m3y.kformat.table
import java.io.File

class ClassSchedule(private var headSchedule: String, private var scheduleContent: MutableList<String>) {
    fun askHeader(): MutableList<String> {
        while (headSchedule.isEmpty()) {
            println("Ingrese la cabecera del horario")
            headSchedule = readln()
            headSchedule = headSchedule.trim()
        }
        return headSchedule.split(";") as MutableList<String>
    }

    fun askContent(): MutableList<String> {

        for (i in 0..6) {
            println("Ingrese el contenido horario")
            val inKeyboard = readln()
            if (inKeyboard == "") break else scheduleContent[i] = inKeyboard
        }
        return scheduleContent
    }

    fun readLinesInFile(fileName: String): MutableList<String> {// this funtion read the file and return the lines
        val file = File(fileName)
        val lines = file.readLines()
        return lines as MutableList<String>
    }

    fun prepairTableFile(classSchedule: MutableList<String>): MutableList<String> {
        var content = mutableListOf<String>()
        for (i in classSchedule) {
            content = table {
                header(classSchedule[0].split(";"))
                for (value in classSchedule.withIndex()) {
                    if (value.index != 0) row(values = classSchedule[value.index].split(";").toTypedArray())
                }
                hints {
                    alignment(1, Table.Hints.Alignment.LEFT)
                    borderStyle = Table.BorderStyle.SINGLE_LINE
                }
            }.render().toString().split("\n") as MutableList<String>
        }
        return content
    }

    fun writeLinesInFile(fileName: String, lines: MutableList<String>) {// this funtion write the file
        val file = File(fileName)
        if (!file.isFile) file.createNewFile()
        file.writeText(lines.joinToString("\n"), Charsets.UTF_8)
    }
}


fun main() {
    val schedule = ClassSchedule("", MutableList(7) { "" })
    val headSchedule = schedule.askHeader()
    val scheduleContent = schedule.askContent()
    printTable(headSchedule, scheduleContent)

    val lines = schedule.readLinesInFile("src/main/kotlin/Relacion7_1/in.txt")
    val formatLines = schedule.prepairTableFile(lines)
    schedule.writeLinesInFile("src/main/kotlin/Relacion7_1/out.txt", formatLines)

}

internal fun printTable(
    headSchedule: MutableList<String>,
    scheduleContent: MutableList<String>
) {
    print(
        table {
            header(headSchedule)
            for (i in scheduleContent.indices) {
                if (scheduleContent[i] == "") {
                    break
                } else {
                    val arrayRows = scheduleContent[i].split(";")
                    row(values = arrayRows.toTypedArray())
                }
            }
            hints {
                alignment(1, Table.Hints.Alignment.LEFT)
                borderStyle = Table.BorderStyle.SINGLE_LINE
            }
        }.render()
    )
}