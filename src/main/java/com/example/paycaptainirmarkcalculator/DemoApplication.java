package com.example.paycaptainirmarkcalculator;

import com.example.paycaptainirmarkcalculator.controller.AsynController;
import com.example.paycaptainirmarkcalculator.fps.GovTalkMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

@Controller
@SpringBootApplication
@EnableAsync
public class DemoApplication {

	@Autowired(required = true)
	private AsynController asynController;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@ResponseBody
	@PostMapping(value = "/generatefpsirmark", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  generateFPSXMLWithIRMark(@RequestHeader HttpHeaders headers,
									  	 	@RequestBody GovTalkMessage xmldata) throws Exception {

		String taxYear = xmldata.Body.IRenvelope.FullPaymentSubmission.RelatedTaxYear;
		String endDateMonth = headers.get("monthnumber").get(0);
		String hmrcId = headers.get("hmrcId").get(0);
		String isSandbox = headers.get("isSandbox").get(0);

		System.out.println("taxYear: "+taxYear);
		System.out.println("endDateMonth: "+endDateMonth);
		System.out.println("hmrcId: "+hmrcId);
		System.out.println("isSandbox: "+isSandbox);

		JAXBContext jaxbContext = JAXBContext.newInstance(GovTalkMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(xmldata, sw);

		String xmlContent = sw.toString();

		asynController.generateFPSIRMark(xmlContent, taxYear, endDateMonth, hmrcId, isSandbox);;

		return "success";
	}

	@ResponseBody
	@PostMapping(value = "/generateepsirmark", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  generateEPSXMLWithIRMark(@RequestHeader HttpHeaders headers,
										 	@RequestBody com.example.paycaptainirmarkcalculator.eps.GovTalkMessage xmldata) throws Exception {

		String taxYear = xmldata.Body.IRenvelope.EmployerPaymentSummary.RelatedTaxYear;
		String endDateMonth = headers.get("monthnumber").get(0);
		String hmrcId = headers.get("hmrcId").get(0);
		String isSandbox = headers.get("isSandbox").get(0);

		JAXBContext jaxbContext = JAXBContext.newInstance(com.example.paycaptainirmarkcalculator.eps.GovTalkMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(xmldata, sw);

		String xmlContent = sw.toString();

		asynController.generateEPSIRMark(xmlContent, taxYear, endDateMonth, hmrcId, isSandbox);;

		return "success";
	}


	@ResponseBody
	@PostMapping(value = "/generatagentauthirmark", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  generateEPSXMLWithIRMark(@RequestHeader HttpHeaders headers,
										 	@RequestBody com.example.paycaptainirmarkcalculator.eps.GovTalkMessage xmldata) throws Exception {

		String hmrcId = headers.get("hmrcId").get(0);
		String isSandbox = headers.get("isSandbox").get(0);

		JAXBContext jaxbContext = JAXBContext.newInstance(com.example.paycaptainirmarkcalculator.eps.GovTalkMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(xmldata, sw);

		String xmlContent = sw.toString();

		asynController.generateAgentAuthIRMark(xmlContent, hmrcId, isSandbox);;

		return "success";
	}










	// use this functions for editing and testing code.
	// AsynController.generateFPSIRMarkTest
	// PayCaptainRestClient.sendIRMarkToPayCaptainTest
	@ResponseBody
	@PostMapping(value = "/generatefpsirmark/test", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  generateFPSXMLWithIRMarkTest(@RequestHeader HttpHeaders headers,
												@RequestBody GovTalkMessage xmldata) throws Exception {
		System.out.println("generateFPSXMLWithIRMarkTest");

		String taxYear = xmldata.Body.IRenvelope.FullPaymentSubmission.RelatedTaxYear;
		String endDateMonth = headers.get("monthnumber").get(0);
		String hmrcId = headers.get("hmrcId").get(0);
		String key = headers.get("key").get(0);
		String isSandbox = headers.get("isSandbox").get(0);

		System.out.println("Test taxYear: "+taxYear);
		System.out.println("Test endDateMonth: "+endDateMonth);
		System.out.println("Test hmrcId: "+hmrcId);
		System.out.println("Test key: "+key);
		System.out.println("Test isSandbox: "+isSandbox);

		JAXBContext jaxbContext = JAXBContext.newInstance(GovTalkMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(xmldata, sw);

		String xmlContent = sw.toString();

		asynController.generateFPSIRMarkTest(xmlContent, taxYear, endDateMonth, hmrcId, key, isSandbox);;

		return "success";
	}



}
