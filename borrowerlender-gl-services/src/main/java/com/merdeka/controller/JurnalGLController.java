package com.merdeka.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.merdeka.model.Account;
import com.merdeka.model.AccountResponse;
import com.merdeka.model.JurnalGl;
import com.merdeka.response.JurnalGlResponse;
import com.merdeka.services.IJurnalGLServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("api")
@Api(value = "Jurnal GL Services",description  = "Jurnal GL Service")
public class JurnalGLController {
	
	@Autowired
	private IJurnalGLServices jurnalGLServices; 
	
	final String urigetAccountByKodeAkun = "http://localhost:8080/api/account/{kodeAkun}";
	
	@PostMapping("jurnalgl")
	@ApiOperation(value = "Save Jurnal GL", response = JurnalGlResponse.class)
	public ResponseEntity<JurnalGlResponse> saveJurnalGl(
			@ApiParam(value = "Jurnal GL Object", required = true) @RequestBody @Valid JurnalGl jurnalGL){
		
		JurnalGlResponse response = new JurnalGlResponse();
		
		 	Map<String, String> params = new HashMap<String,String>();
		    params.put("kodeAkun", jurnalGL.getKodeAkun());
		     
		    RestTemplate restTemplate = new RestTemplate();
		    AccountResponse accountResponse = restTemplate.getForObject(urigetAccountByKodeAkun, AccountResponse.class,params);
		    if (accountResponse.getAccount() == null) {
		    	response.setHttpCode(HttpStatus.BAD_REQUEST.value());
		    	response.setMessage("Kode Akun Tidak Terdaftar");
		    	return new ResponseEntity<JurnalGlResponse>(response, HttpStatus.BAD_REQUEST);
		    }
		   
		    
		jurnalGLServices.AddJurnalGl(jurnalGL);
		response.setHttpCode(HttpStatus.OK.value());
    	response.setMessage("GL Created");
		//CALL 
		return new ResponseEntity<JurnalGlResponse>(response, HttpStatus.OK);
		
	}
}
