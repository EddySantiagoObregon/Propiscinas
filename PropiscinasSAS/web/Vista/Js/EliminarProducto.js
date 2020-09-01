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
               accion: "ListarProductoEliminarJSP"
              
    };    
    $.ajax({          
        url: '../ControllerProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
  success: function (resultado) {
        console.log(resultado);
            
            productos=resultado;          
            var cantidad;
            cantidad= productos.length;
             
             
 
   
            
            var pag = 1;
            var totales = productos.length;
            var xPag = 15;
            var nPag = Math.ceil(totales / xPag);
            var offset = (pag - 1) * xPag;
            var hasta = pag * xPag;
$("#botones button").remove();
 

    function mostrarLista(desde,hasta){     
        $("tbody tr").remove();
      for(var i = desde; i < hasta; i++){
 var body =document.getElementsByTagName("tbody")[0];
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 11; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(productos[i].idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(productos[i].referencia);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(productos[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(productos[i].abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  if(j===4){
     var textoCelda = document.createTextNode(productos[i].unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(productos[i].unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(productos[i].unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidad =productos[i].cantidadUnidad;
  if(cantidad===0){
       if(j===7){
     var textoCelda = document.createTextNode(productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===7){
          var textoCelda = document.createTextNode(productos[i].cantidadUnidad+" "+productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
    

  if(j===8){
     var textoCelda = document.createTextNode(productos[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(productos[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var Estado = productos[i].estado;
  if(Estado==="A"){
      if(j===10){
      var id = productos[i].idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModal('+ id+')');
                           button.setAttribute('class','btn btn-danger');
                           button.setAttribute('style','cursor:pointer;');
                           button.setAttribute('id','btnn');
                           button.innerHTML="❌";
      
      fragment.appendChild(hilera);
      hilera.appendChild(button);
  }
  }else{
       if(j===10){
      var id = productos[i].idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModalActivar('+ id+')');
                           button.setAttribute('class','btn btn-green');
                           button.setAttribute('style','color:green; background:green;cursor:pointer;');
                           button.setAttribute('id','btnn');
                           button.innerHTML="✔️";
      
      fragment.appendChild(hilera);
      hilera.appendChild(button);
  }
  }
 
  
    
 
    // agrega la hilera al final de la tabla (al final del elemento tblbody)
    
    body.appendChild(hilera);
  }
 
  // posiciona el <tbody> debajo del elemento <table>
  
  // appends <table> into <body>
 
  // modifica el atributo "border" de la tabla y lo fija a "2";
 



        }
    }
          function mostrarBotones(t){
                var botones = '';
                for(var i = 0; i < t; i++){
                    var cada = '';
                    cada = "<button id='btnPagination' type='button' "+
                        "class='btn btn-info'>"+(i+1)+
                        "</button>";
                    botones += cada;
                }
                
                $('#botones').append(botones);
            }
            
            function quitarActivo(){
                var losBotones = document.querySelectorAll('#botones button');
                for(var i = 0; i < losBotones.length; i++){
                    $(losBotones[i]).removeClass('active');
                }
            }
            
            mostrarLista(offset,hasta);
            mostrarBotones(nPag);
            
          $( document ).ready(function(){
                // Activar el primer botón
                $('#botones button:first-child').addClass('active');
                
                // Poner oyentes a cada botón
                var losBotones = document.querySelectorAll('#botones button');
                for(var i = 0; i < losBotones.length; i++){
                    losBotones[i].addEventListener('click',function(){
                        quitarActivo();
                        var indice = parseInt(this.textContent);
                        var o = (indice -1) * xPag;
                        var h = indice * xPag;
                        mostrarLista(o,h);
                        $(this).addClass('active');
                    });
                }
            });
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

function abrirModalActivar(id){
  
    
     $("#mensaje").html("");
   
     var parametros=
            {
                accion: "Activar",
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
                      alert("Activado correctamente");
                    
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
               accion: "BuscarEliminarJSP",
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
            
            productos=resultado;          
            var cantidad;
            cantidad= productos.length;
             
             
 
   
            
            var pag = 1;
            var totales = productos.length;
            var xPag = 15;
            var nPag = Math.ceil(totales / xPag);
            var offset = (pag - 1) * xPag;
            var hasta = pag * xPag;
$("#botones button").remove();
 

    function mostrarLista(desde,hasta){     
        $("tbody tr").remove();
      for(var i = desde; i < hasta; i++){
 var body =document.getElementsByTagName("tbody")[0];
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 11; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(productos[i].idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(productos[i].referencia);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(productos[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(productos[i].abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  if(j===4){
     var textoCelda = document.createTextNode(productos[i].unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(productos[i].unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(productos[i].unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidad =productos[i].cantidadUnidad;
  if(cantidad===0){
       if(j===7){
     var textoCelda = document.createTextNode(productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===7){
          var textoCelda = document.createTextNode(productos[i].cantidadUnidad+" "+productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
    

  if(j===8){
     var textoCelda = document.createTextNode(productos[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(productos[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var Estado = productos[i].estado;
  if(Estado==="A"){
      if(j===10){
      var id = productos[i].idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModal('+ id+')');
                           button.setAttribute('class','btn btn-danger');
                           button.setAttribute('style','cursor:pointer;');
                           button.setAttribute('id','btnn');
                           button.innerHTML="❌";
      
      fragment.appendChild(hilera);
      hilera.appendChild(button);
  }
  }else{
       if(j===10){
      var id = productos[i].idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModalActivar('+ id+')');
                           button.setAttribute('class','btn btn-green');
                           button.setAttribute('style','color:green; background:green;cursor:pointer;');
                           button.setAttribute('id','btnn');
                           button.innerHTML="✔️";
      
      fragment.appendChild(hilera);
      hilera.appendChild(button);
  }
  }
 
  
    
 
    // agrega la hilera al final de la tabla (al final del elemento tblbody)
    
    body.appendChild(hilera);
  }
 
  // posiciona el <tbody> debajo del elemento <table>
  
  // appends <table> into <body>
 
  // modifica el atributo "border" de la tabla y lo fija a "2";
 



        }
    }
          function mostrarBotones(t){
                var botones = '';
                for(var i = 0; i < t; i++){
                    var cada = '';
                    cada = "<button id='btnPagination' type='button' "+
                        "class='btn btn-info'>"+(i+1)+
                        "</button>";
                    botones += cada;
                }
                
                $('#botones').append(botones);
            }
            
            function quitarActivo(){
                var losBotones = document.querySelectorAll('#botones button');
                for(var i = 0; i < losBotones.length; i++){
                    $(losBotones[i]).removeClass('active');
                }
            }
            
            mostrarLista(offset,hasta);
            mostrarBotones(nPag);
            
          $( document ).ready(function(){
                // Activar el primer botón
                $('#botones button:first-child').addClass('active');
                
                // Poner oyentes a cada botón
                var losBotones = document.querySelectorAll('#botones button');
                for(var i = 0; i < losBotones.length; i++){
                    losBotones[i].addEventListener('click',function(){
                        quitarActivo();
                        var indice = parseInt(this.textContent);
                        var o = (indice -1) * xPag;
                        var h = indice * xPag;
                        mostrarLista(o,h);
                        $(this).addClass('active');
                    });
                }
            });
    }
     
        
    });
   
}
