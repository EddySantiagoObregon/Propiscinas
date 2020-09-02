/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function(){
    ListarProveedorProducto();
    ListarProveedorr();
    $("#btn_Buscar").click(function(){
        var buscar = $("#txt_Buscar").val();
        var cb_Proveedor = $("#cb_Proveedor").val();
        if(buscar!==""&&cb_Proveedor==='0'){
            BuscarPorNombre();
           
        }else if(buscar!==""&&cb_Proveedor!=='0'){
           
            BuscarPorProveedoryIdProducto();
        }else if(buscar===""&&cb_Proveedor!=='0'){
            
            BuscarPorIdProveedor();
        }
    
        
    });
    $("#btnListar").click(function(){
        $("tbody tr").remove();
        $("#txt_Buscar").val(null);
        $("#cb_Proveedor").val(0);
        ListarProveedorProducto();
    });
});
//Esta function lista todos los prcductos comprados al proveedor 
function ListarProveedorProducto(){
     var parametros = {
               accion: "ListarProveedorProductos"
              
    };    
    $.ajax({          
        url: '../ControllerProveedorProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
       success: function (resultado) {
        console.log(resultado);
            
           productoproveedor=resultado;          
            var cantidad;
            cantidad= productoproveedor.length;
             
             
 
   
            
            var pag = 1;
            var totales = productoproveedor.length;
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
      var textoCelda = document.createTextNode(productoproveedor[i].unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor[i].unDetalleProducto.cantidadUnidad;
var forma=productoproveedor[i].unDetalleProducto.unaForma.descripcion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" "+ productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.cantidadUnidad+" "+ productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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

function BuscarPorNombre(){
    $("tbody tr").remove();
  var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "ListarProveedoresYProductosPorCodigo",
              codigo:buscar
              
    };    
     $.ajax({          
        url: '../ControllerProveedorProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
       success: function (resultado) {
        console.log(resultado);
            
           productoproveedor=resultado;          
            var cantidad;
            cantidad= productoproveedor.length;
             
             
 
   
            
            var pag = 1;
            var totales = productoproveedor.length;
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
      var textoCelda = document.createTextNode(productoproveedor[i].unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor[i].unDetalleProducto.cantidadUnidad;
var forma=productoproveedor[i].unDetalleProducto.unaForma.descripcion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" "+ productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.cantidadUnidad+" "+ productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
function BuscarPorProveedoryIdProducto(){
    $("tbody tr").remove();
  var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "ListarProveedoresYProductosPoridProveedor",
              codigo:buscar,
              idProveedor:$("#cb_Proveedor").val()
              
    };    
     $.ajax({          
        url: '../ControllerProveedorProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
       success: function (resultado) {
        console.log(resultado);
            
           productoproveedor=resultado;          
            var cantidad;
            cantidad= productoproveedor.length;
             
             
 
   
            
            var pag = 1;
            var totales = productoproveedor.length;
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
      var textoCelda = document.createTextNode(productoproveedor[i].unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor[i].unDetalleProducto.cantidadUnidad;
var forma=productoproveedor[i].unDetalleProducto.unaForma.descripcion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" "+ productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.cantidadUnidad+" "+ productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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

function BuscarPorIdProveedor(){
    $("tbody tr").remove();

    
     var parametros = {
               accion: "ListarProveedoresYProductosPoridProveedor",
              idProveedor:$("#cb_Proveedor").val()
              
    };    
     $.ajax({          
        url: '../ControllerProveedorProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
       success: function (resultado) {
        console.log(resultado);
            
           productoproveedor=resultado;          
            var cantidad;
            cantidad= productoproveedor.length;
             
             
 
   
            
            var pag = 1;
            var totales = productoproveedor.length;
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
      var textoCelda = document.createTextNode(productoproveedor[i].unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor[i].unDetalleProducto.cantidadUnidad;
var forma=productoproveedor[i].unDetalleProducto.unaForma.descripcion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" "+ productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor[i].unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor[i].unDetalleProducto.nombre+" "+productoproveedor[i].unDetalleProducto.cantidadUnidad+" "+ productoproveedor[i].unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
function ListarProveedorr()
{
    var parametros=
            {
                accion:"listarProveedor"
            };
            $.ajax({
               url: '../ControllerProveedor' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var proveedores = resultado;
                   $.each(proveedores,function(i,proveedor)
                   {
                       
                       $('#cb_Proveedor').append(
                         $('<option>',{
                            
                            value: proveedor.idProveedor,
                            text: proveedor.nombre
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