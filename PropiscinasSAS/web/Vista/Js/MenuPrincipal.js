/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
       $("#btnSalir").click(function(){
        location.href="Salir.jsp";
    });
    MiPerfil();
 
});

function MiPerfil(){
      var parametros=
            {
                accion: "Nombre",
                Correo: $("#Correo").val()
            };
            $.ajax({
                url: '../ControllerUsuario',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    var usuario= resultado;
                    
                             $("#sNombre").html(usuario.nombre);
                             $("#perfilNombre").html(usuario.nombre);
                             $("#txt_Identificacionnn").val(usuario.identificacion);
                             $("#txt_Nombreee").val(usuario.nombre);
                             $("#txt_Telefonooo").val(usuario.telefono);
                             $("#txt_Correooo").val(usuario.correo);
                           
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
}
