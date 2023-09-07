package com.cg.mts.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicanNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private final static Logger logger = LogManager.getLogger(ApplicanNotFoundException.class);
	private static final long serialVersionUID = 1L;

	public ApplicanNotFoundException(String message) {
        super(message);
        logger.info(message);
    }
}