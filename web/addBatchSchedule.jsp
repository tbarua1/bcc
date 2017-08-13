<%-- 
    Document   : addBatchSchedule
    Created on : 26 Apr, 2017, 8:08:18 PM
    Author     : data1
--%>

<%@page import="java.util.Calendar"%>
<%@page import="com.tarkesh.entity.BatchSchedule"%>
<%@page import="com.tarkesh.entity.University"%>
<%@page import="com.tarkesh.entity.Trainer"%>
<%@page import="com.tarkesh.entity.BatchCodes"%>
<%@page import="com.tarkesh.operation.Operations"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″>
        <title>Add Batch Schedule</title>
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
            document.frm.action = "AddBatchCodeWeb";
            document.frm.submit();
            }
            }

        </script>
        <script>

            function printDays(value){
            //alert("clicked");
            document.getElementById("dday1").innerHTML = parseInt(value);
            document.getElementById("dday2").innerHTML = (parseInt(value) + 1);
            document.getElementById("dday3").innerHTML = (parseInt(value) + 2);
            document.getElementById("dday4").innerHTML = (parseInt(value) + 3);
            document.getElementById("dday5").innerHTML = (parseInt(value) + 4);
            document.getElementById("dday6").innerHTML = (parseInt(value) + 5);
            document.getElementById("dday7").innerHTML = (parseInt(value) + 6);
            document.getElementById("dday8").innerHTML = (parseInt(value) + 7);
            document.getElementById("dday9").innerHTML = (parseInt(value) + 8);
            document.getElementById("dday10").innerHTML = (parseInt(value) + 9);
            document.getElementById("dday11").innerHTML = (parseInt(value) + 10);
            document.getElementById("dday12").innerHTML = (parseInt(value) + 11);
            document.getElementById("dday13").innerHTML = (parseInt(value) + 12);
            document.getElementById("dday14").innerHTML = (parseInt(value) + 13);
            document.getElementById("dday15").innerHTML = (parseInt(value) + 14);
            document.getElementById("dday16").innerHTML = (parseInt(value) + 15);
            }
