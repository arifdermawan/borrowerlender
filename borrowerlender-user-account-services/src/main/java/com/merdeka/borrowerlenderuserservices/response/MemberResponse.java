package com.merdeka.borrowerlenderuserservices.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.merdeka.borrowerlenderuserservices.model.BaseResponse;
import com.merdeka.borrowerlenderuserservices.model.Member;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL) 
public class MemberResponse extends BaseResponse {
	List<Member> members;
	Member member;
	
	public MemberResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	

}
