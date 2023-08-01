/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
console.log($("#opt1"));
document.getElementById("opt1").addEventListener("click", (event)=>{
    window.location = "addstudentintodb.html";
});
document.getElementById("opt2").addEventListener("click", (event)=>{
    window.location = "addinvigilatorcred.html";
});

document.getElementById("opt3").addEventListener("click", (event)=>{
    window.location = "addevaluatorcred.html";
});

document.getElementById("opt4").addEventListener("click", (event)=>{
    window.location = "displayresult.html";
});


