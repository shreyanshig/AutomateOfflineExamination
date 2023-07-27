/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function uploadmarks()
{
    let marks = $("#marksfield").val();
    if(validate(marks) === false){
        swal("Failed", "Please enter valid marks", "error");
        return;
    }
    console.log("validated");
    let data = {marks : marks};
    console.log(marks);
    $.post("UploadMarksControllerServlet", data, processResponse);
}
function processResponse(responseText)
{
    console.log("sending the marks");
    responseText = responseText.trim();
    if(responseText === "yes"){
            swal("Success", "Marks have been successfully uploaded", "success").then(()=>{
                window.location = "EVAppMainPage.html";
            });
    }
    else
            swal("Failed", "Could not upload marks due to server issue. Re-upload the marks", "error");
}
function validate(marks)
{
    marks = marks.trim();
    if(marks === "")
        return false;
    for(let i=0; i<marks.length; i++){
        if(!(marks[i] >= '0' && marks[i] <= '9'))
            return false;
    }
    return true;
}


