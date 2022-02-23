
package com.todo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.todo.entity.Task;
import com.todo.entity.Time;
public class TasksDAO {
    final Connection conn;

    public TasksDAO(Connection conn) {
        this.conn = conn;
    }
    
    public boolean saveTask(Task task){
        boolean flag=false;
        try {
            String sql="insert into tasks(task_name,remind_time,status)values(?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, task.getTaskName());
            ps.setString(2, task.getT().toString());
            ps.setBoolean(3, false);
            ps.executeUpdate();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    //fetching tasks from database
    public ArrayList<Task> getTasks(){
        ArrayList<Task> Tasks=new ArrayList<>();
        try{
            String sql="select * from tasks order by task_no desc";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet res=ps.executeQuery();
            res.next();
            while(res.next()){
                Tasks.add(new Task(res.getInt("task_no"),res.getString("task_name"),new Time(res.getString("remind_time")),res.getBoolean("status")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Tasks;
    }
    
    //change task status
    public boolean updateStatus(boolean b,int task_no){
        boolean flag=false;
        try{
            String sql="update tasks set status=? where task_no=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setBoolean(1, b);
            ps.setInt(2, task_no);
            ps.executeUpdate();
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}