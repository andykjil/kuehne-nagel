package com.kjil;

import com.kjil.domain.Participant;
import com.kjil.utils.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("The program must contain at least 2 arguments!");
            System.exit(0);
        }
        Reader reader = new CSVReader();
        ComputingService computingService = new DefaultComputingService();
        Writer writer = new XMLWriter();

        try {
            List<Participant> participants = args.length >= 3 ?
                    reader.parse(args[0], args[2]) : reader.parse(args[0]);
            List<Participant> participantsWithPlaces = computingService.getParticipantsWithPlaces(participants);
            writer.write(participantsWithPlaces, args[1]);
            System.out.println();
        } catch (IOException | JAXBException e) {
            System.out.println("Something went wrong.");
        }
    }
}
