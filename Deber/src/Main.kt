import java.io.File
import javax.swing.JOptionPane
import java.util.*
import kotlin.math.sqrt

var medicina = Medicina()
var receta = Receta()

//val listaReceta: ArrayList<Receta> = ArrayList<Receta>()

val list = arrayListOf<Medicina>()
val listRe = arrayListOf<Receta>()

fun main(args: Array<String>) {

    cargarMedicamentos()
    cargarRecetas()
    aplicacionFarmacia()
}

fun aplicacionFarmacia() {
    while (true) {
        guardarMedicinas()
        guardarRecetas()
        val seleccion =
            JOptionPane.showInputDialog("BIENVENIDO A LA FARMACIA" + "\n" + "\n"
                    + "\n" + "Escoja una opción:" + "\n"
                    + "\n" + "      1.  Ingresar"
                    + "\n" + "      2.  Consultar"
                    + "\n" + "      3.  Actualizar"
                    + "\n" + "      4.  Eliminar medicamento"
                    + "\n" + "      0.   Salir" + "\n")
        if (seleccion != null) {
            var num = seleccion.toInt()
            when (num) {
                1 -> {
                    submenuInsertar()
                }
                2 -> {
                    submenuConsultar()
                }
                3 -> {
                    submenuEditar()
                }
                4 -> {
                    consultarMedicina()
                    eliminarMedicina()
                }
                0 -> {
                    JOptionPane.showMessageDialog(null, "GRACIAS POR SU VISITA!!")
                    System.exit(0)
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "GRACIAS POR SU VISITA!!")
            System.exit(0)
        }
    }
}

fun submenuInsertar() {

    val seleccion =
        JOptionPane.showInputDialog("INGRESAR" + "\n"
                + "\n" + "      1.  Medicina"
                + "\n" + "      2.  Receta"
                + "\n" + "      0.  Regresar al Menú principal" + "\n")

    if(seleccion!=null){
        var num = seleccion.toInt()
        when (num) {
            1 -> {
                list.add(ingresarMedicina())
                consultarMedicina()
            }
            2 -> {
                listRe.add(ingresarReceta())
                consultarReceta()
            }
            0 -> {
                JOptionPane.showMessageDialog(null, "Regresando al Menú principal")
            }
        }
    }else{
        JOptionPane.showMessageDialog(null, "Regresando al menú principal ...")
        aplicacionFarmacia()
    }
}

fun submenuConsultar() {
    val seleccion =
        JOptionPane.showInputDialog("CONSULTAR" + "\n"
                + "\n" + "     1.   Medicina"
                + "\n" + "     2.   Receta"
                + "\n" + "     0.   Regresar al Menú principal" + "\n")
    if(seleccion!=null){
        var num = seleccion.toInt()
        when (num) {
            1 -> {
                consultarMedicina()
            }
            2 -> {
                consultarReceta()
            }
            0 -> {
                JOptionPane.showMessageDialog(null, "Regresando al Menú principal")
            }
        }
    }else{
        JOptionPane.showMessageDialog(null, "Regresando al menú principal ...")
        aplicacionFarmacia()
    }
}

fun submenuEditar() {
    val seleccion =
        JOptionPane.showInputDialog("EDITAR" + "\n"
                + "\n" + "      1.  Medicina"
                + "\n" + "      2.  Receta"
                + "\n" + "      0.  Regresar al Menú principal" + "\n")
    if (seleccion!=null){
        var num = seleccion.toInt()
        when (num) {
            1 -> {
                modificarMedicina()
                consultarMedicina()
            }
            2 -> {
                modificarReceta()
                consultarReceta()
            }
            0 -> {
                JOptionPane.showMessageDialog(null, "Regresando al Menú principal")
            }
        }
    }else{
        JOptionPane.showMessageDialog(null, "Regresando al menú principal ...")
        aplicacionFarmacia()
    }

}

//------------MEDICINA--------------//
fun ingresarMedicina(): Medicina {
    while (true)
        try {
            var m = Medicina()
            m.codigoMedicina = JOptionPane.showInputDialog(null,"Código del medicamento", (list[list.size-1].codigoMedicina.toInt()+1))
            m.nombreMedicina = JOptionPane.showInputDialog("Nombre del medicamento")
            m.tipoMedicina = JOptionPane.showInputDialog("Tipo de medicamento (Jarabe/Pastillas)")
            m.precio = JOptionPane.showInputDialog("Precio del medicamento").toDouble()
            m.cantidad = JOptionPane.showInputDialog("Cantidad del medicamentos").toInt()

            JOptionPane.showMessageDialog(null, "Medicamento ingresado con éxito")
            return m
        } catch (e: Exception){
            JOptionPane.showMessageDialog(null, "Error al ingresar medicamento\n Vuelva a intentarlo")
        }
}

fun ingresarMedicina(med: Medicina): Medicina {
    while (true)
        try {
            var m = Medicina()
            m.nombreMedicina = JOptionPane.showInputDialog(null,"Nombre del medicamento", med.nombreMedicina)
            m.codigoMedicina = JOptionPane.showInputDialog(null,"Código del medicamento", med.codigoMedicina)
            m.tipoMedicina = JOptionPane.showInputDialog(null,"Tipo de medicamento (Jarabe/Pastillas)", med.tipoMedicina)
            m.precio = JOptionPane.showInputDialog(null,"Precio del medicamento", med.precio).toDouble()
            m.cantidad = JOptionPane.showInputDialog(null,"Cantidad del medicamentos", med.cantidad).toInt()

            JOptionPane.showMessageDialog(null, "Medicamento ingresado con éxito")
            return m
        } catch (e: Exception){
            JOptionPane.showMessageDialog(null, "Error al ingresar medicamento\n Vuelva a intentarlo")
        }
}

fun modificarMedicina() {
    val nombre = JOptionPane.showInputDialog("Nombre del medicamento a modificar")
    var med = Medicina()
    if (list.none { it.nombreMedicina == nombre }) {
        JOptionPane.showMessageDialog(null, "No existe ese medicamento")
    } else {
        var index = getIndex(nombre)
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Error al buscar medicamento")
        } else {
            consultarMedicina(index)
            list[index] = ingresarMedicina(list[index])
        }
    }
}

