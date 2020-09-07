/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
    ListarUsuario(); 
    $("#btnEditarUsuario").click(function(){
         EditarUsuario()();
    });
    $("#btnListarUsuario").click(function(){
        ListarUsuario();
    });

});
function ListarUsuario(){
    $("tbody tr").remove(); 
     var parametros = {
               accion: "listarUsuario"
              
    };    
    $.ajax({          
        url: '../ControllerUsuario',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            usuarios = resultado;          
            var cantidad;
            cantidad= usuarios.length;
              if(cantidad===0){
                 alert("No hay ningún usuario creado");
             }
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(usuarios, function(j,usuario){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 6; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(usuario.identificacion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===1){
     var textoCelda = document.createTextNode(usuario.nombre);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
  if(j===2){
     var textoCelda = document.createTextNode(usuario.telefono);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }
   if(j===3){
     var textoCelda = document.createTextNode(usuario.correo);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

     if(j===5){
      var id=usuario.idUsuario;
      const fragment= document.createDocumentFragment();
      const button= document.createElement('a');
                           button.setAttribute('onclick', 'abrirModalUsuario('+id+')');
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
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function abrirModalUsuario(idUsuario){
    $("#idUsuario").val(idUsuario);
   $('#modal').modal({backdrop: 'static', keyboard: false});
    $("#modal").modal();
     var parametros = {
               accion: "obtenerUsuario",
               idUsuario:idUsuario
    };    
    $.ajax({          
        url: '../ControllerUsuario',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            var usuario =resultado;
            if (resultado) {
                $("#txt_Identificacion").val(usuario.identificacion); 
                $("#txt_Nombre").val(usuario.nombre); 
                $("#txt_Telefono").val(usuario.telefono); 
                $("#txt_Correo").val(usuario.correo);
         
              }else{
                  alert("Error");
              }
                 
           
       
             
 

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function EditarUsuario(){

     var parametros = {
               accion: "EditarUsuario",
               idUsuario:$("#idUsuario").val(),
               identificacion:$("#txt_Identificacion").val(),
               txt_Nombre:$("#txt_Nombre").val(),
               txt_Telefono:$("#txt_Telefono").val(),
               txt_Correo:$("#txt_Correo").val()
    };    
    $.ajax({          
        url: '../ControllerUsuario',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
         
            if (resultado) {
               
                alert("Se edito el producto correctamente!");
                 $("tbody tr").remove();
              ListarUsuario(); 
              }else{
                  alert("No se ha editado correctamente!");
              }
             
        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
