package com.merdeka.error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler{

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
		// TODO Auto-generated method stub
		return (
		          httpResponse.getStatusCode().series() == Series.CLIENT_ERROR 
		          || httpResponse.getStatusCode().series() == Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
		      try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getBody()))) {
		        String httpBodyResponse = reader.lines().collect(Collectors.joining(""));

		        // TODO deserialize (could be JSON, XML, whatever...) httpBodyResponse to a POJO that matches the error structure for that specific API, then extract the error message.
		        // Here the whole response will be treated as the error message, you probably don't want that.
		        String errorMessage = httpBodyResponse;

		        throw new MyRestTemplateException(response.getStatusCode(), errorMessage);
		      }
		    }
	}
	
}
