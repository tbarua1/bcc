<%-- 
    Document   : editSchedule
    Created on : Aug 13, 2017, 1:50:13 AM
    Author     : tarkeshwar
--%>

<%@page import="java.util.Calendar"%>
<%@page import="com.tarkesh.entity.BatchCodes"%>
<%@page import="com.tarkesh.entity.Trainer"%>
<%@page import="com.tarkesh.entity.University"%>
<%@page import="java.util.List"%>
<%@page import="com.tarkesh.entity.BatchSchedule"%>
<%@page import="com.tarkesh.operation.Operations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Schedule Modification</h1>
        <table border="1">
            <form name=frm method="post" action="BatchScheduleUpdate">           
                <font size="3">Add Batch Code</font>
                <tr>
                    <td>Batch Code</td>
                    <td><%Long id = Long.parseLong(request.getParameter("id"));
                        BatchSchedule schedule = Operations.getBatchScheduleById(id);

                        %>
                        <select name="batchcode">
                            <%                                List<BatchCodes> batchCodeList = Operations.getBatchCode();
                                for (BatchCodes university : batchCodeList) {
                            %>
                            <option value="<%=university.getBatchCode()%>"><%=university.getBatchCode()%></option>
                            <%
                                }
                            %>

                        </select><br> <%=schedule.getBatchcode()%></td></tr>
                <input type="text" name="id" value="<%=id%>" hidden="">
                <tr>
                    <td>Trainer</td>
                    <td><select name="trainer">
                            <%
                                List<Trainer> trainerList = Operations.getBatchTrainer();
                                for (Trainer university : trainerList) {
                            %>
                            <option value="<%=university.getName()%>"><%=university.getName()%></option>
                            <%
                                }
                            %>                            
                        </select><br><%=schedule.getTrainer()%></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><select name="status">
                            <option value="scheduled">Scheduled</option>
                            <option value="canceled">Canceled</option>
                            <option value="done">Done</option>
                            <option value="started">Started</option></select><%=schedule.getStatus()%></td>
                </tr>
                <tr><td>University</td>
                    <td><select name="university">
                            <%
                                List<University> list2 = com.tarkesh.operation.Operations.getUniversity();
                                for (University university : list2) {
                            %>
                            <option value="<%=university.getName()%>"><%=university.getName()%></option>
                            <%
                                }
                            %>

                        </select><br><%=schedule.getUniversity()%></td>
                </tr>
                <tr>
                    <td>Schedule Date</td>
                    <td><select name="day" onchange="printDays(this.value);">
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
                        <select name="month">
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

                        <select name="year">
                            <option>2017</option>
                            <option>2018</option>                            
                        </select>
                        <%Calendar c = schedule.getDate();
                            Calendar e = schedule.getTill();%>
                        <%=c.get(Calendar.DAY_OF_MONTH)%>-<%=c.get(Calendar.MONTH) + 1%>-<%=c.get(Calendar.YEAR)%>
                    </td>
                </tr>
                <tr>
                    <td>Schedule Time</td>
                    <td>Start:<select name="starthour" onchange="starthour();" id="starthour1">
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

                        </select>
                        <select name="startminute" onchange="startminute1()" id="startminute1">
                            <option>0</option>                            
                            <option>5</option>
                            <option>10</option>
                            <option>15</option>
                            <option>20</option>
                            <option>25</option>
                            <option>30</option>
                            <option>35</option>
                            <option>40</option>
                            <option>45</option>
                            <option>50</option>
                            <option>55</option>
                        </select> End: <select name="endhour" onchange="endhour();" id="endhour1">
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

                        </select>
                        <select name="endminute" onchange="endminute();" id="endminute1">
                            <option>0</option>                            
                            <option>5</option>
                            <option>10</option>
                            <option>15</option>
                            <option>20</option>
                            <option>25</option>
                            <option>30</option>
                            <option>35</option>
                            <option>40</option>
                            <option>45</option>
                            <option>50</option>
                            <option>55</option>
                        </select>
                        <%=c.get(Calendar.HOUR_OF_DAY)%>:<%=c.get(Calendar.MINUTE) + 1%> to <%=e.get(Calendar.HOUR_OF_DAY)%>:<%=e.get(Calendar.MINUTE)%>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <TD> <input type="submit" value="Update"> </TD>
                </tr>
            </form>
        </table>

    </body>
</html>
