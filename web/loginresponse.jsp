<%-- 
    Document   : loginresponse
    Created on : 20 Jul, 2023, 4:20:40 PM
    Author     : Shreyanshi
--%>

<%@page import="dao.IVAppDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userid = (String)request.getAttribute("userid");
    boolean result = (boolean)request.getAttribute("result");
    if(userid != null){
        HttpSession sess = request.getSession();
        sess.setAttribute("userid", userid);
        String url = "";
        String incorrectCred = (String)request.getAttribute("incorrectCred");
        System.out.println(incorrectCred);
        if(incorrectCred != null && incorrectCred.equals("yes"))
            url = "exceeded";
        else if(result == true){
            url = "IVAdmitCardScan.html;jsessionid="+sess.getId();
            System.out.println("loginresponse.jsp"+" "+"result is"+result);
        }
        else{
            url = "error";
        }
        out.println(url);
    }
    else{
        out.println("error");
    }
%>
