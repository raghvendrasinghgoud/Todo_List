package com.todo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TasksDAO;
import com.todo.entity.Task;
import com.todo.entity.Time;
import com.todo.helper.ConnectionProvider;

public class save extends HttpServlet {

    void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        String taskName=req.getParameter("task");
        int hour=Integer.parseInt(req.getParameter("hour"));
        int minute= Integer.parseInt(req.getParameter("minute"));
        Task task = new Task(taskName,new Time(hour,minute),false);
        if(new TasksDAO(ConnectionProvider.getConnection()).saveTask(task)) System.out.println("Inserted");
        else System.out.println("failed to inserted data="+taskName+" "+hour+" "+minute);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}