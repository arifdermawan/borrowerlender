package com.merdeka.borrowerlenderuserservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.merdeka.borrowerlenderuserservices.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long>{
	List<Account> findByIdMember(Long id);
	Account findByKodeAkunAndIdMember(String kodeAkun, Long id);
	Account findByKodeAkun(String kodeAkun);
}
