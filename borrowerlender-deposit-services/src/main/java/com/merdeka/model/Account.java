package com.merdeka.model;

public class Account {
	private Long id;
	private Long idMember;
	private int isActive;
	private String kodeAkun;
	
	
	
	public Account() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdMember() {
		return idMember;
	}
	public void setIdMember(Long idMember) {
		this.idMember = idMember;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getKodeAkun() {
		return kodeAkun;
	}
	public void setKodeAkun(String kodeAkun) {
		this.kodeAkun = kodeAkun;
	} 
	
	
}
