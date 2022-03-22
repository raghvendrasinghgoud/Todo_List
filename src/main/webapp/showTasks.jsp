<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.todo.entity.Task"  %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.todo.dao.TasksDAO"%>
<%@ page import="com.todo.helper.ConnectionProvider"%>

<table>
        <tr>
            <th>Task No</th>
            <th>Task name</th>
            <th>Remind Time</th>
            <th>Status</th>
            <th>Delete</th>
        </tr>

<%
    ArrayList<Task> tasks=new TasksDAO(ConnectionProvider.getConnection()).getTasks();
    for(int i=0;i<tasks.size();i++){
            Task t=tasks.get(i);
%>
        <tr>
            <td><%= t.getTaskNo() %></td>
            <td><%= t.getTaskName() %></td>
            <td><%= t.getT().toString() %></td>
            <td>
            <%
                if(t.isStatus()){
                %>
                <button class="btn">Done</button>
            <%
                }else{
            %>
                <button class="btn btnTom" onclick="mark('markStatus?task_no=<%= t.getTaskNo() %>')" >Pending</button>
            <%
                }
            %>
            </td>
<td>
    <button style="background-color: blueviolet;" class="btn btnTom" onclick="mark('deleteTask?task_no=<%= t.getTaskNo() %>')" >Delete</button>
</td>
        </tr>
    <%
    }
%>
</table>
<script>
    
</script>