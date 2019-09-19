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


/**
 * The persistent class for the jurnal_gl database table.
 * 
 */
@Data
@Entity
@Table(name="jurnal_gl")
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "All details about the Jurnal GL. ")
public class JurnalGl extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="jumlah")
	@NotNull(message = "jumlah tidak boleh kosong")
	private double jumlah = 0;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tanggal;

	@Column(name="tipe_jurnal")
	@NotNull(message = "tipe_jurnal tidak boleh kosong")
	private int tipeJurnal;

	@Column(name="kode_akun")
	@Size(min = 7, message = "kode Akun minimal 7")
    @NotEmpty(message = "kode akun tidak boleh kosong")
	private String kodeAkun;
	
	@Column(name="nomor_transaksi")
	@Size(min = 7, message = "{user.name.invalid}")
    @NotEmpty(message = "nomor transaksi tidak boleh kosong")
	private String nomorTransaksi;
	
	
	@Column(name="id_member")
	@NotNull(message = "id member tidak boleh kosong")
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