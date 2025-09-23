package com.example.paycaptainirmarkcalculator.fps;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

public class Keys {

    @JacksonXmlProperty(localName = "Key")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Key> key;

    public Keys() {}

    public List<Key> getKey() {
        return key;
    }

    public void setKey(List<Key> key) {
        this.key = key;
    }
}
