package com.merdeka.borrowerlenderuserservices.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.DynamicUpdate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * The persistent class for the members database table.
 * 
 */
@Entity
@Table(name="members")
@DynamicUpdate
@ApiModel(description = "All details about the Members. ")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated Member ID")
	private Long id;

	@Column(name="alamat")
	@NotBlank(message = "Alamat is mandatory")
	private String alamat;
	
	@Column(name="nik")
	@NotBlank(message = "Nik is mandatory")
	@ApiModelProperty(notes = "NIK Member")
	private String nik;

	@Column(name="is_active")
	@ApiModelProperty(notes = "Member Status isActive=0 (Not Active) isActive=1 (Active)")
	private byte isActive;

	@Column(name="is_borrower")
	@ApiModelProperty(notes = "Member as Borrower isBorrower=0 (Not Borrower) isBorrower=1 (Borrower)")
	private byte isBorrower;

	@Column(name="is_lender")
	@ApiModelProperty(notes = "Member as Lender isLender=0 (Not Lender) isLender=1 (Lender)")
	private byte isLender;

	@Column(name="kode")
	@ApiModelProperty(notes = "Kode Member")
	private String kode;

	@Column(name="nama")
	@NotBlank(message = "Nama is mandatory")
	private String nama;

	@Column(name="phone_no")
	@ApiModelProperty(notes = "Phone Number")
	private String phoneNo;

	

	

	public Member() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsBorrower() {
		return this.isBorrower;
	}

	public void setIsBorrower(byte isBorrower) {
		this.isBorrower = isBorrower;
	}

	public byte getIsLender() {
		return this.isLender;
	}

	public void setIsLender(byte isLender) {
		this.isLender = isLender;
	}

	public String getKode() {
		return this.kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return this.nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	

	

}