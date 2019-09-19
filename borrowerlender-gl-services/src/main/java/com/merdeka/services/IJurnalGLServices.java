package com.merdeka.services;


import com.merdeka.model.JurnalGl;

public interface IJurnalGLServices {
	JurnalGl getJurnalGlById(Long id);
	boolean AddJurnalGl(JurnalGl jurnalGl);
	void UpdateJurnalGl(JurnalGl jurnalGl);
	void deleteJurnalGl(int id);
}
