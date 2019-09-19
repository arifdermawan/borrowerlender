package com.merdeka.borrowerlenderuserservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.merdeka.borrowerlenderuserservices.model.Member;


public interface MemberRepository extends CrudRepository<Member, Long>{
	Optional<Member> findByKode(String kode);
	List<Member> findByNama(String nama);
	List<Member> findByNamaAndAlamat(String nama,String alamat);
	List<Member> findByNik(String nik);
}
