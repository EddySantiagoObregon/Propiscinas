/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    ListarProveedorProductoCompra();
    
    $("#btn_Buscar").click(function(){
        var buscar = $("#txt_Buscar").val();
        var fecha = $("#fecha").val();
        if(buscar!==""&&fecha===""){
            BuscarPorNombre();
        }else if(buscar!==""&&fecha!==""){
            alert("sdasd");
            BuscarPorNombreYFecha();
        }
        
        
    });
    $("#btnListar").click(function(){
        $("tbody tr").remove();
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