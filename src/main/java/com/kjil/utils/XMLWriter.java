package com.kjil.utils;

import com.kjil.domain.Participant;
import com.kjil.domain.ParticipantXmlWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class XMLWriter implements Writer {
    @Override
    public void write(List<Participant> participantList, String path) throws JAXBException, IOException {
        JAXBContext contextObj = JAXBContext.newInstance(ParticipantXmlWrapper.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = Paths.get(path).toFile();
        file.createNewFile();
        marshallerObj.marshal(new ParticipantXmlWrapper(participantList), file);
    }
}