fun getIndex(nombre: String): Int {
    for (item: Medicina in list) {
        if (item.nombreMedicina == nombre) {
            return list.indexOf(item)
        }
    }
    return -1
}

fun consultarMedicina() {
    var med: String = ""
    for (item: Medicina in list) {
        med += item.toString()
    }
    JOptionPane.showMessageDialog(null, med)
}

fun consultarMedicina(index: Int) {
    var med = Medicina()
    med = list[index]
    JOptionPane.showMessageDialog(null, med.toString())
}

fun eliminarMedicina() {
    val nombre = JOptionPane.showInputDialog("Ingrese el nombre del medicamento a eliminar")
    var med = Medicina()
    if (list.none { it.nombreMedicina == nombre }) {
        JOptionPane.showMessageDialog(null, "No existe ese medicamento")
    } else {
        var index = getIndex(nombre)
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Error al buscar medicamento")
        } else {
            list.removeAt(index)
            JOptionPane.showMessageDialog(null, "Eliminado")
        }
    }
}

/*---------------Receta------------------*/
fun ingresarReceta(): Receta {
    var receta = Receta()
    receta.codigo = JOptionPane.showInputDialog(null, "Ingrese codigo de la receta", (listRe[listRe.size-1].codigo.toInt()+1))
    receta.nombrePaciente = JOptionPane.showInputDialog("Ingrese nombre cliente")
    receta.apellidoPaciente = JOptionPane.showInputDialog("Ingrese el apellido")
    receta.identificacion = JOptionPane.showInputDialog("Ingrese la cedula")
    var n: Int = 0
    while (n==0){

        receta.medicina.add(list[getIndex(JOptionPane.showInputDialog("Ingrese el medicamento"))])
        receta.detalle.add(JOptionPane.showInputDialog("Ingrese el modo de empleo del medicamento"))
        n = JOptionPane.showConfirmDialog(null, "Ingresar otro medicamento")
    }
    return receta
}

