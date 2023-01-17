package br.com.vr.authorizer.api.handle;

import br.com.vr.authorizer.infra.exception.CreditCardAlreadyRegisteredException;
import br.com.vr.authorizer.infra.exception.InsufficientBalanceException;
import br.com.vr.authorizer.infra.exception.InvalidPasswordException;
import br.com.vr.authorizer.infra.exception.NonExistingCardException;
import br.com.vr.authorizer.infra.exception.enums.ExceptionsE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public final class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<?> handlerInsufficientBalance(InsufficientBalanceException fee) {
        return new ResponseEntity<>(ExceptionsE.INSUFFICIENT_BALANCE.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<?> handlerInvalidPassword(InvalidPasswordException fee) {
        return new ResponseEntity<>(ExceptionsE.INVALID_PASSWORD.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NonExistingCardException.class)
    public ResponseEntity<?> handlerNonExistingCard(NonExistingCardException fee) {
        return new ResponseEntity<>(ExceptionsE.NON_EXISTING_CARD.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(CreditCardAlreadyRegisteredException.class)
    public ResponseEntity<?> handlerCreditCardAlreadyRegistered(CreditCardAlreadyRegisteredException fee) {
        return new ResponseEntity<>(ExceptionsE.CREDIT_CARD_ALREADY_REGISTERED.getTipo(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
