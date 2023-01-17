package br.com.vr.authorizer.domain.mapper;

import br.com.vr.authorizer.domain.TransactionPort;
import br.com.vr.authorizer.infra.adapter.entity.colections.Transaction;
import br.com.vr.authorizer.infra.util.UUIDUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class TransctionMapper implements MapperDomain<Transaction, TransactionPort> {
    @Override
    public TransactionPort toModel(Transaction transaction) {
        if (transaction == null)
            return null;
        TransactionPort transactionPort = TransactionPort.builder()
                .dataTransaction(transaction.getDataTransaction())
                .transactionValue(transaction.getTransactionValue())
                .transactionCode(transaction.getTransactionCode())
                .build();
        transactionPort.set_id(transaction.get_id());
        transactionPort.setCreatedDate(transaction.getCreatedDate());
        return transactionPort;
    }

    @Override
    public Transaction toDomain(TransactionPort transactionPort) {
        if (transactionPort == null)
            return null;

        Transaction transaction = Transaction.builder()
                .dataTransaction(transactionPort.getDataTransaction())
                .transactionValue(transactionPort.getTransactionValue())
                .transactionCode(new Random().nextInt(50))
                .build();
        transaction.set_id(UUIDUtils.getUUID());
        transaction.setCreatedDate(LocalDateTime.now());
        return transaction;
    }
}
