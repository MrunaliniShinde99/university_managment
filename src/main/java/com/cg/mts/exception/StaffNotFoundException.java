package com.cg.mts.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class StaffNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private final static Logger logger = LogManager.getLogger(CourseNotFoundException.class);
	private static final long serialVersionUID = 1L;

	public StaffNotFoundException(String message) {
        super(message);
        logger.info(message);
    }
}