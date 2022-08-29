package br.com.roger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundOperationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundOperationException(String ex) {
		super(ex);
	}

}