//            function startminute1(value){
//               alert(" in Start Minute"); 
//            }
        </script>
        <script type='text/javascript'>
            window.onload = function() { BindEvent(); }

            function BindEvent()
            {
            var elemToBind = document.getElementById ("starthour1");
            elemToBind.onchange = function () { SetSel (this); }
            document.getElementById ("startminute1").onchange = function () { startminute1 (this); };
            document.getElementById ("endhour1").onchange = function () { endhour1 (this); };
            document.getElementById ("endminute1").onchange = function () { endminute1 (this); };
//            elemToBind.onchange = function () { SetSel1 (this); }
//              var elemToBind = document.getElementById ("endhour1");
//            elemToBind.onchange = function () { SetSel (this); }
//              var elemToBind = document.getElementById ("endminute1");
//            elemToBind.onchange = function () { SetSel (this); }
            }
            function startminute1(elem)
            {
            document.getElementById ("smcmb1").value = elem.value;
            document.getElementById ("smcmb2").value = elem.value;
            document.getElementById ("smcmb3").value = elem.value;
            document.getElementById ("smcmb4").value = elem.value;
            document.getElementById ("smcmb5").value = elem.value;
            document.getElementById ("smcmb6").value = elem.value;
            document.getElementById ("smcmb7").value = elem.value;
            document.getElementById ("smcmb8").value = elem.value;
            document.getElementById ("smcmb9").value = elem.value;
            document.getElementById ("smcmb10").value = elem.value;
            document.getElementById ("smcmb11").value = elem.value;
            document.getElementById ("smcmb12").value = elem.value;
            document.getElementById ("smcmb13").value = elem.value;
            document.getElementById ("smcmb14").value = elem.value;
            document.getElementById ("smcmb15").value = elem.value;
            document.getElementById ("smcmb16").value = elem.value;
            }
            function endhour1(elem)
            {document.getElementById ("ehcmb1").value = elem.value;
            document.getElementById ("ehcmb2").value = elem.value;
            document.getElementById ("ehcmb3").value = elem.value;
            document.getElementById ("ehcmb4").value = elem.value;
            document.getElementById ("ehcmb5").value = elem.value;
            document.getElementById ("ehcmb6").value = elem.value;
            document.getElementById ("ehcmb7").value = elem.value;
            document.getElementById ("ehcmb8").value = elem.value;
            document.getElementById ("ehcmb9").value = elem.value;
            document.getElementById ("ehcmb10").value = elem.value;
            document.getElementById ("ehcmb11").value = elem.value;
            document.getElementById ("ehcmb12").value = elem.value;
            document.getElementById ("ehcmb13").value = elem.value;
            document.getElementById ("ehcmb14").value = elem.value;
            document.getElementById ("ehcmb15").value = elem.value;
            document.getElementById ("ehcmb16").value = elem.value; }
            function endminute1(elem)
            { document.getElementById ("emcmb1").value = elem.value;
            document.getElementById ("emcmb2").value = elem.value;
            document.getElementById ("emcmb3").value = elem.value;
            document.getElementById ("emcmb4").value = elem.value;
            document.getElementById ("emcmb5").value = elem.value;
            document.getElementById ("emcmb6").value = elem.value;
            document.getElementById ("emcmb7").value = elem.value;
            document.getElementById ("emcmb8").value = elem.value;
            document.getElementById ("emcmb9").value = elem.value;
            document.getElementById ("emcmb10").value = elem.value;
            document.getElementById ("emcmb11").value = elem.value;
            document.getElementById ("emcmb12").value = elem.value;
            document.getElementById ("emcmb13").value = elem.value;
            document.getElementById ("emcmb14").value = elem.value;
            document.getElementById ("emcmb15").value = elem.value;
            document.getElementById ("emcmb16").value = elem.value; }
            function SetSel(elem)
            {
            //Start Hour 
            document.getElementById ("cmb1").value = elem.value;
            document.getElementById ("cmb2").value = elem.value;
            document.getElementById ("cmb3").value = elem.value;
            document.getElementById ("cmb4").value = elem.value;
            document.getElementById ("cmb5").value = elem.value;
            document.getElementById ("cmb6").value = elem.value;
            document.getElementById ("cmb7").value = elem.value;
            document.getElementById ("cmb8").value = elem.value;
            document.getElementById ("cmb9").value = elem.value;
            document.getElementById ("cmb10").value = elem.value;
            document.getElementById ("cmb11").value = elem.value;
            document.getElementById ("cmb12").value = elem.value;
            document.getElementById ("cmb13").value = elem.value;
            document.getElementById ("cmb14").value = elem.value;
            document.getElementById ("cmb15").value = elem.value;
            document.getElementById ("cmb16").value = elem.value;
            //Start Minutes

            //end Hour

            //end Minutes


            }
        </script><link rel="stylesheet" href="css/bcc.css" type="text/css">
    </head>
    <body><center>
        <form name=frm method="post" action="AddScheduleWeb">
            <table border=”1″>
                <font size=”3″>Add Batch Schedule</font>
                <tr><td>University</td>
                    <td>
                        <select name="university">
                            <%
                                List<University> list2 = com.tarkesh.operation.Operations.getUniversity();
                                for (University university : list2) {
                            %>
                            <option value="<%=university.getName()%>"><%=university.getName()%></option>
                            <%
                                }
                            %>

                        </select></td></tr>
                <tr><td>Trainer</td>
                    <td><select name="trainer">
                            <%
                                List<Trainer> trainerList = Operations.getBatchTrainer();
                                for (Trainer university : trainerList) {
                            %>
                            <option value="<%=university.getName()%>"><%=university.getName()%></option>
                            <%
                                }
                            %>                            
                        </select></td>
                </tr>
                <tr><td>Batch Code</td>
                    <td><select name="batchcode">
                            <%
                                List<BatchCodes> batchCodeList = Operations.getBatchCode();
                                for (BatchCodes university : batchCodeList) {
                            %>
                            <option value="<%=university.getBatchCode()%>"><%=university.getBatchCode()%></option>
                            <%
                                }
                            %>

                        </select></td>
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

                    </td>
                </tr>
                <tr>
                    <td>
                        Days
                    </td>
                    <td>
                        <table>
                            <tr>                            
                                <td>
                            <center>
                                <p id="dday1">1</p> 
                                <input type="checkbox" name="day1" value="0">
                            </center>  
                            <table>
                                <tr>
                                    <td>Start</td>
                                    <td>
                                        <select id="cmb1" name="sh1">
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
                                        <select id="smcmb1" name="sm1">
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
                                    </td>
                                </tr>
                                <tr>
                                    <td>End</td>
                                    <td>
                                        <select id="ehcmb1" name="eh1">
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
                                        <select id="emcmb1" name="em1">
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
                                    </td>
                                </tr>
                            </table>                                    
                    </td> 
                    <td><center>
                    <p id="dday2">2</p>
                    <input type="checkbox" name="day2" value="1">
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb2" name="sh2">
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
                            <select id="smcmb2" name="sm2">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb2" name="eh2">
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
                            <select id="emcmb2" name="em2">
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
                        </td>
                    </tr>
                </table>  
                </td> 
                <td><center>
                    <p id="dday3">3</p>
                    <input type="checkbox" name="day3" value="2">
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb3" name="sh3">
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
                            <select id="smcmb3" name="sm3">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb3" name="eh3">
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
                            <select id="emcmb3" name="em3">
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
                        </td>
                    </tr>
                </table>  </td>
                <td><center><p id="dday4">4</p>
                    <input type="checkbox" name="day4" value="3">
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb4" name="sh4">
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
                            <select id="smcmb4" name="sm4">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb4" name="eh4">
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
                            <select id="emcmb4" name="em4">
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
                            <option>55</option>                            </select>
                        </td>
                    </tr>
                </table>  </td>

                <td><center><p id="dday5">5</p>
                    <input type="checkbox" name="day5" value="4">
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb5" name="sh5">
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
                            <select id="smcmb5" name="sm5">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb5" name="eh5">
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
                            <select id="emcmb5" name="em5">
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
                        </td>
                    </tr>
                </table>  
                </td> 
                <td><center><p id="dday6">6</p>
                    <input type="checkbox" name="day6" value="5"> 
                </center>
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb6"name="sh6">
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
                            <select id="smcmb6" name="sm6">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb6" name="eh6">
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
                            <select id="emcmb6" name="em6">
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
                        </td>
                    </tr>
                </table>  
                </td>
                <td><center><p id="dday7">7</p>
                    <input type="checkbox" name="day7" value="6"> 
                </center>
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb7" name="sh7">
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
                            <select id="smcmb7" name="sm7">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb7" name="eh7">
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
                            <select id="emcmb7" name="em7">
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
                        </td>
                    </tr>
                </table>  
                </td>
                <td><center><p id="dday8">8</p>
                    <input type="checkbox" name="day8" value="7">
                </center>
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb8" name="sh8">
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
                            <select id="smcmb8" name="sm8">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb8" name="eh8">
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
                            <select id="emcmb8" name="em8">
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
                        </td>
                    </tr>
                </table>  
                </td>
                </tr>
                <tr>
                    <td><center><p id="dday9">9</p>
                    <input type="checkbox" name="day9" value="8"> 
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb9" name="sh9">
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
                            <select id="smcmb9" name="sm9">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb9" name="eh9">
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
                            <select id="emcmb9" name="em9">
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
                        </td>
                    </tr>
                </table>  
                </td>
                <td><center><p id="dday10">10</p>
                    <input type="checkbox" name="day10" value="9">
                </center>
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb10" name="sh10">
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
                            <select id="smcmb10" name="sm10">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb10" name="eh10">
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
                            <select id="emcmb10"  name="em10">
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
                        </td>
                    </tr>
                </table>  
                </td>
                <td><center><p id="dday11">11</p>
                    <input type="checkbox" name="day11" value="10" class="largecheckbox"> 
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb11"  name="sh11">
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
                            <select id="smcmb11"  name="sm11">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb11"  name="eh11">
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
                            <select id="emcmb11"  name="em11">
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
                        </td>
                    </tr>
                </table>  
                </td>
                <td><center><p id="dday12">12</p>
                    <input type="checkbox" name="day12" value="11">
                </center>
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb12"  name="sh12">
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
                            <select id="smcmb12"  name="sm12">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb12"  name="eh12">
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
                            <select id="emcmb12" name="em12">
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
                        </td>
                    </tr>
                </table>  
                </td> 

                <td><center><p id="dday13">13</p>
                    <input type="checkbox" name="day13" value="12">
                </center>  
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb13"  name="sh13">
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
                            <select id="smcmb13"  name="sm13">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb13"  name="eh13">
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
                            <select id="emcmb13"  name="em13">
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
                        </td>
                    </tr>
                </table>  
                </td> 
                <td><center><p id="dday14">14</p>
                    <input type="checkbox" name="day14" value="13">
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb14"  name="sh14">
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
                            <select id="smcmb14"  name="sm14">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb14"  name="eh14">
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
                            <select id="emcmb14"  name="em14">
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
                        </td>
                    </tr>
                </table>  
                </td> 
                <td><center><p id="dday15">15</p>
                    <input type="checkbox" name="day15" value="14">
                </center>
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb15"  name="sh15">
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
                            <select id="smcmb15"  name="sm15">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb15" name="eh15">
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
                            <select id="emcmb15"  name="em15">
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
                        </td>
                    </tr>
                </table>  
                </td> 
                <td><center><p id="dday16">16</p>
                    <input type="checkbox" name="day16" value="15">
                </center> 
                <table>
                    <tr>
                        <td>Start</td>
                        <td>
                            <select id="cmb16" name="sh16">
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
                            <select id="smcmb16" name="sm16">
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
                        </td>
                    </tr>
                    <tr>
                        <td>End</td>
                        <td>
                            <select id="ehcmb16" name="eh16">
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
                            <select id="emcmb16" name="em16">
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
                        </td>
                    </tr>
                </table>  </td>
                </td>
                </tr>
            </table>         
            </tr>
            <tr>
                <td></td>
                <TD> 
                    <input type="submit" value="Add"> 
                    <!--<BUTTON type=button value=save name=cmdsave onclick=”save()” >Add</BUTTON>-->
            <input type="reset" value="Cancel"></form>
        <form action="editBatchCode.jsp"><input type="submit" value="Edit"></form>
    </TD>
