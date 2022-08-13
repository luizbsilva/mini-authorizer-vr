package br.com.vr.authorizer.domain;

import br.com.vr.authorizer.data.util.ConstantsColections;
import br.com.vr.authorizer.domain.enums.ProfileEnum;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = ConstantsColections.COLECTION_USER)
public class User extends BaseDomain {

    //    @NotBlank(message = "Name required")
    private String name;

    //    @Indexed(unique = true)
//    @NotBlank(message = "Email required")
//    @Email(message = "Email invalid")
    private String email;

    private String password;

    private ProfileEnum profile;

    //    @NotBlank
    private boolean active;

}
