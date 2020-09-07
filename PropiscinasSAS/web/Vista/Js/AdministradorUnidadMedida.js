/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




$(function(){
    listarUnidadMedida(); 
    $("#btnEditar").click(function(){
   
         Editar();
    });
    $("#btnAgregar").click(function(){
        Agregar();
    });
  

});
function Agregar(){
   
     var parametros = {
               accion: "agregar",
               nombre:$("#txt_Nombre1").val()
    };    
    $.ajax({          
        url: '../ControllerUnidadMedida',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
                        if (resultado) {
                alert("Agregado correctamente");
                 $("tbody tr").remove(); 
                 listarUnidadMedida();
         
              }else{
                  alert("Problemas al agregar");
              }
                 
           
       
             
 

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function listarUnidadMedida(){
    $("tbody tr").remove(); 
     var parametros = {
               accion: "listar"
              
    };    
    $.ajax({          
        url: '../ControllerUnidadMedida',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            
            UnidadMedidas = resultado;          
            var cantidad;
            cantidad= UnidadMedidas.length;
               if(cantidad===0){
                 alert("No hay ningún dato");
             }
             var body =document.getElementsByTagName("tbody")[0];
             
 

 

                $.each(UnidadMedidas, function(j,UnidadMedida){

  
 
    // Crea las hileras de la tabla
    var hilera = document.createElement("tr");
 
    for (var j = 0; j < 3; j++) {
      // Crea un elemento <td> y un nodo de texto, haz que el nodo de
      // texto sea el contenido de <td>, ubica el elemento <td> al final
      // de la hilera de la tabla
      var celda = document.createElement("td");
   
    

  if(j===0){
      var textoCelda = document.createTextNode(UnidadMedida.descripcion);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  }

  if(j===1){
     var textoCelda = document.createTextNode(UnidadMedida.estado);
      celda.appendChild(textoCelda);
      hilera.appendChild(celda);
  
  }

     if(j===2){
      var id=UnidadMedida.idUnidadMedida;
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
 

 });

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function abrirModal(id){
   
    $("#id").val(id);
   $('#modal').modal({backdrop: 'static', keyboard: false});
    $("#modal").modal();
     var parametros = {
               accion: "obtener",
               id:id
    };    
    $.ajax({          
        url: '../ControllerUnidadMedida',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
            var UnidadMedida =resultado;
            if (resultado) {
                $("#cb_Estado").val(UnidadMedida.estado); 
             
         
              }else{
                  alert("Error");
              }
                 
           
       
             
 

        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
function Editar(){

     var parametros = {
               accion: "Editar",
               id:$("#id").val(),
               cb_Estado:$("#cb_Estado").val()
              
    };    
    $.ajax({          
        url: '../ControllerUnidadMedida',         
        data:parametros,
        dataType:'json',
        type: 'post',        
        cache: false,
        success: function (resultado) {
            console.log(resultado);
         
            if (resultado) {
               
                alert("Se desactivo la presentación correctamente!");
                 $("tbody tr").remove();
              listarUnidadMedida(); 
              }else{
                  alert("No se ha editado correctamente!");
              }
             
        },
      
        error: function(ex){
          console.log(ex.responseText);
        }
    });          
}
