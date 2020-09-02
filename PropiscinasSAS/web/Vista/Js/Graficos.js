/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var cantidad=0;
var cantidadd=0;
var cantidaddd=0;
let Nombre = [];
let Tresprimeros =[];
let numero1=0;
let numero2=0;
let numero3=0;
let Nombree = [];
let Tresprimeross =[];
let numeroo1=0;
let numeroo2=0;
let numeroo3=0;
let Tresprimerosss =[];
let numerooo1=0;
let numerooo2=0;
let numerooo3=0;


$(function(){
  
    Productomasvendidohoy();
    Productomasvendido();
    Productomenosvendido();

});
function Productomasvendido(){
    
               var parametros = {
               accion: "Productomasvendido"
              
                   };    
                $.ajax({          
                url: '../ControllerInventarioVenta',         
                data:parametros,
                dataType:'json',
                type: 'post',        
                async: false,
                success: function(resultado)
                {
                    datos = resultado;
                    console.log(datos);
                    cantidad= datos.length;
                    Nombre = [cantidad];
                    Tresprimeros=[cantidad];
                       $.each(datos, function(j,dato){
                            var forma=dato.unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
  
      Nombre.push(dato.unDetalleProducto.nombre+" "+dato.unaUnidadMedida.descripcion);
 
  }
  else{
     
      Nombre.push(dato.unDetalleProducto.unaForma.descripcion+" DE "+dato.unDetalleProducto.nombre+" "+dato.unDetalleProducto.cantidadUnidad+" "+dato.unaUnidadMedida.descripcion);
   
  }
       if(0===j){
           numero1=dato.cantidadTotal;
       }
       if(1===j){
           numero2=dato.cantidadTotal;
       }
       if(2===j){
           numero3=dato.cantidadTotal;
       }

                       });
                },
                error: function(error)
                {
                    console.log(error.responseText);
                }
            });
            
    var ctx = document.getElementById('myChart');
    var ctx = document.getElementById('myChart').getContext('2d');
    var ctx = $('#myChart');
    var ctx = 'myChart'; 
    var ctx = document.getElementById('myChart');
    var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        
        labels: [Nombre[1],Nombre[2],Nombre[3]],
        datasets: [{
            label: 'PRODUCTO MÁS VENDIDO',
            data: [numero1,numero2,numero3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
}
function Productomasvendidohoy(){
          
                
               var parametros = {
               accion: "Productomasvendidohoy"
                   };    
                $.ajax({          
                url: '../ControllerInventarioVenta',         
                data:parametros,
                dataType:'json',
                type: 'post',        
                async: false,
                success: function(resultado)
                {
                    datos = resultado;
                    console.log(datos);
                    cantidadd= datos.length;
                    Nombree = [cantidadd];
                    Tresprimeross=[cantidadd];
                       $.each(datos, function(j,dato){
                            var forma=dato.unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
  
      Nombree.push(dato.unDetalleProducto.nombre+" "+dato.unaUnidadMedida.descripcion);
 
  }
  else{
     
      Nombree.push(dato.unDetalleProducto.unaForma.descripcion+" DE "+dato.unDetalleProducto.nombre+" "+dato.unDetalleProducto.cantidadUnidad+" "+dato.unaUnidadMedida.descripcion);
   
  }
       if(0===j){
           numeroo1=dato.cantidadTotal;
       }
       if(1===j){
           numeroo2=dato.cantidadTotal;
       }
       if(2===j){
           numeroo3=dato.cantidadTotal;
       }

                       });
                },
                error: function(error)
                {
                    console.log(error.responseText);
                }
            });
            
    var ctx = document.getElementById('myChar');
    var ctx = document.getElementById('myChar').getContext('2d');
    var ctx = $('#myChar');
    var ctx = 'myChar'; 
    var ctx = document.getElementById('myChar');
    var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        
        labels: [Nombree[1],Nombree[2],Nombree[3]],
        datasets: [{
            label: 'PRODUCTO MÁS VENDIDO HOY',
            data: [numeroo1,numeroo2,numeroo3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
}


function Productomenosvendido(){
          
                
               var parametros = {
               accion: "Productomenosvendido"
                   };    
                $.ajax({          
                url: '../ControllerInventarioVenta',         
                data:parametros,
                dataType:'json',
                type: 'post',        
                async: false,
                success: function(resultado)
                {
                    datos = resultado;
                    console.log(datos);
                    cantidaddd= datos.length;
                    Nombreee = [cantidadd];
                    Tresprimerosss=[cantidadd];
                       $.each(datos, function(j,dato){
                            var forma=dato.unDetalleProducto.unaForma.descripcion;
  if(forma==="SOLO"){
  
      Nombreee.push(dato.unDetalleProducto.nombre+" "+dato.unaUnidadMedida.descripcion);
 
  }
  else{
     
      Nombreee.push(dato.unDetalleProducto.unaForma.descripcion+" DE "+dato.unDetalleProducto.nombre+" "+dato.unDetalleProducto.cantidadUnidad+" "+dato.unaUnidadMedida.descripcion);
   
  }
       if(0===j){
           numerooo1=dato.cantidadTotal;
       }
       if(1===j){
           numerooo2=dato.cantidadTotal;
       }
       if(2===j){
           numerooo3=dato.cantidadTotal;
       }

                       });
                },
                error: function(error)
                {
                    console.log(error.responseText);
                }
            });
            
    var ctx = document.getElementById('myCha');
    var ctx = document.getElementById('myCha').getContext('2d');
    var ctx = $('#myCha');
    var ctx = 'myCha'; 
    var ctx = document.getElementById('myCha');
    var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        
        labels: [Nombreee[1],Nombreee[2],Nombreee[3]],
        datasets: [{
            label: 'PRODUCTO MENOS VENDIDO ',
            data: [numerooo1,numerooo2,numerooo3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
}