package com.sprint.forex.exception;

import com.sprint.forex.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UsersNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleUsersNotFoundException(UsersNotFoundException e){
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleTransactionNotFoundException(TransactionNotFoundException e) {
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleAdminNotFoundException(AdminNotFoundException e) {
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserBankDetailsNotFoundException.class)
	public ResponseEntity<ExceptionDTO> UserBankDetailsNotFoundException(UserBankDetailsNotFoundException e) {
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidAccountException.class)
	public ResponseEntity<ExceptionDTO> InvalidAccountException(InvalidAccountException e) {
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ExchangeRateNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleExchangeRateNotFoundException(ExchangeRateNotFoundException e) {
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);

	}

	
	@ExceptionHandler(UsersAuthenticationFailureException.class)
	public ResponseEntity<ExceptionDTO> handleUsersAuthenticationFailureException(UsersAuthenticationFailureException e){
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
       
    }
	@ExceptionHandler(UsersEmailNotExistingException.class)
	 public ResponseEntity<ExceptionDTO> UsersEmailNotExistingException(UsersEmailNotExistingException e) {
		return  new ResponseEntity<>(new ExceptionDTO(e.getMessage()),HttpStatus.NOT_FOUND);
 }

}