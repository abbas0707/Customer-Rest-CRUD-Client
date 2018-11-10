/**
 * 
 */
package com.customer.rest.scheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.customer.rest.client.CustomerConsumer;

/**
 * @author abbas
 *
 */
@Component
public class ScheduleRestCalls {
	private static final Log logger = LogFactory.getLog(ScheduleRestCalls.class);
	  private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	
	  @Scheduled(fixedDelay = 300000)// 1 min = 60000 milliseconds , 5 min are 60000 x 5 = 300,000
	public void scheduleTaskWithFixedRate() {
	    logger.info("Fixed Delay: Consuming Rest /listCustomers at  -"+ dateTimeFormatter.format(LocalDateTime.now()) );
	    new CustomerConsumer().listCustomers();
	}
}
