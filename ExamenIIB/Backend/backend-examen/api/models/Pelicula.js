/**
 * Pelicula.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre: {
      type: 'string',
      required: true
    },

    anioLanzamiento: {
      type: 'number',
      required: true
    },

    rating: {
      type: 'number',
      required: true
    },

    actoresPrincipales: {
      type: 'string',
      required: true
    },

    sinopsis: {
      type: 'string',
      required: true
    },

    longitud: {
      required: true,
      type: 'string'
    },
    latitud: {
      required: true,
      type: 'string'
    },

    idActor: {         // Nombre del fk para la relación
      model: 'actor',   // Nombre del modelo a relacionar (padre) 
      required: true   // OPCIONAL-> Simpre se ingrese el fk
    }

  },

};

