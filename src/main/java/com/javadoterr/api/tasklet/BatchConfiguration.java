package com.javadoterr.api.tasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class BatchConfiguration {

	private AutowireCapableBeanFactory beanFactory;

	@Autowired
	public BatchConfiguration(AutowireCapableBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Bean
	public Job executeBatchJob(JobBuilderFactory jobBuilderFactory, Step step) {
		return jobBuilderFactory.get("manualjob").incrementer(new RunIdIncrementer()).flow(step).end().build();
	}

	@Bean
	public Step step(StepBuilderFactory builderFactory) {
		return builderFactory.get("step").tasklet(configTasklet()).build();
	}

	public BatchTasklet configTasklet() {
		BatchTasklet batchTasklet = new BatchTasklet();
		beanFactory.autowireBean(batchTasklet);

		return batchTasklet;

	}

}
