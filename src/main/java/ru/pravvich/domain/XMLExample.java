package ru.pravvich.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Author : Pavel Ravvich.
 * Created : 01.09.17.
 */
@JacksonXmlRootElement(localName = "XMLExample")
public class XMLExample {

    @JacksonXmlProperty(localName = "description")
    @JacksonXmlElementWrapper(useWrapping = false)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public XMLExample(String description) {
        this.description = description;
    }
}
