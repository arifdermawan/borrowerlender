package com.merdeka.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;



public class JurnalGl implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private double jumlah = 0;

	private Date tanggal;

	private int tipeJurnal;

	private String kodeAkun;
	

	private String nomorTransaksi;
	
	private Long idMember;

	public JurnalGl() {
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

	public int getTipeJurnal() {
		return this.tipeJurnal;
	}

	public void setTipeJurnal(int tipeJurnal) {
		this.tipeJurnal = tipeJurnal;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getKodeAkun() {
		return kodeAkun;
	}



	public void setKodeAkun(String kodeAkun) {
		this.kodeAkun = kodeAkun;
	}



	public String getNomorTransaksi() {
		return nomorTransaksi;
	}



	public void setNomorTransaksi(String nomorTransaksi) {
		this.nomorTransaksi = nomorTransaksi;
	}



	public Long getIdMember() {
		return idMember;
	}



	public void setIdMember(Long idMember) {
		this.idMember = idMember;
	}



	

	

}