<%
            String userid=(String)session.getAttribute("userid");
            if(userid == null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }
            String result = (String)request.getAttribute("result");
            System.out.println("result is "+result);
            if(result.equals("no") == false)
                out.println("yes");
            else
                out.println("no");
%>
