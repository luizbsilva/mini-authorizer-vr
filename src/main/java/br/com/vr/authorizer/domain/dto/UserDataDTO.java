package br.com.vr.authorizer.domain.dto;

import br.com.vr.authorizer.infra.adapter.entity.colections.User;
import br.com.vr.authorizer.infra.adapter.enums.ProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDTO {
    private String code;
    private String email;
    private String password;
    private ProfileEnum profile;

    public UserDataDTO(User entity) {
        this.code = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.profile = entity.getProfile();
    }
}
