package com.merdeka.borrowerlenderuserservices.services;

import java.util.List;

import com.merdeka.borrowerlenderuserservices.model.Member;


public interface IMemberService {
	List<Member> getAllMembers();
	List<Member> getMemberByNik(String nik); 
	Member getMemberById(Long id);
	Member getMemberByKode(String kode);
	boolean addMember(Member user);
	void updateMember(Member user);
	void deleteMember(int userId);
}
