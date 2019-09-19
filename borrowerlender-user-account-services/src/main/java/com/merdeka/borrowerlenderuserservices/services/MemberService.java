package com.merdeka.borrowerlenderuserservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.merdeka.borrowerlenderuserservices.model.Member;
import com.merdeka.borrowerlenderuserservices.repository.MemberRepository;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		List<Member> listMember = new ArrayList<Member>();
		memberRepository.findAll().forEach(e -> listMember.add(e));
		return listMember;
	}

	@Override
	public Member getMemberById(Long id) {
		// TODO Auto-generated method stub
		Member member =  memberRepository.findById(id).get();
		return member;
	}

	@Override
	public Member getMemberByKode(String kode) {
		// TODO Auto-generated method stub
		Member member =  memberRepository.findByKode(kode).get();
		return member;
	}

	@Override
	public boolean addMember(Member user) {
		// TODO Auto-generated method stub
		List<Member> list = memberRepository.findByNik(user.getNik());
		if (list.size() > 0) {
			return false;
		}else {
			memberRepository.save(user);
			return true;
		}
		
	}

	@Override
	public void updateMember(Member user) {
		// TODO Auto-generated method stub
		memberRepository.save(user);
	}



	@Override
	public void deleteMember(int userId) {
		// TODO Auto-generated method stub
		memberRepository.delete(getMemberById((long) userId));
	}

	@Override
	public List<Member> getMemberByNik(String nik) {
		// TODO Auto-generated method stub
		List<Member> list = memberRepository.findByNik(nik);
		return list;
	}

	

	

	

}
