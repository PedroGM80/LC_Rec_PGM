package Relacion7_1

class ClassSchedule(private var headSchedule: String, private var scheduleContent: String) {
    fun askHeader(): MutableList<String> {
        println("Ingrese la cabecera horario")
        headSchedule = readLine()!!
        return headSchedule.split(";") as MutableList<String>
    }

    fun askContent(): MutableList<String> {
        for (i in 1..7) {
            println("Ingrese el contenido horario")
            scheduleContent += readLine()!!
            if (scheduleContent == "") break

        }
        return scheduleContent.split(";") as MutableList<String>
    }

    fun formatSchedule(headSchedule: MutableList<String>, contentSchedule: MutableList<String>): String {
        for (i in headSchedule.indices) {
            while (headSchedule[i].length < contentSchedule[i].length) headSchedule[i] = headSchedule[i] + " "
        }
        for (i in contentSchedule.indices) while (contentSchedule[i].length < headSchedule[i].length)
            contentSchedule[i] = " " + contentSchedule[i] + " "

        return headSchedule.joinToString("|") + "\n" + "---|-------------|----------|-------|--------" +
                "|-----------|--------|---------|-----------\n" + contentSchedule.joinToString(
            "|"
        )
    }
}