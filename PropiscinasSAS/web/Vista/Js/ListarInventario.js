/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var numeroo = 0;
$(function ()
{
  $('#btnBuscar').click(function(){ 
           $("tbody tr").remove(); 
          var  fecha=$("#fecha").val();
         
          var buscar = $("#txt_Buscar").val();
          let numeroInfraestructura=0;
          numeroInfraestructura= $("#cb_Infraestructura").val();
          if(buscar!==''&&numeroInfraestructura==='0'&&fecha===''){
             
              buscarInventarioDatosHistoricos();
          }
          else if (numeroInfraestructura==='0') {
             
              if(fecha!==''&&buscar!==''){
                 
         listarInventarioPorFechaYCodigo(fecha);
         
     }else{
          if(fecha!==''){
         listarInventarioPorFecha(fecha);
     }
     }
        }else{
          listarInventarioPorFechaYCodigoYInfraestructura(fecha,numeroInfraestructura);
        }
        
   
     
   }); 
     ListarInventario();
    listarInfraestructura();


    $("#cb_Infraestructura").change(function(){
        var id=$("#cb_Infraestructura").val();
         if(id>0){
              
             $("tbody tr").remove(); 
             ListarInventarioPorIdInfraestructura();
         }else{
                $("tbody tr").remove(); 
         
             ListarInventario();
         }
    });
      $('#bntListarCantidadActualizada').click(function(){ 
           $("tbody tr").remove(); 
        listarCantidadActualizada();
      
   }); 
  
   $("#btnListar").click(function(){
       $("tbody tr").remove(); 
       ListarInventario();
      
     $("#fecha").val(0);
     $("#txt_Buscar").val(null);
     $("#cb_Infraestructura").val(0);
   });
   
});
function listarCantidadActualizada(){
     var parametros = {
               accion: "listarCantidadActual"
             
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
          success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 10; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
    if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

  if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }



    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===8){
     var textoCelda = document.createTextNode(inventarios[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(inventarios[i].unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
function ListarInventario(){
     var parametros = {
               accion: "listarInventario"
             
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
       
      success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 10; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
    if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

  if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }



    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===8){
     var textoCelda = document.createTextNode(inventarios[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(inventarios[i].unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
function ListarInventarioPorIdInfraestructura(){
     var parametros = {
               accion: "listarInventarioInfraestructura",
               infraestructura:$("#cb_Infraestructura").val()
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
           success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 10; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
    if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

  if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }



    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===8){
     var textoCelda = document.createTextNode(inventarios[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(inventarios[i].unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
function listarInfraestructura()
{
    var parametros=
            {
                accion:"ListarInfraestructura"
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
                   var infraestructuras = resultado;
                   $.each(infraestructuras,function(i,infraestructura)
                   {
                       
                       $('#cb_Infraestructura').append(
                         $('<option>',{
                            
                            value: infraestructura.idInfraestructura,
                            text: infraestructura.descripcion
                        })
                      );
                   });
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
}
function listarInventarioPorFecha(fecha){

    $("tbody tr").remove(); 
     
      var parametros=
            {
                accion:"listarInventarioPorFecha",
                fecha:fecha
            };
            $.ajax({
               url: '../ControllerInventarioInfraestructura' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
                  success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 10; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
    if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

  if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }



    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===8){
     var textoCelda = document.createTextNode(inventarios[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(inventarios[i].unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
function listarInventarioPorFechaYCodigo(fecha){

    $("tbody tr").remove(); 
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
      var parametros=
            {
                accion:"listarInventarioPorFechaYCodigo",
                fecha:fecha,
                codigo:buscar
                
            };
            $.ajax({
               url: '../ControllerInventarioInfraestructura' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
                success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 10; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
    if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

  if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }



    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===8){
     var textoCelda = document.createTextNode(inventarios[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(inventarios[i].unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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

function listarInventarioPorFechaYCodigoYInfraestructura(fecha,infraestructura){

    $("tbody tr").remove(); 
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
      var parametros=
            {
                accion:"listarInventarioPorFechaYCodigoYInfraestructura",
                fecha:fecha,
                codigo:buscar,
                infraestructura:infraestructura
                
            };
            $.ajax({
               url: '../ControllerInventarioInfraestructura' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
                success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 10; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
    if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

  if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }



    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===8){
     var textoCelda = document.createTextNode(inventarios[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(inventarios[i].unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
///////////
function buscarInventarioDatosHistoricos(){

    $("tbody tr").remove(); 
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
      var parametros=
            {
                accion:"buscarInventarioDatosHistoricos",
                codigo:buscar
                
                
            };
            $.ajax({
               url: '../ControllerInventarioInfraestructura' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
                 success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 10; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
    if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

  if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }



    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===8){
     var textoCelda = document.createTextNode(inventarios[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(inventarios[i].unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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