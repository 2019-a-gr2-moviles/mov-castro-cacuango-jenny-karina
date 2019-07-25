/**
 * Actor.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombres: {
      type: 'string',
      required: true
    },

    apellidos: {
      type: 'string',
      required: true
    },

    fechaNacimiento: {
      type: 'string',
      required: true
    },

    numeroPeliculas: {
      type: 'number',
      required: true
    },

    retirado: {
      type: 'boolean',
      required: true
    },

    peliculaDeActor: {     // Nombre atributo de la relación
      collection: 'pelicula', // Nombre del modelo a relacionar
      via: 'idActor'        // Nombre del campo a hacer la relacion
    },


  },

};

