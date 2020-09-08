/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
     
      $('#btnAbrirRegistrar').click(function(){ 
                $("#modal").modal(); 
      });
        $('#btnRegistrar').click(function(){ 
        $("#msjIdentificacion").empty();
        $("#msjNombre").empty();
        $("#msjTelefono").empty();
        $("#msjCorreo").empty();
        $("#msjNit").empty();
     
    var Identificacion,Nombre,Telefono,Correo,Nit,Expresion,Expresion2;
    Identificacion = document.getElementById("txt_Identificacion").value;
    Nombre = document.getElementById("txt_Nombre").value;
    Telefono = document.getElementById("txt_Tel").value;
    Correo = document.getElementById("txt_Correo").value;
    Nit = document.getElementById("txt_Nit").value;
    Expresion = /\w+@\w+\.+[a-z]/; 
    Expresion2 = /[a-z]/;

    if (Identificacion === "" || Nombre === "" ||  Telefono === "" || Correo==="" || Nit===""){
        alert("Todos los campos son requeridos");
       return false;
    }
        else if (Nit!=="900127905"){
        $("#msjNit").html("Nit incorrecto");
        return false;
    }
    else if (Identificacion.length>11){
        $("#msjIdentificacion").html("Identificación muy larga");
        return false;
        
    }
     else if (isNaN(Identificacion)){
        $("#msjIdentificacion").html("En la identifcación no se permite letras");
        return false;
    }
    else if (Nombre.length>100){
        $("#msjNombre").html("Nombre muy largo");
        return false;
    }
     else if (!Expresion2.test(Nombre)){
           $("#msjNombre").html("No se permiten números");
        return false;
    }
      
  
    else if (Telefono.length>15){
        $("#msjTelefono").html("Telefono  muy largo");
        return false;
    }
 
    else if (isNaN(Telefono)){
        $("#msjTelefono").html("Telefono  no es un número");
        return false;
    }
 
    
    else if (Correo.length>100){
        $("#msjCorreo").html("Correo  muy largo");
        return false;
    }
     else if (!Expresion.test(Correo)){
        $("#msjCorreo").html("El correo no es válido");
        return false;
    }
     
 
        
              RegistrarPersona();
            
   });
   
  $('#btnRecuperar').click(function(){ 
      
          $("#modalRecuperClave").modal();
            
   });
});
//////////////////////////

   

function RegistrarPersona(){
         
  document.body.style.cursor = "progress";       

        var parametros=
            {
                accion: "RegistrarPersona",
                txt_Identificacion:$("#txt_Identificacion").val().trim(),
                txt_Nombre:$("#txt_Nombre").val().trim(),
                txt_Tel:$("#txt_Tel").val(),
                txt_Correo:$("#txt_Correo").val().trim()
             
                
         
            };
            $.ajax({
                url: '../ControllerUsuario',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                         
                     alert("Se ha registrado correctamente, colocate en contacto con el administrador para que te de la contraseña de acceso");
                     document.body.style.cursor = "default";
              
                } else{
                     document.body.style.cursor = "default";
                 
                    alert("Problemas al registrar ");
                }
                           
 
                },
                error:function(ex)
                {
                     document.body.style.cursor = "default";
                    alert("Problemas al registrar ");
                    console.log(ex);
                }
            });
}
