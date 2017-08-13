I RES<%-- 
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
            function ValidateForYEm()
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
        </script>
        <link rel="stylesheet" href="css/design.css" type="text/css">
    </head>
    <body>
        <h1>Daily Activity Report Generator</h1>
        <form action="getDAR">
            <table>
                <tr><td>Trainer</td>
                    <td><select name="trainer">
                            <%
                            List<Trainer> trainerList = com.tarkesh.operation.Operations.getBatchTrainer();
                                for (Trainer university : trainerList) {
                            %>
                            <option value="<%=university.getName()%>"><%=university.getName()%></option>
                            <%
                                }
                            %>                            
                        </select></td>
                </tr>
                 <tr>
                    <td>Start Date</td>
                    <td><select name="sday">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                            <option>13</option>
                            <option>14</option>
                            <option>15</option>
                            <option>16</option>
                            <option>17</option>
                            <option>18</option>
                            <option>19</option>
                            <option>20</option>
                            <option>21</option>
                            <option>22</option>
                            <option>23</option>
                            <option>24</option>
                            <option>25</option>
                            <option>26</option>
                            <option>27</option>
                            <option>28</option>
                            <option>29</option>
                            <option>30</option>
                            <option>31</option>
                        </select>
                        <select name="smonth">
                            <option value="0">January</option>
                            <option value="1">February</option>
                            <option value="2">March</option>
                            <option value="3">April</option>
                            <option value="4">May</option>
                            <option value="5">June</option>
                            <option value="6">July</option>
                            <option value="7">August</option>
                            <option value="8">September</option>
                            <option value="9">October</option>
                            <option value="10">November</option>
                            <option value="11">December</option>
                        </select>

                        <select name="syear">
                            <option>2017</option>
                            <option>2018</option>                            
                        </select>
                    </td>
                </tr>
               
                 <tr>
                    <td>End Date</td>
                    <td><select name="eday">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                            <option>6</option>
                            <option>7</option>
                            <option>8</option>
                            <option>9</option>
                            <option>10</option>
                            <option>11</option>
                            <option>12</option>
                            <option>13</option>
                            <option>14</option>
                            <option>15</option>
                            <option>16</option>
                            <option>17</option>
                            <option>18</option>
                            <option>19</option>
                            <option>20</option>
                            <option>21</option>
                            <option>22</option>
                            <option>23</option>
                            <option>24</option>
                            <option>25</option>
                            <option>26</option>
                            <option>27</option>
                            <option>28</option>
                            <option>29</option>
                            <option>30</option>
                            <option>31</option>
                        </select>
                        <select name="emonth">
                            <option value="0">January</option>
                            <option value="1">February</option>
                            <option value="2">March</option>
                            <option value="3">April</option>
                            <option value="4">May</option>
                            <option value="5">June</option>
                            <option value="6">July</option>
                            <option value="7">August</option>
                            <option value="8">September</option>
                            <option value="9">October</option>
                            <option value="10">November</option>
                            <option value="11">December</option>
                        </select>

                        <select name="eyear">
                            <option>2017</option>
                            <option>2018</option>                            
                        </select>
                    </td>
                </tr><tr><td></td><TD> <input type="submit" value="Generate Report"> 
                        <!--<BUTTON type=button value=save name=cmdsave onclick=”save()” >Add</BUTTON>-->

                    </TD>
                </tr>
            </table>
        </form>
    </body>
</html>
