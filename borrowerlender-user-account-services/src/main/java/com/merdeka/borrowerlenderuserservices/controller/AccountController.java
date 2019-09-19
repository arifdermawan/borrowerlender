package com.merdeka.borrowerlenderuserservices.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.merdeka.borrowerlenderuserservices.model.Account;
import com.merdeka.borrowerlenderuserservices.model.Member;
import com.merdeka.borrowerlenderuserservices.response.AccountResponse;
import com.merdeka.borrowerlenderuserservices.services.IAccountServices;
import com.merdeka.borrowerlenderuserservices.services.IMemberService;
import com.merdeka.borrowerlenderuserservices.utils.Utility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("api")
@Api(value = "Account Services",description  = "Account Service")
public class AccountController {
	
	@Autowired
	private IAccountServices accountServices;
	
	@Autowired
	private IMemberService memberService;
	
	
	@ApiOperation(value = "Get Account By Acoount Code and ID Member", response = AccountResponse.class)
	@GetMapping("account/{kodeAkun}/member/{id}")
	public ResponseEntity<AccountResponse> getAccountByKodeAkunAndMemberid(
			@ApiParam(value = "Kode Akun", required = true) @PathVariable("kodeAkun") @NotBlank @Size(min=7) String kodeAkun, 
			@ApiParam(value = "Id Member", required = true) @PathVariable("id") Long id){
		AccountResponse response = new AccountResponse();
		try {
			Account account = accountServices.getAccountByKodeAccountAndMemberId(kodeAkun, id);
			response.setAccount(account);
			return new ResponseEntity<AccountResponse>(response,HttpStatus.OK);
		}catch(Exception ex) {
			response.setHttpCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Account Not Found");
			return new ResponseEntity<AccountResponse>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@ApiOperation(value = "Get List Account By ID Member", response = AccountResponse.class)
	@GetMapping("account/member/{id}")
	public ResponseEntity<AccountResponse> getAccountByMemberid(
			@ApiParam(value = "Id Member", required = true) @PathVariable("id") Long id){
		AccountResponse response = new AccountResponse();
		try {
			List<Account> accounts = accountServices.getAccountByMemberId(id);
			response.setAccounts(accounts);
			return new ResponseEntity<AccountResponse>(response,HttpStatus.OK);
		}catch(Exception ex) {
			response.setHttpCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("List Account Not Found");
			return new ResponseEntity<AccountResponse>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@ApiOperation(value = "Get Account By Kode Akun", response = AccountResponse.class)
	@GetMapping("account/{kodeAkun}")
	public ResponseEntity<AccountResponse> getAccountByKodeAkun(
			@ApiParam(value = "Kode Akun", required = true) @PathVariable("kodeAkun") @NotBlank @Size(min=7) String kodeAkun){
		AccountResponse response = new AccountResponse();
		try {
			Account account = accountServices.getAccountByKode(kodeAkun);
			response.setAccount(account);
			return new ResponseEntity<AccountResponse>(response,HttpStatus.OK);
		}catch(Exception ex) {
			response.setHttpCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Account Not Found");
			return new ResponseEntity<AccountResponse>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@ApiOperation(value = "Add Account", response = AccountResponse.class)
	@PostMapping("account")
	public ResponseEntity<AccountResponse> addAccount(
			@ApiParam(value = "Account Object", required = true) @RequestBody Account account, 
			UriComponentsBuilder builder){
		
		AccountResponse response = new AccountResponse();
		account.setKodeAkun(Utility.randomAlphaNumeric(7));
		
		try {
			Member member = memberService.getMemberById(account.getId());
			
			boolean flag = accountServices.AddAccount(account);
			 if (flag == false) {
				 response.setHttpCode(HttpStatus.CONFLICT.value());
				response.setMessage("Account Already Exsist");
	         	return new ResponseEntity<AccountResponse>(response, HttpStatus.CONFLICT);
	         }
			 
			  	response.setHttpCode(HttpStatus.CREATED.value());
			  	response.setMessage("Account Created");
			  	Account acc = accountServices.getAccountByKode(account.getKodeAkun());
			  	response.setAccount(acc);
		         return new ResponseEntity<AccountResponse>(response, HttpStatus.CREATED);
			 
			 
		}catch(Exception ne) {
			response.setHttpCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Member Not Found");
         	return new ResponseEntity<AccountResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
       
		
	}
	
	
	

}
