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
         var buscar;
        $("tbody tr").remove(); 
       buscar = $("#txt_Buscar").val();
       numero = $("#cb_Opciones").val();
     if(numero==="0"&&buscar!==null){
     
       BuscarProducto();
       } else  if(numero!=="0"&&buscar!==""&&numero!=="1"){
        
         numero=numero-1;

       BuscarCantidadActualizadaPorNombreYInfraestructura(numero);
       
       }else if(buscar!==""&&numero==="1"){

           totalProductosInfraestructuraYcodigo();
       }
  });
   $("#btnListar").click(function(){
        $("tbody tr").remove();
        $("#cb_Opciones").val(0);
        $("#txt_Buscar").val("");
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
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
             
             
    if(cantidad===0){
                 alert("No hay ningún dato");
             }
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode("TODAS");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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
    function BuscarProductoDeInfraestructura(){
        $("tbody tr").remove(); 
        var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
           var parametros = {
               accion: "BuscarProductoDeInfraestructura",
               producto: buscar,
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
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
               if(cantidad===0){
                 alert("No hay ningún dato");
             } 
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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
      function BuscarCantidadActualizadaPorCodigoYInfraestructura(numero){
          $("tbody tr").remove(); 
          var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
               accion: "BuscarCantidadActualizadaPorCodigoYInfraestructura",
               infraestructura:numero,
               buscar1: buscar
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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
     function BuscarCantidadActualizadaPorNombreYInfraestructura(numero){
         $("tbody tr").remove(); 
         var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
               accion: "BuscarCantidadActualizadaPorNombreYInfraestructura",
               infraestructura:numero,
                buscar1: buscar
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
      success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
             
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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
     function BuscarProducto(){
         $("tbody tr").remove(); 
         var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
              accion: "BuscarProducto",
                buscar:buscar
              
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
     success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode(inventarios[i].unaInfraestructura.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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
    function totalProductosInfraestructuraYcodigo()
    {
           var txtBuscar =$("#txt_Buscar").val().trim();
    var buscar=txtBuscar.substring(0,13);
     var parametros = {
              accion: "totalProductosInfraestructuraYcodigo",
                buscar:buscar
                
    };    
    $.ajax({          
        url: '../ControllerInventarioInfraestructura',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
        console.log(resultado);
            
            inventarios=resultado;          
            var cantidad;
            cantidad= inventarios.length;
                if(cantidad===0){
                 alert("No hay ningún dato");
             }
             
 
   
            
            var pag = 1;
            var totales = inventarios.length;
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
 
    for (var j = 0; j < 9; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   if(j===0){
      var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.idProducto);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }
  if(j===1){
      var textoCelda = document.createTextNode(inventarios[i].fecha);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===2){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
    var cantidad=inventarios[i].unDetalleProducto.cantidadUnidad;
 
  if(cantidad===0){
  if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }else{
      if(j===3){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaForma.descripcion+" "+inventarios[i].unDetalleProducto.cantidadUnidad+" "+inventarios[i].unDetalleProducto.unaUnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  }

 
  
  if(j===4){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unaPresentacion.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===5){
     var textoCelda = document.createTextNode(inventarios[i].unDetalleProducto.unGrupo.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 if(j===6){
     var textoCelda = document.createTextNode(inventarios[i].cantidad);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

    if(j===7){
     var textoCelda = document.createTextNode("TODAS");
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
 var cantidadInventrario=inventarios[i].cantidad;
   if(cantidadInventrario<5){
         if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                        button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🔴";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
  if(cantidadInventrario>5&&cantidadInventrario<20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟡";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
  }
    if(cantidadInventrario>5&&cantidadInventrario>20){
      if(j===8){
     
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                          
                           button.setAttribute('class','agregar');
                           button.setAttribute('id','agregar');
                           button.setAttribute('style','position: absolute;margin-top: 10px;');
                           const img= document.createElement('img');
                           button.innerHTML="🟢";
       button.appendChild(img);
      fragment.appendChild(hilera);
      hilera.appendChild(button);
      }
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