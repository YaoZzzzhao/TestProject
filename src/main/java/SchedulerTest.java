
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerTest implements Runnable {
    private String jobName;

    public SchedulerTest(String jobName){
        this.jobName = jobName;
    }

    @Override
    public void run(){
        System.out.println("Execute " + jobName);
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        // The task will be executed after the time period since the last task began;
        service.scheduleAtFixedRate(new SchedulerTest("job1"),1,1, TimeUnit.SECONDS);

        // The task will be executed after the time period since the last task finished;
        service.scheduleWithFixedDelay(new SchedulerTest("job2"),2,2,TimeUnit.SECONDS);



    }
}
