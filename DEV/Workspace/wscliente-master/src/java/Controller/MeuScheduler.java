package Controller;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class MeuScheduler implements ServletContextListener {

    public static final String NOME_JOB = "NomeDoJob";

    public static void agendar() {
        /*   try {
            SchedulerFactory schedFact = new StdSchedulerFactory();
            org.quartz.Scheduler sched = schedFact.getScheduler();
            sched.start();
            JobDetail job = JobBuilder.newJob(JobMes.class)
                    .withIdentity("myJob", "group1")
                    .build();
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                    .build();
            sched.scheduleJob(job, trigger);
        } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }*/
    }

    @Override
    public void contextInitialized(ServletContextEvent ce) {
        try {

            run();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // Finaliza o schedule

    }

    public void run() throws Exception {

        try {
            Logger log = LoggerFactory.getLogger(JobMes.class);

          
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler sched = sf.getScheduler();

                      
            JobDetail job = newJob(JobMes.class).withIdentity("job1", "group1").build();
         
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 5 * ?"))
                    .build();
          
            sched.scheduleJob(job, trigger);
           

            sched.start();
             

        } catch (Exception e) {
            System.out.println("erro");
            e.printStackTrace();
        }

    }

}
