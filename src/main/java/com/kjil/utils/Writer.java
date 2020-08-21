package com.kjil.utils;

import com.kjil.domain.Participant;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface Writer {
    void write(List<Participant> participantList, String path) throws JAXBException, IOException;
}
