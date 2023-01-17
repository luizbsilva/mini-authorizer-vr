package br.com.vr.authorizer.domain;

import br.com.vr.authorizer.domain.dto.ItemTransaction;
import br.com.vr.authorizer.domain.dto.TransactionRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NotBlank
public class TransactionPort {

    private String _id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private LocalDateTime deleted;

    private CreditCardPort creditCardPort;

    private LocalDateTime dataTransaction;

    private Integer transactionCode;

    private BigDecimal transactionValue;

    public TransactionPort(String _id, LocalDateTime dataTransaction, Integer transactionCode, BigDecimal transactionValue) {
        this._id = _id;
        this.dataTransaction = dataTransaction;
        this.transactionCode = transactionCode;
        this.transactionValue = transactionValue;
    }

    public TransactionPort(TransactionRequest request) {
        this.createdDate = LocalDateTime.now();
        this.creditCardPort = new CreditCardPort(request.getNumberCard(), request.getPassword());
        this.dataTransaction = LocalDateTime.now();
        this.transactionValue = request.getTransactionValue();
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

    public CreditCardPort getCreditCardPort() {
        return creditCardPort;
    }

    public void setCreditCardPort(CreditCardPort creditCardPort) {
        this.creditCardPort = creditCardPort;
    }

    public LocalDateTime getDataTransaction() {
        return dataTransaction;
    }

    public void setDataTransaction(LocalDateTime dataTransaction) {
        this.dataTransaction = dataTransaction;
    }

    public Integer getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Integer transactionCode) {
        this.transactionCode = transactionCode;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public ItemTransaction toItem() {
        return new ItemTransaction(this.transactionCode, this.dataTransaction, this.transactionValue);
    }

}