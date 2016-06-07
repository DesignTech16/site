/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danilo
 */
public class JobMes implements Job {
private static Logger _log = LoggerFactory.getLogger(JobMes.class);
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("3 em 3 minutos");
    }
    
    public JobMes(){
        
    }
}
