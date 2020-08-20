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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;

if(cantidadMedida===0){
     if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;
if(cantidadMedida===0){
     if(j===1){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;
if(cantidadMedida===0){
     if(j===1){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;
if(cantidadMedida===0){
     if(j===1){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;
if(cantidadMedida===0){
     if(j===1){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;
if(cantidadMedida===0){
     if(j===1){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;
if(cantidadMedida===0){
     if(j===1){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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
            
            proveedoresproductocompra = resultado;          
            var cantidad;
            cantidad= proveedoresproductocompra.length;
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(proveedoresproductocompra, function(j,proveedor){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 5; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unProveedor.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

var cantidadMedida =proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad;
if(cantidadMedida===0){
     if(j===1){
      var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
}else{
    
  if(j===1){
     var textoCelda = document.createTextNode(proveedor.unProveedorProducto.unDetalleProducto.unaForma.descripcion+" DE "+proveedor.unProveedorProducto.unDetalleProducto.nombre+" "+proveedor.unProveedorProducto.unDetalleProducto.cantidadUnidad+" "+ proveedor.unProveedorProducto.unDetalleProducto.unaUnidadMedida.descripcion+" "+proveedor.unProveedorProducto.unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

  if(j===2){
     var textoCelda = document.createTextNode(proveedor.fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor.compra);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor.idProveedorProductoCompra);
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