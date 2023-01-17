package br.com.vr.authorizer.domain.adapter.service;

import br.com.vr.authorizer.domain.TransactionPort;
import br.com.vr.authorizer.domain.dto.TransactionDTO;
import br.com.vr.authorizer.domain.dto.TransactionRequest;
import br.com.vr.authorizer.domain.port.adapter.TransactionServicePort;
import br.com.vr.authorizer.domain.port.repository.TransactionRepositoryPort;
import javassist.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionServicePort {

    private TransactionRepositoryPort repositoryPort;

    public TransactionServiceImpl(TransactionRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void startTransaction(TransactionRequest request) throws NotFoundException {
        repositoryPort.startTransaction(new TransactionPort(request));
    }

    @Override
    public TransactionDTO getListTransaction(String numberCard, String password) throws NotFoundException {
        List<TransactionPort> transactionPorts = repositoryPort.getListTransaction(numberCard, password);
        return new TransactionDTO(repositoryPort.getAvailableCreditCard(numberCard, password),
                transactionPorts.stream().map(TransactionPort::toItem).collect(Collectors.toList()));
    }
}

