import javax.swing.JOptionPane
import java.util.*

var medicina = Medicina()
var receta = Receta()

//val listaReceta: ArrayList<Receta> = ArrayList<Receta>()

val list = arrayListOf<Medicina>()
val listRe = arrayListOf<Receta>()

fun main(args:Array<String>) {

    quemarMedicina()
    quemarReceta()
    aplicacionFarmacia()
}

fun aplicacionFarmacia() {

    val seleccion =
        JOptionPane.showInputDialog("BIENVENIDO A LA FARMACIA"+ "\n" + "\n"
                + "\n" + "Escoja una opción:" + "\n"
                + "\n" + "      1.  Ingresar"
                + "\n" + "      2.  Consultar"
                + "\n" + "      3.  Actualizar"
                + "\n" + "      4.  Eliminar"
                + "\n\n"+"      0.   Salir"+ "\n")
    if(seleccion !=null){
        var num=seleccion.toInt()
        when(num){
            1->{
                submenuInsertar()
            }
            2->{
                submenuConsultar()
            }
            3->{
                submenuEditar()
            }
            4->{
                submenuEliminar()
            }
            0->{
                JOptionPane.showMessageDialog(null, "GRACIAS POR SU VISITA!!")
                System.exit(0)
            }
        }

    }else{
        JOptionPane.showMessageDialog(null, "GRACIAS POR SU VISITA!!")
        System.exit(0)
    }


}

fun submenuInsertar(){

    val seleccion =
        JOptionPane.showInputDialog("INGRESAR" + "\n"
                + "\n" + "      1.  Medicina"
                + "\n" + "      2.  Receta"
                + "\n\n"+"      0.  Regresar al Menú principal"+ "\n")

    var num=seleccion.toInt()
    when(num){
        1->{
            list.add(ingresarMedicina())
            consultarMedicina()
            aplicacionFarmacia()
        }
        2->{
            listRe.add(ingresarReceta())
            consultarReceta()
            aplicacionFarmacia()

        }
        0->{
            JOptionPane.showMessageDialog(null, "Regresando al Menú principal")
            aplicacionFarmacia()
        }

    }

}

fun submenuConsultar(){
    val seleccion =
        JOptionPane.showInputDialog("CONSULTAR"+ "\n"
                + "\n" + "     1.   Medicina"
                + "\n" + "     2.   Receta"
                + "\n\n"+"     0.   Regresar al Menú principal"+ "\n")

    var num=seleccion.toInt()
    when(num){
        1->{
            consultarMedicina()
            aplicacionFarmacia()
        }
        2->{
            consultarReceta()
            aplicacionFarmacia()
        }
        0->{
            JOptionPane.showMessageDialog(null, "Regresando al Menú principal")
            aplicacionFarmacia()
        }
    }
}




fun submenuEditar(){
    val seleccion =
        JOptionPane.showInputDialog("EDITAR"+ "\n"
                + "\n" + "      1.  Medicina"
                + "\n" + "      2.  Receta"
                + "\n\n"+"      0.  Regresar al Menú principal"+ "\n")

    var num=seleccion.toInt()
    when(num){
        1->{
            modificarMedicina()
            consultarMedicina()
            aplicacionFarmacia()

        }
        2->{

        }
        0->{
            JOptionPane.showMessageDialog(null, "Regresando al Menú principal")
            aplicacionFarmacia()

        }

    }

}

fun submenuEliminar(){
    val seleccion =
        JOptionPane.showInputDialog("ELIMINAR"+ "\n"
                + "\n" + "      1.  Medicina"
                + "\n" + "      2.  Receta"
                + "\n\n"+"      0.  Regresar al Menú principal"+ "\n")

    var num=seleccion.toInt()
    when(num){
        1->{
            consultarMedicina()
            eliminarMedicina()
            consultarMedicina()
            aplicacionFarmacia()
        }
        2->{

        }
        0->{
            JOptionPane.showMessageDialog(null, "Regresando al Menú principal")
            aplicacionFarmacia()

        }

    }

}

//------------MEDICINA--------------//

fun ingresarMedicina():Medicina{
    var m = Medicina()
    val nombre = JOptionPane.showInputDialog("Nombre del medicamento")
    m.nombreMedicina=nombre.toString()

    val codigo = JOptionPane.showInputDialog("Código del medicamento")
    m.codigoMedicina=codigo.toString()

    val tipo = JOptionPane.showInputDialog("Tipo de medicamento (Jarabe/Pastillas)")
    m.tipoMedicina=tipo.toString()

    val valor = JOptionPane.showInputDialog("Precio del medicamento")
    m.precio=valor.toDouble()

    val cant = JOptionPane.showInputDialog("Cantidad del medicamentos")
    m.cantidad=cant.toInt()
    JOptionPane.showMessageDialog(null, "Medicamento ingresado con éxito")

    return m
}

fun ingresarMedicina(med: Medicina):Medicina{
    var m = Medicina()
    val nombre = JOptionPane.showInputDialog(null, "Nombre del medicamento", med.nombreMedicina)
    m.nombreMedicina=nombre.toString()

    val codigo = JOptionPane.showInputDialog(null, "Código del medicamento", med.codigoMedicina)
    m.codigoMedicina=codigo.toString()

    val tipo = JOptionPane.showInputDialog(null, "Tipo de medicamento (Jarabe/Pastillas)", med.tipoMedicina)
    m.tipoMedicina=tipo.toString()

    val valor = JOptionPane.showInputDialog(null, "Precio del medicamento", med.precio)
    m.precio=valor.toDouble()

    val cant = JOptionPane.showInputDialog(null, "Cantidad del medicamentos", med.cantidad)
    m.cantidad=cant.toInt()
    JOptionPane.showMessageDialog(null, "Medicamento ingresado con éxito")

    return m
}

