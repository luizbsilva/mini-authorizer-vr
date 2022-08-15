package br.com.vr.authorizer.domain;

import br.com.vr.authorizer.domain.dto.CreditCartDTO;
import br.com.vr.authorizer.domain.dto.CreditCartRequest;
import br.com.vr.authorizer.infra.adapter.entity.colections.CreditCard;
import lombok.Builder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public class CreditCardPort {

    public static final long NEW_AVAILABLE = 500L;
    private String _id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private LocalDateTime deleted;

    private String numberCard;
    private String password;

    private BigDecimal available;

    public CreditCardPort() {
    }

    public CreditCardPort(CreditCartRequest request) {
        this.numberCard = request.getNumberCard();
        this.password = encodPassword(request.getPassword());
        this.available = newAvailableValue();
    }

    public CreditCardPort(String numberCard, String password) {
        this.numberCard = numberCard;
        this.password = password;
    }

    public CreditCardPort(CreditCard creditCard) {
        this.numberCard = creditCard.getNumberCard();
        this.available = creditCard.getAvailable();
    }

    private String encodPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    private BigDecimal newAvailableValue() {
        return BigDecimal.valueOf(NEW_AVAILABLE);
    }

    public CreditCardPort(String _id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, LocalDateTime deleted, String numberCard, String password, BigDecimal available) {
        this._id = _id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.deleted = deleted;
        this.numberCard = numberCard;
        this.password = password;
        this.available = available;
    }

    public CreditCartDTO toCreditCard() {
        return new CreditCartDTO(this.numberCard, this.password, this.available);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDateTime getDeleted() {
        return deleted;
    }

    public void setDeleted(LocalDateTime deleted) {
        this.deleted = deleted;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }
}
