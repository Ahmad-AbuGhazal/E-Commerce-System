package edu.mum.estore.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.estore.exception.CustomerNotFoundException;
import edu.mum.estore.exception.PaymentNotValidException;
import edu.mum.estore.exception.ProductNotFoundException;
import edu.mum.estore.exception.VendorNotFoundException;

@ControllerAdvice
public class EstoreExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
	}
	
	
	@ExceptionHandler(PaymentNotValidException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody DomainError handleException(PaymentNotValidException ex) {
		DomainError error = new DomainError(ex.getMessage());
		return error;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody DomainError handleException(CustomerNotFoundException ex) {
		DomainError error = new DomainError(ex.getMessage());
		return error;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody DomainError handleException(ProductNotFoundException ex) {
	DomainError error = new DomainError(ex.getMessage());
	return error;
	}
	@ExceptionHandler(VendorNotFoundException.class)
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody DomainError handleException(VendorNotFoundException ex) {
	DomainError error = new DomainError(ex.getMessage());
	return error;
	}
}
