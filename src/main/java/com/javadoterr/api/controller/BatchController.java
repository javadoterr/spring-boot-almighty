package com.javadoterr.api.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping(path = "/batch")
public class BatchController {
	
	private JobLauncher jobLauncher;
	private Job job;
	
	@Autowired
	public BatchController(JobLauncher jobLauncher, Job job) {
		this.jobLauncher = jobLauncher;
		this.job = job;
	}
	
	
	@RequestMapping(path = "/{jobName}")
	public void executeBatch(@PathVariable("jobName") String jobName){
		
		JobParameters jobParameters = new JobParametersBuilder()
							.addString("jobName", jobName)
							.addLong("time", System.currentTimeMillis())
							.toJobParameters();
		
		try {
			jobLauncher.run(job, jobParameters).getExitStatus().getExitCode();
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	

}
