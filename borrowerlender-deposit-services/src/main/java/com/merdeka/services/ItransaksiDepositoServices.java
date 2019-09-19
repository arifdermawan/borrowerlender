package com.merdeka.services;

import com.merdeka.model.TransaksiDeposit;

public interface ItransaksiDepositoServices {
	TransaksiDeposit getTransaksiDepositoById(Long id);
	void AddTransaksiDeposito(TransaksiDeposit transaksiDeposito);
	void UpdateTransaksiDeposito(TransaksiDeposit transaksiDeposito);
	void DeleteTransaksiDeposito(Long Id);
}
