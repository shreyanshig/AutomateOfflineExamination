/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var userid , password;
function ivappsignin()
{
    username = $("#ivuname").val();
    password = $("#password").val();
    if(validate() === false){
        swal("Access denied!", "All fields are mandatory", "error");
        return;
    }
    let data = {username : username,
                password : password
            };
    let xhr = $.post("LoginControllerServlet", data, processResponse);
    xhr.fail(handleError);
    
}
function validate()
{
    if(userid === "" || password === ""){
        swal("Access denied!", "All fields are mandatory", "error");
        return false;
    }
    return true;
}
function handleError(xhr)
{
    swal("Error!","Problem in server communication: "+xhr.statusText, "error");
}
function processResponse(responseText, textStatus, xhr)
{
    let result = responseText.trim();
    if(result === "error"){
        swal("Access denied!", "Invalid userid / password", "error");
    }
    else if(result === "exceeded"){
        swal("Failed!", "You have entered wrong password 5 times in a row.You have been blocked! Contact the admin to\
              unblock your Credentials", "error");
    }
    else if(result.indexOf("jsessionid") !== -1){
        let pr = swal("Sucees", "Login Successful", "success");
        pr.then( (value) => {
            window.location = result;   //here, it will run only after swal()is completed because promises are synchronized
        });
    }
    else{
        swal("Access denied", "Some problem in the server occured:"+responseText, "error");
    }
}function evappsignin()
{
    username = $("#evname").val();
    password = $("#evpassword").val();
    if(validate() === false){
        swal("Access denied!", "All fields are mandatory", "error");
        return;
    }
    let data = {username : username,
                password : password
               };
    let xhr = $.post("EVLoginControllerServlet", data, processResponse);
    xhr.fail(handleError);
    
}



