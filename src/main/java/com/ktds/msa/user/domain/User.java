package com.ktds.msa.user.domain;


import com.ktds.msa.user.common.jpa.BooleanYesNoConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @NotNull
    private String userName;

    @NotNull
    private String realName;

    @NotNull
    private String userPass;

    @NotNull
    private String userPass2;

    @NotNull
    private String roles;

    @Column(length = 1)
    @Convert(converter = BooleanYesNoConverter.class)
    private Boolean accountNonExpired;

    @Column(length = 1)
    @Convert(converter = BooleanYesNoConverter.class)
    private Boolean accountNonLocked;

    @Column(length = 1)
    @Convert(converter = BooleanYesNoConverter.class)
    private Boolean credentialsNonExpired;

    @Column(length = 1)
    @Convert(converter = BooleanYesNoConverter.class)
    private Boolean enabled;

    public User() {
    }

    public User(String userName, String realName, String userPass) {
        this.userName = userName;
        this.realName = realName;
        this.userPass = userPass;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "seq=" + seq +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", roles='" + roles + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }
}
