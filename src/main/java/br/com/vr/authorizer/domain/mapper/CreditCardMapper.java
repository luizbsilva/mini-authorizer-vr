package br.com.vr.authorizer.domain.mapper;

import br.com.vr.authorizer.domain.CreditCardPort;
import br.com.vr.authorizer.infra.adapter.entity.colections.CreditCard;
import br.com.vr.authorizer.infra.util.UUIDUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreditCardMapper implements MapperDomain<CreditCard, CreditCardPort> {

    @Override
    public CreditCardPort toModel(CreditCard creditCard) {
        if (creditCard == null)
            return null;
        return CreditCardPort.builder()
                ._id(creditCard.get_id())
                .createdDate(creditCard.getCreatedDate())
                .lastModifiedDate(creditCard.getLastModifiedDate() != null ? creditCard.getLastModifiedDate() : null)
                .deleted(creditCard.getDeleted() != null ? creditCard.getDeleted() : null)
                .numberCard(creditCard.getNumberCard())
                .password(creditCard.getPassword())
                .available(creditCard.getAvailable())
                .build();
    }

    @Override
    public CreditCard toDomain(CreditCardPort creditCardPort) {
        if (creditCardPort == null)
            return null;

        CreditCard creditCard = CreditCard.builder()
                .numberCard(creditCardPort.getNumberCard())
                .password(creditCardPort.getPassword())
                .available(creditCardPort.getAvailable())
                .build();
        creditCard.set_id(null == creditCardPort.get_id() ? UUIDUtils.getUUID() : creditCardPort.get_id());
        creditCard.setCreatedDate(LocalDateTime.now());
        return creditCard;
    }
}
