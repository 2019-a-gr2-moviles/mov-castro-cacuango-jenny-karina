class Receta {

    var codigo :String = ""
    var nombrePaciente:String =""
    var apellidoPaciente:String =""
    var identificacion:String ="" //cedula-pasaporte
    var medicina = ArrayList<Medicina>()
    var detalle = ArrayList<String>()

    override fun toString(): String {
        var rec:String =  "\nCodigo: " + codigo.toString() + "\n" +
                "Nombre del Cliente: " + nombrePaciente + "\n" +
                "Apellido del cliente: " + apellidoPaciente + "\n" +
                "Cedula del cliente: " + identificacion + "\n"
        var i:Int = 0
        for (med: Medicina in medicina) {
            rec += (med.nombreMedicina + "  " + detalle[i] + "\n")
            i++
        }
        return rec
    }

    fun toSave(): String{
        var rec:String =
            codigo.toString() + "," +
                    nombrePaciente + "," +
                    apellidoPaciente + "," +
                    identificacion + ","
        var i:Int = 0
        for (med: Medicina in medicina) {
            rec += (med.nombreMedicina + "," + detalle[i] + ",")
            i++
        }
        return rec.substring(0, rec.length-1)
    }
}