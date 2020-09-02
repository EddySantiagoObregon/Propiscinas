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
    document.body.style.cursor = "progress";
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
                       document.body.style.cursor = "default";
                      alert("Se ha enviado un mensaje al  correo del administrador para que le de  su nueva contraseña");
                   }else
                   {
                       document.body.style.cursor = "default";
                       alert("Identificación o correo electrónico incorrectos");
                   }
                    $("#modalRecuperarClave").hide();
            },
            error: function(ex)
            {
                document.body.style.cursor = "default";
                alert("Identificación o correo electrónico incorrectos");
                console.log(ex.responseText);
            }
        });
}


