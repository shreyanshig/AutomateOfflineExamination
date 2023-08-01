/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function registerinvig()
{
    let userid = $(".userid").val();
    let password = $("#Password").val();
    console.log(userid+" "+password);
    let data = {userid : userid,
                password : password
                };
    $.post("RegisterInvigControllerServlet", data, function(responseText){
        responseText = responseText.trim();
        if(responseText === "yes")
            swal("Admin!", "Invigilator has been successfully registered", "success");
        else
            swal("Failed!", "Some server issue occured. Register again", "error");
    });
}
function registerevaluator()
{
    let userid = $(".userid").val();
    let password = $("#Password").val();
    console.log(userid+" "+password);
    let data = {userid : userid,
                password : password
                };
    $.post("RegisterEvalControllerServlet", data, function(responseText){
        responseText = responseText.trim();
        if(responseText === "yes")
            swal("Admin!", "Evaluator has been successfully registered", "success");
        else
            swal("Failed!", "Some server issue occured. Register again", "error");
    });
}


