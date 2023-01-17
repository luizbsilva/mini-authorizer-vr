package br.com.vr.authorizer.infra.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDomain implements Persistable<String> {

    @Id
    public String _id;

    @CreatedDate
    public LocalDateTime createdDate;

    @LastModifiedDate
    public LocalDateTime lastModifiedDate;

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
