package com.kjil.utils;

import com.kjil.domain.Participant;

import java.util.List;

public interface ComputingService {
    List<Participant> getParticipantsWithPlaces(List<Participant> participants);
}
