/*
import java.util.*
import javax.swing.JOptionPane
fun main (args: Array<String>) {
    println("Hello, world!")
        //JOptionPane.showInputDialog("Bienvenido al inventario!!!");

    //comentarios
    /* Comentarios
    */

    //Variables
    // Que es mutar:?? Cambiar

    //Variables mutables
    var nombre = "Jenny"
    nombre = "Karina"


    //Inmutables
    //no se puede cambiar una variable de tipo inmutable
    val nombrei: String = "Jenny"
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

    if (apellido == "Castro" && edad == 15) {
        println("verdadero")
    } else {
        println("false")
    }

    val tieneNombreyApellido = if (apellido != null && nombre != null) "ok" else "no"
    println(tieneNombreyApellido)

    estaJalado(1.0)
    estaJalado(8.0)
    estaJalado(0.0)
    estaJalado(7.0)
    estaJalado(10.0)

    holaMundo("Jenny")
    holaMundoAvanzado(2)

    val total = sumarDosnNumeros(1,2)
    //la palabra numUno y numDos lo pone el editor de texto
    println(total)

    val arregloCumpleanos: Array<Int> = arrayOf(1,2,3,4)
    val arregloTodo: Array<Any> = arrayOf(1, "Jenny", 10.2, true)
    arregloCumpleanos [0] = 5
    arregloCumpleanos.set(0, 5)
    //arregloTodo = arrayOf(1,2,3,4)

    //val fecha = Date()
    //fecha.time = 123456
    //fecha.year = 2019
    // fecha = Date(1996,6,10)

    val notas = arrayListOf<Int>(1,2,3,4,5,6)
    
    //iterar en notas
    
    notas.forEach {
        it      //ese it representa el elemento del arreglo
    }
    
    notas.forEach { nota: Int ->
        println(nota)
    }

    //foreach itera el arreglo

    notas.forEachIndexed{indice, nota ->
        println("Indice: $indice")
        println("Nota: $nota")
        notas[indice]=notas[indice]+1
        //return Unit
    }
    println(notas)

    //a todos los elementos del arreglo sumar 1
    //OPERADOR MAP -> ITERA Y MODIFICA TODO EL ARREGLO

    println("OOPERADOR MAP")
    val notasDos = notas.map { nota ->
        nota + 1
    }
    //Para pder revisar los datos de las notasDos
    notasDos.forEach{
        println("Notas 2: $it")
    }

    println("numeros impares suma uno  y pares suman dos")
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
    println(notasTres)

    val respuestaFilter = notas.filter {
        it < 4
    }
    respuestaFilter.forEach{println(it)}
    println(respuestaFilter)

    val respuestaFilter2 = notas.filter {
        it > 2
    }

    //Filtra el arreglo y luego multiplica *2
    val respuestaFilter3 = notas.filter {
        it in 2 .. 4 //se puede asignar un rango
    }.map {
        it * 2
    }
    //buscar un elemento pedido
    //existirá ALGUN elemento que sea ==3
    val novias = arrayListOf(1,2,2.3,3,3,4,4,5)
    val respuestaNovias:Boolean=novias.any {
        it == 3
    }
    println(respuestaNovias) //true

    //TODOS SON mayores a 7
    val tazos = arrayListOf(1,2,3,4,5,6)
    val respuestaTazos = tazos.all{
        it> 1
    }
    println(respuestaTazos) // false

    //sumar todos los valores
    val valrTazos = tazos.reduce { valorAcumulado, tazo ->
        valorAcumulado + tazo
    }
    println(valrTazos)




}

