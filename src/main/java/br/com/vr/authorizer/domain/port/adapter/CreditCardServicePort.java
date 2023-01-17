package br.com.vr.authorizer.domain.port.adapter;

import br.com.vr.authorizer.domain.dto.CreditCartDTO;
import br.com.vr.authorizer.domain.dto.CreditCartRequest;
import javassist.NotFoundException;

import java.math.BigDecimal;

public interface CreditCardServicePort {

    CreditCartDTO findByNumberCard(String numberCard) throws NotFoundException;

    BigDecimal getAvailableCreditCard(String numberCard, String password) throws NotFoundException;

    CreditCartDTO createdCreditCard(CreditCartRequest request) throws NotFoundException;

    CreditCartDTO changePassword(CreditCartRequest request, String newPassword) throws NotFoundException;
}
