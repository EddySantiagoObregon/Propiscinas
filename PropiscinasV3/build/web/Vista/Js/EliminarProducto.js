/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function ()
{
    
    ListarProducto();
    $('#btnListar').click(function(){
        $("tbody tr").remove(); 
        ListarProducto();
    });
    $('#btnBuscar').click(function(){ 
 
        BuscarProducto();
      
   }); 
   
});

function ListarProducto(){
     var parametros = {
               accion: "listarDetalleProducto"
              
    };    
    $.ajax({          
        url: '../ControllerProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            detalleproductos = resultado;          
            var cantidad;
            cantidad= detalleproductos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(detalleproductos, function(j,detalleproducto){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 11; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(detalleproducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(detalleproducto.referencia);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(detalleproducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(detalleproducto.abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  if(j===4){
     var textoCelda = document.createTextNode(detalleproducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(detalleproducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(detalleproducto.unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidad =detalleproducto.cantidadUnidad;
  if(cantidad===0){
       if(j===7){
     var textoCelda = document.createTextNode(detalleproducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===7){
          var textoCelda = document.createTextNode(detalleproducto.cantidadUnidad+" "+detalleproducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
    

  if(j===8){
     var textoCelda = document.createTextNode(detalleproducto.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(detalleproducto.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  if(j===10){
      var id = detalleproducto.idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModal('+ id+')');
                           button.setAttribute('class','btn btn-danger');
                           button.setAttribute('id','btnn');
                           button.innerHTML="❌";
      
      fragment.appendChild(hilera);
      hilera.appendChild(button);
  }
  
    
 
    // agrega la hilera al final de la tabla (al final del elemento tblbody)
    
    body.appendChild(hilera);
  }
 
  // posiciona el <tbody> debajo del elemento <table>
  
  // appends <table> into <body>
 
  // modifica el atributo "border" de la tabla y lo fija a "2";
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function abrirModal(id){
  
    
     $("#mensaje").html("");
   
     var parametros=
            {
                accion: "Eliminar",
                id:id
      
            };
    
         $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   
                   console.log(resultado);
                   if(resultado)
                   {
                     
                      $("tbody tr").remove(); 
                      alert("Eliminado correctamente");
                    
                       ListarProducto();
                       limpiar();
                   }else
                   {
                       alert("fallo");
                  
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
}
function  BuscarProducto(){
     $("tbody tr").remove(); 
       var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
               accion: "Buscar",
              txt_Buscar: buscar
              
    };    
    $.ajax({          
        url: '../ControllerProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            detalleproductos = resultado;          
            var cantidad;
            cantidad= detalleproductos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(detalleproductos, function(j,detalleproducto){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 11; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(detalleproducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(detalleproducto.referencia);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(detalleproducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(detalleproducto.abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  if(j===4){
     var textoCelda = document.createTextNode(detalleproducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(detalleproducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(detalleproducto.unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidad =detalleproducto.cantidadUnidad;
  if(cantidad===0){
       if(j===7){
     var textoCelda = document.createTextNode(detalleproducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===7){
          var textoCelda = document.createTextNode(detalleproducto.cantidadUnidad+" "+detalleproducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
    

  if(j===8){
     var textoCelda = document.createTextNode(detalleproducto.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(detalleproducto.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  if(j===10){
      var id = detalleproducto.idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModal('+ id+')');
                           button.setAttribute('class','btn btn-danger');
                           button.setAttribute('id','btnn');
                           button.innerHTML="❌";
      
      fragment.appendChild(hilera);
      hilera.appendChild(button);
  }
  
    
 
    // agrega la hilera al final de la tabla (al final del elemento tblbody)
    
    body.appendChild(hilera);
  }
 
  // posiciona el <tbody> debajo del elemento <table>
  
  // appends <table> into <body>
 
  // modifica el atributo "border" de la tabla y lo fija a "2";
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}