/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.addEventListener("load", ()=>{
    showstudentform();
});
function showstudentform()
{
    removecandidateForm();
    var newdiv = document.createElement("div");
    newdiv.setAttribute("id", "studentform");
    newdiv.setAttribute("float", "left");
    newdiv.setAttribute("padding-left", "12px");
    newdiv.setAttribute("border", "solid 2px red");
    newdiv.innerHTML = "<h3> Add new student</h3>";
    newdiv.innerHTML = newdiv.innerHTML+"<form method='Post' enctype='multipart/form-data' id='fileUploadForm' name='studentform'>\n\
    <table><tr><th>Roll No:</th><td><input type='text' id='roll_no'></td></tr>\n\
    <tr><th>Student Name :</th><td><input type='text' id='sname'></td></tr>\n\
    <tr><th>Class</th><td><select id='class'><option value='10'>10</option><option value='12'>12</option></select></td></tr>\
    <tr><th>Board :</th><td><select id='board'><option value='cbse'>CBSE</option><option value='mp'>MP Board</option>\
    <option value='icse'>ICSE</option><option value='up'>UP Board</option><option value='ib'>IB Board</option>n\
    <option value='nios'>NIOS Board</option><option value='aissce'>AISSCE</option></select></td></tr>\
    <tr><th>Center Id :</th><td><input type='text' id='centerid'></td></tr>\
    <tr><th>School :</th><td><input type='text' id='school'></td></tr>\
    <tr><th>Father Name :</th><td><input type='text' id='fname'></td></tr>\
    <tr><th>Mother Name :</th><td><input type='text' id='mname'></td></tr>\
    <tr><td colspan='2'><input type='file' name ='files' value='Select Student Photo'></td></tr>\
    <tr><th><input type='text' placeholder='Subject 1' id='s1'/></th><td><input type='text' placeholder='date (dd-mm-yyyy)' id='d1'/></td></tr>\
    <tr><th><input type='text' placeholder='Subject 2' id='s2'/></th><td><input type='text' placeholder='date (dd-mm-yyyy)' id='d2'/></td></tr>\
    <tr><th><input type='text' placeholder='Subject 3' id='s3'/></th><td><input type='text' placeholder='date (dd-mm-yyyy)' id='d3'/></td></tr>\
    <tr><th><input type='text' placeholder='Subject 4' id='s4'/></th><td><input type='text' placeholder='date (dd-mm-yyyy)' id='d4'/></td></tr>\
    <tr><th><input type='text' placeholder='Subject 5' id='s5'/></th><td><input type='text' placeholder='date (dd-mm-yyyy)' id='d5'/></td></tr>\
    <tr><th><input type='button' value='Add Student' onclick='addstudent()' id='addsdt'></th>\
    <th><input type='reset' value='Clear' onclick='clearText()'></th></tr>\</table></form>"+"<br><span id='addresp'></span>";
    var addcand = $(".sign-up-form")[0];
    addcand.appendChild(newdiv);
    $("#studentform").hide();
    $("#studentform").fadeIn(3500);
}
function clearText()
{
    $("#addresp").html("");
}
function addstudent()
{
    let form = $("#fileUploadForm")[0];
    let data = new FormData(form);
    alert(data);
    let roll_no = $("#roll_no").val();
    let sname = $("#sname").val();
    let grade = $("#class").val();
    let board = $("#board").val();
    let centerid = $("#centerid").val();
    let school = $("#school").val();
    let fname = $("#fname").val();
    let mname = $("#mname").val();
    let s1 = $("#s1").val();
    let d1 = $("#d1").val();
    let s2 = $("#s2").val();
    let d2 = $("#d2").val();
    let s3 = $("#s3").val();
    let d3 = $("#d3").val();
    let s4 = $("#s4").val();
    let d4 = $("#d4").val();
    let s5 = $("#s5").val();
    let d5 = $("#d5").val();
    data.append("roll_no", roll_no);
    data.append("sname", sname);
    data.append("class", grade);
    data.append("board", board);
    data.append("centerid", centerid);
    data.append("school", school);
    data.append("fname", fname);
    data.append("mname", mname);
    data.append("s1", s1);
    data.append("d1", d1);
    data.append("s2", s2);
    data.append("d2", d2);
    data.append("s3", s3);
    data.append("d3", d3);
    data.append("s4", s4);
    data.append("d4", d4);
    data.append("s5", s5);
    data.append("d5", d5);
    $.ajax({
        type : "POST",
        enctype : 'multipart/form-data',
        url : "AddNewStudentControllerServlet",
        data : data,
        processData : false,
        contentType : false,
        cache : false,
        timeout : 600000,
        success : function(data){
            let str = data + ".....";
            swal("Admin!", "Student has been successfully Registered", "success").then((value) =>{
                showstudentform();
            });
        },
        error : function(e){
            swal("Admin!", e, "error");
        }
    });
}
function removecandidateForm()
{
    let contdiv = document.getElementById("result");
    let formdiv = document.getElementById("studentform");
    if(formdiv !== null){
        contdiv.removeChild(formdiv);
        $("#studentform").fadeOut("3500");
    }
}


