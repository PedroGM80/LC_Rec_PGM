package agenda

fun listado(datosAgenda: MutableMap<String, String>) {
    for (value in datosAgenda.values.sorted()){
        val key = datosAgenda.filterValues { it == value }.keys
        println("$value $key")
    }
}
fun buscarTexto(datosAgenda: MutableMap<String, String>, texto: String) {
    val datosFiltrados = datosAgenda.filterValues { it.contains(texto) }
    println(datosFiltrados.toString())
}

fun main() {
var entrada=""
    val datosAgenda: MutableMap<String, String> = mutableMapOf()
    do {
        println("Deme un número de teléfono a comprobar:")
         entrada = readLine().toString()
        if (entrada != null) {
            if (entrada.contains("adios")) {
                break
            } else if (entrada.contains("texto_a_buscar")) {
                val arrayDatos = entrada.split(" ")
                buscarTexto(datosAgenda, arrayDatos[1])
            } else if (entrada.contains("listado")) {
                listado(datosAgenda)
            } else if (datosAgenda.containsKey(entrada)) {
                println(datosAgenda[entrada])
            } else if (datosAgenda.containsValue(entrada)) {
                val numeroEnAgenda = datosAgenda.filterValues { it == entrada }.keys
                println(numeroEnAgenda)
            } else {
                println("No existe ni el número ni el contacto en la agenda")
                println("Deme el número de teléfono del nuevo contacto:")
                entrada = readLine().toString()
                do {

                    println("Deme el nombre del  nuevo contacto:")
                    val entradaNombre = readLine()

                    if (!entradaNombre !![0].isLetter())
                        println("Error el nombre debe empezar con una letra")
                    else
                        datosAgenda.put(entrada,entradaNombre)
                }while(!entradaNombre !![0].isLetter())
            }
        }
    } while (entrada != "adios")
}


