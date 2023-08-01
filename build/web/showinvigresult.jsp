<%
    String userid = (String)session.getAttribute("userid");
    if(userid == null){
        session.invalidate();
        response.sendRedirect("accessdenied.jsp");
        return;
    }
    boolean result = (boolean)request.getAttribute("result");
    if(result == true)
        out.println("yes");
    else
        out.println("no");
%>
