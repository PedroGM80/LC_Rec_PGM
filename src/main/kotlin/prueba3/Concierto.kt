package prueba3

fun main() {
    val obra = arrayOf<Nota?>(Nota.MI, Nota.MI, Nota.DO, Nota.FA)
    val interpretes = mutableMapOf(
        "prueba3.Pianista" to Pianista(Piano(), obra),
        "Violinista" to Violinista(Violin(), obra),
        "AlumnoMusico1" to AlumnoMusica(Violin(), obra),
        "AlumnoMusico2" to AlumnoMusica(Piano(), obra)
    )

    repeat(4)
    {
        interpretes.keys.random().run {
            i("CONCIERTO", this)
            interpretes[this]?.interpretar()
            interpretes.remove(this)
        }
    }
}