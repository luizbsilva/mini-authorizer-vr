package br.com.vr.authorizer.domain.mapper;

public interface MapperDomain<DOMAIN, MODEL> {
    public abstract MODEL toModel(DOMAIN domain);

    public abstract DOMAIN toDomain(MODEL model);
}
