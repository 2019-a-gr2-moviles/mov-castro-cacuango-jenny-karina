/**
 * Medicamento.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombreMedicina:{
      type: 'string',
      required: true
    },

    tipoMedicina:{
      type: 'string',
      required: true,
      enum: ['Pastillas', 'Jarabe', 'Pomada']

    },

    precio:{
      type: 'number',
      required: true

    },

    
      //CONFIGURAIÓN DEL PAPÁ
    //Campo que van a tener todos los servicios
    relacionMedicamento:{ //nombre atributo de la relación
    collection: 'MedicamentoReceta',  //nombre del modelo a relacionar
    via: 'fkMedicamento' //nombre del atributo fk del otro moodelo
                    //campo para hacer la relación
  }


  },

};

