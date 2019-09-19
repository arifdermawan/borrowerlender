package com.merdeka.borrowerlenderuserservices.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.merdeka.borrowerlenderuserservices.model.Account;
import com.merdeka.borrowerlenderuserservices.model.BaseResponse;


@JsonInclude(JsonInclude.Include.NON_NULL) 
public class AccountResponse extends BaseResponse{
	private Account account;
	private List<Account> accounts;
	
	public AccountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	
}
