<%-- 
    Document   : editTrainer
    Created on : Aug 13, 2017, 3:45:11 AM
    Author     : tarkeshwar
--%>

<%@page import="com.tarkesh.operation.Operations"%>
<%@page import="com.tarkesh.entity.Trainer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Trainer Update</h1>
         <table border="1">
            <form name=frm method="post" action="TrainerUpdate">           
                <font size="3">Add Batch Code</font>
                <tr>
                    <td>Skype Id</td>
                    <td><%Long id = Long.parseLong(request.getParameter("id"));
                        Trainer code = Operations.getTrainerById(id);                    
                        %>
                        <INPUT type="text" name="skype" value="<%=code.getSkype()%>" size="24"></td></tr>
                <input type="text" name="id" value="<%=id%>" hidden="">
                 <tr>
                    <td>Name</td>
                    <td><INPUT type="text" name="name" value="<%=code.getName()%>" size="24"></td>
                </tr>
                 <tr>
                    <td>Email</td>
                    <td><INPUT type="text" name="email" value="<%=code.getEmailid()%>" size="24"></td>
                </tr>
                 <tr>
                    <td>Experience</td>
                    <td><INPUT type="text" name="experience" value="<%=code.getExperience()%>" size="24"></td>
                </tr>
                 <tr>
                    <td>Nationality</td>
                    <td><INPUT type="text" name="nationality" value="<%=code.getNatianality()%>" size="24"></td>
                </tr>
                 <tr>
                    <td>Skill Set </td>
                    <td><INPUT type="text" name="skillset" value="<%=code.getSkillset()%>" size="24"></td>
                </tr>
                <tr>
                    <td>Mobile</td>
                    <td><INPUT type="text" name="mobile" value="<%=code.getMobile()%>" size="24"></td>
                </tr>
                <tr>
                    <td>Whats App</td>
                    <td><INPUT type="text" name="whatsapp" value="<%=code.getWhatsapp()%>" size="24"></td>
                </tr>
                <tr><td>Qualification</td>
                    <td><INPUT type="text" name="qualification" value="<%=code.getQualification()%>" size="24"></td>
                </tr>
                <tr>
                    <td></td>
                    <TD> <input type="submit" value="Update"> </TD>
                </tr>
            </form>
        </table>
    </body>
</html>
