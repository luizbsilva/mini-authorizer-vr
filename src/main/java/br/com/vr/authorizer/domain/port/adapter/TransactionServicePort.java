package br.com.vr.authorizer.domain.port.adapter;

import br.com.vr.authorizer.domain.dto.TransactionDTO;
import br.com.vr.authorizer.domain.dto.TransactionRequest;
import javassist.NotFoundException;

public interface TransactionServicePort {

    void startTransaction(TransactionRequest request) throws NotFoundException;

    TransactionDTO getListTransaction(String numberCard, String password) throws NotFoundException;
}
