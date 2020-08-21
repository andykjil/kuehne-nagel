package com.kjil.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "participants")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantXmlWrapper {

    @XmlElement(name = "participant")
    private List<Participant> participants;

    public ParticipantXmlWrapper() {
    }

    public ParticipantXmlWrapper(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
