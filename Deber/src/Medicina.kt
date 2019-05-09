class Medicina {

    var nombreMedicina: String = ""
    var codigoMedicina: String = ""
    var tipoMedicina: String = ""
    var precio: Double = 0.0
    var cantidad: Int = 0

    override fun toString(): String {
        return  "\nNombre del medicamento: " + nombreMedicina + "\n" +
                "Códido de medicina: " +  codigoMedicina + "\n" +
                "Tipo de mediciana: " +  tipoMedicina + "\n" +
                "Precio: " + precio + "\n" +
                "Cantidad: " + cantidad +"\n"
    }

    fun toSave(): String {
        return  codigoMedicina + "," +
                nombreMedicina + "," +
                tipoMedicina + "," +
                precio + "," +
                cantidad
    }
}