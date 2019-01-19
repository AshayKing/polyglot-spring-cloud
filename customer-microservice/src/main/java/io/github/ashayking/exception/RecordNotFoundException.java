package io.github.ashayking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Ashay S Patil
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Record not found in database!")
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String msg) {
		super(msg);
	}
}