/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    listarVenta();
    $("#btn_Buscar").click(function(){
  
        BuscarVenta();
        var fecha = $("#fecha").val();
        var buscar = $("#txt_Buscar").val();
        if(fecha!==''&&buscar!==''){
            BuscarVentaPorProductoYFecha();
        }else if(fecha===''&&buscar!==''){
            BuscarVenta();
        }else if(fecha!==''&&buscar===''){
            BuscarProductoPorFecha();
        }
    });
    $("#btnListar").click(function(){
        $("tbody tr").remove();
         $("#fecha").val(null);
         $("#txt_Buscar").val(null);
        listarVenta(); 
    });
});

function listarVenta(){
     var parametros = {
               accion: "listarVenta"
              
    };    
    $.ajax({          
        url: '../ControllerVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
      success: function (resultado) {
        console.log(resultado);
            
            ventas=resultado;          
            var cantidad;
            cantidad= ventas.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = ventas.length;
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
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  var forma=ventas[i].unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.unaForma.descripcion+" DE "+ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.cantidadUnidad+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }

  
 
  if(j===2){
     var textoCelda = document.createTextNode(ventas[i].fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(ventas[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(ventas[i].valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(ventas[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(ventas[i].unUsuario.nombre);
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

function BuscarVenta(){
    $("tbody tr").remove();
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "BuscarVenta",
                       buscar:buscar
              
    };    
    $.ajax({          
        url: '../ControllerVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
       success: function (resultado) {
        console.log(resultado);
            
            ventas=resultado;          
            var cantidad;
            cantidad= ventas.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = ventas.length;
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
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
 var forma=ventas[i].unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.unaForma.descripcion+" DE "+ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.cantidadUnidad+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }

  
 
  if(j===2){
     var textoCelda = document.createTextNode(ventas[i].fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(ventas[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(ventas[i].valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(ventas[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(ventas[i].unUsuario.nombre);
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


function BuscarVentaPorProductoYFecha(){
    $("tbody tr").remove();
      var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "BuscarVentaPorProductoYFecha",
               fecha:$("#fecha").val(),
               buscar:buscar
               
    };    
    $.ajax({          
        url: '../ControllerVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
            ventas=resultado;          
            var cantidad;
            cantidad= ventas.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = ventas.length;
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
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
 var forma=ventas[i].unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.unaForma.descripcion+" DE "+ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.cantidadUnidad+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }

  
 
  if(j===2){
     var textoCelda = document.createTextNode(ventas[i].fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(ventas[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(ventas[i].valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(ventas[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(ventas[i].unUsuario.nombre);
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

function BuscarProductoPorFecha(){
    $("tbody tr").remove();
     var parametros = {
               accion: "BuscarProductoPorFecha",
               fecha:$("#fecha").val()              
    };    
    $.ajax({          
        url: '../ControllerVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
         success: function (resultado) {
        console.log(resultado);
            
            ventas=resultado;          
            var cantidad;
            cantidad= ventas.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = ventas.length;
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
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
 var forma=ventas[i].unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(ventas[i].unDetalleProducto.unaForma.descripcion+" DE "+ventas[i].unDetalleProducto.nombre+" "+ventas[i].unDetalleProducto.cantidadUnidad+" "+ventas[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+ventas[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }

  
 
  if(j===2){
     var textoCelda = document.createTextNode(ventas[i].fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(ventas[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(ventas[i].valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(ventas[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(ventas[i].unUsuario.nombre);
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