/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function saveattendance()
{
    let div = document.querySelector(".attsheet");
    div.style.visibility = "visible";
}
function takebiometric()
{
    swal("Success","Keep the student finger on the fingerprint sensor", "success").then(()=>{
        setTimeout(() =>{
            swal("Student!","Biometric Scanned Successfully!", "success").then(value => {
                window.location = "IVAnswerSheetScan.html";
            });
        }, 3000);
    });      
}


