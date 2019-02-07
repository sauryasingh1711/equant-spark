<!DOCTYPE html>
   <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
        <title>MoRE Portal</title>
        
    </head>
    <body style="border-color:Gray;">
        <table width="914" height="78">
            <tr>
                <th width="200">
                    <img src="moreTemplates/logo_finanz.gif" height="113" width="197"/>
                </th>
                <th width="708"
                    style="font-size:xx-large; color:Black; background-color:ThreeDFace; font-stretch:condensed;">
                     MoRE System 
                    <abbr>
                        <mark></mark>
                    </abbr>
                    <p style="color:Black; font-size:large">                         
                        Spark based Enterprise System for Strategy and Risk-Controlling  </p>
                </th>
            </tr>
        </table>
        <table width="913" height="49" style="background-color:InfoBackground;">
        
         <tr>           
                <th style="text-align:left;font-size:small; color:Black;">                    
                    &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    <a rel="stylesheet" media="screen" href="morePortalHome.jsp" type="text/css">Home</a>  &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    <a rel="stylesheet" media="screen" href="SummitInformationSystem.jsp" type="text/css">Summit-Services</a> &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    <a rel="stylesheet" media="screen" href="MoREInformationSystem.jsp" type="text/css">MoRE-Services</a> &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    <a rel="stylesheet" media="screen" href="MoRESystem.jsp" type="text/css">MoRE-Apps</a>  &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    <a rel="stylesheet" media="screen" href="morePortalLogout.jsp" type="text/css">Logout</a> &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
                    &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;                    
                </th>
            </tr>
        </table>
        <table width="913" height="614">
             <tr>
                <th style="color:WindowText; text-align:center; border-color:Gray; background-color:InfoBackground; vertical-align:top;"
                    width="148">
                    <br/>
                    <a rel="stylesheet" media="screen" href="DFAInformationSystem.jsp" type="text/css">DFA-Info-System</a>
                </th>
                
                <th width="757" style="text-align:center; alignment-adjust:auto; vertical-align:top;">
                    
                    <a rel="stylesheet" media="screen" href="morePortalWelcomeBody.html" type="text/css">
                        <br/><br/><br/>                            
                        </a>
                       
                       
                          <h2>MoRE-Services </h2>
                        <br/>
                        <br/>
                        
                        <h3> <a rel="stylesheet" media="screen" href="MoRERefTrades.jsp" type="text/css">MoRE - Reference Portfolio</a> </h3>
                        <br/>
                        <h3> <a rel="stylesheet" media="screen" href="MoREBMBondTrades.jsp" type="text/css">MoRE - Benchmark Bond Portfolio</a> </h3>
                        <br/>
                        <h3> <a rel="stylesheet" media="screen" href="MoREBMSwapTrades.jsp" type="text/css">MoRE - Benchmark Swap Portfolio</a> </h3>
                        <br/>
                                                     
                        <br/>                                                
                        <br/>
                        
                </th>                    
             </tr>
        </table>
        <br/>
        <table width="913" height="38"
               style="font-style:italic; text-align:center; column-rule-color:InactiveCaption; color:Orange;">
             
            <tr>
                <th style="text-align:center; column-rule-color:GrayText; color:Maroon; column-rule-style:dotted; background-color:InactiveCaption; border-color:black;">
                    Copyright 2014 BRD Finazagentur, [ Proof of Concept - MoRE, V1_2014 ]
                </th>
            </tr>  
        
        </table>
        <%  
            session = request.getSession();
            String moreusername="Guest";
            if (!session.equals(null)) { 
                moreusername=(String) session.getAttribute("moreUser");                                                    
            } 
        %>
        <th style="font-size:small; color:Blue; text-align:right;"> 
        &#160;&#160;&#160;&#160;
        (<%=moreusername %>) session:(<%=session %>) </th>  
    </body>
</html>

