package com.kjil.utils;

import com.kjil.domain.Event;
import com.kjil.domain.EventType;
import com.kjil.domain.Participant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultComputingServiceTest {
    private static final String PARTICIPANT_NAME_1 = "Test_Name_One";
    private static final String PARTICIPANT_NAME_2 = "Test_Name_Two";


    private static ComputingService computingService;
    @BeforeAll
    static void beforeAll() {
        computingService = new DefaultComputingService();
    }

    @Test
    void testGetParticipantsWithPlaces() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant(PARTICIPANT_NAME_1, getTestEvent_1()));
        participants.add(new Participant(PARTICIPANT_NAME_2, getTestEvent_2()));

        List<Participant> participantsWithPlaces = computingService.getParticipantsWithPlaces(participants);

        assertEquals(participantsWithPlaces.get(1).getName(), PARTICIPANT_NAME_2);
        assertEquals(participantsWithPlaces.get(1).getPosition(), "1");
    }

    @Test
    void testGetParticipantsWithPlacesWithEqualsPlaces() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant(PARTICIPANT_NAME_1, getTestEvent_1()));
        participants.add(new Participant(PARTICIPANT_NAME_2, getTestEvent_1()));

        List<Participant> participantsWithPlaces = computingService.getParticipantsWithPlaces(participants);

        assertEquals(participantsWithPlaces.get(1).getPosition(), "1-2");
        assertEquals(participantsWithPlaces.get(0).getPosition(), "1-2");
    }

    private List<Event> getTestEvent_1(){
        List<Event> events = new ArrayList<>();

        events.add(new Event(EventType.DASH_100_M, 1.2));
        events.add(new Event(EventType.DASH_400_M, 3.1));
        events.add(new Event(EventType.DISCUS_THROW, 12.4));
        events.add(new Event(EventType.HIGH_JUMP, 15.12));
        events.add(new Event(EventType.HURDLES_110_M, 22.32));
        events.add(new Event(EventType.JAVELIN_THROW, 33.33));
        events.add(new Event(EventType.LONG_JUMP, 44.44));
        events.add(new Event(EventType.POLE_VAULT, 56.12));
        events.add(new Event(EventType.RUN_1500_M, 82.12));
        events.add(new Event(EventType.SHOT_PUT, 71.9));

        return events;
    }

    private List<Event> getTestEvent_2(){
        List<Event> events = new ArrayList<>();

        events.add(new Event(EventType.DASH_100_M, 3.3));
        events.add(new Event(EventType.DASH_400_M, 23.12));
        events.add(new Event(EventType.DISCUS_THROW, 87.12));
        events.add(new Event(EventType.HIGH_JUMP, 67.0));
        events.add(new Event(EventType.HURDLES_110_M, 82.81));
        events.add(new Event(EventType.JAVELIN_THROW, 33.0));
        events.add(new Event(EventType.LONG_JUMP, 20.12));
        events.add(new Event(EventType.POLE_VAULT, 87.73));
        events.add(new Event(EventType.RUN_1500_M, 43.88));
        events.add(new Event(EventType.SHOT_PUT, 15.0));

        return events;
    }
}