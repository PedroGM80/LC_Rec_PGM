package prueba1

fun generaTabla(numero: Int): String {
    var resultado = ""
    resultado += "TABLA DEL $numero\n"
    var underline = ""
    while (underline.length < resultado.length - 1) {
        underline += "*"
    }
    resultado += underline + "\n"
    for (i in 1..10) {
        resultado += "$numero x $i = ${numero * i}\n"
    }
    return resultado
}

fun generarTablas(tablas: Array<Int>): String {
    var tablasAlumno = ""
    for (i in tablas) {
        tablasAlumno += generaTabla(i)
    }
    return tablasAlumno
}

fun getRangoEdad(edad: Int): Array<Int> {
    when (edad) {
        in 11..12 -> {
            return arrayOf(11, 12)
        }
        in 9..10 -> {
            return arrayOf(9, 10)
        }
        in 6..8 -> {
            arrayOf(6, 8)
        }
    }
    return arrayOf(-1)
}

fun tablasEstudio(edad: Int, meses: Int): Array<Int> {
    var tablasEstudio = arrayOf(-1)
    when (edad) {
        in 11..12 -> {
            tablasEstudio = if (meses % 2 == 0) {
                arrayOf(14, 15, 16)
            } else {
                arrayOf(11, 12, 13)
            }
        }
        in 9..10 -> {
            tablasEstudio = if (meses % 2 == 0) {
                arrayOf(7, 9)
            } else {
                arrayOf(6, 8, 10)
            }
        }
        in 6..8 -> {
            tablasEstudio = if (meses % 2 == 0) {
                arrayOf(1, 3, 5)
            } else {
                arrayOf(2, 4)
            }
        }
    }
    return tablasEstudio
}

fun generaCabecera(nombre: String): String {
    return """*********************************************************************************
            PROGRAMA DE GENERACIÓN DE TABLAS: <$nombre>
    ̣̣̣_________________________________________________________________________________"""
}

fun generaConsulta(edad: Int, mes: Int): String =
    """Edad: $edad. El alumno está dentro del rango [${getRangoEdad(edad)[0]}-${getRangoEdad(edad)[1]}]
Mes: $mes. El mes es impar, corresponden las tablas siguientes: ${tablasEstudio(edad, mes)}
̣̣̣_________________________________________________________________________________"""

fun edadError(nombre: String, edad: Int): String {
    return """*********************************************************************************
PROGRAMA DE GENERACIÓN DE TABLAS: <$nombre>
̣̣̣_________________________________________________________________________________
Edad: $edad. No se cotempla esta edad.
̣̣̣_________________________________________________________________________________
*********************************************************************************"""
}

fun mesError(nombre: String, mes: Int): String {
    return """*********************************************************************************
PROGRAMA DE GENERACIÓN DE TABLAS: <$nombre>
̣̣̣_________________________________________________________________________________
Mes: $mes. El mes es erroneo.
̣̣̣_________________________________________________________________________________
*********************************************************************************"""

}

fun main() {
    var continuar = true
    while (continuar) {
        println("Deme el nombre del alumno")
        val nombre = readln()
        println("Deme la edad del alumno")
        val entradaEdad = readln().toInt()
        println("Deme el mes del alumno")
        val entradaMes = readln().toInt()
        if (entradaEdad in 6..12) {
            if (entradaMes in 1..12) {
                println(generaCabecera(nombre))
                println(generaConsulta(entradaEdad, entradaMes))
                println(generarTablas(tablasEstudio(entradaEdad, entradaMes)))
            } else {
                println(mesError(nombre, entradaMes))
            }
        } else println(edadError(nombre, entradaEdad))
        println("Desea continuar s/n")
        val respuesta = readln()
        if (respuesta.contains("n")) {
            println("Adios")
            continuar = false
        }
    }
}