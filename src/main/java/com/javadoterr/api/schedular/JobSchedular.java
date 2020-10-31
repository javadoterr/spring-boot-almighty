package com.javadoterr.api.schedular;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.javadoterr.api.service.AddressService;
import com.javadoterr.api.service.UserService;

//@Component
public class JobSchedular {
	
	private static Logger logger = LogManager.getLogger(JobSchedular.class);
	
	private UserService userService;
	private AddressService addressService;
	
	@Autowired
	public JobSchedular(UserService userService, AddressService addressService) {
		this.userService = userService;
		this.addressService = addressService;
	}

	//@Scheduled(cron ="*/5 * * * * *") //for 5 second
	public void scheduleUsingCron() {
		logger.info(userService.userList());
	}

	//@Scheduled(fixedDelay = 1000, initialDelay = 1000)
	public void scheduleUsingFixedDelayWithInitialDelay() {
		logger.info(userService.findUserById(1L));
	}

	//@Scheduled(fixedDelay = 1000)
	public void scheduleUsingDelay() {
		logger.info(addressService.addressList());
	}

	//@Scheduled(fixedRate = 5000)
	public void scheduleUsingRate() {
		logger.info(addressService.findAddressById(2L));
	}

}
