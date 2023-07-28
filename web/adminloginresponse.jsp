<%-- 
    Document   : adminloginresponse
    Created on : 28 Jul, 2023, 8:14:12 AM
    Author     : Shreyanshi
--%>

<%
    String userid = (String)request.getAttribute("userid");
    boolean result = (boolean)request.getAttribute("result");
    if(userid != null){
        HttpSession sess = request.getSession();
        sess.setAttribute("userid", userid);
        String url = "";
        if(result == true){
            url = "Adminactions.html;jsessionid="+sess.getId();
            System.out.println("adminloginresponse.jsp"+" "+"result is"+result);
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
