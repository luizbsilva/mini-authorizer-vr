package br.com.vr.authorizer.infra.config;

import br.com.vr.authorizer.domain.adapter.service.CreditCardServiceImpl;
import br.com.vr.authorizer.domain.adapter.service.TransactionServiceImpl;
import br.com.vr.authorizer.domain.adapter.service.UserServiceImp;
import br.com.vr.authorizer.domain.port.adapter.CreditCardServicePort;
import br.com.vr.authorizer.domain.port.adapter.TransactionServicePort;
import br.com.vr.authorizer.domain.port.adapter.UserServicePort;
import br.com.vr.authorizer.domain.port.repository.CreditCardRepositoryPort;
import br.com.vr.authorizer.domain.port.repository.TransactionRepositoryPort;
import br.com.vr.authorizer.domain.port.repository.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    UserServicePort userService(UserRepositoryPort repositoryPort) {
        return new UserServiceImp(repositoryPort);
    }

    @Bean
    CreditCardServicePort creditCardService(CreditCardRepositoryPort repositoryPort) {
        return new CreditCardServiceImpl(repositoryPort);
    }

    @Bean
    TransactionServicePort transactionService(TransactionRepositoryPort repositoryPort) {
        return new TransactionServiceImpl(repositoryPort);
    }
}
