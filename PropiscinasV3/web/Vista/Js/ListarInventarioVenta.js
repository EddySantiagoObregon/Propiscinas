/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function(){
    listarVenta();
    tipoDocumento();
    $("#btnBuscar").click(function(){
       
        var fecha = $("#fecha").val();
        var buscar = $("#txt_Buscar").val();
        var idTipoDocumento = $("#cb_TipoDocumento").val();
        if(fecha!==''&&buscar!==''&&idTipoDocumento>'0'){
            BuscarPorProductoYTipoDocumentoYFecha();
           alert('1');
        }
        else if(fecha!==''&&buscar===''&&idTipoDocumento<'1'){
             alert('2');
            buscarInventarioVentaPorFecha();
        }
        else if(fecha===''&&buscar!==''&&idTipoDocumento<'1'){
             alert('3');
            buscarVenta();
        }
        else if(fecha!==""&&buscar!==''&&idTipoDocumento<'1'){
            alert('4');
            buscarInventarioVentaPorProductoYFecha();
        }else if(fecha===""&&buscar===""&&idTipoDocumento>'0'){
           alert('5');
            BuscarPorTipoDocumento();
        }
        else if (fecha!==""&&buscar===""&&idTipoDocumento>'0'){
            alert('6');
            BuscarPorTipoDocumentoYFecha();
        }
       else if(fecha===''&&buscar!==''&&idTipoDocumento>'1'){
            alert('7');
            BuscarPorProductoYTipoDocumento();
        }
    });
    $("#btnListar").click(function(){
        $("tbody tr").remove();
        $("#txt_Buscar").val(null);
        $("#cb_TipoDocumento").val(0);
        $("#fecha").val(null);
        listarVenta(); 
    });
});

function listarVenta(){
     var parametros = {
               accion: "listarInventarioVenta"
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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

function buscarVenta(){
    $("tbody tr").remove();
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "buscarIventarioVenata",
               buscar:buscar
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
           
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
   var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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

function buscarInventarioVentaPorFecha(){
    $("tbody tr").remove();
     var parametros = {
               accion: "buscarInventarioVentaPorFecha",
               fecha: $("#fecha").val()
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
           
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
   var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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

function buscarInventarioVentaPorProductoYFecha(){
    $("tbody tr").remove();
      var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "buscarInventarioVentaPorProductoYFecha",
               fecha: $("#fecha").val(),
                 buscar:buscar
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
           
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
   var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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
function BuscarPorTipoDocumento(){
    $("tbody tr").remove();
     var parametros = {
               accion: "BuscarPorTipoDocumento",
               TipoDocumento: $("#cb_TipoDocumento").val()
               
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
           
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
   var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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
function BuscarPorTipoDocumentoYFecha(){
    $("tbody tr").remove();
     var parametros = {
               accion: "BuscarPorTipoDocumentoYFecha",
               TipoDocumento: $("#cb_TipoDocumento").val(),
               fecha:$("#fecha").val()
               
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
           
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
 var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }
  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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
function BuscarPorProductoYTipoDocumentoYFecha(){
    $("tbody tr").remove();
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "BuscarPorProductoYTipoDocumentoYFecha",
               TipoDocumento: $("#cb_TipoDocumento").val(),
               fecha:$("#fecha").val(),
               buscar:buscar
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
           
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
 var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }
  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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
function tipoDocumento()
{
    var parametros={
        accion:"listarTipoDocumento"
    };
    $.ajax({
        url: '../ControllerVenta',
        data:parametros,
        type: 'post',
        dataType: 'json',
        cache: false,
        success: function(resultado){
            console.log(resultado);
            var TipoDocumentos= resultado;
            $.each(TipoDocumentos, function(i, TipoDocumento){
                $('#cb_TipoDocumento').append(
                        $('<option>',{
                            
                            value: TipoDocumento.idTipoDocumento,
                            text: TipoDocumento.descripcion
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
function BuscarPorProductoYTipoDocumento(){
   $("tbody tr").remove();
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "BuscarPorProductoYTipoDocumento",
               TipoDocumento: $("#cb_TipoDocumento").val(),
                buscar:buscar
              
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
           
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
 var cantidadU =inventarioventa.unDetalleProducto.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unDetalleProducto.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  else{
     if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }   
  }
  if(j===2){
     var textoCelda = document.createTextNode(inventarioventa.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(inventarioventa.cantidadTotal);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===4){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }    
if(j===5){
     var textoCelda = document.createTextNode(inventarioventa.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }  
if(j===6){
     var textoCelda = document.createTextNode(inventarioventa.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                        }     

if(j===7){
     var textoCelda = document.createTextNode(inventarioventa.unUsuario.nombre);
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