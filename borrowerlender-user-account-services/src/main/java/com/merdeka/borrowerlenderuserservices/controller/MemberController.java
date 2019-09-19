package com.merdeka.borrowerlenderuserservices.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.merdeka.borrowerlenderuserservices.model.Member;
import com.merdeka.borrowerlenderuserservices.repository.MemberRepository;
import com.merdeka.borrowerlenderuserservices.response.MemberResponse;
import com.merdeka.borrowerlenderuserservices.services.IMemberService;
import com.merdeka.borrowerlenderuserservices.utils.Utility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("api")
@Api(value = "User Services", description = "User Service")
public class MemberController {

	@Autowired
	private IMemberService memberService;

	@ApiOperation(value = "Get Member By Kode", response = MemberResponse.class)
	@GetMapping("member/kode/{kode}")
	public ResponseEntity<MemberResponse> getMemberByKode(
			@ApiParam(value = "Kode member", required = true) @PathVariable("kode") @NotBlank @Size(min=5) String kode) {

		MemberResponse memberResponse = new MemberResponse();
		try {
			Member member = memberService.getMemberByKode(kode);
			memberResponse.setMember(member);
			return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.OK);
		} catch (Exception ex) {

			memberResponse.setHttpCode(HttpStatus.BAD_REQUEST.value());
			memberResponse.setMessage("Member Not Found");
			return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Get Member By ID", response = MemberResponse.class)
	@GetMapping("member/{id}")
	public ResponseEntity<MemberResponse> getMemberById(
			@ApiParam(value = "ID Member", required = true) @PathVariable("id") Long id) {

		MemberResponse memberResponse = new MemberResponse();
		try {
			Member member = memberService.getMemberById(id);
			memberResponse.setMember(member);
			return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.OK);
		} catch (Exception ex) {

			memberResponse.setHttpCode(HttpStatus.BAD_REQUEST.value());
			memberResponse.setMessage("Member Not Found");
			return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Add an Mamber", response = MemberResponse.class)
	@PostMapping("member")
	public ResponseEntity<MemberResponse> addMember(
			@ApiParam(value = "Member object store in database table", required = true) @Valid @RequestBody Member member,
			UriComponentsBuilder builder) {
		MemberResponse response = new MemberResponse();

		member.setKode(Utility.randomAlphaNumeric(10));

		boolean flag = memberService.addMember(member);
		if (flag == false) {
			response.setHttpCode(HttpStatus.CONFLICT.value());
			response.setMessage("Member Already Registered");
			return new ResponseEntity<MemberResponse>(response, HttpStatus.CONFLICT);
		}

		Member getMember = memberService.getMemberByKode(member.getKode());
		response.setHttpCode(HttpStatus.CREATED.value());
		response.setMessage("Member Created");
		response.setMember(getMember);
		return new ResponseEntity<MemberResponse>(response, HttpStatus.CREATED);

	}

	@ApiOperation(value = "Update an Member", response = MemberResponse.class)
	@PutMapping("member/{id}")
	public ResponseEntity<MemberResponse> updateMember(
			@ApiParam(value = "Member object store in database table", required = true) @Valid @RequestBody Member member, 
			@ApiParam(value = "Id Member", required = true) @Valid @PathVariable Long Id) {
		MemberResponse response = new MemberResponse();
		try {
			memberService.updateMember(member);
			response.setHttpCode(HttpStatus.OK.value());
			response.setMessage("Member Updated");
			return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setHttpCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Error Member Updated");
			return new ResponseEntity<MemberResponse>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Update an Member Status Active or Not Active", response = MemberResponse.class)
	@PatchMapping("member/{id}")
	public ResponseEntity<MemberResponse> updateMemberStatus(
			@ApiParam(value = "Is Active 0 = Not Active, 1 = Active", required = true) @Valid  @RequestParam int isActive, 
			@ApiParam(value = "Member id", required = true) @Valid  @PathVariable Long id) {
		MemberResponse response = new MemberResponse();
		try {
			Member member = memberService.getMemberById(id);
			member.setIsActive((byte) isActive);
			memberService.updateMember(member);
			response.setHttpCode(HttpStatus.OK.value());
			response.setMessage("Member Updated");
			return new ResponseEntity<MemberResponse>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setHttpCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("Error Member Updated");
			return new ResponseEntity<MemberResponse>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
