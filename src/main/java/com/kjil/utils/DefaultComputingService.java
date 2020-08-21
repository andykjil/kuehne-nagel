package com.kjil.utils;

import com.kjil.domain.Event;
import com.kjil.domain.EventType;
import com.kjil.domain.Participant;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DefaultComputingService implements ComputingService {

    @Override
    public List<Participant> getParticipantsWithPlaces(List<Participant> participants) {
        Map<Integer, List<Participant>> positions = new TreeMap<>(Collections.reverseOrder());
        List<Participant> allScores = getAllScores(participants);

        allScores.forEach(participant -> {
            positions.computeIfPresent(participant.getTotalScore(), (score, equalPlaces) -> {
                equalPlaces.add(participant);
                return equalPlaces;
            });

            positions.putIfAbsent(participant.getTotalScore(), new ArrayList<>(Collections.singletonList(participant)));

        });

        AtomicInteger position = new AtomicInteger(0);
        positions.forEach((score, equalPlaces) -> {
            position.incrementAndGet();
            int equalPlacesSize = positions.get(score).size();
            if (equalPlacesSize > 1) {
                equalPlaces.forEach(participant -> participant.setPosition(position.toString() + "-" + (position.get() - 1 + equalPlacesSize)));
            } else {
                equalPlaces.get(0).setPosition(position.toString());
            }
        });

        return allScores;
    }

    private List<Participant> getAllScores(List<Participant> participants) {
        participants.forEach(participant -> participant.setTotalScore(getParticipantScore(participant)));
        return participants.stream()
                .sorted(Comparator.comparingInt(Participant::getTotalScore))
                .collect(Collectors.toList());
    }

    private int getParticipantScore(Participant participant) {
        return participant.getEvents()
                .stream()
                .mapToInt(this::getEventScore)
                .sum();
    }

    private int getEventScore(Event event) {
        EventType eventType = event.getType();
        return (int) (eventType.getA() * Math.pow(Math.abs(event.getValue() - eventType.getB()), eventType.getC()));
    }

}
