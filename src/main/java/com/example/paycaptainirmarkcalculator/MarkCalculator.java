package com.example.paycaptainirmarkcalculator;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.apache.xml.internal.security.signature.XMLSignatureInput;
import com.sun.org.apache.xml.internal.security.transforms.Transforms;
import org.bouncycastle.util.encoders.Base64;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;


public abstract class MarkCalculator
{

    public static final String DEFAULT_SEC_HASH_ALGORITHM = "SHA";


    public String createMark(InputStream in) throws Exception {
        System.out.println("### createMark " + in);
        return toBase64(getMarkBytes(in));
    }


    protected byte[] getMarkBytes(InputStream in) throws Exception {
        System.out.println("### getMarkBytes " + in);

        Init.init();

        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document doc=db.parse(new ByteArrayInputStream(getAlgorithm().getBytes()));

        Transforms transforms = new Transforms(doc.getDocumentElement(), null);

        XMLSignatureInput input = new XMLSignatureInput(in);
        //System.out.println("XMLSignatureInput : "+input);
        XMLSignatureInput result = transforms.performTransforms(input);

        MessageDigest md = MessageDigest.getInstance(DEFAULT_SEC_HASH_ALGORITHM);
        md.update(result.getBytes());

        return md.digest();
    }

    protected abstract String getAlgorithm();



    public static String toBase64(byte[] irMarkBytes){
        System.out.println("### toBase64 " + irMarkBytes);
        return new String(Base64.encode(irMarkBytes));
    }

}