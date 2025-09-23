package com.example.paycaptainirmarkcalculator.fps;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Key")
public class Key {

    @JacksonXmlProperty(isAttribute = true, localName = "Type")
    private String type;

    @JacksonXmlText
    private String text;

    // Required no-arg constructor
    public Key() {}

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
