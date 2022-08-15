package br.com.vr.authorizer.infra.adapter.repository.dao;

import br.com.vr.authorizer.domain.CreditCardPort;
import br.com.vr.authorizer.domain.mapper.CreditCardMapper;
import br.com.vr.authorizer.domain.port.repository.CreditCardRepositoryPort;
import br.com.vr.authorizer.infra.adapter.entity.colections.CreditCard;
import br.com.vr.authorizer.infra.adapter.repository.CreditCardRepository;
import br.com.vr.authorizer.infra.exception.InvalidPasswordException;
import br.com.vr.authorizer.infra.exception.NonExistingCardException;
import br.com.vr.authorizer.infra.validation.RegistrationValidation;
import javassist.NotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class CreditCardDao implements CreditCardRepositoryPort {

    private CreditCardRepository repository;
    private RegistrationValidation validation;
    private CreditCardMapper mapper;

    public CreditCardDao(CreditCardRepository repository, RegistrationValidation validation, CreditCardMapper mapper) {
        this.repository = repository;
        this.validation = validation;
        this.mapper = mapper;
    }

    @Override
    public CreditCardPort findByNumberCard(String numberCard) throws NotFoundException {
        return mapper.toModel(findByCreditCard(numberCard));
    }

    public CreditCard findByCreditCard(String numberCard) throws NotFoundException {
        Optional<CreditCard> cardOptionalv = repository.findByNumberCard(numberCard);
        return cardOptionalv.orElseThrow(() -> new NonExistingCardException());
    }

    @Override
    public CreditCardPort createdCreditCard(CreditCardPort creditCardPort) throws NotFoundException {
        CreditCard creditCard = mapper.toDomain(creditCardPort);
        validation.isValid(Optional.ofNullable(creditCard));
        repository.save(creditCard);
        return mapper.toModel(creditCard);
    }

    @Override
    public CreditCardPort changePassword(CreditCardPort creditCardPort, String newPassword) throws NotFoundException {
        CreditCard creditCard = findByCreditCard(creditCardPort.getNumberCard());
        getValidatePassword(creditCardPort.getPassword(), creditCard.getPassword());
        creditCard.setPassword(encodPassword(newPassword));
        repository.save(creditCard);
        return mapper.toModel(creditCard);
    }

    private String encodPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    public CreditCardPort changeCreditCardBalance(CreditCardPort creditCardPort) {
        CreditCard creditCard = mapper.toDomain(creditCardPort);
        repository.save(creditCard);
        return mapper.toModel(creditCard);
    }

    @Override
    public BigDecimal getAvailableCreditCard(String numberCard, String password) throws NotFoundException {
        CreditCard creditCard = findByCreditCard(numberCard);
        getValidatePassword(password, creditCard.getPassword());
        return creditCard.getAvailable();
    }

    @Override
    public void getValidatePassword(String passwordRequest, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(passwordRequest, password))
            throw new InvalidPasswordException();
    }

    @Override
    public CreditCard getCreditCard(String idCreditCard) {
        Optional<CreditCard> cardOptionalv = repository.findById(idCreditCard);
        return cardOptionalv.orElseThrow(() -> new NonExistingCardException());
    }

    @Override
    public CreditCard getCreditCardByNumberCard(String numberCard) throws NotFoundException {
        return findByCreditCard(numberCard);
    }

}
