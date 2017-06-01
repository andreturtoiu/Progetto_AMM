/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(usr){
    var img = $("<img>")
            .attr("alt","Foto Profilo")
            .attr("src",usr.urlFotoProfilo);
    var link = $("<a>")
            .attr("href", "Bacheca?user="+usr.id)
            .html(usr.nome + " " + usr.cognome);
  
    var userData = $("<div>")
             .attr("class","userData")
             .append(img)
             .append(link);
            
    
    return $("<li>")
            .append(userData);
}

function stateSuccess(data){
    var title = $("<h3>")
                .html("Amici"); 
    var userListPage = $("#user");
    
    var lista = $("<ul>");
    $(userListPage).empty();
    $(userListPage).append(title);
    
    for(var instance in data){
        $(lista).append(createElement(data[instance]));
    }
    $(userListPage).append(lista);
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchFriends").change(function(){
        
        var wantedUser = $("#searchFriends")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                nomeAmico: wantedUser  
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
    });
});



