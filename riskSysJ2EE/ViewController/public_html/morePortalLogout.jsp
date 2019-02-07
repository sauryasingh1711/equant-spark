<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>
        <%         
            session = request.getSession();
            String username="Guest";
            if (!session.equals(null)) {
                username=(String) session.getAttribute("moreUser"); 
                session.removeAttribute("moreUser"); 
                session.removeAttribute("morePassword"); 
            }
             
            session.invalidate(); 
            response.sendRedirect("morePortalWelcome.html"); 
            
        %>
        <h2> See you again. < <%= username %> > </h2>
                
    </body>
</html>