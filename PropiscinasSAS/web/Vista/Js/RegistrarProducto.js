/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  var contador=0;

$(function ()
{
  
  
  
     $("#content").val("");
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
        if (txt_DetalleObservacion.length<1 || txt_DetalleObservacion.length >50){
        $("#msjtxt_DetalleObservacion").html("OBSERVACION MAXIMA DE 50 DIGITOS");
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
        if (_txt_Observacion_Producto.length<1 || _txt_Observacion_Producto.length >500){
        $("#msj_txt_DetalleObservacion").html("OBSERVACION MAXIMA DE 500 DIGITOS");
        return false;
    }else{
         $("#msj_txt_DetalleObservacion").html(" ");
    }
     });
    contador=0;
     $("#txt_cantidadUnidad").val(0);
     $("#txt_cancod").val(0);
   $('#txt_Cantidad').val(0);
   $('#btnAgregar').click(function(){ 
  
    /*
        *De esta menera podemos obtener el texto de un combobox 
        var combo = document.getElementById("cb_SubGrupo");
        var selected = combo.options[combo.selectedIndex].text;
        alert(selected);
*/

       agregarProducto();
      
   });
    $('#btnRegistrarProo').click(function(){ 
        
   agregarProductoBotella_Bolsa();
    });
});
function borrarCod(){
   
    $("#content").val("");
}

