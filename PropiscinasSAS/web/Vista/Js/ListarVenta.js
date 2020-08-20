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
            
            ventas = resultado;          
            var cantidad;
            cantidad= ventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(ventas, function(j,venta){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  var forma=venta.unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.unaForma.descripcion+" DE "+venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.cantidadUnidad+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }

  
 
  if(j===2){
     var textoCelda = document.createTextNode(venta.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(venta.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(venta.valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(venta.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(venta.unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
            
            ventas = resultado;          
            var cantidad;
            cantidad= ventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(ventas, function(j,venta){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  var forma=venta.unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.unaForma.descripcion+" DE "+venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.cantidadUnidad+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }

  if(j===2){
     var textoCelda = document.createTextNode(venta.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(venta.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(venta.valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(venta.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(venta.unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
            
            ventas = resultado;          
            var cantidad;
            cantidad= ventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(ventas, function(j,venta){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
   var forma=venta.unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.unaForma.descripcion+" DE "+venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.cantidadUnidad+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }

  if(j===2){
     var textoCelda = document.createTextNode(venta.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(venta.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(venta.valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(venta.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(venta.unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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
            
            ventas = resultado;          
            var cantidad;
            cantidad= ventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(ventas, function(j,venta){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 7; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  var forma=venta.unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===1){
      var textoCelda = document.createTextNode(venta.unDetalleProducto.unaForma.descripcion+" DE "+venta.unDetalleProducto.nombre+" "+venta.unDetalleProducto.cantidadUnidad+" "+venta.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  }
  if(j===2){
     var textoCelda = document.createTextNode(venta.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(venta.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
if(j===4){
     var textoCelda = document.createTextNode(venta.valor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }             
   if(j===5){
     var textoCelda = document.createTextNode(venta.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===6){
     var textoCelda = document.createTextNode(venta.unUsuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
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