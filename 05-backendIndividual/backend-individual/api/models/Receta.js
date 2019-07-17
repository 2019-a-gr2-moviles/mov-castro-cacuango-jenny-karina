/**
 * Receta.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombrePaciente:{
      type: 'string',
      required: true

    },

    apellidoPaciente:{
      type: 'string',
      required: true

    },

    identificacion: {
      type: 'number',
      required: true,
      unique: true

    },

    //CONFIGURAIÓN DEL PAPÁ
    //Campo que van a tener todos los servicios
    relacionReceta:{ //nombre atributo de la relación
      collection: 'MedicamentoReceta',  //nombre del modelo a relacionar
      via: 'fkReceta' //nombre del atributo fk del otro moodelo
                      //campo para hacer la relación
    },


  },

};

