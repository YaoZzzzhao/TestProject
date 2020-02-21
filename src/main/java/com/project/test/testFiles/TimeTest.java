package com.project.test.testFiles;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTest extends TimerTask {
    String jobName;

    public TimeTest(String jobName){
//        super();
        this.jobName=jobName;
    }

    @Override
    public void run(){
        System.out.println("Execute "+ jobName);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        long delay1 = 1000;
        long period1 = 1000;
//        timer.schedule(new TimeTest("job1"),delay1,period1);
        long delay2 = 2000;
        long period2 = 2000;
//        timer.schedule(new TimeTest("job2"),delay2,period2);
        HashMap<String,String> map = new HashMap<>();
        map.put("key","value");
        System.out.println(map!=null);
    }
}
