package br.com.vr.authorizer.infra.adapter.repository;

import br.com.vr.authorizer.infra.adapter.entity.colections.CreditCard;
import br.com.vr.authorizer.infra.adapter.entity.colections.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findByCreditCard(CreditCard creditCard);

}
