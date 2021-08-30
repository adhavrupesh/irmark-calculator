package com.example.paycaptainirmarkcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@ResponseBody
	@PostMapping(value = "/ex/foos", consumes = MediaType.APPLICATION_XML_VALUE)//
	public String  getFoosBySimplePath(@RequestBody GovTalkMessage xmldata) throws Exception {

		//System.out.println("new xmldata = "+xmldata);

		JAXBContext jaxbContext = JAXBContext.newInstance(GovTalkMessage.class);

		//Create Marshaller
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		//Required formatting??
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		//Print XML String to Console
		StringWriter sw = new StringWriter();

		//Write XML to StringWriter
		jaxbMarshaller.marshal(xmldata, sw);

		//Verify XML Content
		String xmlContent = sw.toString();
		//System.out.println( "before replace xmlContent : "+xmlContent );

		if(xmlContent.contains("<MessageDetailsClass>")) {
			xmlContent = xmlContent.replace("<MessageDetailsClass>", "<Class>");
			xmlContent = xmlContent.replace("</MessageDetailsClass>", "</Class>");
		}
		if(xmlContent.contains("<IRenvelope>")){
			xmlContent = xmlContent.replace("<IRenvelope>", "<IRenvelope xmlns=\"http://www.govtalk.gov.uk/taxation/PAYE/RTI/FullPaymentSubmission/20-21/1\">");
		}
		if(xmlContent.contains(" standalone=\"yes\"")){
			xmlContent = xmlContent.replace(" standalone=\"yes\"", "");
		}
		if(xmlContent.contains("\n")){
			xmlContent = xmlContent.replace("\n", "");
		}
		System.out.println( "after replace xmlContent");
		System.out.println(xmlContent);

		InputStream targetStream = new ByteArrayInputStream(xmlContent.getBytes());

		IRMarkCalculator mc = new IRMarkCalculator();
		String base64 = mc.createMark(targetStream);
		System.out.println("output base64 : "+base64);

		//List<String> tosend = new ArrayList<String>();
		//tosend.add(xmlContent);
		//tosend.add(d);

		if(base64 != "" && xmlContent.contains("<IRmark Type=\"generic\"></IRmark>")){
			xmlContent = xmlContent.replace("<IRmark Type=\"generic\"></IRmark>", "<IRmark Type=\"generic\">"+base64+"</IRmark>");
		}
		if(xmlContent.contains("\n")){
			xmlContent = xmlContent.replace("\n", "");
		}

		return xmlContent;
	}

}
