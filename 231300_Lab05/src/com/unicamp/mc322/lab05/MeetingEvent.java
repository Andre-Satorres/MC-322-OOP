package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingEvent extends Event {
    protected List<Participant> participants;

    public MeetingEvent(String description, LocalDateTime date, List<Participant> participants) {
        super(description, date);

        if (participants == null) {
            throw new IllegalArgumentException("Participants list must not be null!");
        }

        this.participants = new ArrayList<>(participants);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n   - Confirmed: " + participants.stream().filter(Participant::isConfirmed).collect(Collectors.toList()) +
                "\n   - Not confirmed: " + participants.stream().filter(Participant::isNotConfirmed).collect(Collectors.toList());
    }
}
