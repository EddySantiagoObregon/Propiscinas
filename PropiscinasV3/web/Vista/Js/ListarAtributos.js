/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function ()
{

    listarGrupo();
    listarPresentacion();
    listarForma();
    listarUnidadMedida();
    listarInfraestructura();
   
});
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

function listarPresentacion()
{
    var parametros=
            {
                accion:"ListarPresentacion"
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var presentaciones = resultado;
                   $.each(presentaciones,function(i,presentacion)
                   {
                       
                       $('#cb_Presentacion').append(
                         $('<option>',{
                            
                            value: presentacion.idPresentacion,
                            text: presentacion.descripcion
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

function listarForma()
{
    var parametros=
            {
                accion:"listarForma"
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var formas = resultado;
                   $.each(formas,function(i,forma)
                   {
                       
                       $('#cb_Forma').append(
                         $('<option>',{
                            
                            value: forma.idForma,
                            text: forma.descripcion
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

function listarUnidadMedida()
{
    var parametros=
            {
                accion:"ListarUnidadMedida"
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var UnidadMedidas = resultado;
                   $.each(UnidadMedidas,function(i,UnidadMedida)
                   {
                       
                       $('#cb_UnidadMedida').append(
                         $('<option>',{
                            
                            value: UnidadMedida.idUnidadMedida,
                            text: UnidadMedida.descripcion
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
function listarInfraestructura()
{
    var parametros=
            {
                accion:"ListarInfraestructura"
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var infraestructuras = resultado;
                   $.each(infraestructuras,function(i,infraestructura)
                   {
                       
                       $('#cb_Infraestructura').append(
                         $('<option>',{
                            
                            value: infraestructura.idInfraestructura,
                            text: infraestructura.descripcion
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

function listarTransaccion()
{
    var parametros=
            {
                accion:"ListarTransaccion"
            };
            $.ajax({
               url: '../ControllerProducto' ,
               data: parametros,
               type: 'post',
               dataType: 'json',
               cache: false,
               success: function(resultado)
               {
                   console.log(resultado);
                   var Transacciones = resultado;
                   $.each(Transacciones,function(i,Transaccion)
                   {
                       
                       $('#cb_Transaccion').append(
                         $('<option>',{
                            
                            value: Transaccion.idInfraestructura,
                            text: Transaccion.descripcion
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




