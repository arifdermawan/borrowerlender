package com.merdeka.borrowerlenderuserservices.services;

import java.util.List;

import com.merdeka.borrowerlenderuserservices.model.Account;

public interface IAccountServices {
	List<Account> getAccountByMemberId(Long memberId);
	Account getAccountByKodeAccountAndMemberId(String kodeAccount, Long memberId);
	Account getAccountById(Long id);
	Account getAccountByKode(String Kode);
	boolean AddAccount(Account account);
	void UpdateAccount(Account account);
	void deleteAccount(int id);
}
