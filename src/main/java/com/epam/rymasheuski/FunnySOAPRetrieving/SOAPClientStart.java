package com.epam.rymasheuski.FunnySOAPRetrieving;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.dataaccess.webservicesserver.NumberConversion;
import com.dataaccess.webservicesserver.NumberConversionSoapType;


public class SOAPClientStart {
	private static final String WSDL_LOCATION = "http://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL";

	public static void main(String[] args) {
		
		try {
			URL wsdlLocation = new URL(WSDL_LOCATION);
			NumberConversion numberConversion = new NumberConversion(wsdlLocation);
			NumberConversionSoapType portSoap12 = numberConversion.getNumberConversionSoap12();
			
			String result = portSoap12.numberToWords(new BigInteger("45616833"));
			System.out.println(result);
			String result0 = portSoap12.numberToDollars(new BigDecimal("100.75"));
			System.out.println(result0);
			
			NumberConversionSoapType portSoap = numberConversion.getNumberConversionSoap();
			String result1 = portSoap.numberToWords(new BigInteger("45616833"));
			System.out.println(result1);
			
			QName serviceName = numberConversion.getServiceName();
			System.out.println(serviceName);
			
			System.out.println("Finish!!!!!!!!!!!!!!!!!");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}

