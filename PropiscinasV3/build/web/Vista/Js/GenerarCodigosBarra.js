/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    listarGrupo();
    $("#btnGenerarTodos").click(function(){
           GenerarCodigoDeBarras();     
    });
    $("#btnGenerCodigoBarrasPorGrupo").click(function(){
           GenerarCodigoDeBarrasPorGrupo();     
    });
     $("#btnGenerCodigoBarrasIndenpendiente").click(function(){
           GenerCodigoBarrasIndenpendiente();     
    });
    
});

function GenerarCodigoDeBarras(){
         
        var parametros=
            {
                accion: "GenerarCodigoDeBarras"
             
                
         
            };
            $.ajax({
                url: '../ControllerProducto',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                     
                      alert("Correcto");
                 
                } else{
                    alert("error");
                }
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
        }
        
        function GenerarCodigoDeBarrasPorGrupo(){
         
        var parametros=
            {
                accion: "GenerarCodigoDeBarrasPorGrupo",
                idGrupo:$("#cb_Grupo").val()
            };
            $.ajax({
                url: '../ControllerProducto',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                     
                      alert("Correcto");
                 
                } else{
                    alert("error");
                }
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
        }
        
         function GenerCodigoBarrasIndenpendiente(){
         
        var parametros=
            {
                accion: "GenerarCodigoDeBarraIndependiente",
                cantidad:$("#txt_Cantidad").val(),
                codigo:$("#txt_Codigo").val().trim()
            };
            $.ajax({
                url: '../ControllerProducto',
                data:parametros,
                dataType: 'json',
                type: 'post',
                cache: false,
                success: function(resultado){
                    console.log(resultado);
                    if(resultado){
                     
                      alert("Correcto");
                 
                } else{
                    alert("error");
                }
                           
 
                },
                error:function(ex)
                {
                    console.log(ex);
                }
            });
        }
function listarGrupo()
{
    var parametros={
        accion:"ListarGrupo"
    };
    $.ajax({
        url: '../ControllerProducto',
        data:parametros,
        type: 'post',
        dataType: 'json',
        cache: false,
        success: function(resultado){
            console.log(resultado);
            var grupos= resultado;
            $.each(grupos, function(i, grupo){
                $('#cb_Grupo').append(
                        $('<option>',{
                            
                            value: grupo.idGrupo,
                            text: grupo.descripcion
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