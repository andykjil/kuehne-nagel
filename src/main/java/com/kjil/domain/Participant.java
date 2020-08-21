package com.kjil.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Participant {
    private String name;
    private List<Event> events;
    private int totalScore;
    private String position;

    public Participant() {
    }

    public Participant(String name, List<Event> events) {
        this.name = name;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    @XmlElementWrapper
    @XmlElement(name = "event")
    public List<Event> getEvents() {
        return events;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