/*
function listarPresentacionGalon()
{
    var parametros=
            {
                accion:"listarPresentacionGalon"
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
                   var presentaciones = resultado;
                   $.each(presentaciones,function(i,presentacion)
                   {
                       
                       $('#_txt_Presentacion').append(
                         $('<option>',{
                            
                            value: presentacion.idPresentacion,
                            text: presentacion.descripcion
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
function listarPresentacionBulto()
{
    var parametros=
            {
                accion:"listarPresentacionBulto"
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
                   var presentaciones = resultado;
                   $.each(presentaciones,function(i,presentacion)
                   {
                       
                       $('#_txt_Presentacion').append(
                         $('<option>',{
                            
                            value: presentacion.idPresentacion,
                            text: presentacion.descripcion
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
function listarPresentacionCaneca()
{
    var parametros=
            {
                accion:"listarPresentacionCaneca"
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
                   var presentaciones = resultado;
                   $.each(presentaciones,function(i,presentacion)
                   {
                       
                       $('#_txt_Presentacion').append(
                         $('<option>',{
                            
                            value: presentacion.idPresentacion,
                            text: presentacion.descripcion
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
*/
function agregarProducto()
{
   
     $("#mensaje").html("");
   
     var parametros=
            {
                accion: "Agregar",
       
                check:$("#check:checked").val(),
                content: $("#content").val().trim(),
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
                   if(resultado)
                   {
                      var can=$("#txt_cancod").val();
                      if(can>0){
                           n =  new Date();
                           //Año
                           y = n.getFullYear();
                           //Mes
                           m = n.getMonth() + 1;
                           //Día
                           d = n.getDate();
                           //hora
                           h =n.getHours();
                           //minutos
                           min = n.getMinutes();
                           //Lo ordenas a gusto.
                       $("#referencia").val($("#txt_Referencia").val());
                       $("#fecha").val(y+""+m+""+""+d+""+h+""+min);
                       $("#cancod").val($("#txt_cancod").val());
                        
                         element = document.getElementById("repetir");
        
                         element.style.display='block';
                     }
                      var idForma =$("#cb_Forma").val();
                 
                     var referencia=$("#txt_Referencia").val();
                     $("#_referencia").val(referencia);
                      var nombreProducto = $("#txt_Nombre").val();
                 
                      //Preguntamos si la forma es igual a dos quiere decir que la forma que se registro anteriorme  es igual a galon haga todo este proceso
                      if(idForma==="2"){
                       
                        var statusConfirm = confirm("¿ESTE PRODUCTO "+nombreProducto+"  SE DIVIDE EN MILILITROS Y SE EMPACA TAMBIEN EN BOTELLA?" );
                        if (statusConfirm === true)
                        {
                            var opcion_seleccionada1 = $("#cb_Presentacion option:selected").text();
                            var presentacion = $("#cb_Presentacion").val();
                            $("input.check").prop("checked",false);
                            element = document.getElementById("content");
                            element.style.display='none';
                            $('#modal-avisolegal').modal({backdrop: 'static', keyboard: false});
                            var Nombre= $("#txt_Nombre").val();
                            $("#_txt_Nombre").val(Nombre);
                            $("#_txt_Grupo").val("QUIMICO");
                            $("#_txt_forma").val("BOTELLA");
                            $("#_txt_UnidadMedida").val("MILILITRO");
                            $("#_txt_cantidadUnidad").val(500);
                            $("#_txt_Presentacion").val(opcion_seleccionada1);
                            var  grupo =  $("#cb_Grupo").val();
                            var unidadMedida = $("#cb_UnidadMedida").val();
                            var  forma=$("#cb_Forma").val();   
                            $("#_cb_Grupo").val(grupo);
                            $("#_cb_UnidadMedida").val(unidadMedida);
                            $("#_cb_Forma").val(3);
                            $("#_cb_Presentacion").val(presentacion);
                            var cbForma = $("#cb_Forma option:selected").text();
                             var UnidadCantidad = $("#txt_cantidadUnidad").val();
                             var UnidadMedida = $("#cb_UnidadMedida option:selected").text();
                             var contatenar=cbForma+" DE "+Nombre+" "+UnidadCantidad+" "+UnidadMedida;
                            $("#_txt_Producto_Convertir").val(contatenar);
                            $("#_txt_Producto_Convertir_Cantidad").val(UnidadCantidad);
                           }
                        else
                        {
                             var statusConfirm = confirm("¿ESTA SEGUR@ QUE ESTE PRODUCTO"+nombreProducto+" NO SE DIVIDE EN MILILITROS Y SE EMPACA TAMBIEN EN BOTELLA?");
                        if (statusConfirm === true)
                        {
                            
                           }else{
                            var opcion_seleccionada2 = $("#cb_Presentacion option:selected").text();
                            var presentacion = $("#cb_Presentacion").val();
                            $("input.check").prop("checked",false);
                            element = document.getElementById("content");
                            element.style.display='none';
                            $('#modal-avisolegal').modal({backdrop: 'static', keyboard: false});
                            var Nombre= $("#txt_Nombre").val();
                            $("#_txt_Nombre").val(Nombre);
                            $("#_txt_Grupo").val("QUIMICO");
                            $("#_txt_forma").val("BOTELLA");
                            $("#_txt_UnidadMedida").val("MILILITRO");
                            $("#_txt_cantidadUnidad").val(500);
                            $("#_txt_Presentacion").val(opcion_seleccionada2);
                            var  grupo =  $("#cb_Grupo").val();
                            var unidadMedida = $("#cb_UnidadMedida").val();
                            var  forma=$("#cb_Forma").val();   
                            $("#_cb_Grupo").val(grupo);
                            $("#_cb_UnidadMedida").val(unidadMedida);
                            $("#_cb_Forma").val(3);
                            $("#_cb_Presentacion").val(presentacion);
                             var cbForma = $("#cb_Forma option:selected").text();
                             var UnidadCantidad = $("#txt_cantidadUnidad").val();
                             var UnidadMedida = $("#cb_UnidadMedida option:selected").text();
                             var contatenar=cbForma+" DE "+Nombre+" "+UnidadCantidad+" "+UnidadMedida;
                            $("#_txt_Producto_Convertir").val(contatenar);
                            $("#_txt_Producto_Convertir_Cantidad").val(UnidadCantidad);
                       
                           }

                        }
                      }
                      //Este proceso es si la forma elegia es igual a 6 es porque es igual a caneca .
                       if(idForma==="6"){
                       
                        var statusConfirm = confirm("¿ESTE PRODUCTO "+nombreProducto+" SE DIVIDE EN KILOS Y SE EMPACA TAMBIEN EN BOLSA?" );
                        if (statusConfirm === true)
                        {
                           var opcion_seleccionada3 = $("#cb_Presentacion option:selected").text();
                           var presentacion = $("#cb_Presentacion").val();
                           $("input.check").prop("checked",false);
                           element = document.getElementById("content");
                           element.style.display='none';
                           $('#modal-avisolegal').modal({backdrop: 'static', keyboard: false});
                           var Nombre= $("#txt_Nombre").val();
                           $("#_txt_Nombre").val(Nombre);
                           $("#_txt_Grupo").val("QUIMICO");
                           $("#_txt_forma").val("BOLSA");
                           $("#_txt_UnidadMedida").val("KILO");
                           $("#_txt_cantidadUnidad").val(1);
                           $("#_txt_Presentacion").val(opcion_seleccionada3);
                           var  grupo =  $("#cb_Grupo").val();
                           var unidadMedida = $("#cb_UnidadMedida").val();
                           var  forma=$("#cb_Forma").val();   
                           
                           $("#_cb_Grupo").val(grupo);
                           $("#_cb_UnidadMedida").val(unidadMedida);
                           $("#_cb_Forma").val(1);
                           $("#_cb_Presentacion").val(presentacion);
                            var cbForma = $("#cb_Forma option:selected").text();
                             var UnidadCantidad = $("#txt_cantidadUnidad").val();
                             var UnidadMedida = $("#cb_UnidadMedida option:selected").text();
                             var contatenar=cbForma+" DE "+Nombre+" "+UnidadCantidad+" "+UnidadMedida;
                            $("#_txt_Producto_Convertir").val(contatenar);
                            $("#_txt_Producto_Convertir_Cantidad").val(UnidadCantidad);
                       
                           }
                        else
                        {
                             var statusConfirm = confirm("¿ESTA SEGUR@ QUE ESTE PRODUCTO NO SE  SE DIVIDE EN KILOS Y SE EMPACA TAMBIEN EN BOLSA");
                        if (statusConfirm === true)
                        {
                      
                           }else{
                           var opcion_seleccionada4 = $("#cb_Presentacion option:selected").text();
                           var presentacion = $("#cb_Presentacion").val();
                           $("input.check").prop("checked",false);
                           element = document.getElementById("content");
                           element.style.display='none';
                           $('#modal-avisolegal').modal({backdrop: 'static', keyboard: false});
                           var Nombre= $("#txt_Nombre").val();
                           $("#_txt_Nombre").val(Nombre);
                           $("#_txt_Grupo").val("QUIMICO");
                           $("#_txt_forma").val("BOLSA");
                           $("#_txt_UnidadMedida").val("KILO");
                           $("#_txt_cantidadUnidad").val(1);
                           $("#_txt_Presentacion").val(opcion_seleccionada4);
                           var  grupo =  $("#cb_Grupo").val();
                           var unidadMedida = $("#cb_UnidadMedida").val();
                           var  forma=$("#cb_Forma").val();   
                           $("#_cb_Grupo").val(grupo);
                           $("#_cb_UnidadMedida").val(unidadMedida);
                           $("#_cb_Forma").val(1);
                           $("#_cb_Presentacion").val(presentacion);
                           var cbForma = $("#cb_Forma option:selected").text();
                             var UnidadCantidad = $("#txt_cantidadUnidad").val();
                             var UnidadMedida = $("#cb_UnidadMedida option:selected").text();
                             var contatenar=cbForma+" DE "+Nombre+" "+UnidadCantidad+" "+UnidadMedida;
                            $("#_txt_Producto_Convertir").val(contatenar);
                            $("#_txt_Producto_Convertir_Cantidad").val(UnidadCantidad);
                       
                           }

                        }
                      }
                       if(idForma==="7"){
                       
                        var statusConfirm = confirm("¿ESTE PRODUCTO "+nombreProducto+" SE DIVIDE EN KILOS Y SE EMPACA TAMBIEN EN BOLSA?" );
                        if (statusConfirm === true)
                        {
                           var opcion_seleccionada5 = $("#cb_Presentacion option:selected").text();
                           var presentacion = $("#cb_Presentacion").val();
                           $("input.check").prop("checked",false);
                           element = document.getElementById("content");
                           element.style.display='none';
                           $('#modal-avisolegal').modal({backdrop: 'static', keyboard: false});
                           var Nombre= $("#txt_Nombre").val();
                           $("#_txt_Nombre").val(Nombre);
                           $("#_txt_Grupo").val("QUIMICO");
                           $("#_txt_forma").val("BOLSA");
                           $("#_txt_UnidadMedida").val("KILO");
                           $("#_txt_cantidadUnidad").val(1);
                           $("#_txt_Presentacion").val(opcion_seleccionada5);
                           var  grupo =  $("#cb_Grupo").val();
                           var unidadMedida = $("#cb_UnidadMedida").val();
                           var  forma=$("#cb_Forma").val();   
                           $("#_cb_Grupo").val(grupo);
                           $("#_cb_UnidadMedida").val(unidadMedida);
                           $("#_cb_Forma").val(1);
                            $("#_cb_Presentacion").val(presentacion); 
                           var cbForma = $("#cb_Forma option:selected").text();
                             var UnidadCantidad = $("#txt_cantidadUnidad").val();
                             var UnidadMedida = $("#cb_UnidadMedida option:selected").text();
                             var contatenar=cbForma+" DE "+Nombre+" "+UnidadCantidad+" "+UnidadMedida;
                            $("#_txt_Producto_Convertir").val(contatenar);
                            $("#_txt_Producto_Convertir_Cantidad").val(UnidadCantidad);
                       
                           }
                        else
                        {
                             var statusConfirm = confirm("¿ESTA SEGUR@ QUE ESTE PRODUCTO NO SE  SE DIVIDE EN KILOS Y SE EMPACA TAMBIEN EN BOLSA");
                        if (statusConfirm === true)
                        {
                      
                           }else{
                           var opcion_seleccionada6 = $("#cb_Presentacion option:selected").text();
                           var presentacion = $("#cb_Presentacion").val();
                           $("input.check").prop("checked",false);
                           element = document.getElementById("content");
                           element.style.display='none';
                           $('#modal-avisolegal').modal({backdrop: 'static', keyboard: false});
                           var Nombre= $("#txt_Nombre").val();
                           $("#_txt_Nombre").val(Nombre);
                           $("#_txt_Grupo").val("QUIMICO");
                           $("#_txt_forma").val("BOLSA");
                           $("#_txt_UnidadMedida").val("KILO");
                           $("#_txt_cantidadUnidad").val(1);
                           $("#_txt_Presentacion").val(opcion_seleccionada6);
                           var  grupo =  $("#cb_Grupo").val();
                           var unidadMedida = $("#cb_UnidadMedida").val();
                           var  forma=$("#cb_Forma").val();   
                           $("#_cb_Grupo").val(grupo);
                           $("#_cb_UnidadMedida").val(unidadMedida);
                           $("#_cb_Forma").val(1);
                            $("#_cb_Presentacion").val(presentacion); 
                            var cbForma = $("#cb_Forma option:selected").text();
                             var UnidadCantidad = $("#txt_cantidadUnidad").val();
                             var UnidadMedida = $("#cb_UnidadMedida option:selected").text();
                             var contatenar=cbForma+" DE "+Nombre+" "+UnidadCantidad+" "+UnidadMedida;
                            $("#_txt_Producto_Convertir").val(contatenar);
                            $("#_txt_Producto_Convertir_Cantidad").val(UnidadCantidad);
                       
                           }

                        }
                      }
                       $("#mensaje").html("Producto agregado correctamente");
                       
                       limpiar();
                   }else{
                       alert("Fallo al agregar el producto!");
                   }
                   
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
        
}


function agregarProductoBotella_Bolsa()
{

    $("#accion").val("agregar2");
    $("#mensaje").html("");
    
         $.ajax({
               url: '../ControllerProducto' ,
               data: $("#frmAgregarPro").serialize(),
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   if(resultado)
                   {
                       alert("registrado");
                       limpiarModal();
                   }else
                   {
                       alert("Problemas al agregar producto");
                       
                   }
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
        
}
function repetirCodigo(){
     var parametros=
            {
                accion: "repetir",
       
                fecha:$("#fecha").val(),
                referencia: $("#referencia").val().trim(),
                cancod:$("#cancod").val()
               
                
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
                       if(contador===0){
                           element = document.getElementById("repetir");
                           element.style.display='none';
                      
                       }
                       contador++;
                      
                       $("#mensaje").html("Imprimio correctamente");
                    
                   }else
                   {
                       alert("fallo");
                       $("#mensaje").html("Hay problemas al imprimir los codigos de barras");
                   }
                   $("#msj").show();
            },
            error: function(ex)
            {
                console.log(ex.responseText);
            }
        });
        
}
function libros ()
{

}
function limpiar(){
      
       $("#content").val("");
       $("#txt_Referencia").val("");
       $("#txt_Nombre").val("");
       $("#txt_Abreviatura").val("");
       $("#txt_cantidadUnidad").val(0);
       $("#txt_cancod").val(0);
       $("#cb_Forma").val(0);
       $("#cb_Grupo").val(0);
       $("#cb_SubGrupo").val(0);
       $("#cb_Presentacion").val(0);
       $("#cb_UnidadMedida").val(0);
       $("#txt_DetalleObservacion").val("");
       $("#txt_cancod").val(0);  
    }
    function limpiarModal(){
      
       $("#_cb_Grupo").val("");
       $("#_cb_UnidadMedida").val("");
       $("#_cb_Forma").val("");
       $("#_cb_Presentacion").val("");
       $("#_cod_barra").val(0);
       $("#_txt_Referencia").val("");
       $("#_txt_Nombre").val("");
       $("#_txt_Abreviatura").val("");
       $("#_txt_Grupo").val("");
       $("#_txt_Presentacion").val(""); 
       $("#_txt_forma").val("");
       $("#_txt_UnidadMedida").val("");
       $("#_txt_cantidadUnidad").val("");
       $("#_txt_DetalleObservacion").val("");
       
       
       
    }