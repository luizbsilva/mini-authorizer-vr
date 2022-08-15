package br.com.vr.authorizer.infra.adapter.entity.colections;

import br.com.vr.authorizer.infra.adapter.entity.BaseDomain;
import br.com.vr.authorizer.infra.util.ConstantsColections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@Document(collection = ConstantsColections.COLECTION_CREDITCARD)
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard extends BaseDomain {

    private String numberCard;
    private String password;
    private BigDecimal available;

}
