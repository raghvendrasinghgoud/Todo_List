package com.todo.entity;

public class Time {
    private int hour;
    private int minute;
    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    public Time(String timeString){
        String str[]=timeString.split(":");
        this.hour=Integer.parseInt(str[0]);
        this.minute=Integer.parseInt(str[1]);
        System.out.println("string to Time conv hour="+this.hour+" minute="+this.minute);
    }
    public int getHour() {
        return hour;
    }
   
    public int getMinute() {
        return minute;
    }

    private boolean checkForOneDigit(int n){
        if(n<10) return true;
        else return false;
    }
    private String getTimeInFormat(){
        String Hour="";
        String Minute="";
        if(checkForOneDigit(this.getHour())) Hour+="0"+this.getHour();
        else Hour+=this.hour;
        if(checkForOneDigit(this.getMinute())) Minute+="0"+this.getMinute();
        else Minute+=this.getMinute();
        return Hour+":"+Minute+":00";
    }
    @Override
    public String toString() {
        return this.getTimeInFormat();
    }
    
    
}