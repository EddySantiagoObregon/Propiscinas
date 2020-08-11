/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
     
      $('#btnAbrirRegistrar').click(function(){ 
                $("#modal").modal(); 
   });
   //////////////////////////////////////
    $('#txt_Nit').keyup(function() {
     var txt_Nit;
      txt_Nit = document.getElementById("txt_Nit").value;
        if (txt_Nit!=='900127905'){
        $("#msjNit").html("Nit incorrecto");
        return false;
    }else{
         $("#msjNit").html(" ");
    }
  
 });
  
   //////////////////////////////////////////
    $('#txt_Identificacion').keyup(function() {
     var txt_Identificacion;
      txt_Identificacion = document.getElementById("txt_Identificacion").value;
        if (txt_Identificacion.length<1 || txt_Identificacion.length >11){
        $("#msjIdentificacion").html("Identificacíon maxima de 11 digitos");
        return false;
    }else{
         $("#msjIdentificacion").html(" ");
    }
  
 });
 ////////////////////////////////////////////
     $('#txt_Nombre').keyup(function() {
     var txt_Nombre;
     txt_Nombre = document.getElementById("txt_Nombre").value;
        if (txt_Nombre.length<1 || txt_Nombre.length >100){
        $("#msjNombre").html("Nombre maximo de 100 digitos");
        return false;
    }else{
         $("#msjNombre").html(" ");
    }
  
 });
 
 ///////////////////////////////////////
  $('#txt_Telefono').keyup(function() {
     var txt_Telefono;
     txt_Telefono = document.getElementById("txt_Telefono").value;
        if (txt_Telefono.length<1 || txt_Telefono.length >15){
        $("#msjTelefono").html("Telefono maximo de 15 digitos");
        return false;
    }else{
         $("#msjTelefono").html(" ");
    }
  
 });
 
 //////////////////////////////////////
   $('#txt_Correo').keyup(function() {
     var txt_Correo;
     txt_Correo = document.getElementById("txt_Correo").value;
        if (txt_Correo.length<1 || txt_Correo.length >100){
        $("#msjCorreo").html("Correo maximo de 100 caracteres");
        return false;
    }else{
         $("#msjCorreo").html(" ");
    }
  
 });
 /////////////////////////////////////
  $('#txt_Contrasena').keyup(function() {
     var txt_Contrasena;
     txt_Contrasena = document.getElementById("txt_Contrasena").value;
        if (txt_Contrasena.length<1 || txt_Contrasena.length >100){
        $("#msjContrasena").html("Contraseña maxima de 100 caracteres");
        return false;
    }else{
         $("#msjContrasena").html(" ");
    }
  
 });
 //////////////////////////////////////
  $('#txt_RepetirContrasena').keyup(function() {
     var txt_RepetirContrasena;
     txt_RepetirContrasena = document.getElementById("txt_RepetirContrasena").value;
     var contrasena= document.getElementById("txt_Contrasena").value;
        contrasena+=0;
        txt_RepetirContrasena+=0;
        if (contrasena!==txt_RepetirContrasena) {
           $("#msjRepetirContrasena").html("Las contraseñas no coinciden");
           return false;
      }else{
         $("#msjRepetirContrasena").html(" ");
    }
  
 });
 ////////////////////////////////////
      $('#btnRegistrar').click(function(){ 
        
          var nit=$("#txt_Nit").val();
          if(nit==="900127905"){
                
                RegistrarPersona();
          }else{
              alert("Nit incorrecto");
          }
            
   });
   
  $('#btnRecuperar').click(function(){ 
      
          $("#modalRecuperClave").modal();
            
   });
});
//////////////////////////

   

function RegistrarPersona(){
         
        var parametros=
            {
                accion: "RegistrarPersona",
                txt_Identificacion:$("#txt_Identificacion").val().trim(),
                txt_Nombre:$("#txt_Nombre").val().trim(),
                txt_Tel:$("#txt_Tel").val(),
                txt_Correo:$("#txt_Correo").val().trim(),
                txt_Contrasena:$("#txt_Contrasena").val().trim()
             
                
         
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
                     alert("Se registro correctamente!");
                     location.href="MenuPrincipal.jsp";
                } else{
                    alert("Problemas al registrar ");
                }
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}