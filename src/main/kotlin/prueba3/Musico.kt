package prueba3

open class Musico(val unInstrumento: Instrumento) : Interprete {

    //   override fun interpretar()
    private var melodia = mutableListOf<Nota>()
    fun incorporaNota(nota: Nota) {
        melodia.add(nota)
    }

    fun reset() = melodia.clear()
    override fun interpretar() {
        println("####### - SOY ${this::class.simpleName}")
        unInstrumento.play()
    }
}