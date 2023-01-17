package br.com.vr.authorizer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemTransaction {

    private Integer transactionCode;
    private LocalDateTime transactionDate;
    private BigDecimal transactionValue;

}
