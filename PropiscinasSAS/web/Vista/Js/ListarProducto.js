/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var buscarr;
$(function(){

    ListarProducto();
     $('#btnBuscar').click(function(){ 
 
      BuscarProducto();
   }); 
    $('#btnCodBarra').click(function(){
        GenerarCodigoDeBarras();
    });
   
    $('#btnEditar').click(function(){ 
        
        EditarProducto();
      
   }); 
   $('#btnListar').click(function(){
       $("tbody tr").remove();
   
       ListarProducto();
   });
   $('#txt_Referencia').keyup(function() {
     var txt_Referencia;
      txt_Referencia = document.getElementById("txt_Referencia").value;
        if (txt_Referencia.length<1 || txt_Referencia.length >20){
        $("#msjReferencia").html("REFERENCIA MAXIMA DE 20 DIGITOS");
        return false;
    }else{
         $("#msjReferencia").html(" ");
    }
    
    var parametros=
            {
                accion: "referencia",
                referencia: $("#txt_Referencia").val().trim()
               
                
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
                   if(resultado)
                   {
                      
                      $("#msjReferencia").html("referencia ya existe! ❌");
                    
                   }else
                   {
                       
                       $("#msjReferencia").html(" ");
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
  
  
 });
  $('#txt_Nombre').keyup(function() {
     var txt_Nombre;
      txt_Nombre = document.getElementById("txt_Nombre").value;
        if (txt_Nombre.length<1 || txt_Nombre.length >50){
        $("#msjNombre").html("NOMBRE MÁXIMO DE 50 DIGITOS");
        return false;
    }else{
         $("#msjNombre").html(" ");
    }
  
 });
  $('#txt_Abreviatura').keyup(function() {
     var txt_Abreviatura;
      txt_Abreviatura = document.getElementById("txt_Abreviatura").value;
        if (txt_Abreviatura.length<1 || txt_Abreviatura.length >5){
        $("#msjAbreviatura").html("ABREVIATURA MAXIMA DE 5 DIGITOS");
        return false;
    }else{
         $("#msjAbreviatura").html(" ");
    }
     var parametros=
            {
                accion: "abreviaturaigual",
                abreviatura: $("#txt_Abreviatura").val().trim()
               
                
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
                   if(resultado)
                   {
                      
                      $("#msjAbreviatura").html("Abreviatura ya existe! ❌");
                    
                   }else
                   {
                       
                       $("#msjAbreviatura").html(" ");
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
  
 });
 $('#content').keyup(function() {
     var content;
      content = document.getElementById("content").value;
        if (content.length<1 || content.length >20){
        $("#msjContent").html("CODIGO MÁXIMO DE 20 DIGITOS");
        return false;
    }else{
         $("#msjContent").html(" ");
    }
     var parametros=
            {
                accion: "codigoigual",
                codigo: $("#content").val().trim()
               
                
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
                   if(resultado)
                   {
                      
                      $("#msjContent").html("Codigo ya existe! ❌");
                    
                   }else
                   {
                       
                       $("#msjContent").html(" ");
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
  
 });



  $('#txt_DetalleObservacion').keyup(function() {
     var txt_DetalleObservacion;
      txt_DetalleObservacion = document.getElementById("txt_DetalleObservacion").value;
        if (txt_DetalleObservacion.length<1 || txt_DetalleObservacion.length >500){
        $("#msjtxt_DetalleObservacion").html("OBSERVACION MAXIMA DE 500 DIGITOS");
        return false;
    }else{
         $("#msjtxt_DetalleObservacion").html(" ");
    }
  
 });
  $('#_txt_Referencia').keyup(function() {
     var _txt_Referencia;
      _txt_Referencia = document.getElementById("_txt_Referencia").value;
        if (_txt_Referencia.length<1 || _txt_Referencia.length >20){
        $("#msj_txt_Referencia").html("REFERENCIA MAXIMA DE 20 DIGITOS");
        return false;
    }else{
         $("#msj_txt_Referencia").html(" ");
    }
        var parametros=
            {
                accion: "referencia",
                referencia: $("#_txt_Referencia").val().trim()
               
                
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
                   if(resultado)
                   {
                      
                      $("#msj_txt_Referencia").html("referencia ya existe! ❌");
                    
                   }else
                   {
                       
                       $("#msj_txt_Referencia").html(" ");
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
  
    
  
 });
   $('#_txt_Abreviatura').keyup(function() {
     var _txt_Abreviatura;
      _txt_Abreviatura = document.getElementById("_txt_Abreviatura").value;
        if (_txt_Abreviatura.length<1 || _txt_Abreviatura.length >5){
        $("#msj_txt_Abreviatura").html("ABREVIATURA MAXIMA DE 5 DIGITOS");
        return false;
    }else{
         $("#msj_txt_Abreviatura").html(" ");
    }
       var parametros=
            {
                accion: "abreviaturaigual",
                abreviatura: $("#_txt_Abreviatura").val().trim()
               
                
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
                   if(resultado)
                   {
                      
                      $("#msj_txt_Abreviatura").html("Abreviatura ya existe! ❌");
                    
                   }else
                   {
                       
                       $("#msj_txt_Abreviatura").html(" ");
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
  
 });
 
  
    $('#_txt_DetalleObservacion').keyup(function() {
     var _txt_Observacion_Producto;
      _txt_Observacion_Producto = document.getElementById("_txt_DetalleObservacion").value;
        if (_txt_Observacion_Producto.length<1 || _txt_Observacion_Producto.length >5){
        $("#msj_txt_DetalleObservacion").html("OBSERVACION MAXIMA DE 500 DIGITOS");
        return false;
    }else{
         $("#msj_txt_DetalleObservacion").html(" ");
    }
     });
});

function ListarProducto(){
     $("tbody tr").remove(); 
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
     var textoCelda = document.createTextNode(productos[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(productos[i].abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  if(j===4){
     var textoCelda = document.createTextNode(productos[i].unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(productos[i].unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(productos[i].unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidad =productos[i].cantidadUnidad;
  if(cantidad===0){
       if(j===7){
     var textoCelda = document.createTextNode(productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===7){
          var textoCelda = document.createTextNode(productos[i].cantidadUnidad+" "+productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
    

  if(j===8){
     var textoCelda = document.createTextNode(productos[i].observacion);
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
                           img.setAttribute('src','Imagenes/Editar.png');
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
function  BuscarProducto(){
   var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
    
     var parametros = {
               accion: "Buscar",
              txt_Buscar:buscar
              
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
     var textoCelda = document.createTextNode(productos[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===3){
     var textoCelda = document.createTextNode(productos[i].abreviatura);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 

  if(j===4){
     var textoCelda = document.createTextNode(productos[i].unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(productos[i].unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===6){
     var textoCelda = document.createTextNode(productos[i].unaForma.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  var cantidad =productos[i].cantidadUnidad;
  if(cantidad===0){
       if(j===7){
     var textoCelda = document.createTextNode(productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
                            
  }
  }else{
        if(j===7){
          var textoCelda = document.createTextNode(productos[i].cantidadUnidad+" "+productos[i].unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  }
    

  if(j===8){
     var textoCelda = document.createTextNode(productos[i].observacion);
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
                           img.setAttribute('src','Imagenes/Editar.png');
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
function abrirModal(codigo){
   $('#modal').modal({backdrop: 'static', keyboard: false});
    $("#modal").modal();
     var parametros = {
               accion: "obtenerProductoSeleccionado",
               codigo:codigo
    };    
    $.ajax({          
        url: '../ControllerProducto',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            var producto =resultado;
            if (resultado) {
                $("#txt_Codigo").val(producto.idProducto); 
                $("#txt_Referencia").val(producto.referencia); 
                $("#txt_Nombre").val(producto.nombre); 
                $("#txt_Abreviatura").val(producto.abreviatura); 
                $("#cb_Grupo").val(producto.unGrupo.idGrupo); 
                $("#cb_Presentacion").val(producto.unaPresentacion.idPresentacion); 
                $("#cb_Forma").val(producto.unaForma.idForma); 
                $("#cb_UnidadMedida").val(producto.unaUnidadMedida.idUnidadMedida);
                $("#txt_cantidadUnidad").val(producto.cantidadUnidad);
                $("#txt_DetalleObservacion").val(producto.observacion);
                  
              }else{
                  alert("Error");
              }
                 
           
       
             
 

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function limpiarModal(){
                $("#txt_Codigo").val(0); 
                $("#txt_Referencia").val(""); 
                $("#txt_Nombre").val(""); 
                $("#txt_Abreviatura").val(""); 
                $("#cb_Grupo").val(0); 
                $("#cb_Presentacion").val(0); 
                $("#cb_Forma").val(0); 
                $("#cb_UnidadMedida").val(0);
                $("#txt_cantidadUnidad").val("");
                $("#txt_DetalleObservacion").val("");  
                $("#msjReferencia").html("");
                $("#msjNombre").html("");
                $("#msjAbreviatura").html("");
                $("#msjtxt_DetalleObservacion").html("");
              


    
}
function EditarProducto()
{
   
     $("#mensaje").html("");
   
     var parametros=
            {
                accion: "EditarProducto",
       
               
                txt_Codigo: $("#txt_Codigo").val().trim(),
                txt_Nombre: $("#txt_Nombre").val().trim(),
                txt_Referencia:$("#txt_Referencia").val().trim(),
                txt_Abreviatura: $("#txt_Abreviatura").val().trim(),
                cb_Grupo: $("#cb_Grupo").val(),
                txt_cantidadUnidad: $("#txt_cantidadUnidad").val().trim(),
                cb_Presentacion: $("#cb_Presentacion").val(),
                cb_UnidadMedida: $("#cb_UnidadMedida").val(),
                cb_Forma:$("#cb_Forma").val(),
                txt_DetalleObservacion: $("#txt_DetalleObservacion").val(),
                txt_cancod: $("#txt_cancod").val()
                
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
                   if(resultado){
                        $("tbody tr").remove();
                       alert("SE EDITO CORRECTAMENTE EL PRODUCTO");
                      ListarProducto();
                   }
                   
                   $("#msj").show();
            },   error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
        
}


function GenerarCodigoDeBarras(){
         
        var parametros=
            {
                accion: "GenerarCodigoDeBarras"
             
                
         
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
                     
                      alert("Correcto");
                 
                } else{
                    alert("error");
                }
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}