package com.merdeka.borrowerlenderuserservices.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Data
@Entity
@Table(name="account")
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "All details about the Account. ")
public class Account extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated Account ID")
	private Long id;

	@Column(name="is_active")
	@ApiModelProperty(notes = "Account Status isActive=0 (Not Active) isActive=1 (Active)")
	private byte isActive;

	@Column(name="kode_akun")
	@ApiModelProperty(notes = "Account Number")
	private String kodeAkun;

	@Column(name="id_member")
	@ApiModelProperty(notes = "ID Member of Account")
	private Long idMember;


	public Account() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getKodeAkun() {
		return this.kodeAkun;
	}

	public void setKodeAkun(String kodeAkun) {
		this.kodeAkun = kodeAkun;
	}

	public byte getIsActive() {
		return isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public Long getIdMember() {
		return idMember;
	}

	public void setIdMember(Long idMember) {
		this.idMember = idMember;
	}



	

}