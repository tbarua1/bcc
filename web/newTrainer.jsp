<%-- 
    Document   : addTrainer
    Created on : 26 Apr, 2017, 8:07:24 PM
    Author     : data1
--%>

<%@page import="com.tarkesh.entity.Trainer"%>
<%@page import="com.tarkesh.operation.Operations"%>
<%@page import="java.util.List"%>
<%@page import="com.tarkesh.entity.BatchCodes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″>
        <title>Add Trainer</title>
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
            document.frm.action = "AddTrainer";
            document.frm.submit();
            }
            }
        </script> <link rel="stylesheet" href="css/design.css" type="text/css">
    </head>
    <body><center>
        <form name=frm method="post" action="AddTrainer" enctype="multipart/form-data">
            <table border=”1″>
                <font size=”3″>Add Batch Schedule</font>
                <tr><td>Skype ID</td>
                    <td><INPUT type=”text” name=skypeid value="" size=”24″></td></tr>
                <tr><td>Email ID</td>
                    <td><INPUT type=”text” name=email value="" size=”24″></td>
                </tr>
                <tr><td>Experience</td>
                    <td><INPUT type=”text” name=experience value="" size=”24″></td>
                </tr>
                <tr><td>Mobile</td>
                    <td><INPUT type=”text” name=mobile value="" size=”24″></td>
                </tr>
                <tr><td>Whats App Number</td>
                    <td><INPUT type=”text” name=whatsapp value="" size=”24″></td>
                </tr>
                <tr><td>Trainer Name</td>
                    <td><INPUT type=”text” name=name value="" size=”24″></td>
                </tr>
                <tr>
                    <td>Nationality</td>
                    <td>
                        <select name="nationality">
                            <option value="Indian" selected="">Indian</option>
                            <option value="Bangladeshi">Bangladeshi</option>
                        </select>
                        <!--<INPUT type=”text” name=nationality value="" size=”24″>-->
                    </td>
                </tr>
                <tr><td>Qualification</td>
                    <td><INPUT type=”text” name=qualification value="" size=”24″></td>
                </tr>
                <tr><td>Skillset</td>
                    <td><INPUT type=”text” name=skillset value="" size=”24″></td>
                </tr>
                <tr><td>Photo</td>
                    <td><INPUT type="file" name=photo size=”24″></td>
                </tr>   
                <tr><td></td><TD> <input type="submit" value="Add"> 
                        <!--<BUTTON type=button value=save name=cmdsave onclick=”save()” >Add</BUTTON>-->
                        <input type="reset" value="Cancel"></form>
                        <form action="editBatchCode.jsp"><input type="submit" value="Edit"></form>
                    </TD>
                </tr>
            </table>           
    </center>
</body>
</html>