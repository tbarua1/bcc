<%-- 
    Document   : editBatchCode
    Created on : 12 Aug, 2017, 11:35:14 PM
    Author     : Abhishek.Sehgal
--%>

<%@page import="com.tarkesh.entity.BatchCodes"%>
<%@page import="com.tarkesh.daoImp.BatchCodeImp"%>
<%@page import="com.tarkesh.dao.BatchCodedao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>BatchCode Editor</h1>
        <table border="1">
            <form name=frm method="post" action="BatchCodeController">           
                <font size="3">Add Batch Code</font>
                <tr>
                    <td>Batch Code</td>
                    <td><%Long id = Long.parseLong(request.getParameter("id"));
                        BatchCodedao batchCodedao = new BatchCodeImp();
                        BatchCodes code = batchCodedao.getRecord(id);
                        %>
                        <INPUT type="text" name="batchCode" value="<%=code.getBatchCode()%>" size="24"></td></tr>
                <input type="text" name="id" value="<%=id%>" hidden="">
                <tr>
                    <td>Facebook Group</td>
                    <td><INPUT type="text" name="facebookGroup" value="<%=code.getFacebookGroup()%>" size="24"></td>
                </tr>
                <tr>
                    <td>Scheduled Day</td>
                    <td><INPUT type="text" name="scheduledDay" value="<%=code.getScheduledDay()%>" size="24"></td>
                </tr>
                <tr><td>Content</td>
                    <td><INPUT type="text" name="content" value="<%=code.getContent()%>" size="24"></td>
                </tr>
                <tr>
                    <td></td>
                    <TD> <input type="submit" value="Submit"> </TD>
                </tr>
            </form>
        </table>
    </body>
</html>
