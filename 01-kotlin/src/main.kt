fun main (args: Array<String>){
    println("Hello, world!")

    //comentarios
    /* Comentarios
    */

    //Variables
    // Que es mutar:

    //Variables mutables

    var nombre = "Jenny"
    nombre = "Karina"

    //Inmutables
    //no se puede cambiar una variable de tipo inmutable
    val nombrei = "Jenny"
    //nombrei = "Karina"

    //TIPOS DE DATOS
    val apellido: String = "Castro"
    val edad: Int = 15
    val sueldo: Double = 120.00
    val casado: Boolean = false
    val estudiante: Boolean = true
    val hijos: Nothing? = null

    //Duck Typing
    //como reconoce el tipo de datos que usa, Kotlin lo infiere automáticamente


    //CONDICIONALES

    if (apellido == "Castro" && edad == 15){
        println("verdadero")
    }else{
        println("false")
    }

    val tieneNombreyApellido = if (apellido!=null && nombre!=null) "ok" else "no"
    println(tieneNombreyApellido)

    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)






}

fun estaJalado(nota:Double): Double{
    when (nota){
        7.0 ->{
            println("Felicidades mijo pasaste")
        }
        10.0 ->{
            println("Excelente")
        }
        0.0 ->{
            println("Dios mio")
        }
        else -> {
            println("Tu nota es: $nota")
        }
    }
    return nota
}