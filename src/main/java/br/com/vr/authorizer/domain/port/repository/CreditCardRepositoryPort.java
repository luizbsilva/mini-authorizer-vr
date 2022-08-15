package br.com.vr.authorizer.domain.port.repository;

import br.com.vr.authorizer.domain.CreditCardPort;
import br.com.vr.authorizer.infra.adapter.entity.colections.CreditCard;
import javassist.NotFoundException;

import java.math.BigDecimal;

public interface CreditCardRepositoryPort {
    CreditCardPort findByNumberCard(String numberCard) throws NotFoundException;

    CreditCardPort createdCreditCard(CreditCardPort creditCardPort) throws NotFoundException;

    CreditCardPort changePassword(CreditCardPort creditCardPort, String newPassword) throws NotFoundException;

    CreditCardPort changeCreditCardBalance(CreditCardPort creditCardPort);

    BigDecimal getAvailableCreditCard(String numberCard, String password) throws NotFoundException;

    void getValidatePassword(String passwordRequest, String password);

    CreditCard getCreditCard(String idCreditCard) throws NotFoundException;

    CreditCard getCreditCardByNumberCard(String numberCard) throws NotFoundException;
}
