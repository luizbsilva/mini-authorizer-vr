package br.com.vr.authorizer.infra.validation;

import br.com.vr.authorizer.infra.adapter.entity.colections.CreditCard;
import br.com.vr.authorizer.infra.adapter.repository.CreditCardRepository;
import br.com.vr.authorizer.infra.exception.CreditCardAlreadyRegisteredException;
import br.com.vr.authorizer.infra.exception.dto.ErrorInfo;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegistrationValidation implements Validation<CreditCard> {
    public static final String CREDIT_CARD_ALREADY_REGISTERED = "Credit Card Already Registered";
    private CreditCardRepository repository;

    public RegistrationValidation(CreditCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public void isValid(Optional<CreditCard> res) throws NotFoundException {
        CreditCard creditCard = res.orElseThrow(() -> new NotFoundException(""));
        List<ErrorInfo> listError = new ArrayList<>();

        Optional<CreditCard> creditCardOld = repository.findByNumberCard(creditCard.getNumberCard());

        if (creditCardOld.isPresent()) {
            listError.add(new ErrorInfo(CREDIT_CARD_ALREADY_REGISTERED));
        }
        if (!listError.isEmpty()) {
            throw new CreditCardAlreadyRegisteredException();
        }

    }
}
