package prueba3

class Violin : Instrumento() {

    override fun play() {
        println("===> Tocando ${this::class.simpleName}")
        melodia.forEach { nota ->
            when (nota) {
                Nota.DO -> print("doggg ")
                Nota.RE -> print("reggg ")
                Nota.MI -> print("miggg ")
                Nota.FA -> print("faggg ")
                Nota.SOL -> print("solggg ")
                Nota.LA -> print("laggg ")
                Nota.SI -> print("siggg ")
            }
        }
        println("")
    }
}