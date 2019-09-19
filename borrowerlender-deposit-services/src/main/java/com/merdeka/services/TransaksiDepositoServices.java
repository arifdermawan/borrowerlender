package com.merdeka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merdeka.model.TransaksiDeposit;
import com.merdeka.repository.TransaksiDepositoRepository;

@Service
public class TransaksiDepositoServices implements ItransaksiDepositoServices {
	
	@Autowired
	private TransaksiDepositoRepository transaksiDepositoRepository;

	@Override
	public TransaksiDeposit getTransaksiDepositoById(Long id) {
		// TODO Auto-generated method stub
		TransaksiDeposit tr = transaksiDepositoRepository.findById(id).get();
		return tr;
	}

	@Override
	public void AddTransaksiDeposito(TransaksiDeposit transaksiDeposito) {
		// TODO Auto-generated method stub
		transaksiDepositoRepository.save(transaksiDeposito);
	}

	@Override
	public void UpdateTransaksiDeposito(TransaksiDeposit transaksiDeposito) {
		// TODO Auto-generated method stub
		transaksiDepositoRepository.save(transaksiDeposito);
	}

	@Override
	public void DeleteTransaksiDeposito(Long Id) {
		// TODO Auto-generated method stub
		transaksiDepositoRepository.delete(getTransaksiDepositoById(Id));
	}

}
