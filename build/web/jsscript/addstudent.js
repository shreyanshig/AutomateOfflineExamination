/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    <tr><th><input type='button' value='Add Student' onclick='addstudent()' id='addsdt'></th>\
    <th><input type='reset' value='Clear' onclick='clearText()'></th></tr></table></form>"+
    "<br><span id='addresp'></span>";
    var addcand = $("#result")[0];
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
    data.append("roll_no", roll_no);
    data.append("sname", sname);
    data.append("class", grade);
    data.append("board", board);
    data.append("centerid", centerid);
    data.append("school", school);
    data.append("fname", fname);
    data.append("sname", sname);
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


