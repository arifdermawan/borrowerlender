package com.merdeka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.merdeka.error.RestTemplateResponseErrorHandler;
import com.merdeka.model.JurnalGl;

@Service
public class GlobalConsumeServices {
	private RestTemplate restTemplate;
	 
    @Autowired
    public GlobalConsumeServices(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
          .errorHandler(new RestTemplateResponseErrorHandler())
          .build();
    }
 
    public JurnalGl PostToJurnalGL(String uri, JurnalGl jurnalGL) {
        JurnalGl jurnal = restTemplate.postForObject(uri, jurnalGL, JurnalGl.class);
        return jurnal;
    }
}
