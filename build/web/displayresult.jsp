<%-- 
    Document   : displayresult
    Created on : 1 Aug, 2023, 10:15:13 AM
    Author     : Shreyanshi
--%>
<%@page import="java.util.Map"%>
<%@page import="dao.AdminDAO"%>
<%@page import="java.util.LinkedHashMap"%>
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
            String roll_no = (String)session.getAttribute("roll_no");
            StudentDetails student = (StudentDetails)request.getAttribute("details");
            LinkedHashMap<String, Float> hm = (LinkedHashMap)AdminDAO.getMarksByRoll_no(roll_no);
            StringBuffer displayBlock=new StringBuffer("");
            displayBlock.append("<div class='sticky'><div class='student'>IV App</div><br>"+
                                    "<div class='subcandidate'>Student Details Page</div><br><br>");
            displayBlock.append("<div class='logout'><a href='login.html'>logout</a></div></div>");
            displayBlock.append("<div class='container'>");
            displayBlock.append("<table width='100%'>");
            displayBlock.append("<tr><th><img src='data:image/jpg;base64,"+student.getPhoto()+"' style='width:200px;height:200px;'/></th></tr>");
            displayBlock.append("<tr><th>Roll No :</th><td>"+student.getRoll_no()+"</td>");
            displayBlock.append("<th>Name :</th><td>"+student.getName()+"</td>");
            displayBlock.append("<th>Class :</th><td>"+student.getGrade()+"</td>");
            displayBlock.append("<th>Board :</th><td>"+student.getBoard()+"</td></tr>");
            displayBlock.append("<tr><th>Center Id :</th><td>"+student.getCenter_id()+"</td>");
            displayBlock.append("<th>School :</th><td>"+student.getSchool()+"</td>");
            displayBlock.append("<th>Father Name :</th><td>"+student.getFather_name()+"</td>");
            displayBlock.append("<th>Mother Name :</th><td>"+student.getMother_name()+"</td></tr>");
            displayBlock.append("</table></div>");
            displayBlock.append("<div><table width='100%'>");
            displayBlock.append("<tr><th>S no.</th><th>Subject</th><th>Marks Obtained</th><th>Total Marks</th></tr>");
            int a = 1;
            float total = 0.0f;
            for(Map.Entry m : hm.entrySet())
            {
                String subject = (String)m.getKey();
                float marks = (float)m.getValue();
                displayBlock.append("<tr><td>"+a+"</td><td>"+subject+"</td><td>"+marks+"</td><td>100</td></tr>");
                a++;
                total += marks;
            }
            displayBlock.append("<tr><th>Percentage</th><td>"+(total/5)+"</td></tr>");
            String result = "";
            if(total >= 33)
                result = "Pass";
            else
                result = "Fail";
            displayBlock.append("<tr><th>Result</th><td>"+result+"</td></tr>");
            displayBlock.append("</table></div>");
            out.println(displayBlock.toString());
%>
    </body>
</html>