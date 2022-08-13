package br.com.vr.authorizer.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;
@Data
public class BaseDomain implements Persistable<String>{

    @Id
    private String _id;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private LocalDateTime deleted;

    @Override
   public String getId() {
        return _id;
    }

    @Override
    public boolean isNew() {
        return _id == null;
    }
}
