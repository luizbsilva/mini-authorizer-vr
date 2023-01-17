package br.com.vr.authorizer.domain;

import br.com.vr.authorizer.domain.dto.UserDataDTO;
import br.com.vr.authorizer.infra.adapter.enums.ProfileEnum;

import java.time.LocalDateTime;

public class UserPort {

    private String _id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private LocalDateTime deleted;

    private String name;

    private String email;

    private String password;

    private ProfileEnum profile;

    private boolean active;

    public UserPort() {
    }

    public UserPort(String _id, LocalDateTime createdDate, LocalDateTime lastModifiedDate, LocalDateTime deleted,
                    String name, String email, String password, ProfileEnum profile, boolean active) {
        this._id = _id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.deleted = deleted;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.active = active;
    }

    public UserPort(UserDataDTO userDataDTO) {
        this.name = userDataDTO.getEmail();
        this.email = userDataDTO.getEmail();
        this.password = userDataDTO.getPassword();
        this.profile = userDataDTO.getProfile();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserDataDTO toUser() {
        return new UserDataDTO(this._id, this.email, this.password, this.profile);
    }
}
