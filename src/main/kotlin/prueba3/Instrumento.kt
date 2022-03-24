package prueba3
//Para comentar
open class Instrumento {

    open var melodia = mutableListOf<Nota>()

    open fun incorporaCancion(unaCancion: Array<Nota>) {
        for (i in unaCancion) {
            melodia.add(i)
        }
    }

    open fun incorporaNota(nota: Nota) {
        melodia.add(nota)
    }

    open fun reset() = melodia.clear()
    open fun play() {
        println("===> Tocando ${this::class.simpleName}")
        melodia.forEach { nota ->
            when (nota) {
                Nota.DO -> print("do ")
                Nota.RE -> print("re ")
                Nota.MI -> print("mi ")
                Nota.FA -> print("fa ")
                Nota.SOL -> print("sol ")
                Nota.LA -> print("la ")
                Nota.SI -> print("si ")
            }
        }
        println("")
    }
}