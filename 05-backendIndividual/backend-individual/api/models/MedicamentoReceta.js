/**
 * MedicamentoReceta.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    //CONFIGURACIÓN DEL HIJO  
    fkMedicamento:{//nombre del fk para la relación
      model: 'Medicamento' //Nombre del modelo a relacionae (papá)
      //required: true //OPCIONAL ->Siempre infresar el fk
    },

  fkReceta:{//nombre del fk para la relación
      model: 'Receta' //Nombre del modelo a relacionae (papá)
      //required: true //OPCIONAL ->Siempre infresar el fk
    }
  },

};

