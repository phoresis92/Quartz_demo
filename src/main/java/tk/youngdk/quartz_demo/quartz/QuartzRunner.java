package tk.youngdk.quartz_demo.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import tk.youngdk.quartz_demo.quartz.job.HelloJob;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
@RequiredArgsConstructor
@Slf4j
public class QuartzRunner implements ApplicationRunner {
//    private final Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {

//            scheduler.shutdown();
//            scheduler.start();
            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();

            // Tell quartz to schedule the job using our trigger
//            scheduler.scheduleJob(job, trigger);

        } catch (Exception e){
            log.error("Exception");
//            scheduler.shutdown();
        }/* finally {
        }*/

    }

    static class RunMeJob extends QuartzJobBean {

        @Override
        protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        }
    }
}
