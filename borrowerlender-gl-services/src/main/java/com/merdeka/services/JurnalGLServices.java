package com.merdeka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merdeka.model.JurnalGl;
import com.merdeka.repository.JurnalRepository;

@Service
public class JurnalGLServices implements IJurnalGLServices {
	
	@Autowired
	private JurnalRepository jurnalRepository;

	@Override
	public boolean AddJurnalGl(JurnalGl jurnalGL) {
		// TODO Auto-generated method stub
		 jurnalRepository.save(jurnalGL);
		 return true;
	}

	@Override
	public void UpdateJurnalGl(JurnalGl jurnalGL) {
		// TODO Auto-generated method stub
		jurnalRepository.save(jurnalGL);
	}

	@Override
	public void deleteJurnalGl(int id) {
		// TODO Auto-generated method stub
		
		jurnalRepository.delete(getJurnalGlById((long) id));

	}

	@Override
	public JurnalGl getJurnalGlById(Long id) {
		// TODO Auto-generated method stub
		return jurnalRepository.findById((long) id).get();
	}

}
