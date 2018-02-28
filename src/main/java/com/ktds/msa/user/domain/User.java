package com.ktds.msa.user.domain;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="User")
public class User implements Serializable {
	
	@Id
	@NotNull
	private String name;
	
	private String password;	
	private String enabled;
	private String use_yn;
	private String birth_dt;
	private String submit_yn;
	private String save_tab_id;
	private String password_chg_yn;
	private String salt;
	private String ad_no;
		
	public User() {
	}
	
	public User(String userName, String userPass) {
		this.name = userName;      
	    this.password = userPass;
	}	
	
   public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getBirth_dt() {
		return birth_dt;
	}

	public void setBirth_dt(String birth_dt) {
		this.birth_dt = birth_dt;
	}

	public String getSubmit_yn() {
		return submit_yn;
	}

	public void setSubmit_yn(String submit_yn) {
		this.submit_yn = submit_yn;
	}

	public String getSave_tab_id() {
		return save_tab_id;
	}

	public void setSave_tab_id(String save_tab_id) {
		this.save_tab_id = save_tab_id;
	}

	public String getPassword_chg_yn() {
		return password_chg_yn;
	}

	public void setPassword_chg_yn(String password_chg_yn) {
		this.password_chg_yn = password_chg_yn;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getAd_no() {
		return ad_no;
	}

	public void setAd_no(String ad_no) {
		this.ad_no = ad_no;
	}

	@Override
    public String toString() {
        return "User{" +                
                "name='" + name +
                ", password='" + password + '\'' +
                ", enabled='" + enabled + '\'' +
                ", use_yn=" + use_yn +
                ", birth_dt=" + birth_dt +
                ", submit_yn=" + submit_yn +
                ", save_tab_id=" + save_tab_id +
                ", password_chg_yn=" + password_chg_yn +
                ", salt=" + salt +
                ", ad_no=" + ad_no +                
                '}';
    }	
	
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long seq;
//
//    @NotNull
//    private String userName;
//
//    @NotNull
//    private String realName;
//
//    @NotNull
//    private String userPass;
//
//    @NotNull
//    private String userPass2;
//
//    @NotNull
//    private String roles;
//
//    @Column(length = 1)
//    @Convert(converter = BooleanYesNoConverter.class)
//    private Boolean accountNonExpired;
//
//    @Column(length = 1)
//    @Convert(converter = BooleanYesNoConverter.class)
//    private Boolean accountNonLocked;
//
//    @Column(length = 1)
//    @Convert(converter = BooleanYesNoConverter.class)
//    private Boolean credentialsNonExpired;
//
//    @Column(length = 1)
//    @Convert(converter = BooleanYesNoConverter.class)
//    private Boolean enabled;
//
//    public User() {
//    }
//
//    public User(String userName, String realName, String userPass) {
//        this.userName = userName;
//        this.realName = realName;
//        this.userPass = userPass;
//    }
//
		
}
