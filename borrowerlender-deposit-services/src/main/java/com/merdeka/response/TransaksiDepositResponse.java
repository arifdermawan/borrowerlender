package com.merdeka.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.merdeka.model.TransaksiDeposit;


@JsonInclude(JsonInclude.Include.NON_NULL) 
public class TransaksiDepositResponse extends BaseResponse{
	private TransaksiDeposit transaksiDeposit;
	private List<TransaksiDeposit> transaksiDeposits;
	public TransaksiDeposit getTransaksiDeposit() {
		return transaksiDeposit;
	}
	public void setTransaksiDeposit(TransaksiDeposit transaksiDeposit) {
		this.transaksiDeposit = transaksiDeposit;
	}
	public List<TransaksiDeposit> getTransaksiDeposits() {
		return transaksiDeposits;
	}
	public void setTransaksiDeposits(List<TransaksiDeposit> transaksiDeposits) {
		this.transaksiDeposits = transaksiDeposits;
	}
	
	
}
