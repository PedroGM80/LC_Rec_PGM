package prueba3

class Violinista(unInstrumento: Instrumento, unaCancion: Array<Nota?> = arrayOfNulls<Nota?>(0)) :
    Musico(unInstrumento) {

    private var partitura: Array<Nota?> = unaCancion
        set(value) {
            field = value
            unInstrumento.reset()
            value.forEach { nota ->
                i("Prueba.${this::class.simpleName}.setPartitura", "incorpora nota $nota de canción")
                nota?.let { unInstrumento.incorporaNota(nota) }
            }
        }

    init {
        partitura = unaCancion
    }
}