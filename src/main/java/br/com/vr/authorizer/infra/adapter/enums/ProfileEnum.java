package br.com.vr.authorizer.infra.adapter.enums;

public enum ProfileEnum {
    ROLE_NULL(0),
    ROLE_ADM(1);


    ProfileEnum(int codeRole) {
    }

    public static ProfileEnum fromInteger(int codeRole) {
        switch (codeRole) {

            case 1:
                return ProfileEnum.ROLE_ADM;
        }
        return ROLE_NULL;
    }
}
