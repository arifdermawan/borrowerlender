package com.merdeka.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * The persistent class for the transaksi_deposit database table.
 * 
 */
@Entity
@Table(name="transaksi_deposit")
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "All details about the Jurnal GL. ")
public class TransaksiDeposit extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="jumlah")
	@NotNull(message = "jumlah tidak boleh kosong")
	private double jumlah;

	@Column(name="kode_transaksi_deposit")
	@Size(min = 10, message = "kode Transaksi minimal 10")
    @NotEmpty(message = "kode tidak boleh kosong")
	private String kodeTransaksiDeposit;
	
	@Column(name="kode_akun")
	@Size(min = 7, message = "kode Akun minimal 7")
    @NotEmpty(message = "kode tidak boleh kosong")
	private String kodeAkun;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tanggal;

	
	@Column(name="id_member")
	@NotNull(message="id number tidak boleh kosong")
	private Long idNumber;

	public TransaksiDeposit() {
	}

	

	public double getJumlah() {
		return this.jumlah;
	}

	public void setJumlah(double jumlah) {
		this.jumlah = jumlah;
	}

	

	public Date getTanggal() {
		return this.tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getKodeTransaksiDeposit() {
		return kodeTransaksiDeposit;
	}



	public void setKodeTransaksiDeposit(String kodeTransaksiDeposit) {
		this.kodeTransaksiDeposit = kodeTransaksiDeposit;
	}



	public Long getIdNumber() {
		return idNumber;
	}



	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}



	public String getKodeAkun() {
		return kodeAkun;
	}



	public void setKodeAkun(String kodeAkun) {
		this.kodeAkun = kodeAkun;
	}

	

}