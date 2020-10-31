package com.javadoterr.api.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javadoterr.api.service.UserService;

//@Service
public class BatchTasklet implements Tasklet{
	
	@Autowired
	private UserService userService;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println(chunkContext.getStepContext().getJobParameters().get("jobName").toString());
		userService.userList();
		return RepeatStatus.FINISHED;
	}
	
	

}
