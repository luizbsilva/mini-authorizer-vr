package br.com.vr.authorizer.domain.port.repository;

import br.com.vr.authorizer.domain.TransactionPort;
import javassist.NotFoundException;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepositoryPort {
    void startTransaction(TransactionPort transactionPort) throws NotFoundException;

    List<TransactionPort> getListTransaction(String numberCard, String password) throws NotFoundException;

    BigDecimal getAvailableCreditCard(String numberCard, String password) throws NotFoundException;
}
