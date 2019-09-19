package com.merdeka.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.merdeka.model.JurnalGl;
import com.merdeka.model.TransaksiDeposit;
import com.merdeka.response.TransaksiDepositResponse;
import com.merdeka.services.ItransaksiDepositoServices;
import com.merdeka.services.GlobalConsumeServices;
import com.merdeka.utils.Utility;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("api")
@Api(value = "Transaksi Deposito Services",description  = "Transaksi Deposito Service")
public class TransaksiDepositoController {
	
	@Autowired
	private ItransaksiDepositoServices transaksiDeposito;
	
	@Autowired 
	private GlobalConsumeServices consumeServices; 
	
	final String jurnalGL = "http://localhost:8081/api/jurnalgl";
	
	@PostMapping("deposit")
	public ResponseEntity<TransaksiDepositResponse> saveTransaksiDeposit(@RequestBody @Valid TransaksiDeposit transaksiDeposit) {
		TransaksiDepositResponse response = new TransaksiDepositResponse();
		
		transaksiDeposit.setKodeTransaksiDeposit(Utility.randomAlphaNumeric(10));
		transaksiDeposito.AddTransaksiDeposito(transaksiDeposit);
		
		JurnalGl jurnalGL = new JurnalGl();
		jurnalGL.setId((long) 0);
		jurnalGL.setIdMember(transaksiDeposit.getIdNumber());
		jurnalGL.setJumlah(transaksiDeposit.getJumlah());
		jurnalGL.setKodeAkun(transaksiDeposit.getKodeAkun());
		jurnalGL.setNomorTransaksi(transaksiDeposit.getKodeTransaksiDeposit());
		jurnalGL.setTanggal(new Date());
		jurnalGL.setTipeJurnal(1);
		
		JurnalGl jurnal =  consumeServices.PostToJurnalGL(this.jurnalGL, jurnalGL);
 
		 response.setHttpCode(HttpStatus.OK.value());
		 response.setMessage("Deposit Created");
		 
		return new ResponseEntity<TransaksiDepositResponse>(response,HttpStatus.OK);
		
	}
	
}
