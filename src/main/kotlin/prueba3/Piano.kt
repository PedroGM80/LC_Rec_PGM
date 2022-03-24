package prueba3

//Un piano es un instrumento que interpreta las notas con un timbre muy característico
class Piano:Instrumento() {

    //Recorreremos las notas y las interpretaremos de la forma específica del piano.
    override fun play() {
        println("===> Tocando ${this::class.simpleName}")
        melodia.forEach { nota ->
            when (nota) {
                Nota.DO -> print("dooo ")
                Nota.RE -> print("reee ")
                Nota.MI -> print("miiii ")
                Nota.FA -> print("faaa ")
                Nota.SOL -> print("soool ")
                Nota.LA -> print("laaa ")
                Nota.SI -> print("siiii ")
            }
        }
        println("")
    }
}
