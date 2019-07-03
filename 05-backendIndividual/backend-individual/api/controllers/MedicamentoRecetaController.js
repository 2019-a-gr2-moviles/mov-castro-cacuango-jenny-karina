/**
 * MedicamentoRecetaController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {

    //CONFIGURACIÓN DEL HIJO  
    fkMedicamento:{//nombre del fk para la relación
        model: 'Medicamento' //Nombre del modelo a relacionae (papá)
        //require: true //OPCIONAL ->Siempre infresar el fk
      },

    fkReceta:{//nombre del fk para la relación
        model: 'Receta' //Nombre del modelo a relacionae (papá)
        //require: true //OPCIONAL ->Siempre infresar el fk
      }

  

};

