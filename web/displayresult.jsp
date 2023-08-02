<%-- 
    Document   : displayresult
    Created on : 1 Aug, 2023, 10:15:13 AM
    Author     : Shreyanshi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map, dao.AdminDAO, java.util.LinkedHashMap, dto.StudentDetails"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script src="jsscript/jquery.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="stylesheet/showresult.css"/>
        <script src="jsscript/displayresult.js"></script>
        <title>Show Student Details</title>;
    </head>
    <body>
<%
            String userid=(String)session.getAttribute("userid");
            if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
            String roll_no = (String)session.getAttribute("roll_no");
            StudentDetails student = (StudentDetails)request.getAttribute("details");
            LinkedHashMap<String, Float> hm = (LinkedHashMap)request.getAttribute("marks");
            if(hm.size() == 0){
                out.println("<div class='resultdiv'>Results have yet not been declared</div>");
                return;
            }
            StringBuffer displayBlock=new StringBuffer("");
            displayBlock.append("<div class='sticky'><div class='student'>Admin Page</div>");
            displayBlock.append("<div class='logout' onclick='logout()'><p>logout</p></div></div><br><br>");
            displayBlock.append("<div id='container'>");
            displayBlock.append("<img src='data:image/jpg;base64,"+student.getPhoto()+"' style='width:200px;height:200px;' id='img'/><br><br>");
            displayBlock.append("<table width='100%' id='t1'>");
            displayBlock.append("<tr><th>Roll No :</th><td>"+student.getRoll_no()+"</td>");
            displayBlock.append("<th>Name :</th><td>"+student.getName()+"</td>");
            displayBlock.append("<th>Class :</th><td>"+student.getGrade()+"</td>");
            displayBlock.append("<th>Board :</th><td>"+student.getBoard()+"</td></tr>");
            displayBlock.append("<tr><th>Center Id :</th><td>"+student.getCenter_id()+"</td>");
            displayBlock.append("<th>School :</th><td>"+student.getSchool()+"</td>");
            displayBlock.append("<th>Father Name :</th><td>"+student.getFather_name()+"</td>");
            displayBlock.append("<th>Mother Name :</th><td>"+student.getMother_name()+"</td></tr>");
            displayBlock.append("</table></div><br><br>");
            displayBlock.append("<div><table width='100%' id='t2'>");
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
            displayBlock.append("<tr><th colspan=2>Percentage</th><td colspan=2>"+(total/5)+"</td></tr>");
            if(total >= 33)
                displayBlock.append("<tr><th colspan=2>Result</th><td colspan=2><span style='color:green; font-weight:bold'>Pass</span></td></tr>");
            else
                displayBlock.append("<tr><th colspan=2>Result</th><td colspan=2><span style='color:red; font-weight:bold'>Fail</span></td></tr>");
            displayBlock.append("</table></div>");
            out.println(displayBlock.toString());
%>
    </body>
</html>