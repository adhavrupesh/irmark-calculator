package com.example.paycaptainirmarkcalculator;

import com.example.paycaptainirmarkcalculator.controller.AsynController;
import com.example.paycaptainirmarkcalculator.fps.GovTalkMessage;
import com.example.paycaptainirmarkcalculator.controller.NotificationService;
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
	@PostMapping(value = "/calculate", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  generateFPSXMLWithIRMark(@RequestHeader HttpHeaders headers,
									  	 	@RequestBody GovTalkMessage xmldata) throws Exception {

		String taxYear = xmldata.Body.IRenvelope.FullPaymentSubmission.RelatedTaxYear;
		String endDateMonth = headers.get("monthnumber").get(0);

		JAXBContext jaxbContext = JAXBContext.newInstance(GovTalkMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(xmldata, sw);

		String xmlContent = sw.toString();

		if(xmlContent.contains("<MessageDetailsClass>")) {
			xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
			xmlContent = xmlContent.replace("</MessageDetailsClass>", "</Class>");
		}
		if(xmlContent.contains("<IRenvelope>")){
			xmlContent = xmlContent.replace("<IRenvelope>",
					"<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/"+taxYear+"/"+endDateMonth+"\">");
		}
		if(xmlContent.contains(" standalone=\"yes\"")){
			xmlContent = xmlContent.replace(" standalone=\"yes\"", "");
		}
		if(xmlContent.contains("\n")){
			xmlContent = xmlContent.replace("\n", "");
		}

		//added on 09 December 2021
		if(xmlContent.contains("NIlettersAndValuesB")){
			xmlContent = xmlContent.replace("NIlettersAndValuesB", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesC")){
			xmlContent = xmlContent.replace("NIlettersAndValuesC", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesH")){
			xmlContent = xmlContent.replace("NIlettersAndValuesH", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesJ")){
			xmlContent = xmlContent.replace("NIlettersAndValuesJ", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesM")){
			xmlContent = xmlContent.replace("NIlettersAndValuesM", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesX")){
			xmlContent = xmlContent.replace("NIlettersAndValuesX", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesZ")){
			xmlContent = xmlContent.replace("NIlettersAndValuesZ", "NIlettersAndValues");
		}

		InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());

		IRMarkCalculator mc = new IRMarkCalculator();
		String base64 = mc.createMark(targetStream);
		System.out.println("output base64 : "+base64);

		if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
			xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
		}
		if(xmlContent.contains("\n")){
			xmlContent = xmlContent.replace("\n", "");
		}

		return xmlContent;
	}

	@ResponseBody
	@PostMapping(value = "/calculateeps", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  generateEPSXMLWithIRMark(@RequestHeader HttpHeaders headers,
										 	@RequestBody com.example.paycaptainirmarkcalculator.eps.GovTalkMessage xmldata) throws Exception {

		//System.out.println("#### calculateeps monthnumber = "+ headers.get("monthnumber").get(0));

		//String endDateMonth = xmldata.Body.IRenvelope.IRheader.PeriodEnd;
		String taxYear = xmldata.Body.IRenvelope.EmployerPaymentSummary.RelatedTaxYear;
		String endDateMonth = headers.get("monthnumber").get(0);

		JAXBContext jaxbContext = JAXBContext.newInstance(com.example.paycaptainirmarkcalculator.eps.GovTalkMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(xmldata, sw);

		String xmlContent = sw.toString();

		if(xmlContent.contains("<MessageDetailsClass>")) {
			xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
			xmlContent = xmlContent.replace("</MessageDetailsClass>", "</Class>");
		}
		if(xmlContent.contains("<IRenvelope>")){
			xmlContent = xmlContent.replace("<IRenvelope>",
					"<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/PAYE/RTI/EmployerPaymentSummary/"+taxYear+"/"+endDateMonth+"\">");
		}
		if(xmlContent.contains(" standalone=\"yes\"")){
			xmlContent = xmlContent.replace(" standalone=\"yes\"", "");
		}
		if(xmlContent.contains("\n")){
			xmlContent = xmlContent.replace("\n", "");
		}

		InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());

		IRMarkCalculator mc = new IRMarkCalculator();
		String base64 = mc.createMark(targetStream);
		//System.out.println("#### calculateeps output base64 : "+base64);

		if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
			xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
		}
		if(xmlContent.contains("\n")){
			xmlContent = xmlContent.replace("\n", "");
		}

		return xmlContent;
	}


	@ResponseBody
	@PostMapping(value = "/generatefpsirmark/test", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  testGenerateFPSXMLWithIRMark(@RequestHeader HttpHeaders headers,
											@RequestBody GovTalkMessage xmldata) throws Exception {
		System.out.println("testGenerateFPSXMLWithIRMark");

		String taxYear = xmldata.Body.IRenvelope.FullPaymentSubmission.RelatedTaxYear;
		String endDateMonth = headers.get("monthnumber").get(0);

		JAXBContext jaxbContext = JAXBContext.newInstance(GovTalkMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(xmldata, sw);

		String xmlContent = sw.toString();

		if(xmlContent.contains("<MessageDetailsClass>")) {
			xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
			xmlContent = xmlContent.replace("</MessageDetailsClass>", "</Class>");
		}
		if(xmlContent.contains("<IRenvelope>")){
			xmlContent = xmlContent.replace("<IRenvelope>",
					"<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/"+taxYear+"/"+endDateMonth+"\">");
		}
		if(xmlContent.contains(" standalone=\"yes\"")){
			xmlContent = xmlContent.replace(" standalone=\"yes\"", "");
		}
		if(xmlContent.contains("\n")){
			xmlContent = xmlContent.replace("\n", "");
		}

		//added on 09 December 2021
		if(xmlContent.contains("NIlettersAndValuesB")){
			xmlContent = xmlContent.replace("NIlettersAndValuesB", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesC")){
			xmlContent = xmlContent.replace("NIlettersAndValuesC", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesH")){
			xmlContent = xmlContent.replace("NIlettersAndValuesH", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesJ")){
			xmlContent = xmlContent.replace("NIlettersAndValuesJ", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesM")){
			xmlContent = xmlContent.replace("NIlettersAndValuesM", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesX")){
			xmlContent = xmlContent.replace("NIlettersAndValuesX", "NIlettersAndValues");
		}
		if(xmlContent.contains("NIlettersAndValuesZ")){
			xmlContent = xmlContent.replace("NIlettersAndValuesZ", "NIlettersAndValues");
		}

		asynController.generateIRMark(xmlContent);;

		return "success";
	}



}
