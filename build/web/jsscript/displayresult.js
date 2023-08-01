/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function searchstudent()
{
    let roll_no = $("#roll_no").val();
    let name = $("#name").val();
    let data = {roll_no : roll_no,
                name : name
               };
    $.post("RetriveResultControllerServlet", data, (responseText)=>{
        responseText = responseText.trim();
        console.log(responseText);
        if(responseText === "yes"){
            swal("Success", "Fetching student details", "success").then(()=>{
                window.location = "RetriveStudentDetailControllerServlet";
            });
        }
        else
            swal("Failed", "Incorrect roll_no or name. Enter correct details", "error");
    });
}


