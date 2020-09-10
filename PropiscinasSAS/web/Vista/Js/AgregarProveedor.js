/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var unmed="";
$(function ()
{
    var correo = $("#Correo").val();
    
    listarProveedor();
   
    ListarProducto();
    $('#btnListar').click(function(){
        $("tbody tr").remove(); 
        ListarProducto();
    });
    $('#btnBuscar').click(function(){ 
 
        BuscarProducto();
      
   }); 
   
   $('#btnAgregarProveedor').click(function(){ 
  var cb_Proveedor = $("#cb_Proveedor").val();
  if(cb_Proveedor!=='0'){
      document.getElementById('btnAgregarProveedor').disabled=false;
        AgregarProveedor();
    }else{
        document.getElementById('btnAgregarProveedor').disabled=false;
        alert("Seleccioné el proveedor");
    }
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
  var cantidad=productos[i].cantidadUnidad;
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
                           img.setAttribute('src','Imagenes/anadir.png');
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
  var cantidad=productos[i].cantidadUnidad;
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
                           img.setAttribute('src','Imagenes/anadir.png');
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
                            
                         
                     var cantidad=producto.cantidadUnidad;
                    if(cantidad===0){
                  
                        $("#nombreproducto").html(producto.nombre+" "+producto.unaUnidadMedida.descripcion);
                      
                    }else{
                    
                        $("#nombreproducto").html(producto.nombre+" "+producto.unaForma.descripcion+" "+producto.cantidadUnidad+" "+producto.unaUnidadMedida.descripcion);
                      
                    }
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}
 //el inventario infraestructura , esto lo hago solo para traerme la cantidad que tiene el producto
    

//Esta funcion agrega la cantidad de productos
function AgregarProveedor(){
    var idPro = $("#idProducto").val();     

        var parametros=
            {
                accion: "Agregar",
                idProducto: $("#idProducto").val(),
                cb_Proveedor:$("#cb_Proveedor").val()
                
         
            };
            $.ajax({
                url: '../ControllerProveedorProducto',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                     
                      
                       
                      document.getElementById('btnAgregarProveedor').disabled=false;
                    
                      alert("Proveedor agregado correctamente al producto");
                 
                      limpiarModal();
                } else{
                    document.getElementById('btnAgregarProveedor').disabled=false;
                    alert("Este producto ya tiene este proveedor");
                }
                           
 
                },
                error:function(ex)
                {
                    document.getElementById('btnAgregarProveedor').disabled=false;
                    console.log(ex);
                }
            });
}
function listarProveedor()
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
function limpiarModal(){
    
      $("#cb_Proveedor").val(0);
    
       
}