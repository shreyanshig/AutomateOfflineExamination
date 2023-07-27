<%-- 
    Document   : evshowresult
    Created on : 27 Jul, 2023, 6:50:39 AM
    Author     : Shreyanshi
--%>

<%@page import="dto.EVStudentDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EV App Page</title>
        <script src="jsscript/evshowresult.js"></script>
        <script src="jsscript/jquery.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <%
            String userid=(String)session.getAttribute("userid");
            if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
            String roll_no = (String)request.getAttribute("roll_no");
            EVStudentDTO student = (EVStudentDTO)request.getAttribute("student");
            StringBuffer displayBlock = new StringBuffer();
            displayBlock.append("<div class='sticky'><div class='student'>EV App</div><br>"+
                                    "<div class='subcandidate'>Student details and marks allocation page</div><br><br>");
            displayBlock.append("<div class='logout'><a href='login.html'>logout</a></div></div>");
            displayBlock.append("<div class='container'>");
            displayBlock.append("<img src='data:image/jpg;base64,"+student.getPhoto()+"' style='width:300px;height:200px;'/>");
            displayBlock.append("<table>");
            displayBlock.append("<tr><th>Subject :</th><td>"+student.getSubject()+"</td></tr>");
            displayBlock.append("<tr><th>Board :</th><td>"+student.getBoard()+"</td></tr>");
            displayBlock.append("</table></div>");
            displayBlock.append("<input type='text' placeholder='Fill Marks' id='marksfield'/><br>");
            displayBlock.append("<input type='submit' value='Upload Marks' id='btn' onclick='uploadmarks()'/>");
            out.println(displayBlock.toString());
        %>
    </body>
</html>
