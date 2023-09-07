package com.cg.mts.exception;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDetails {
	private LocalDateTime localDateTime;
	private String message;
	private String details;

	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
	}
	
}