/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    ListarProveedorProductoCompra();
    ListarProveedorr();
    $("#btn_Buscar").click(function(){
        var buscar = $("#txt_Buscar").val();
        var fecha = $("#fecha").val();
        var cb_Proveedor = $("#cb_Proveedor").val();
        if(buscar!==""&&fecha===""&&cb_Proveedor==='0'){
            BuscarPorNombre();
        }else if(buscar!==""&&fecha!==""&&cb_Proveedor==='0'){
            
            BuscarPorNombreYFecha();
        }else if(fecha!==""&&buscar===""&&cb_Proveedor==='0'){
            BuscarPorFecha();
        }else if(fecha===""&&buscar===""&&cb_Proveedor!=='0'){
            BuscarPorProveedor(cb_Proveedor);
        }else if(fecha!==""&&buscar===""&&cb_Proveedor!=='0'){
            BuscarPorProveedorYFecha(cb_Proveedor);
        }
        else if(fecha!==""&&buscar!==""&&cb_Proveedor!=='0'){
            BuscarPorProveedorYFechaYidProducto(cb_Proveedor);
        }
          else if(fecha===""&&buscar!==""&&cb_Proveedor!=='0'){
            BuscarPorProveedorYidProducto(cb_Proveedor);
        }
        
    
        
    });
    $("#btnListar").click(function(){
        $("tbody tr").remove();
        $("#fecha").val(null);
        $("#txt_Buscar").val(null);
        $("#cb_Proveedor").val(0);
        ListarProveedorProductoCompra();
    });
});
//Esta function lista todos los prcductos comprados al proveedor 
function ListarProveedorProductoCompra(){
     var parametros = {
               accion: "ListarProveedorProductoCompra"
              
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
          success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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

function BuscarPorNombre(){
    $("tbody tr").remove();
    var buscar = $("#txt_Buscar").val().trim();
     var parametros = {
               accion: "BuscarPorNombre",
               buscar:buscar
            
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
         success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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

function BuscarPorNombreYFecha(){
    $("tbody tr").remove();
    var buscar = $("#txt_Buscar").val().trim();
     var parametros = {
               accion: "BuscarPorNombreYFecha",
               buscar:buscar,
               fecha:$("#fecha").val()
            
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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

function BuscarPorFecha(){
    $("tbody tr").remove();
    
     var parametros = {
               accion: "BuscarPorFecha",
               fecha:$("#fecha").val()
            
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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
function BuscarPorProveedor(idProveedor){
    $("tbody tr").remove();
    
     var parametros = {
               accion: "BuscarPorProveedor",
               idProveedor:idProveedor
            
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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

function BuscarPorProveedorYFecha(idProveedor){
    $("tbody tr").remove();
    
     var parametros = {
               accion: "BuscarPorProveedorYFecha",
               idProveedor:idProveedor,
               fecha:$("#fecha").val()
            
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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

function BuscarPorProveedorYFechaYidProducto(idProveedor){
    $("tbody tr").remove();
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
               accion: "BuscarPorProveedorYFechaYidProducto",
               idProveedor:idProveedor,
               fecha:$("#fecha").val(),
               idProducto:buscar
            
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
       success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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
function BuscarPorProveedorYidProducto(idProveedor){
    $("tbody tr").remove();
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
               accion: "BuscarPorProveedorYidProducto",
               idProveedor:idProveedor,
               idProducto:buscar
            
    };    
    $.ajax({          
        url: '../ControllerProveedorProductoCompra',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
           proveedoresproductocompra=resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = proveedoresproductocompra.length;
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
 
    for (var j = 0; j < 5; j++) {


      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.nombre+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedoresproductocompra[i].unProveedorProducto.unDetalleProducto.idProducto);
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