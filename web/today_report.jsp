<%-- 
    Document   : DAR
    Created on : 18 May, 2017, 2:39:51 PM
    Author     : Abhishek.Sehgal
--%>

<%@page import="com.tarkesh.entity.BatchSchedule"%>
<%@page import="java.util.List"%>
<%@page import="com.tarkesh.entity.Trainer"%>
<%@page import="com.tarkesh.operation.Operations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type=”text/javascript”>
            function ValidateForm()
            {

            if (document.frm.userName.value == ””)
            {
            alert(“Please Enter User Name “);
            return false;
            }
            if (document.frm.userAge.value == ””)
            {
            alert(“Please Enter Age”);
            return false;
            }
            if (document.frm.usercellNO.value == ””)
            {
            alert(“Please Enter Cell No”);
            return false;
            }
            if (document.frm.userAddress.value == ””)
            {
            alert(“Please Enter Address “);
            return false;
            }

            return true;
            }
            function save(){

            if (!ValidateForm()) return; {
            document.frm.action = "getDAR";
            document.frm.submit();
            }
            }
        </script> <link rel="stylesheet" href="css/design.css" type="text/css">
    </head>
    <body>
        <h1>Daily Activity Report Generator</h1>
         <% 
                            List<Trainer> trainerList = com.tarkesh.operation.Operations.getBatchTrainer();
                            for(Trainer university:trainerList){
                            %>
                            <option value="<%=university.getName()%>"><%=university.getName()%></option>
                            <%
                            }
                            %>  
        
        <table>
            <tr><td>Trainer</td>
                   
                </tr>
                <tr><td></td><TD> 
                        <!--<BUTTON type=button value=save name=cmdsave onclick=”save()” >Add</BUTTON>-->
                       
                    </TD>
                </tr>
        </table>
        </form>
    </body>
</html>
