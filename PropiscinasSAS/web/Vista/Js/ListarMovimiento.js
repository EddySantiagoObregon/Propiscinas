/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    tipoDocumento();
    listarMovimiento();
    
    $("#txt_Buscar").val(null);
    $("#btn_Buscar").click(function(){
        var fecha = $("#fecha").val();
        var buscar = $("#txt_Buscar").val();
        var idTipoDocumento = $("#cb_TipoDocumento").val();
      
       if(fecha!==null&&buscar!==''&&idTipoDocumento>0){
         
       BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento();
        }    
        else if(fecha!==''&&buscar!==''&&idTipoDocumento<1){
      
            BuscarMovimientoPorFechaYNumeroDocumento();
        }else if(fecha===''&&buscar!==''&&idTipoDocumento<1){
       
             BuscarMovimiento(); 
        }else if(fecha!==''&&buscar===''&&idTipoDocumento<1){
 
            BuscarMovimientoPorFecha();
        }else if(idTipoDocumento>0&&fecha===''&&buscar===''){
        
            BuscarMovimientoTipoDocumento();
        }
        else if(idTipoDocumento>0&&fecha!==''&&buscar===''){
            BuscarMovimientoTipoDocumentoYFecha();
        }
        
      
       
    });
    $("#btnListar").click(function(){
        $("tbody tr").remove();
         listarMovimiento();
         $("#fecha").val(null);
         $("#txt_Buscar").val(null);
         $("#cb_TipoDocumento").val(0);
    });
         
    
    
});

function listarMovimiento(){
     var parametros = {
               accion: "listarMovimiento"
              
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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

function BuscarMovimiento(){
     $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarMovimiento",
               buscar:$("#txt_Buscar").val().trim()
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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

function BuscarMovimientoPorFecha(){
     $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarMovimientoPorFecha",
               fecha:$("#fecha").val()
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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


function BuscarMovimientoPorFechaYNumeroDocumento(){
     $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarMovimientoPorFechaYNumeroDocumento",
               fecha:$("#fecha").val(),
               buscar:$("#txt_Buscar").val().trim()
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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

function BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento(){
     $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarMovimientoPorFechaYNumeroDocumentoYTipoDocumento",
               fecha:$("#fecha").val(),
               buscar:$("#txt_Buscar").val().trim(),
               idTipoDocumento: $("#cb_TipoDocumento").val()
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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


function BuscarMovimientoTipoDocumento(){
     $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarMovimientoTipoDocumento",
               idTipoDocumento: $("#cb_TipoDocumento").val()
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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

function BuscarMovimientoTipoDocumentoYFecha(){
     $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarMovimientoTipoDocumentoYFecha",
               idTipoDocumento: $("#cb_TipoDocumento").val(),
               fecha:$("#fecha").val()
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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

function BuscarMovimientoTxt_BuscarYFecha(){
     $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarMovimientoTxt_BuscarYFecha",
               buscar: $("#txt_Buscar").val(),
               fecha:$("#fecha").val()
    };    
    $.ajax({          
        url: '../ControllerMovimiento',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            movimientos = resultado;          
            var cantidad;
            cantidad= movimientos.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(movimientos, function(j,movimiento){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 13; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(movimiento.unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(movimiento.unaTransaccion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }


  if(j===2){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  var cantidad =movimiento.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
       if(j===3){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===3){
          var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unaForma.descripcion+" "+movimiento.unDetalleProducto.cantidadUnidad+" "+movimiento.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
  if(j===4){
     var textoCelda = document.createTextNode(movimiento.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(movimiento.fecharegistro);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

   if(j===6){
      var textoCelda = document.createTextNode(movimiento.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  
    

  if(j===7){
     var textoCelda = document.createTextNode(movimiento.unDocumento.numerodocumento);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===8){
     var textoCelda = document.createTextNode(movimiento.unDocumento.unTipoDocumento.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===9){
     var textoCelda = document.createTextNode(movimiento.unDocumento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  var verdadero=movimiento.unaInfraestructuraDespacho.descripcion;
  if(verdadero===" "){
      if(j===10){
     var textoCelda = document.createTextNode("NIGUNA");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }else{
    if(j===10){
     var textoCelda = document.createTextNode(movimiento.unaInfraestructuraDespacho.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
  }
  if(j===11){
     var textoCelda = document.createTextNode(movimiento.observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
   if(j===12){
     var textoCelda = document.createTextNode(movimiento.unUsuario.nombre);
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