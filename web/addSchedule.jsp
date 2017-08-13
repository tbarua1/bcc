<%-- 
    Document   : editBatchCode
    Created on : 25 Apr, 2017, 12:49:29 AM
    Author     : data1
--%>

<%@page import="java.util.List"%>
<%@page import="com.tarkesh.operation.Operations"%>
<%@page import="com.tarkesh.entity.BatchCodes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<script type="text/javascript">
function ValidateForm()
{

if(document.frm.userName.value=="")
{
alert(“Please Enter User Name “);
return false;
}
if(document.frm.userAge.value=="")
{
alert(“Please Enter Age");
return false;
}
if(document.frm.usercellNO.value=="")
{
alert(“Please Enter Cell No");
return false;
}
if(document.frm.userAddress.value=="")
{
alert(“Please Enter Address “);
return false;
}

return true;
}
function save(){
if(!ValidateForm()) return;{
document.frm.action="UpdateUser";
document.frm.submit();
}
}
function onUserName(){
alert(document.frm.cbousername.value);
document.frm.action="edituser.jsp";
document.frm.submit();
}
</script> <link rel="stylesheet" href="css/design.css" type="text/css">
</head>
<body>
<!--<form name=frm method="post">
<table border="1">
<THEAD>
<tr><td colspan="7" align="center"><font size="3">Update User Details</font></td>
</tr>
</THEAD>
<tr><TD><B>User Name</B></TD>-->
<table>
    <% List<BatchCodes> list1=com.tarkesh.operation.Operations.getBatchCode();
for (BatchCodes u1 : list1) {
//if((request.getParameter(“cbousername")!=null)&&(request.getParameter(“cbousername").trim().equalsIgnoreCase(u1.getUserID().trim()))){
%><tr>
<td><%=u1.getBatchCode()%> </td><td><%=u1.getScheduledDay()%></td>
<td><%=u1.getContent()%></td><td><%=u1.getFacebookGroup()%></td></tr>
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
<tr><td>Name</td>

</table>
</form>
</body>
</html>