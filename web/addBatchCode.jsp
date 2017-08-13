<%-- 
    Document   : addBatchCode
    Created on : 25 Apr, 2017, 12:43:53 AM
    Author     : data1
--%>

<%@page import="java.util.List"%>
<%@page import="com.tarkesh.entity.BatchCodes"%>
<%@page import="com.tarkesh.operation.Operations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″>
        <title>Add Batch Code</title>
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
            document.frm.action = "AddBatchCode";
            document.frm.submit();
            }
            }
        </script>
        <link rel="stylesheet" href="css/design.css" type="text/css"></head>
    <body><center>
        <form name=frm method="post" action="AddBatchCode">
            <table border=”1″>
                <font size=”3″>Add Batch Code</font>
                <tr><td>Batch Code</td>
                    <td><INPUT type="text" name=batchCode value="" size=”24″></td></tr>
                <tr><td>Facebook Group</td>
                    <td><INPUT type="text" name=facebookGroup value="" size=”24″></td>
                </tr>
                <tr><td>Scheduled Day</td>
                    <td><INPUT type="text" name=scheduledDay value="" size=”24″></td>
                </tr>
                <tr><td>Content</td>
                    <td><INPUT type="text" name=content value="" size=”24″></td>
                </tr>
                <tr><td></td><TD> <input type="submit" value="Add"> 
                        <!--<BUTTON type=button value=save name=cmdsave onclick=”save()” >Add</BUTTON>-->
                        <input type="reset" value="Cancel"></form>
                        <form action="editBatchCode.jsp"><input type="submit" value="Edit"></form>
                    </TD>
                </tr>
            </table>
            <table>
                <tr>
                    <th>Batch Code</th>
                    <th>Scheduled Days</th>
                    <th>Content</th>
                    <th>Facebook Group</th>
                    <th>Action to Perform</th>
                </tr>
                <% List<BatchCodes> list1 = com.tarkesh.operation.Operations.getBatchCode();
                    for (BatchCodes u1 : list1) {
            //if((request.getParameter(“cbousername")!=null)&&(request.getParameter(“cbousername").trim().equalsIgnoreCase(u1.getUserID().trim()))){
                %><tr>
                    <td><%=u1.getBatchCode()%> </td><td><%=u1.getScheduledDay()%></td>
                    <td><%=u1.getContent()%></td><td><%=u1.getFacebookGroup()%></td> 
                    <td><a href="editBatchCode.jsp?id=<%=u1.getId()%>">Edit</a></td></tr>
                    <%}
                    %>

                <%/*
                UserDetail udet = new UserDetail();
                List<USERTABLE> mylist=new ArrayList<USERTABLE>();
                USERTABLE e = new USERTABLE();
                mylist=udet.getUserDetails(uid);
                System.out.println(“–size-*"+mylist.size());
                Iterator it=mylist.iterator();
                while(it.hasNext())
                {
                e=USERTABLE)it.next();
                     */
                %>
            </table>

    </center></body>
</html>