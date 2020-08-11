/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function ()
{
 
    $("#btnRecuperarClaveModal").click(function(){
        recuperarClave();
    });
    
    
});

function recuperarClave(){
    var parametros = {
        accion: "ActualizarPassword",
        identificacion: $("#txtIdentificacion").val(),
        correo: $("#txtCorreo").val()
    };
    $.ajax({
        url: '../ControllerUsuario',
        data:parametros,
        type:'post',
        dataType:'json',
        cache: false,

 success: function(resultado)
               {
                   console.log(resultado);
                   if(resultado)
                   {
                      alert("Se ha enviado un mensaje a su correo con su nueva contraseña");
                   }else
                   {
                       alert("Identificación o correo electrónico incorrectos");
                   }
                    $("#modalRecuperarClave").hide();
            },
            error: function(ex)
            {
                alert("Identificación o correo electrónico incorrectos");
                console.log(ex.responseText);
            }
        });
}