fun modificarMedicina(){
    val nombre = JOptionPane.showInputDialog("Nombre del medicamento a modificar")
    var med = Medicina()
    if(list.none{it.nombreMedicina==nombre}){
        JOptionPane.showMessageDialog(null, "No existe ese medicamento")
    } else {
        var index = getIndex(nombre)
        if(index<0) {
            JOptionPane.showMessageDialog(null, "Error al buscar medicamento")
        }else{
            consultarMedicina(index)
            med = ingresarMedicina(list[index])

            list[index] = med
        }
    }

}

fun getIndex(nombre: String): Int{
    for (item: Medicina in list) {
        if (item.nombreMedicina == nombre) {
            return list.indexOf(item)
        }
    }
    return -1
}

fun consultarMedicina(){
    var med: String =""
    for (item: Medicina in list) {
        med +=
            "Nombre del medicamento: " +item.nombreMedicina+ "\n" +
                    "Códido de medicina: "+ item.codigoMedicina + "\n" +
                    "Tipo de mediciana: " + item.tipoMedicina + "\n" +
                    "Precio: " +item.precio + "\n" +
                    "Cantidad: "+item.cantidad + "\n\n"
    }
    JOptionPane.showMessageDialog(null, med)
}

fun consultarMedicina(index: Int){
    var med = Medicina()
    med = list[index]
    JOptionPane.showMessageDialog(null,
        "Nombre del medicamento: " + med.nombreMedicina+ "\n" +
                "Códido de medicina: "+ med.codigoMedicina + "\n" +
                "Tipo de mediciana: " + med.tipoMedicina + "\n" +
                "Precio: " + med.precio + "\n" +
                "Cantidad: "+ med.cantidad)
}

fun eliminarMedicina(){
    var nombreMedicamento: String
    val nombreMEliminar = JOptionPane.showInputDialog("Ingrese el nombre del medicamento a eliminar")
    nombreMedicamento = nombreMEliminar.toString()

    for (i in list.indices) {
        if (list[i].nombreMedicina.equals(nombreMedicamento)) {
            list.removeAt(i)
            JOptionPane.showMessageDialog(null, "Eliminado")
            //println("Eliminado")
        }
    }


}

/*---------------Receta------------------*/

fun ingresarReceta():Receta{
    var receta = Receta()

    val medicamentoReceta = JOptionPane.showInputDialog("Ingrese nombre del Medicamento:").toString()

    buscarReceta(medicamentoReceta)

    receta.medicina = medicamentoReceta

    val nombreCliente = JOptionPane.showInputDialog("Ingrese nombre cliente")
    receta.nombrePaciente = nombreCliente.toString()

    val apellidoCliente = JOptionPane.showInputDialog("Ingrese el apellido")
    receta.apellidoPaciente = apellidoCliente.toString()

    val cedulaCliente = JOptionPane.showInputDialog("Ingrese la cedula")
    receta.identificacion = cedulaCliente.toString()

    val detalleR = JOptionPane.showInputDialog("Detalle de la receta")
    receta.detalle = detalleR.toString()


    return receta
}


fun buscarReceta(nombre: String): Medicina {
    var opcion: Int = 0
    var medReceta = Medicina()
    var recetass = Receta()
    for (item: Medicina in list) {
        if (item.nombreMedicina.equals(nombre)) {
            recetass.medicina = item.nombreMedicina
            JOptionPane.showMessageDialog(null, "Medicamento seleccionado" + "\n"+ item.nombreMedicina )
            medReceta = item
        }
    }
    return medReceta
}

fun consultarReceta() {
    var nuevo:String =""
    for (item: Receta in listRe) {
        nuevo+= "Medicina: "+item.medicina +"\n" +
                "Nombre del Cliente: "+item.nombrePaciente + "\n" +
                "Apellido del cliente: "+ item.apellidoPaciente + "\n" +
                "Cedula del cliente: "+item.identificacion + "\n" +
                "Detalle de la receta: "+item.detalle+ "\n\n"
    }
    JOptionPane.showMessageDialog(null,nuevo)
}

fun quemarReceta(){
    var rec = Receta()
    rec.medicina="BioSil"
    rec.nombrePaciente="Mario"
    rec.apellidoPaciente="Caza"
    rec.identificacion="1725052292"
    rec.detalle="Generador de colágeno"
    listRe.add(rec)

}
fun quemarMedicina(){
    var med = Medicina()
    med.nombreMedicina="BioSil"
    med.codigoMedicina="001"
    med.tipoMedicina="Pastillas"
    med.precio= 39.99
    med.cantidad= 20
    list.add(med)

    med = Medicina()
    med.nombreMedicina="NeoGripal"
    med.codigoMedicina="002"
    med.tipoMedicina="Pastillas"
    med.precio=4.60
    med.cantidad=18
    list.add(med)

    med = Medicina()
    med.nombreMedicina="Vaporex"
    med.codigoMedicina="003"
    med.tipoMedicina="Jarabe"
    med.precio= 7.10
    med.cantidad= 16
    list.add(med)
}

