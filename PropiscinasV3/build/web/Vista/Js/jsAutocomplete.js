
      $(function (){   
                  
                    var availableTags= new Array();
                    $("#txt_Buscar").bind("keydown",function(event){
                        var data ={nombre:$("#txt_Buscar").val()};
                        var url="../buscar";
                        $.getJSON(url,data,function (res,est,jqXHR){   
                            availableTags.length=0;
                            $.each(res,function (i,item){
                                availableTags[i]=item;
                            });                            
                        });
                    });
                    
                    $("#txt_Buscar").autocomplete({
                        source:availableTags,
                        minLength:1
                        
                    });
                });
                