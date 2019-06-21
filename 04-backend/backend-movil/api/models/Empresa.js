/**
 * Empresa.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombreEmpresa:{
      type: 'string'
    },
    empresaDeUsuario:{ //nombre atributo de la relación
      collection: 'usuario',  //nombre del modelo a relacionar
      via: 'fkEmpresa' //nombre del atributo fk del otro moodelo
    },
    

  },

};

