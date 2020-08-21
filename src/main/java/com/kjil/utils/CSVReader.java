package com.kjil.utils;

import com.kjil.domain.Event;
import com.kjil.domain.EventType;
import com.kjil.domain.Participant;
import com.kjil.domain.Unit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements Reader {
    private String separator = ";";

    public List<Participant> parse(String path, String separator) throws IOException {
        this.separator = separator;
        return parse(path);
    }

    public List<Participant> parse(String path) throws IOException {
        EventType[] eventTypes = EventType.values();
        List<Participant> participants = new ArrayList<>();
        Files.readAllLines(Paths.get(path)).stream()
                .filter(line -> !line.equals(""))
                .forEach(line -> {
                    List<Event> events = new ArrayList<>();
                    String[] row = line.split(separator);

                    for (int i = 1; i < row.length; i++) {
                        try {
                            events.add(toEvent(row[i], eventTypes[i - 1]));
                        } catch (NumberFormatException ex) {
                            return;
                        }
                    }

                    participants.add(new Participant(row[0], events));
                });
        return participants;
    }

     private Event toEvent(String value, EventType eventType) throws NumberFormatException {
        if (eventType.getUnit() == Unit.SECONDS) {
            if (value.contains(":")) {
                String[] time = value.split(":");
                return new Event(eventType, Double.parseDouble(time[0]) * 60 + Double.parseDouble(time[1]));
            }
        }
        return new Event(eventType, Double.parseDouble(value));
    }
}
