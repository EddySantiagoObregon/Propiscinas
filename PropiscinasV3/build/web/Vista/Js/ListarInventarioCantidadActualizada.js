/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function ()
{
  var num;
  var numero;
        listarCantidadActualizada();
  
          $("#cb_Opciones").change(function(){
        numero = $("#cb_Opciones").val();
    
        $("tbody tr").remove(); 
        if(numero==='0'){
           
           listarCantidadActualizada();
       }
       if(numero==='1'){
           
           totalProductosInfraestructura();
       }
       if(numero==='2'){
           listarCantidadActualizadaInfraestructura(1);
       }
       if(numero==='3'){
           listarCantidadActualizadaInfraestructura(2); 
       }
       if(numero==='4'){
            listarCantidadActualizadaInfraestructura(3); 
       }

    });
    $("#btnBuscar").click(function(){
        $("tbody tr").remove(); 
    BuscarProducto();
  });
   $("#btnListar").click(function(){
        $("tbody tr").remove();
        $("#cb_Opciones").val(0);
        listarCantidadActualizada(); 
    });

});

function listarCantidadActualizada(){
    $("tbody tr").remove(); 
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
            
            inventarios = resultado;          
    
            cantidad= inventarios.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarios, function(j,unInventario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(unInventario.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(unInventario.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(unInventario.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidadInventrario=unInventario.cantidad;
  var cantidad=unInventario.unDetalleProducto.cantidadUnidad;
   if(cantidadInventrario<5){
      hilera.setAttribute('id','alertaRoja');
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      hilera.setAttribute('id','alertaAmarilla');
  }
  if(cantidad===0){
  if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaForma.descripcion+" "+unInventario.unDetalleProducto.cantidadUnidad+" "+unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
  if(j===5){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    if(j===7){
     var textoCelda = document.createTextNode(unInventario.unaInfraestructura.descripcion);
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
    function totalProductosInfraestructura(){
        $("tbody tr").remove(); 
     var parametros = {
               accion: "totalProductosInfraestructura"
             
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            inventarios = resultado;          
    
            cantidad= inventarios.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarios, function(j,unInventario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(unInventario.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(unInventario.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(unInventario.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidadInventrario=unInventario.cantidad;
  var cantidad=unInventario.unDetalleProducto.cantidadUnidad;
   if(cantidadInventrario<5){
      hilera.setAttribute('id','alertaRoja');
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      hilera.setAttribute('id','alertaAmarilla');
  }
  if(cantidad===0){
  if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaForma.descripcion+" "+unInventario.unDetalleProducto.cantidadUnidad+" "+unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
  if(j===5){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    if(j===7){
     var textoCelda = document.createTextNode("TODAS");
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
    function BuscarProductoDeInfraestructura(){
        $("tbody tr").remove(); 
           var parametros = {
               accion: "BuscarProductoDeInfraestructura",
               producto: $("#txt_Buscar").val(),
               infraestructura: $("#cb_Infraestura").val()
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            inventarios = resultado;          
    
            cantidad= inventarios.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarios, function(j,unInventario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(unInventario.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(unInventario.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(unInventario.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidad=unInventario.unDetalleProducto.cantidadUnidad;
  if(cantidad===0){
  if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaForma.descripcion+" "+unInventario.unDetalleProducto.cantidadUnidad+" "+unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
  if(j===5){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    if(j===7){
     var textoCelda = document.createTextNode(unInventario.unaInfraestructura.descripcion);
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
    function listarCantidadActualizadaInfraestructura(numero){
        $("tbody tr").remove(); 
     var parametros = {
               accion: "listarCantidadActualInfraestructura",
               infraestructura:numero
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            inventarios = resultado;          
    
            cantidad= inventarios.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarios, function(j,unInventario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(unInventario.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(unInventario.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(unInventario.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidadInventrario=unInventario.cantidad;
  var cantidad=unInventario.unDetalleProducto.cantidadUnidad;
   if(cantidadInventrario<5){
      hilera.setAttribute('id','alertaRoja');
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      hilera.setAttribute('id','alertaAmarilla');
  }
  if(cantidad===0){
  if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaForma.descripcion+" "+unInventario.unDetalleProducto.cantidadUnidad+" "+unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
  if(j===5){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    if(j===7){
     var textoCelda = document.createTextNode(unInventario.unaInfraestructura.descripcion);
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
      function BuscarCantidadActualizadaPorCodigoYInfraestructura(numero){
          $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarCantidadActualizadaPorCodigoYInfraestructura",
               infraestructura:numero,
               buscar1: $("#txt_Buscar1").val()
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            inventarios = resultado;          
    
            cantidad= inventarios.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarios, function(j,unInventario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(unInventario.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(unInventario.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(unInventario.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidadInventrario=unInventario.cantidad;
  var cantidad=unInventario.unDetalleProducto.cantidadUnidad;
   if(cantidadInventrario<5){
      hilera.setAttribute('id','alertaRoja');
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      hilera.setAttribute('id','alertaAmarilla');
  }
  if(cantidad===0){
  if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaForma.descripcion+" "+unInventario.unDetalleProducto.cantidadUnidad+" "+unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
  if(j===5){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    if(j===7){
     var textoCelda = document.createTextNode(unInventario.unaInfraestructura.descripcion);
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
     function BuscarCantidadActualizadaPorNombreYInfraestructura(numero){
         $("tbody tr").remove(); 
     var parametros = {
               accion: "BuscarCantidadActualizadaPorNombreYInfraestructura",
               infraestructura:numero,
                buscar1: $("#txt_Buscar1").val()
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            inventarios = resultado;          
    
            cantidad= inventarios.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarios, function(j,unInventario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(unInventario.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(unInventario.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(unInventario.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidadInventrario=unInventario.cantidad;
  var cantidad=unInventario.unDetalleProducto.cantidadUnidad;
   if(cantidadInventrario<5){
      hilera.setAttribute('id','alertaRoja');
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      hilera.setAttribute('id','alertaAmarilla');
  }
  if(cantidad===0){
  if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaForma.descripcion+" "+unInventario.unDetalleProducto.cantidadUnidad+" "+unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
  if(j===5){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    if(j===7){
     var textoCelda = document.createTextNode(unInventario.unaInfraestructura.descripcion);
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
     function BuscarProducto(){
         $("tbody tr").remove(); 
     var parametros = {
              accion: "BuscarProducto",
                buscar: $("#txt_Buscar1").val().trim()
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            inventarios = resultado;          
    
            cantidad= inventarios.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarios, function(j,unInventario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 8; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(unInventario.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(unInventario.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(unInventario.cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidadInventrario=unInventario.cantidad;
  var cantidad=unInventario.unDetalleProducto.cantidadUnidad;
   if(cantidadInventrario<5){
      hilera.setAttribute('id','alertaRoja');
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      hilera.setAttribute('id','alertaAmarilla');
  }
  if(cantidad===0){
  if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===4){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaForma.descripcion+" "+unInventario.unDetalleProducto.cantidadUnidad+" "+unInventario.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }
  if(j===5){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(unInventario.unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    if(j===7){
     var textoCelda = document.createTextNode(unInventario.unaInfraestructura.descripcion);
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