</tr>
</table>
<table border="1">
    <% List<BatchSchedule> batchScheduleList = Operations.getBatchSchedule15();
        for (BatchSchedule u1 : batchScheduleList) {
            //if((request.getParameter(“cbousername")!=null)&&(request.getParameter(“cbousername").trim().equalsIgnoreCase(u1.getUserID().trim()))){
%><tr> 
        <td><%=u1.getStatus()%></td>
        <td><%=u1.getBatchcode()%> </td>                

        <td><%=u1.getTrainer()%></td>

        <td><%=u1.getDate().get(Calendar.DATE) + "-" + (u1.getDate().get(Calendar.MONTH) + 1) + "-" + u1.getDate().get(Calendar.YEAR) + " " + u1.getDate().get(Calendar.HOUR_OF_DAY) + ":" + u1.getDate().get(Calendar.MINUTE)%></td>
        <td><%=u1.getTill().get(Calendar.DATE) + "-" + (u1.getTill().get(Calendar.MONTH) + 1) + "-" + u1.getTill().get(Calendar.YEAR) + " " + u1.getTill().get(Calendar.HOUR_OF_DAY) + ":" + u1.getTill().get(Calendar.MINUTE)%></td>
        <td><%=u1.getUniversity()%></td><!--<td><%=u1.getTill()%></td>-->

    </tr>
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
</center>
</body>
</html>