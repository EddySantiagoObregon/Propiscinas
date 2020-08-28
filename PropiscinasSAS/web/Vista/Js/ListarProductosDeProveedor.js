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
            
            productoproveedores = resultado;          
            var cantidad;
            cantidad= productoproveedores.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(productoproveedores, function(j,productoproveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 2; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(productoproveedor.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor.unDetalleProducto.cantidadUnidad;
var forma=productoproveedor.unDetalleProducto.unaForma.obcervacion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" "+ productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.cantidadUnidad+" "+ productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
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
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
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
            
            productoproveedores = resultado;          
            var cantidad;
            cantidad= productoproveedores.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(productoproveedores, function(j,productoproveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 2; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(productoproveedor.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor.unDetalleProducto.cantidadUnidad;
var forma=productoproveedor.unDetalleProducto.unaForma.obcervacion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" "+ productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.cantidadUnidad+" "+ productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
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
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
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
            
            productoproveedores = resultado;          
            var cantidad;
            cantidad= productoproveedores.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(productoproveedores, function(j,productoproveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 2; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(productoproveedor.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor.unDetalleProducto.cantidadUnidad;
var forma=productoproveedor.unDetalleProducto.unaForma.obcervacion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" "+ productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.cantidadUnidad+" "+ productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
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
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
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
            
            productoproveedores = resultado;          
            var cantidad;
            cantidad= productoproveedores.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(productoproveedores, function(j,productoproveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 2; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(productoproveedor.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =productoproveedor.unDetalleProducto.cantidadUnidad;
var forma=productoproveedor.unDetalleProducto.unaForma.obcervacion;
if(cantidadMedida===0){
    if(forma==="SOLO"){
     if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
    }else{
      if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" "+ productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(productoproveedor.unDetalleProducto.unaForma.descripcion+" DE "+productoproveedor.unDetalleProducto.nombre+" "+productoproveedor.unDetalleProducto.cantidadUnidad+" "+ productoproveedor.unDetalleProducto.unaUnidadMedida.descripcion+" "+productoproveedor.unDetalleProducto.unaPresentacion.descripcion);
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
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
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