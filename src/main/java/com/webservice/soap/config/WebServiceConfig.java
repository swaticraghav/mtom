package com.webservice.soap.config;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.webservice.soap.FileWsImpl;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endPoint() {

		Endpoint endPoint = new EndpointImpl(bus, new FileWsImpl());
		endPoint.publish("/uploadAndDownload");

		// turn the MTOM support ON on soap binding
		SOAPBinding binding = (SOAPBinding) endPoint.getBinding();
		binding.setMTOMEnabled(true);

		return endPoint;
	}
}
