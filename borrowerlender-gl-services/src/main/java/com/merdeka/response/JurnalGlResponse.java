package com.merdeka.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.merdeka.model.JurnalGl;


@JsonInclude(JsonInclude.Include.NON_NULL) 
public class JurnalGlResponse extends BaseResponse{
	private JurnalGl jurnalGL;
	private List<JurnalGl> jurnalGLs;
	
	public JurnalGlResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JurnalGl getJurnalGL() {
		return jurnalGL;
	}

	public void setJurnalGL(JurnalGl jurnalGL) {
		this.jurnalGL = jurnalGL;
	}

	public List<JurnalGl> getJurnalGLs() {
		return jurnalGLs;
	}

	public void setJurnalGLs(List<JurnalGl> jurnalGLs) {
		this.jurnalGLs = jurnalGLs;
	}
	

	
}
