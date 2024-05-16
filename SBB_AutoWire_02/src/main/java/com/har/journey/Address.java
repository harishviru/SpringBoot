package com.har.journey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

	@Value("7-52")
	private String dNo;
	@Value("Hyd")
	private String loc;
	@Override
	public String toString() {
		return "Address [dNo=" + dNo + ", loc=" + loc + "]";
	}
}
