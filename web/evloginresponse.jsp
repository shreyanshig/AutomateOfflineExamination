<%
    String userid = (String)request.getAttribute("userid");
    boolean result = (boolean)request.getAttribute("result");
    if(userid != null){
        HttpSession sess = request.getSession();
        sess.setAttribute("userid", userid);
        String url = "";
        if(result == true){
            url = "EVAppMainPage.html;jsessionid="+sess.getId();
            System.out.println("loginresponse.jsp"+" "+"result is"+result);
        }
        else{
//            int num = (int)request.getAttribute("num");
//            if(num > 5)
//                url = "exceeded";
              url = "error";
        }
        out.println(url);
    }
    else{
        out.println("error");
    }
%>
