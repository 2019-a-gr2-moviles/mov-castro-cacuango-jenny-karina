import java.util.*

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

    holaMundoAvanzado(2)
    holaMundo(" Jenny")


    val total = sumarDosnNumeros(1,2)  //la palabra numUno y numDos lo pone el editor de texto
    println(total)


    val arregloCumpleanos: Array<Int> = arrayOf(1,2,3,4)
    val arregloTodo: Array<Any> = arrayOf(1, "Jenny", 10.2, true)

    arregloCumpleanos [0] = 5
    arregloCumpleanos.set(0, 5)
    //arregloTodo = arrayOf(1,2,3,4)

    val fecha = Date()
    fecha.time = 123456
    fecha.year = 2019
   // fecha = Date(1996,6,10)

    val notas = arrayListOf(1,2,3,4,5,6)
    /*
    notas.forEach {
        it      ese it representa el elemento del arreglo
    }
    */

    notas.forEach { nota ->
        println(nota)

    }

    //foreach itera el arreglo

    notas.forEachIndexed{indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")
        //return Unit
    }

        //a todos los elementos del arreglo sumar 1

    //OPERADOR MAP -< ITERA Y MODIFICA TODO EL ARREGLO

    val notasDos = notas.map { nota ->
        nota + 1
    }


    notasDos.forEach{
        println("Notas 2: $it")
    }


    //numeros impares suma uno  y pares suman dos



        val notasTres = notas.map { nota ->
            val modulo = nota % 2
            val esPar = 0
            when (modulo) {
                esPar -> {
                    nota + 1
                }
                else -> {
                    nota + 2
                }
            }
        }

    val respuestaFilter = notas.filter {
        it < 4

    }

    val respuestaFilter2 = notas.filter {
        it > 2

    }

    //Filtra el arreglo y luego multiplica *2

    val respuestaFilter3 = notas.filter {
        it in 2 .. 4

    }.map {
        it * 2
    }

    //FILTER -> fILTRA EL ARREGLO
    //MAP -> MUTAR P CAMBIAR EL ARREGLO

    val novias = arrayListOf(1,2,2.3,4,4,5)


    val respuestaNovias:Boolean=novias.any {
        it == 3
    }

    println(respuestaNovias) //true

    val tazos = arrayListOf(1,2,3,4,5,6)

        val respuestaTazos = tazos.all{
            it> 1
        }
        println(respuestaTazos) // false

    val valrTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }
    println(valrTazos)



    val numerito = Numero("1")




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


fun holaMundo (mensaje: String):Unit {
    println("Mensaje: $mensaje.")
}

fun holaMundoAvanzado (mensaje: Any):Unit {
    println("Mensaje: $mensaje.")
}

fun sumarDosnNumeros(numUno: Int, numDos: Int): Int{
    return numUno + numDos
}

//Definir una clase

class Usuarios(val cedula:String){
    public var nombre:String = ""
    public var apellido:String = ""

    constructor(cedulaM: String, apellido:String) : this(cedulaM){

    }
}




class usuariokt(var nombre:String, public val apellido: String, private var id:Int ){


    init {

    }

    fun hola():String{
        return this.apellido
    }

    private fun hola2(){

    }

    protected fun hola3(){

    }

    companion object {
        //definir métodos y propedades  --> toso esto es estático
        val gravedad = 9.8
        fun correr(){
            println("estoy corriendo en $gravedad")
        }
    }


    class BaseDeDatos(){
        companion object {
            val usuarios = arrayListOf(1,2,3)
            fun agregarUsuario(usuario:Int){
                this.usuarios.add(usuario)

            }
            fun eliminarUsuario(usuario: Int){

            }
        }
    }

    fun aa(){
        usuariokt.gravedad  //propiedad estática -->Java
        usuariokt.correr()  //metodo estático -->Java

}


}



fun a(){
    val adrian = usuariokt("a", "b", 3)
    adrian.nombre="Jenny"
}

class Numero(var numero:Int){
    constructor(numeroString:String):this(numeroString.toInt()){
        println("CONSTRUCTOR")
    }
    init {
        println("INIT")
        this.numero
    }

}


class A{
    // a.correr //metodo estático
    // a.gravedad //propiedad estática
}


open class Numeros(var numero1:Int, var numero2:Int){

}
class suma( numeroUno:Int,  numeroDos:Int):Numeros(numeroUno, numeroDos){

}

fun cc(){
    val a = suma(1,2)
}


fun presley(requerido:Int, opcional : Int=1, nulo:usuariokt?){

    if(nulo !=null){
        nulo.nombre
    }
    val nombresito:String =nulo?.nombre.toString()
    nulo!!.nombre


}

fun ccdd(){

    presley(1,nulo = null)
    //presley(1,1,null)
}