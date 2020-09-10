/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var unmed="";

$(function ()
{
    var correo= $("#Correo").val();
  
    listarInfraestructura();
   
    ListarProducto();
    $('#btnListar').click(function(){
        $("tbody tr").remove(); 
        ListarProducto();
    });
    $('#btnBuscar').click(function(){ 
 
        BuscarProducto();
      
   }); 
    $('#btnAgregarCambio').click(function(){ 
 
   CambioProductos(correo);
    }); 
    //Uso el evento chaange para cuando seleccione la infraestructura le aparezca la cantidad de de producto que tiene en el inventario.
      $("#cb_Infraestructura").change(function(){
      $("#txt_CantidadExistente").empty();
       $("#cb_InfraestructuraCambio").empty();
       $('#cb_InfraestructuraCambio').append(
                         $('<option>',{
                            
                            value: 0,
                            text: "Seleccioné"
                        })
                      );
    seleccionarInventario($("#cb_Infraestructura").val());
     listarInfraestructuraCambio($("#cb_Infraestructura").val());
    });
     $("#cb_InfraestructuraCambio").change(function(){
      $("#txt_CantidadCambio").empty();
      
    seleccionarInventarioI($("#cb_InfraestructuraCambio").val());
  

    });
    
});
//Esta funcion es la que lista todo los producto para poder agregar la cantidad al producto
function ListarProducto(){
     var parametros = {
               accion: "listarDetalleProducto"
              
    };    
    $.ajax({          
        url: '../ControllerProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
     success: function (resultado) {
        console.log(resultado);
            
            productos=resultado;          
            var cantidad;
            cantidad= productos.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = productos.length;
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
      var textoCelda = document.createTextNode(productos[i].idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(productos[i].referencia);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
   if(j===2){
     var textoCelda = document.createTextNode(productos[i].abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(productos[i].unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===4){
     var textoCelda = document.createTextNode(productos[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
    var cantidad=productos[i].cantidadUnidad;
  if(cantidad===0){
   if(j===5){
 
          var textoCelda = document.createTextNode(productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===5){
 
          var textoCelda = document.createTextNode(productos[i].cantidadUnidad+" "+productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
       }
   }
 
 
  if(j===6){
     var textoCelda = document.createTextNode(productos[i].unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    

  if(j===7){
     var textoCelda = document.createTextNode(productos[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
    if(j===8){
     var textoCelda = document.createTextNode(productos[i].unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(productos[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
 
  if(j===10){
      var id = productos[i].idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModal('+id+')');
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           const img= document.createElement('img');
                           img.setAttribute('src','Imagenes/cambio.png');
                           img.setAttribute('class','anadir');
                           img.setAttribute('id','anadir');
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
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

////Esta funcion es la que busca todo los productso para poder agregar la cantidad al producto
function  BuscarProducto(){
     $("tbody tr").remove(); 
     var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
               accion: "Buscar",
              txt_Buscar: buscar
              
    };    
    $.ajax({          
        url: '../ControllerProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
         success: function (resultado) {
        console.log(resultado);
            
            productos=resultado;          
            var cantidad;
            cantidad= productos.length;
             
             
 
      if(cantidad===0){
                 alert("No hay ningún dato");
             }
            
            var pag = 1;
            var totales = productos.length;
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
      var textoCelda = document.createTextNode(productos[i].idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(productos[i].referencia);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
   if(j===2){
     var textoCelda = document.createTextNode(productos[i].abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(productos[i].unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===4){
     var textoCelda = document.createTextNode(productos[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 
    var cantidad=productos[i].cantidadUnidad;
  if(cantidad===0){
   if(j===5){
 
          var textoCelda = document.createTextNode(productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }else{
       if(j===5){
 
          var textoCelda = document.createTextNode(productos[i].cantidadUnidad+" "+productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
       }
   }
 
 
  if(j===6){
     var textoCelda = document.createTextNode(productos[i].unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }


    

  if(j===7){
     var textoCelda = document.createTextNode(productos[i].observacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
    if(j===8){
     var textoCelda = document.createTextNode(productos[i].unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===9){
     var textoCelda = document.createTextNode(productos[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
     
  }
 
  if(j===10){
      var id = productos[i].idProducto;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModal('+id+')');
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           const img= document.createElement('img');
                           img.setAttribute('src','Imagenes/cambio.png');
                           img.setAttribute('class','anadir');
                           img.setAttribute('id','anadir');
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
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
//Esta funcion lo que hace es abrir una pestaña modal y le envia como parametro el del producto 
function abrirModal(id)
{
    $('#modal').modal({backdrop: 'static', keyboard: false});
      var id=id;
    $("#modal").modal();
    $("#idProducto").val(id);
    //Esta funcion lo que hace es buscar la unidad de medidad del producto para poder llevarla al formulario de agregar cantidad al producto
     Buscar(id);
     //Cuando es abierta la pestaña modal es porque se le ha enviado el id del producto lo que hace la funcion es buscar 
     //el inventario infraestructura , esto lo hago solo para traerme la cantidad que tiene el producto
     seleccionarInventario();

  
     
    
}//Esta es la funcion que se ejecuta cuando es abierta la pestaña modal
//Esta funcion lo que hace es buscar la unidad de medidad del producto para poder llevarla al formulario de agregar cantidad al producto
function Buscar(id){
        
        var parametros=
            {
                accion: "Seleccionado",
                id:id
         
            };
            $.ajax({
                url: '../ControllerProducto',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    var producto= resultado;
                            
                       $("#sIdUnidad").val(producto.unaUnidadMedida.idUnidadMedida);
                          
                         
                     var cantidad=producto.cantidadUnidad;
                    if(cantidad===0){
                        $("#sUnidad").val(producto.unaUnidadMedida.descripcion);
                         $("#sNombree").html(producto.nombre+" "+producto.unaUnidadMedida.descripcion);
                      
                    }else{
                          $("#sNombree").html(producto.nombre+" "+producto.unaForma.descripcion+" "+producto.cantidadUnidad+" "+producto.unaUnidadMedida.descripcion);
                      
                        $("#sUnidad").val(producto.unaForma.descripcion+" "+producto.cantidadUnidad+" "+producto.unaUnidadMedida.descripcion);
                     }
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}
 //el inventario infraestructura , esto lo hago solo para traerme la cantidad que tiene el producto
    
function seleccionarInventario(infraestructura){
         
        var parametros=
            {
                accion: "Seleccionar",
                buscar:$("#idProducto").val(),
                infraestructura:infraestructura
            };
            $.ajax({
                url: '../ControllerInventarioInfraestructura',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    var Inventario= resultado;
                            if(Inventario===null){
                                 $("#txt_CantidadExistente").val(0);
                            }
                            else{
                          $("#txt_CantidadExistente").val(Inventario.cantidad);
                          
                } 
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}
function seleccionarInventarioI(infraestructura){
         
        var parametros=
            {
                accion: "Seleccionar2",
                buscar:$("#idProducto").val(),
                infraestructura:infraestructura
            };
            $.ajax({
                url: '../ControllerInventarioInfraestructura',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    var Inventario= resultado;
                            if(Inventario===null){
                                 $("#txt_CantidadCambio").val(0);
                            }
                            else{
                          $("#txt_CantidadCambio").val(Inventario.cantidad);
                          
                } 
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}
//Esta funcion lo que hace es listar todas las infraestructuras
function listarInfraestructura()
{
    var parametros=
            {
                accion:"ListarInfraestructura"
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var infraestructuras = resultado;
                   $.each(infraestructuras,function(i,infraestructura)
                   {
                       
                       $('#cb_Infraestructura').append(
                         $('<option>',{
                            
                            value: infraestructura.idInfraestructura,
                            text: infraestructura.descripcion
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
function listarInfraestructuraCambio(idInfraestrucutura)
{
        
    var parametros=
            {
                accion:"ListarInfraestructuraCambio",
                idInfraestructura:idInfraestrucutura
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var infraestructuras = resultado;
                   $.each(infraestructuras,function(i,infraestructura)
                   {
                       
                       $('#cb_InfraestructuraCambio').append(
                         $('<option>',{
                            
                            value: infraestructura.idInfraestructura,
                            text: infraestructura.descripcion
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
//Esta funcion lista los tipos de documento

//Esta funcion agrega la cantidad de productos
function CambioProductos(correo){
   var txt_ObservacionDocumentoo = $("#txt_ObservacionDocumento").val();
         var txt_numeroDocumentoo=$("#txt_NumeroDocumento").val();
         if(txt_ObservacionDocumentoo!==""&&txt_numeroDocumentoo!==""){
        var parametros=
            {
                accion: "CambioProductosEnInfraestructuras",
                txt_Correo:correo,
                nombreInfraestructura:$("#cb_Infraestructura option:selected").text(),
                cb_Infraestructura:$("#cb_Infraestructura").val(),
                txt_CantidadExistente:$("#txt_CantidadExistente").val(),
                txt_Cantidad_Enviara:$("#txt_Cantidad_Enviara").val(),
                cb_InfraestructuraCambio:$("#cb_InfraestructuraCambio").val(),
                txt_CantidadCambio:$("#txt_CantidadCambio").val(),
                idProducto:$("#idProducto").val(),
                sIdUnidad:$("#sIdUnidad").val(),
                txt_Observacion:$("#txt_Observacion").val(),
                txt_NumeroDocumento:$("#txt_NumeroDocumento").val(),
                txt_ObservacionDocumento:$("#txt_ObservacionDocumento").val()
                
                
         
            };
            $.ajax({
                url: '../ControllerProducto',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                     
                      
                          
                      
                     document.getElementById('btnAgregarCambio').disabled=false;
                      alert("La cantidad del producto se cambio correctamente");
                      location.href="CambioDeProductosEnInfraestructura.jsp";
                      limpiarModal();
                } else{
                     document.getElementById('btnAgregarCambio').disabled=false;
                    alert("La cantidad que quiere enviar debe ser menos a la cantidad actual en esta infraestructura");
                }
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
        }else{
            document.getElementById('btnAgregarCambio').disabled=false;
            alert("TODOS LOS CAMPOS SON REQUERIDOS");
        }
       
}
function limpiarModal(){
    
      $("#txt_Cantidad").val("");
       $("#txt_NumeroFactura").val("");
       $("#txt_Observacion").val("");
       $("#cb_Infraestructura").val(0);
       
       $("#cb_TipoDocumento").val(0);
}
