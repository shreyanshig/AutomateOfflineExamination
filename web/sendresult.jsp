<%
    String userid=(String)session.getAttribute("userid");
    if(userid==null)
    {
        response.sendRedirect("accessdenied.html");
        return;
    }
    boolean result = (boolean)request.getAttribute("result");
    if(result)
        out.println("yes");
    else
        out.println("no");
%>
