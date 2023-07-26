<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="jsscript/jquery.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="jsscript/studentdetails.js"></script>
        <title>Show Student Details</title>
    </head>
    <body>
<%@page import="dto.StudentDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            String userid=(String)session.getAttribute("userid");
            if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
            String roll_no = (String)request.getAttribute("roll_no");
            StudentDetails student = (StudentDetails)request.getAttribute("details");
            String subject = (String)request.getAttribute("subject");
            boolean isSubjectPresent = (boolean)request.getAttribute("isSubjectPresent");
            StringBuffer displayBlock=new StringBuffer("");
            displayBlock.append("<div class='sticky'><div class='student'>IV App</div><br>"+
                                    "<div class='subcandidate'>Student Details Page</div><br><br>");
            displayBlock.append("<div class='logout'><a href='login.html'>logout</a></div></div>");
            displayBlock.append("<div class='container'>");
            displayBlock.append("<img src='data:image/jpg;base64,"+student.getPhoto()+"' style='width:300px;height:200px;'/>");
            displayBlock.append("<table>");
            displayBlock.append("<tr><th>Roll No :</th><td>"+student.getRoll_no()+"</td></tr>");
            displayBlock.append("<tr><th>Name :</th><td>"+student.getName()+"</td></tr>");
            displayBlock.append("<tr><th>Class :</th><td>"+student.getGrade()+"</td></tr>");
            displayBlock.append("<tr><th>Board :</th><td>"+student.getBoard()+"</td></tr>");
            displayBlock.append("<tr><th>Center Id :</th><td>"+student.getCenter_id()+"</td></tr>");
            displayBlock.append("<tr><th>School :</th><td>"+student.getSchool()+"</td></tr>");
            displayBlock.append("<tr><th>Father Name :</th><td>"+student.getFather_name()+"</td></tr>");
            displayBlock.append("<tr><th>Mother Name :</th><td>"+student.getMother_name()+"</td></tr>");
            if(subject.equals("no")){
                displayBlock.append("<script>swal('Failed', 'You have no exam today!', 'error');</script>");
                displayBlock.append("<tr><th></th><td><a href='IVAdmitCardScan.html'>Click here to Scan Other Student</a></td></tr>");
            }
            else if(subject.equals("no") == false && isSubjectPresent == true){
                displayBlock.append("<script>swal('Failed', 'You have already appeared in this exam', 'error');</script>");
                displayBlock.append("<tr><th></th><td><a href='IVAdmitCardScan.html'>Click here to Scan Other Student</a></td></tr>");
            }
            else{
                displayBlock.append("<tr><th>Subject :</th><td>"+subject+"</td></tr>");
                displayBlock.append("<tr><th></th><td><input type='button' onclick='saveattendance()' value='Attach Sheet'/></td></tr>");
            }
            displayBlock.append("</table></div>");
            displayBlock.append("<div><input type='button' class='attsheet'onclick='takebiometric()' style='visibility:hidden' value='Verify'/></div>");
            out.println(displayBlock.toString());
%>
    </body>
</httml>