fun estaJalado(nota:Double):Double{
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

   /*

    val numerito = Numero("1")
















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

    */


//---------------

 */




import java.util.Scanner

val reader = Scanner(System.`in`)
val materiales: MutableList<Material> = mutableListOf()
val prendas: MutableList<Prenda> = mutableListOf()


fun main(args: Array<String>) {
    println("S.A.STRE")
    menu()
    //println(prendas.toString())


}

fun menu(){

    var opc = 99
    while(opc != 0){

        println("Hola Bienvenido a S.A.Stre")
        println("Elija una de las acciones para continuar:")
        println("1. Ingresar")
        println("2. Consultar")
        println("3. Editar")
        println("4. Borrar")
        println("0. Salir")

        opc = reader.nextInt()

        when (opc){
            1 -> submenuIngresar()
            2 -> submenuConsultar()
            3 -> submenuEditar()
            4 -> submenuBorrar()
            0 -> println("Hasta luego...")
        }
    }
}

fun submenuIngresar(){
    var opc = 99
    while (opc != 0){
        println("1.- Ingresar nuevo material")
        println("2.- Ingresar nueva prenda")
        println("0.- Volver")
        opc = reader.nextInt()

        when (opc){
            1 -> quemar_materiales()
            2 -> quemar_prendas()
            0 -> println("saliendo de menu ingresar...")
        }
    }
}

fun submenuConsultar(){
    var opc = 99
    while (opc != 0){
        println("1.- Consultar materiales")
        println("2.- Consultar prendas")
        println("0.- Volver")
        opc = reader.nextInt()

        when (opc){
            1 -> imprimir_materiales()
            2 -> imprimir_prendas()
            0 -> println("saliendo de menu consultar...")
        }
    }
}

fun submenuEditar(){
    var opc = 99
    while (opc != 0){
        println("1.- Editar material")
        println("2.- Editar prenda")
        println("0.- Volver")
        opc = reader.nextInt()

        when (opc){
            1 -> {imprimir_materiales()
                editar_material()}
            2 -> {imprimir_prendas()
                editar_prenda()}
            0 -> println("saliendo de menu editar...")
        }
    }
}



fun submenuBorrar(){
    var opc = 99
    while (opc != 0){
        println("1.- Borrar material (todos)")
        println("2.- Borrar prenda (todos)")
        println("3.- Borrar material")
        println("4.- Borrar prenda")
        println("0.- Volver")
        opc = reader.nextInt()

        when (opc){
            1 -> materiales.removeAll(materiales)
            2 -> prendas.removeAll(prendas)
            3 -> {imprimir_materiales()
                borrar_material()}
            4 -> {imprimir_prendas()
                borrar_prenda()}
            0 -> println("saliendo de menu borrar...")
        }
    }
}


fun borrar_material(){
    print("Ingrese el indice del material a borrar")
    var indice = readLine().toString().toInt()
    materiales.removeAt(indice)
    println("Material borrado con exito")
}

fun borrar_prenda(){
    print("Ingrese el indice del material a borrar")
    var indice = readLine().toString().toInt()
    prendas.removeAt(indice)
    println("Prenda borrada con exito")
}

fun editar_prenda(){
    println("Ingresar el inidice de la prenda a editar")
    var indice = readLine()!!
    println(prendas[indice.toInt()])
    println("Ingrese el nombre: ")
    prendas[indice.toInt()].setnombre(readLine().toString())
    println("Escoja el material ${materiales.toString()}")
    prendas[indice.toInt()].setmaterial(materiales[readLine().toString().toInt()])
    println("Ingrese el precio: ")
    prendas[indice.toInt()].setprecio(readLine().toString().toDouble())
    println("Ingrese el tipo: ")
    prendas[indice.toInt()].settipo(readLine().toString())
    println("Ingrese la descripcion: ")
    prendas[indice.toInt()].setdescripcion(readLine().toString())
}
fun editar_material(){
    println("Ingresar el inidice de la prenda a editar")
    var indice = readLine()!!
    println(materiales[indice.toInt()])
    println("Ingrese el nombre: ")
    materiales[indice.toInt()].setnombre(readLine().toString())
    println("Ingrese el color: ")
    materiales[indice.toInt()].setcolor(readLine().toString())
    println("Ingrese el precio: ")
    materiales[indice.toInt()].setprecio(readLine().toString().toDouble())
    println("Ingrese la cantidad: ")
    materiales[indice.toInt()].setcantidad(readLine().toString().toInt())
}

fun quemar_prendas(){
    prendas.add(Prenda("pantalon","inferior","pantalon formal",50.00,materiales[0]))
    prendas.add(Prenda("camisa","superior","camisa formal",30.00,materiales[0]))
    prendas.add(Prenda("abrigo","superior","abrigo de lana",46.00,materiales[0]))
    prendas.add(Prenda("chaleco","superior","chaleco comodo",25.00,materiales[0]))
}
fun quemar_materiales(){
    materiales.add(Material("seda","azul oscuro","metros",10, 5.0))
    materiales.add(Material("lino","blanco","metros",43, 7.0))
    materiales.add(Material("lana","blanco","metros",22, 2.5))
    materiales.add(Material("cuero","negro","metros",15, 3.5))
}

fun imprimir_materiales(){
    var n = 0
    for (item in materiales) {
        println("${n}.- ${item}")
        n++
    }
}

fun imprimir_prendas(){
    var n = 0
    for (item in prendas) {
        println("${n}.- ${item}")
        n++
    }
}