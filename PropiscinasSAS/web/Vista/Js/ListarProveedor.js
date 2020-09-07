/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    ListarProveedor(); 
    $("#btnEditar").click(function(){
         EditarProveedor();
    });
    $("#btnListar").click(function(){
        ListarProveedor();
    });
    $("#btnBuscar").click(function(){
        buscarProveedor();
    });
});
function ListarProveedor(){
    $("tbody tr").remove(); 
     var parametros = {
               accion: "ListarProveedores"
              
    };    
    $.ajax({          
        url: '../ControllerProveedor',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
           success: function (resultado) {
        console.log(resultado);
            
            proveedor=resultado;          
            var cantidad;
            cantidad= proveedor.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = proveedor.length;
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
      var textoCelda = document.createTextNode(proveedor[i].nitProveedor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===1){
     var textoCelda = document.createTextNode(proveedor[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===2){
     var textoCelda = document.createTextNode(proveedor[i].telefono);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor[i].correo);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  
     if(j===4){
      var id=proveedor[i].idProveedor;;
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
function abrirModal(idProveedor){
    $("#idProveedor").val(idProveedor);
   $('#modal').modal({backdrop: 'static', keyboard: false});
    $("#modal").modal();
     var parametros = {
               accion: "obtenerProveedor",
               idProveedor:idProveedor
    };    
    $.ajax({          
        url: '../ControllerProveedor',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            var proveedor =resultado;
            if (resultado) {
                $("#txt_Nit").val(proveedor.nitProveedor); 
                $("#txt_Nombre").val(proveedor.nombre); 
                $("#txt_Telefono").val(proveedor.telefono); 
                $("#cb_Estado").val(proveedor.estado);
                 $("#txt_Correo").val(proveedor.correo);
         
              }else{
                  alert("Error");
              }
                 
           
       
             
 

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function EditarProveedor(){

     var parametros = {
               accion: "EditarProveedor",
               idProveedor:$("#idProveedor").val(),
               txt_Nit:$("#txt_Nit").val(),
               txt_Nombre:$("#txt_Nombre").val(),
               txt_Telefono:$("#txt_Telefono").val(),
               cb_Estado:$("#cb_Estado").val(),
               txt_Correo:$("#txt_Correo").val()
    };    
    $.ajax({          
        url: '../ControllerProveedor',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
         
            if (resultado) {
               
                alert("Se edito el producto correctamente!");
                 $("tbody tr").remove();
                ListarProveedor();
              }else{
                  alert("No se ha editado correctamente!");
              }
                 
           
       
             
 

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}

function buscarProveedor(){
    $("tbody tr").remove(); 
     var parametros = {
               accion: "buscarProveedor",
               buscar:$("#txt_Buscar").val()
    };    
    $.ajax({          
        url: '../ControllerProveedor',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
           success: function (resultado) {
        console.log(resultado);
            
            proveedor=resultado;          
            var cantidad;
            cantidad= proveedor.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = proveedor.length;
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
      var textoCelda = document.createTextNode(proveedor[i].nitProveedor);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===1){
     var textoCelda = document.createTextNode(proveedor[i].nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===2){
     var textoCelda = document.createTextNode(proveedor[i].telefono);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(proveedor[i].correo);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===4){
     var textoCelda = document.createTextNode(proveedor[i].estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  
     if(j===4){
      var id=proveedor[i].idProveedor;;
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