package br.com.vr.authorizer.domain.adapter.service;

import br.com.vr.authorizer.domain.CreditCardPort;
import br.com.vr.authorizer.domain.dto.CreditCartDTO;
import br.com.vr.authorizer.domain.dto.CreditCartRequest;
import br.com.vr.authorizer.domain.port.adapter.CreditCardServicePort;
import br.com.vr.authorizer.domain.port.repository.CreditCardRepositoryPort;
import javassist.NotFoundException;

import java.math.BigDecimal;

public class CreditCardServiceImpl implements CreditCardServicePort {

    private CreditCardRepositoryPort repositoryPort;

    public CreditCardServiceImpl(CreditCardRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public CreditCartDTO findByNumberCard(String numberCard) throws NotFoundException {
        CreditCardPort creditCardPort = repositoryPort.findByNumberCard(numberCard);
        return new CreditCartDTO(creditCardPort, "");
    }

    @Override
    public BigDecimal getAvailableCreditCard(String numberCard, String password) throws NotFoundException {
        return repositoryPort.getAvailableCreditCard(numberCard, password);
    }

    @Override
    public CreditCartDTO createdCreditCard(CreditCartRequest request) throws NotFoundException {
        CreditCardPort creditCard = repositoryPort.createdCreditCard(new CreditCardPort(request));
        return new CreditCartDTO(creditCard, request.getPassword());
    }

    @Override
    public CreditCartDTO changePassword(CreditCartRequest request, String newPassword) throws NotFoundException {
        CreditCardPort creditCard = repositoryPort.changePassword(new CreditCardPort(request.getNumberCard(), request.getPassword()), newPassword);
        return new CreditCartDTO(creditCard, request.getPassword());
    }
}
