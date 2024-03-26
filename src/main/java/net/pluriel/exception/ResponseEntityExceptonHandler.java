package net.pluriel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import net.pluriel.dto.response.ErrorResponse;

@ControllerAdvice
public class ResponseEntityExceptonHandler {
	@ExceptionHandler(DataException.class)
	public ResponseEntity<ErrorResponse> handleAdherentNotFound(DataException data) {
		return new ResponseEntity<>(
				new ErrorResponse().builder().errorMessage(data.getMessage()).errorCode(data.getErrorCode()).build(),
				HttpStatus.BAD_REQUEST);
	}
}
