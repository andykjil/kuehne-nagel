package com.kjil.domain;

import javax.xml.bind.annotation.XmlElement;

public class Event {
    @XmlElement(name = "name")
    private EventType type;
    @XmlElement(name = "value")
    private double value;

    public Event() {
    }

    public Event(EventType type, double value) {
        this.type = type;
        this.value = value;
    }

    public EventType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
}
