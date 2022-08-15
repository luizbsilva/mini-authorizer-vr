package br.com.vr.authorizer.infra.adapter.repository.dao;

import br.com.vr.authorizer.domain.CreditCardPort;
import br.com.vr.authorizer.domain.TransactionPort;
import br.com.vr.authorizer.domain.mapper.TransctionMapper;
import br.com.vr.authorizer.domain.port.repository.CreditCardRepositoryPort;
import br.com.vr.authorizer.domain.port.repository.TransactionRepositoryPort;
import br.com.vr.authorizer.infra.adapter.entity.colections.CreditCard;
import br.com.vr.authorizer.infra.adapter.entity.colections.Transaction;
import br.com.vr.authorizer.infra.adapter.repository.TransactionRepository;
import br.com.vr.authorizer.infra.exception.InsufficientBalanceException;
import javassist.NotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionDao implements TransactionRepositoryPort {

    private CreditCardRepositoryPort creditCardRepositoryPort;
    private TransactionRepository repository;
    private TransctionMapper mapper;


    public TransactionDao(CreditCardRepositoryPort creditCardRepositoryPort, TransactionRepository repository,
                          TransctionMapper mapper) {
        this.creditCardRepositoryPort = creditCardRepositoryPort;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void startTransaction(TransactionPort transactionPort) throws NotFoundException {
        CreditCardPort creditCardPort = creditCardRepositoryPort.findByNumberCard(transactionPort.getCreditCardPort().getNumberCard());
        creditCardRepositoryPort.getValidatePassword(transactionPort.getCreditCardPort().getPassword(), creditCardPort.getPassword());
        validateAvailableBalance(transactionPort.getTransactionValue(), creditCardPort.getAvailable());
        creditCardPort.setAvailable(creditCardPort.getAvailable().subtract(transactionPort.getTransactionValue()));
        creditCardPort = creditCardRepositoryPort.changeCreditCardBalance(creditCardPort);
        Transaction transaction = mapper.toDomain(transactionPort);
        transaction.setCreditCard(creditCardRepositoryPort.getCreditCard(creditCardPort.get_id()));
        repository.save(transaction);
    }

    @Override
    public List<TransactionPort> getListTransaction(String numberCard, String password) throws NotFoundException {
        CreditCard creditCard = creditCardRepositoryPort.getCreditCardByNumberCard(numberCard);
        creditCardRepositoryPort.getValidatePassword(password, creditCard.getPassword());
        List<Transaction> transaction = repository.findByCreditCard(creditCard);
        return transaction.stream().map(Transaction::toTransactionPort).collect(Collectors.toList());
    }

    @Override
    public BigDecimal getAvailableCreditCard(String numberCard, String password) throws NotFoundException {
        return creditCardRepositoryPort.getAvailableCreditCard(numberCard, password);
    }

    private void validateAvailableBalance(BigDecimal transactionValue, BigDecimal availableBalance) {
        if (availableBalance.compareTo(transactionValue) < 0)
            throw new InsufficientBalanceException();

    }
}
