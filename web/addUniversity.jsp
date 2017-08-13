<%-- 
    Document   : addUniversity
    Created on : 26 Apr, 2017, 8:09:01 PM
    Author     : data1
--%>

<%@page import="com.tarkesh.entity.University"%>
<%@page import="com.tarkesh.operation.Operations"%>
<%@page import="java.util.List"%>
<%@page import="com.tarkesh.entity.BatchCodes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″>
        <title>Add University</title>
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
        </script> <link rel="stylesheet" href="css/design.css" type="text/css">
    </head>
    <body><center>
        <form name=frm method="post" action="OneTimeUniversityAdd">
            <table border=”1″>
                <font size=”3″>Add University</font>
                <tr><td>Division</td>
                    <td><select name="division">
                            <option value="Barisal">Barisal</option>
                            <option value="Chittagong">Chittagong</option>
                            <option value="Dhaka">Dhaka</option>
                            <option value="Khulna">Khulna</option>
                            <option value="Rajshahi">Rajshahi</option>
                            <option value="Rangpur">Rangpur</option>
                            <option value="Sylhet">Sylhet</option>
                        </select></td></tr>
                <tr><td>University Name</td>
                    <td><INPUT type="text" name="name" value="" size=”24″></td>
                </tr>
                <tr><td>Latitude</td>
                    <td><INPUT type="text" name="latitute" value="" size=”24″></td>
                </tr>
                <tr><td>Longitude</td>
                    <td><INPUT type="text" name="longitute" value="" size=”24″></td>
                </tr>
                <tr><td></td><TD> <input type="submit" value="Add"> 
                        <!--<BUTTON type=button value=save name=cmdsave onclick=”save()” >Add</BUTTON>-->
                        <input type="reset" value="Cancel"></form>
                        <form action="editBatchCode.jsp"><input type="submit" value="Edit"></form>
                    </TD>
                </tr>
            </table>
            <table>
                <% List<University> universityList = com.tarkesh.operation.Operations.getUniversity();
                    for (University u1 : universityList) {
                //if((request.getParameter(“cbousername")!=null)&&(request.getParameter(“cbousername").trim().equalsIgnoreCase(u1.getUserID().trim()))){
                %><tr>
                    <td><%=u1.getUniversity_type()%> </td><td><%=u1.getDivision()%> </td><td><%=u1.getLatitude()%></td>
                    <td><%=u1.getLongitude()%></td><td><%=u1.getName()%></td></tr>
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