fun ingresarReceta(rec: Receta): Receta {
    var receta = Receta()
    receta.codigo = JOptionPane.showInputDialog("Ingrese codigo de la receta")
    receta.nombrePaciente = JOptionPane.showInputDialog(null,"Ingrese nombre cliente", rec.nombrePaciente)
    receta.apellidoPaciente = JOptionPane.showInputDialog(null, "Ingrese el apellido", rec.apellidoPaciente)
    receta.identificacion = JOptionPane.showInputDialog(null,"Ingrese la cedula", rec.identificacion)
    var i: Int = 0
    var j: Int = -1
    for(med in rec.medicina){
        try {
            j = -1
            while (j==-1){
                j = getIndex(JOptionPane.showInputDialog(null,"Ingrese el medicamento", med.nombreMedicina))
                if(j==-1)
                    JOptionPane.showMessageDialog(null, "No se encontro ese medicamento")
            }
            receta.medicina.add(list[j])
            receta.detalle.add(JOptionPane.showInputDialog(null,"Ingrese el modo de empleo del medicamento", rec.detalle[i]))
            i++
        }catch (e:Exception){
        }
    }
    return receta
}

fun modificarReceta() {
    var rec = Receta()
    while (rec.codigo.equals(""))
        rec = consultarReceta(JOptionPane.showInputDialog("Ingrese el codigo de la receta a modificar"))
    val index: Int = getIndexRe(rec.codigo)
    listRe[index]=ingresarReceta(rec)

}

fun eliminarReceta() {
    val codigo:String = JOptionPane.showInputDialog("Ingrese el codigo de la receta a eliminar")
    var rec = Receta()
    if (listRe.none { it.codigo == codigo }) {
        JOptionPane.showMessageDialog(null, "No existe esa receta")
    } else {
        val index = getIndexRe(codigo)
        if (index < 0) {
            JOptionPane.showMessageDialog(null, "Error al buscar receta")
        } else {
            list.removeAt(index)
            JOptionPane.showMessageDialog(null, "Eliminada")
        }
    }
}

fun consultarReceta() {
    var rec: String = ""
    for (item: Receta in listRe) {
        rec += item.toString()
    }
    JOptionPane.showMessageDialog(null, rec)
}

fun consultarReceta(codigo:String): Receta{
    while (true)
        if (listRe.none{it.codigo==codigo}){
            JOptionPane.showMessageDialog(null, "No existe una receta con ese codigo")
        } else {
            for (item: Receta in listRe) {
                if(item.codigo==codigo)
                    return item
            }
        }
}

fun getIndexRe(codigo: String): Int{
    for (item: Receta in listRe) {
        if (item.codigo == codigo) {
            return listRe.indexOf(item)
        }
    }
    return -1
}

fun cargarMedicamentos(){
    val path = "./src/Medicamentos.txt"

    val Medicamentos = ArrayList<String>()
    File(path).forEachLine { linea ->
        Medicamentos.add(linea)
    }

    var med = Medicina()
    var splMed = listOf<String>()
    Medicamentos.forEach { leida ->
        splMed = leida.split(",")
        med = Medicina()
        med.codigoMedicina = splMed[0]
        med.nombreMedicina = splMed[1]
        med.tipoMedicina = splMed[2]
        med.precio = splMed[3].toDouble()
        med.cantidad = splMed[4].toInt()
        list.add(med)
    }
}

fun cargarRecetas(){
    val path = "./src/Recetas.txt"

    val Recetas = ArrayList<String>()
    File(path).forEachLine { linea ->
        Recetas.add(linea)
    }

    var rec = Receta()
    var splRe = listOf<String>()
    Recetas.forEach { leida ->
        splRe = leida.split(",")
        rec = Receta()
        rec.codigo = splRe[0]
        rec.identificacion = splRe[1]
        rec.nombrePaciente = splRe[2]
        rec.apellidoPaciente = splRe[3]
        for (i in 4 until splRe.size step 2){
            rec.medicina.add(list[getIndex(splRe[i])])
            rec.detalle.add(splRe[i+1])
        }

        listRe.add(rec)
    }
}

fun guardarMedicinas(){
    val path = "./src/Medicamentos.txt"
    var fileData:String = ""
    for (med:Medicina in list)
        fileData+=med.toSave()+"\n"
    File(path).writeText(fileData)
}

fun guardarRecetas(){
    val path = "./src/Recetas.txt"
    var fileData:String = ""
    for (rec:Receta in listRe)
        fileData+=rec.toSave()+"\n"
    File(path).writeText(fileData)
}