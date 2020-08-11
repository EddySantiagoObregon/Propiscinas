/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    var correo = $("#Correo").val();
    tipoDocumento();
 $("#txt_Valor").on({
    "focus": function (event) {
        $(event.target).select();
    },
    "keyup": function (event) {
        $(event.target).val(function (index, value ) {
            return value.replace(/\D/g, "")
                        .replace(/([0-9])([0-9]{2})$/, '$1.$2')
                        .replace(/\B(?=(\d{3})+(?!\d)\.?)/g, ",");
        });
    }
});

 $("#btnAgregar").click(function(){
     var cantidad = $("#txt_CantidadVendidaa").val();
     if(cantidad>0){
     AgregarVenta(correo);
 }else{
     alert("La cantidad vendida tiene que ser mayor que 0");
 }
 });
 $('#txt_NumeroFactura').keyup(function() {
    $("tbody tr").remove(); 

    listarVentaPorFactura();
});
    
});

function buscarProducto(){
    
    //obtiene la cajita de texto
    var busqueda =  $("#txt_Codigo").val();
    //verifica que no hallan campos vacios y pasa los daots a la variable busqueda1
    var busqueda1=busqueda.trim();
  
     var parametros = {
               accion: "Consulta",
              txt_Buscar: busqueda1
              
    };   
    $.ajax({
        //LLAMADO AL CONTROLADOR
        url:'../ControllerProducto',
        data:parametros,
        type: 'POST',
        dataType: 'json',
        cache: false,
        success: function (resultado){
            console.log(resultado);
            if(resultado!== null){
                
                $("#txt_Nombre").val(resultado.nombre);
                $("#txt_Grupo").val(resultado.unGrupo.descripcion);
                $("#txt_Presentacion").val(resultado.unaPresentacion.descripcion);
                $("#txt_forma").val(resultado.unaForma.descripcion);
                $("#txt_UnidadMedida").val(resultado.telefono);
                  var cantidad=resultado.cantidadUnidad;
                 if(cantidad===0){  
            
                      $("#txt_UnidadMedida").val(resultado.unaUnidadMedida.descripcion);
                        
                }else{
                     
                         
                      $("#txt_UnidadMedida").val(resultado.cantidadUnidad+" "+resultado.unaUnidadMedida.descripcion);
                 
                    }
            
            }else{
                
                $("#msj").html("*** Debes Ingresar un Codigo ***");
            }
        },
        error:function (ex){
            console.log(ex.responseText);
        }
    });
}
function AgregarVenta(correo){
 
   
    var parametros=
            {
               accion: "RegistrarVenta",
              txt_Correo: correo,
              txt_Codigo: $("#txt_Codigo").val().trim(),
              txt_CantidadVendidaa: $("#txt_CantidadVendidaa").val().trim(),
              txt_NumeroFactura:$("#txt_NumeroFactura").val().trim(),
              txt_Valor:$("#txt_Valor").val().trim(),
              cb_TipoDocumento:$("#cb_TipoDocumento").val()
     
                
            };
    
         $.ajax({
               url: '../ControllerVenta' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   
                   console.log(resultado);
                   if(resultado)
                   {
                      $("tbody tr").remove(); 
                      alert("Producto agregado a la venta");
                      
                      
                      document.getElementById('tblMovimiento').style.display = 'block';
                      listarVentaPorFactura();
                      limpiar();
                    
                   }else
                   {
                       
                       alert("No hay esta cantidad de productos en la sala de ventas");
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
  
}


function listarVentaPorFactura(){
   $("tbody tr").remove(); 
     var parametros = {
               accion: "listarVentaPorFactura",
               factura:$("#txt_NumeroFactura").val()
    };    
    $.ajax({          
        url: '../ControllerInventarioVenta',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            document.getElementById('tblMovimiento').style.display = 'block';
            console.log(resultado);
            
            inventarioventas = resultado;          
            var cantidad;
            cantidad= inventarioventas.length;
            if (cantidad===0) {
                document.getElementById('tblMovimiento').style.display = 'none';
            }
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(inventarioventas, function(j,inventarioventa){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 6; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
      if(j===0){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  var cantidadU =inventarioventa.cantidadUnidad;
  if(cantidadU>0){
  if(j===1){
      var textoCelda = document.createTextNode(inventarioventa.unDetalleProducto.unaForma.descripcion+" DE "+inventarioventa.unDetalleProducto.nombre+" "+inventarioventa.cantidadUnidad+" "+inventarioventa.unaUnidadMedida.descripcion);
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


 
    // agrega la hilera al final de la tabla (al final del elemento tblbody)
    
    body.appendChild(hilera);
  }
 
  // posiciona el <tbody> debajo del elemento <table>
  
  // appends <table> into <body>
 
  // modifica el atributo "border" de la tabla y lo fija a "2";
 

 });

        }
        
        ,
      
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
function limpiar(){
    $("#txt_Nombre").val("");
    $("#txt_Codigo").val("");
    $("#txt_forma").val("");
    $("#txt_UnidadMedida").val("");
    $("#txt_Grupo").val("");
    $("#txt_Presentacion").val("");
    $("#txt_CantidadVendidaa").val("");
    $("#txt_Valor").val("");
}