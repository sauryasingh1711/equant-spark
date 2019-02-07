<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>
        <%           
            String username=request.getParameter("moreUser"); 
            String password=request.getParameter("morePassword"); 
            
            //if ( (!username.equals(null)) && (password.equals(null)) )                      
                if((username.equals("user1") && password.equals("user1"))) 
                        
            { 
                session = request.getSession(true);                
                session.setAttribute("moreUser",username); 
                response.sendRedirect("morePortalHome.jsp"); 
                
                //session = request.getSession();
                //String name = (String) session.getAttribute("name");
                                
            } 
            
            response.sendRedirect("morePortalLoginFailure.html"); 
            
        %>
        <h2> HELLO <%= username %> </h2>
                
    </body>
</html>
