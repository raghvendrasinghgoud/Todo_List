package com.todo.entity;

public class Task {
    private int taskNo;
    private String taskName;
    private Time t;
    private boolean status;
    public Task(String taskName, Time t, boolean status) {
        this.taskName = taskName;
        this.t = t;
        this.status = status;
    }

    public Task(int taskNo, String taskName, Time t, boolean status) {
        this.taskNo = taskNo;
        this.taskName = taskName;
        this.t = t;
        this.status = status;
    }
    

    /**
     * @return int return the taskNo
     */
    public int getTaskNo() {
        return taskNo;
    }

    /**
     * @param taskNo the taskNo to set
     */
    public void setTaskNo(int taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * @return String return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return Time return the t
     */
    public Time getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(Time t) {
        this.t = t;
    }

    /**
     * @return boolean return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}