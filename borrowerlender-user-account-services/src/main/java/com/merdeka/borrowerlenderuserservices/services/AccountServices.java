package com.merdeka.borrowerlenderuserservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merdeka.borrowerlenderuserservices.model.Account;
import com.merdeka.borrowerlenderuserservices.repository.AccountRepository;

@Service
public class AccountServices implements IAccountServices{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAccountByMemberId(Long memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountByKodeAccountAndMemberId(String kodeAccount, Long memberId) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findByKodeAkunAndIdMember(kodeAccount, memberId);
		return account;
	}

	@Override
	public boolean AddAccount(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
		return true;
	}

	@Override
	public void UpdateAccount(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		accountRepository.delete(getAccountById((long) id));
	}

	@Override
	public Account getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).get();
		return account;
	}

	@Override
	public Account getAccountByKode(String Kode) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findByKodeAkun(Kode);
		return account;
	}

}
