/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre:{
      type:'string'
    },
    //CONFIGURACIÓN DEL HIJO  
    fkUsuario:{//nombre del fk para la rrelación
      model: 'usuario' //Nombre del modelo a relacionae (papá)
      //require: true //OPCIONAL ->Siempre infresar el fk
    }
  },

};

