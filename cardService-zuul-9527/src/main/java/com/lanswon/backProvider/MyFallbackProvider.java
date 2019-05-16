package com.lanswon.backProvider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Zull 对熔断的支持
 * @author GU-YW
 *
 */
//@Component
public class MyFallbackProvider implements FallbackProvider {
	
	@Override
	public String getRoute() {
		return "CARDSERVICECONSUME";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {
			
			 @Override
	            public HttpStatus getStatusCode() throws IOException {
	                return HttpStatus.BAD_REQUEST;
	            }

	            @Override
	            public int getRawStatusCode() throws IOException {
	                return HttpStatus.BAD_REQUEST.value();
	            }

	            @Override
	            public String getStatusText() throws IOException {
	                return HttpStatus.BAD_REQUEST.getReasonPhrase();
	            }

	            @Override
	            public void close() {

	            }

	            @Override
	            public InputStream getBody() throws IOException {
	                return new ByteArrayInputStream((getRoute() + "微服务不可用，请稍后再试").getBytes());
	            }

	            @Override
	            public HttpHeaders getHeaders() {
	                HttpHeaders headers = new HttpHeaders();
	                headers.setContentType(MediaType.APPLICATION_JSON);
	                return headers;
	            }
	
		};
	}

}
